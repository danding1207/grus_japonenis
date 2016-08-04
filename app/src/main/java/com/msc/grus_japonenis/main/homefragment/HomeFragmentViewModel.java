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

package com.msc.grus_japonenis.main.homefragment;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.thread.EventThread;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.lib.injection.ViewModel;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.grus_japonenis.search.SearchActivity;
import com.msc.lib.net.AppService;
import com.msc.lib.net.event.AdvertsEvent;
import com.msc.lib.net.event.Constant;
import com.msc.lib.net.event.DestinationsEvent;
import com.msc.lib.net.event.DestinationsNearbyEvent;
import com.msc.lib.utils.CircularAnimUtil;
import com.msc.lib.utils.SnackbarUtils;
import com.orhanobut.logger.Logger;

/**
 * Exposes the data to be used in the {@link HomeFragment, MainActivity}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class HomeFragmentViewModel extends BaseObservable implements ViewModel, ObservableScrollViewCallbacks, OnItemClickListener {

    private HomeFragment homeFragment;
    private MainActivity mainActivity;
    private ConvenientBanner convenientBanner;

    public HomeFragmentViewModel(MainActivity mainActivity, HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        this.mainActivity = mainActivity;
    }

    /**  生命周期 */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
        AppService.getInstance().getAdverts(homeFragment.getActivity(),homeFragment.getActivity().getTaskId());
        AppService.getInstance().getDestinations(homeFragment.getActivity(),homeFragment.getActivity().getTaskId());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onStop() {

    }

    public void onResume() {
        if(convenientBanner!=null) {
            convenientBanner.stopTurning();
            convenientBanner.startTurning(3000);
        }
    }

    public void onPause() {
        if(convenientBanner!=null) {
            convenientBanner.stopTurning();
        }
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
    /**
     * 攻略主题
     */
    @Subscribe(
            thread = EventThread.MAIN_THREAD
    )
    public void result(AdvertsEvent event) {
        if (event.getmEventResult().equals(Constant.Result.SUCCESSS)) {
            Logger.e("成功");
            if (event.getResult() != null) {
                homeFragment.getDestinationsListAdapter().setAdverts(event.getResult());
            }
        } else if (event.getmEventResult().equals(Constant.Result.FAIL)) {
//            AppNetSession.doException(gasFeeActivity, event.getThrowable());
            Logger.e("失败");
        }
    }

    /**
     * 攻略主题
     */
    @Subscribe(
            thread = EventThread.MAIN_THREAD
    )
    public void result(DestinationsEvent event) {
        if (event.getmEventResult().equals(Constant.Result.SUCCESSS)) {
            Logger.e("成功");
            if (event.getResult() != null) {
                homeFragment.getDestinationsListAdapter().setDestinations(event.getResult());
            }
        } else if (event.getmEventResult().equals(Constant.Result.FAIL)) {
//            AppNetSession.doException(gasFeeActivity, event.getThrowable());
            Logger.e("失败");
        }
    }

    /**
     * 附近目的地
     */
    @Subscribe(
            thread = EventThread.MAIN_THREAD
    )
    public void result(DestinationsNearbyEvent event) {
        if (event.getmEventResult().equals(Constant.Result.SUCCESSS)) {
            Logger.e("成功");
            if (event.getResult() != null) {
                homeFragment.getDestinationsListAdapter().setDestinationsNearby(event.getResult());
            }
        } else if (event.getmEventResult().equals(Constant.Result.FAIL)) {
//            AppNetSession.doException(gasFeeActivity, event.getThrowable());
            Logger.e("失败");
        }
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if (scrollState == ScrollState.UP) {
            mainActivity.hideToolbar();
        } else if (scrollState == ScrollState.DOWN) {
            mainActivity.showToolbar();
        }
    }

    public void onClick(View view, int id, String name) {
        Logger.d("id--->"+id);
        Intent intent = new Intent(mainActivity, SearchActivity.class);
        intent.putExtra("DestinationId", id);
        intent.putExtra("DestinationName", name);
        CircularAnimUtil.startActivity(mainActivity, intent, view, R.color.appToolbarColor);
    }

    public void onClickMoreNearby(View view) {
        SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "点击了更多附近目的地", Snackbar.LENGTH_SHORT);
    }

    public void onItemClick(int position) {
        SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "点击了第" + position + "页", Snackbar.LENGTH_SHORT);
    }

    public void setConvenientBanner(ConvenientBanner convenientBanner) {
        this.convenientBanner = convenientBanner;
    }


}
