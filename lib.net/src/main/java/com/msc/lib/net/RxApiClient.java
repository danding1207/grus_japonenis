package com.msc.lib.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.orhanobut.logger.Logger;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.io.IOException;

import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by msc on 2016/1/28.
 */
public class RxApiClient {

    private static RxApi rxApi;
    private static Context mContext;
    RxApiClient() {
    }

    public static RxApi getRxNewsApi(Context context) {
        if (rxApi == null) {
            mContext = context;
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.interceptors().add(logging);
            httpClient.interceptors().add(interceptor);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(HttpURLS.ip)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(CutmosGsonConverterFactory.create())
                    .client(httpClient)
                    .build();
            rxApi = retrofit.create(RxApi.class);
        }
        return rxApi;
    }

    private static Interceptor interceptor = new Interceptor() {
        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
//            Request request = chain.request();
            Request request = chain.request()
                    .newBuilder()
//                    .addHeader("Content-Type", "application/json")
                    .addHeader("User-Agent", "Meizu MX4 Pro;Android 5.1.1;wandoujia;2.1.0")
//                    .addHeader("Accept-Encoding", "gzip")
//                    .addHeader("Connection", "keep-alive")
                    .addHeader("Token", "866002025660878")
                    .addHeader("Authorization", "JDJhJDEwJFdMVnltYkcuUWpiY0tCS0xsUVIzYk9sWG44OExhOGpuRHJWRzJsVEtPeFBlSlpNajJZSmx5")
//                    .addHeader("Host", "q.chanyouji.com")
                    .build();

            Logger.e(request.url().toString());

            if (!isNetworkReachable(mContext)) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            com.squareup.okhttp.Response response = chain.proceed(request);

            if (isNetworkReachable(mContext)) {
                int maxAge = 60 * 60;
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 7; //  设置超时为一周
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    };


    /**
     * 判断网络是否可用
     *
     * @param context Context对象
     */
    public static Boolean isNetworkReachable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo current = cm.getActiveNetworkInfo();
        if (current == null) {
            return false;
        }
        return (current.isAvailable());
    }

}
