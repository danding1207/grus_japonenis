package com.msc.grus_japonenis.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.msc.grus_japonenis.DetailActivity;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.publish.PublishActivity;
import com.msc.grus_japonenis.search.SearchActivity;
import com.msc.lib.net.AppService;
import com.msc.lib.utils.SnackbarUtils;
import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by msc on 2016/6/20.
 */

public class MainPresenter extends MainContract.Presenter<MainContract.View> implements ViewPager.OnPageChangeListener, AMapLocationListener {

    private BaseActivity mActivity;
    public AMapLocationClient mLocationClient = null;
    public AMapLocationClientOption mLocationOption = null;
    private boolean mFabIsShown = false;

    public MainPresenter(@NonNull BaseActivity activity) {
        mActivity = checkNotNull(activity, "MainActivity cannot be null!");
    }

    @Override
    public void attachView(MainContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void start() {
        checkViewAttached();
        //初始化定位
        mLocationClient = new AMapLocationClient(mActivity.getApplicationContext());
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(true);
        if (mLocationOption.isOnceLocationLatest()) {
            mLocationOption.setOnceLocationLatest(true);
            //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。
            //如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会。
        }
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                getMvpView().hideFab();
                getMvpView().showToolbar();
                break;
            case 1:
                getMvpView().showFab();
                getMvpView().showToolbar();
                break;
            case 2:
                getMvpView().hideFab();
                getMvpView().showToolbar();
                break;
            case 3:
                getMvpView().hideFab();
                getMvpView().showToolbar();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean toolbarIsHidden() {
        return ViewCompat.getTranslationY(getMvpView().getActivityMainBinding().appbar) == -getMvpView().getActivityMainBinding().fakeSearchView.getHeight();
    }

    @Override
    public boolean toolbarIsShown() {
        return ViewCompat.getTranslationY(getMvpView().getActivityMainBinding().appbar) == 0.0F;
    }

    @Override
    public void setFabIsShown(boolean fabIsShown) {
        mFabIsShown = fabIsShown;
    }

    @Override
    public boolean fabIsShown() {
        return mFabIsShown;
    }

    @Override
    public void search() {
        mActivity.startActivity(new Intent(mActivity, SearchActivity.class));
    }

    @Override
    public void add() {
        mActivity.startActivity(new Intent(mActivity, PublishActivity.class));
    }

    private boolean isExit = false;

    @Override
    public void onBackPressed() {
        if (isExit) {
            mActivity.finish();
        } else {
            isExit = true;
            Observable
                    .timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Long>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                        }

                        @Override
                        public void onNext(Long number) {
                            isExit = false;
                        }
                    });
            SnackbarUtils.toast(getMvpView().getActivityMainBinding().mainContent, "再按一次退出！", "立即", Snackbar.LENGTH_SHORT, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.finish();
                }
            });
        }
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {

                Logger.e("AmapSuccess","location Success: Lat-->"
                        + amapLocation.getLatitude() + ", Lng-->:"
                        + amapLocation.getLongitude());

                //定位成功回调信息，设置相关消息
                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                amapLocation.getLatitude();//获取纬度
                amapLocation.getLongitude();//获取经度

                AppService.getInstance().getDestinationsNearby(mActivity,mActivity.getTaskId(), String.valueOf(amapLocation.getLatitude()), String.valueOf(amapLocation.getLongitude()));

                amapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(amapLocation.getTime());
                df.format(date);//定位时间
                amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                amapLocation.getCountry();//国家信息
                amapLocation.getProvince();//省信息
                amapLocation.getCity();//城市信息
                amapLocation.getDistrict();//城区信息
                amapLocation.getStreet();//街道信息
                amapLocation.getStreetNum();//街道门牌号信息
                amapLocation.getCityCode();//城市编码
                amapLocation.getAdCode();//地区编码
                amapLocation.getAoiName();//获取当前定位点的AOI信息
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                Logger.e("AmapError","location Error, ErrCode:"
                        + amapLocation.getErrorCode() + ", errInfo:"
                        + amapLocation.getErrorInfo());
            }
        }
    }
}
