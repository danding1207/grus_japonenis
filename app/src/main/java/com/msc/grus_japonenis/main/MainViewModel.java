/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.msc.grus_japonenis.main;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.msc.grus_japonenis.MyPlanFragment;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.UserFansFragment;
import com.msc.grus_japonenis.lib.injection.ViewModel;
import com.msc.grus_japonenis.main.homefragment.HomeFragment;
import com.msc.grus_japonenis.main.userfragment.UserFragment;
import com.msc.grus_japonenis.publish.PublishActivity;
import com.msc.grus_japonenis.search.SearchActivity;
import com.msc.lib.net.AppService;
import com.msc.lib.utils.CircularAnimUtil;
import com.msc.lib.utils.SnackbarUtils;
import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Exposes the data to be used in the {@link MainActivity}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class MainViewModel extends BaseObservable implements ViewModel, ViewPager.OnPageChangeListener, AMapLocationListener {

    private static final int[] sIcon = new int[]{R.drawable.icon_tab_home, R.drawable.icon_tab_trip, R.drawable.icon_tab_plan, R.drawable.icon_tab_my};
    private static final String[] sTitles = new String[]{"攻略", "游记", "行程", "我的"};
    private static final Fragment[] sFragment = new Fragment[]{HomeFragment.newInstance(), UserFansFragment.newInstance(), MyPlanFragment.newInstance(), UserFragment.newInstance()};

    private SectionsPagerAdapter adapter;

    private MainActivity mainActivity;

    public AMapLocationClient mLocationClient = null;
    public AMapLocationClientOption mLocationOption = null;
    private boolean mFabIsShown = false;

    public MainViewModel(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        adapter = new SectionsPagerAdapter(mainActivity.getSupportFragmentManager(), sFragment, sTitles);
    }

    /**  数据绑定 */
    @Bindable
    public SectionsPagerAdapter getSectionsPagerAdapter() {
        return adapter;
    }

    @Bindable
    public boolean isFabIsShown() {
        return mFabIsShown;
    }

    @Bindable
    public int[] getIcon() {
        return sIcon;
    }

    @Bindable
    public String[] getTitles() {
        return sTitles;
    }

    @Bindable
    public Fragment[] getFragments() {
        return sFragment;
    }

    /**  生命周期 */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroyView() {

    }

    @Override
    public void onDestroy() {
        mLocationClient.stopLocation();//停止定位
        mLocationClient.onDestroy();//销毁定位客户端
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    /**  业务处理 */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mainActivity.hideFab();
                mainActivity.showToolbar();
                break;
            case 1:
                mainActivity.showFab();
                mainActivity.showToolbar();
                break;
            case 2:
                mainActivity.hideFab();
                mainActivity.showToolbar();
                break;
            case 3:
                mainActivity.hideFab();
                mainActivity.showToolbar();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public boolean toolbarIsHidden() {
        return ViewCompat.getTranslationY(mainActivity.getActivityMainBinding().appbar) == -mainActivity.getActivityMainBinding().fakeSearchView.getHeight();
    }

    public boolean toolbarIsShown() {
        return ViewCompat.getTranslationY(mainActivity.getActivityMainBinding().appbar) == 0.0F;
    }

    public void setFabIsShown(boolean fabIsShown) {
        mFabIsShown = fabIsShown;
    }

    public boolean fabIsShown() {
        return mFabIsShown;
    }

    public void search() {
        mainActivity.startActivity(new Intent(mainActivity, SearchActivity.class));
    }

    public void add(View view) {
        CircularAnimUtil.startActivity(mainActivity, PublishActivity.class, view, R.color.appToolbarColor);
    }

    private boolean isExit = false;

    public void onBackPressed() {
        if (isExit) {
            mainActivity.finish();
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
            SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "再按一次退出！", "立即", Snackbar.LENGTH_SHORT, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.finish();
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

                AppService.getInstance().getDestinationsNearby(mainActivity, mainActivity.getTaskId(), String.valueOf(amapLocation.getLatitude()), String.valueOf(amapLocation.getLongitude()));

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
