package com.msc.lib.net;

import android.content.Context;

/**
 * Created by msc on 2016/1/28.
 */
public class RxApiFactory {

    private static RxApi rxApi;
    public RxApiFactory() {

    }

    public static RxApi getRxApi(Context context) {
        synchronized (RxApiFactory.class) {
            if (rxApi == null) {
                RxApiClient newsClient = new RxApiClient();
                rxApi = newsClient.getRxNewsApi(context);
            }
            return rxApi;
        }
    }

}
