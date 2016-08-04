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

package com.msc.grus_japonenis.launch;

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
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.grus_japonenis.main.SectionsPagerAdapter;
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
import rx.functions.Func1;

/**
 * Exposes the data to be used in the {@link MainActivity}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class LaunchViewModel extends BaseObservable implements ViewModel{

    private LaunchActivity launchActivity;

    public LaunchViewModel(LaunchActivity launchActivity) {
        this.launchActivity = launchActivity;
    }

    /**  数据绑定 */

//    @Bindable
//    public boolean isFabIsShown() {
//        return mFabIsShown;
//    }
//
//    @Bindable
//    public int[] getIcon() {
//        return sIcon;
//    }
//
//    @Bindable
//    public String[] getTitles() {
//        return sTitles;
//    }
//
//    @Bindable
//    public Fragment[] getFragments() {
//        return sFragment;
//    }

    /**  生命周期 */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
        Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .map(new Func1<Long, Object>() {
                    @Override
                    public Object call(Long aLong) {
                        launchActivity.startActivity(new Intent(launchActivity, MainActivity.class));
                        launchActivity.finish();
                        return null;
                    }
                }).subscribe();
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
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    /**  业务处理 */


}
