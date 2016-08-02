package com.msc.grus_japonenis.main.homefragment;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.thread.EventThread;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.grus_japonenis.search.SearchActivity;
import com.msc.lib.net.event.AdvertsEvent;
import com.msc.lib.net.event.Constant;
import com.msc.lib.net.event.DestinationsEvent;
import com.msc.lib.net.AppService;
import com.msc.lib.net.event.DestinationsNearbyEvent;
import com.msc.lib.utils.CircularAnimUtil;
import com.msc.lib.utils.SnackbarUtils;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by msc on 2016/6/20.
 */

public class HomeFragmentPresenter extends HomeFragmentContract.Presenter<HomeFragmentContract.View> implements ObservableScrollViewCallbacks , OnItemClickListener {

    private MainActivity mActivity;
    private ConvenientBanner convenientBanner;

    public HomeFragmentPresenter(@NonNull MainActivity activity){
        mActivity = checkNotNull(activity, "MainActivity cannot be null!");
    }

    @Override
    public void attachView(HomeFragmentContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void start() {
        checkViewAttached();
        AppService.getInstance().getAdverts(mActivity,mActivity.getTaskId());
        AppService.getInstance().getDestinations(mActivity,mActivity.getTaskId());
    }

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
                getMvpView().getDestinationsListAdapter().setAdverts(event.getResult());
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
                getMvpView().getDestinationsListAdapter().setDestinations(event.getResult());
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
                getMvpView().getDestinationsListAdapter().setDestinationsNearby(event.getResult());
            }
        } else if (event.getmEventResult().equals(Constant.Result.FAIL)) {
//            AppNetSession.doException(gasFeeActivity, event.getThrowable());
            Logger.e("失败");
        }
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void onResume() {
        if(convenientBanner!=null) {
            convenientBanner.stopTurning();
            convenientBanner.startTurning(3000);
        }
    }

    @Override
    public void onPause() {
        if(convenientBanner!=null) {
            convenientBanner.stopTurning();
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
            mActivity.hideToolbar();
        } else if (scrollState == ScrollState.DOWN) {
            mActivity.showToolbar();
        }
    }

    public void onClick(View view, int id, String name) {
        Logger.d("id--->"+id);
        Intent intent = new Intent(mActivity, SearchActivity.class);
        intent.putExtra("DestinationId", id);
        intent.putExtra("DestinationName", name);
//        mActivity.startActivity(intent);
        CircularAnimUtil.startActivity(mActivity, intent, view, R.color.appToolbarColor);
    }


    public void onClickMoreNearby(View view) {
        SnackbarUtils.toast(mActivity.getActivityMainBinding().mainContent, "点击了更多附近目的地", Snackbar.LENGTH_SHORT);
    }

    @Override
    public void onItemClick(int position) {
        SnackbarUtils.toast(mActivity.getActivityMainBinding().mainContent, "点击了第" + position + "页", Snackbar.LENGTH_SHORT);
    }

    @Override
    public void setConvenientBanner(ConvenientBanner convenientBanner) {
        this.convenientBanner = convenientBanner;
    }

}
