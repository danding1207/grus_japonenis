package com.msc.grus_japonenis.search;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.thread.EventThread;
import com.msc.lib.net.AppService;
import com.msc.lib.net.event.Constant;
import com.msc.lib.net.event.DestinationsSearchEvent;
import com.msc.lib.utils.SnackbarUtils;
import com.orhanobut.logger.Logger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by msc on 2016/6/20.
 */

public class SearchPresenter extends SearchContract.Presenter<SearchContract.View> {

    private SearchActivity mActivity;
    private int destinationid;
    private String destinationname;

    public SearchPresenter(@NonNull SearchActivity activity) {
        mActivity = checkNotNull(activity, "MainActivity cannot be null!");
    }

    @Override
    public void attachView(SearchContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void start() {
        checkViewAttached();
        destinationid = mActivity.getIntent().getIntExtra("DestinationId", -1);
        destinationname = mActivity.getIntent().getStringExtra("DestinationName");
        getMvpView().setSearchText(destinationname);
        if (destinationid != -1) {
            serach("destination", destinationid+"");
        }
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    void serach(String type, String s) {
        getMvpView().showProgressBar();
        getMvpView().setSearchResult(null);
        AppService.getInstance().getDestinationsSearch(mActivity, mActivity.getTaskId(), type , s);
    }

    /**
     * 目的地搜索
     */
    @Subscribe(
            thread = EventThread.MAIN_THREAD
    )
    public void result(DestinationsSearchEvent event) {
        getMvpView().dismissProgressBar();
        if (event.getmEventResult().equals(Constant.Result.SUCCESSS)) {
            Logger.e("成功");
            if (event.getResult() != null) {
                getMvpView().setSearchResult(event.getResult());
            }
        } else if (event.getmEventResult().equals(Constant.Result.FAIL)) {
//            AppNetSession.doException(gasFeeActivity, event.getThrowable());
            Logger.e("失败");
        }
    }

    @Override
    public void destination(int id) {
        Logger.e("destination");
        SnackbarUtils.toast(getMvpView().getActivitySearchBinding().mainContent, "destination:"+id, Snackbar.LENGTH_SHORT);
    }

    @Override
    public void destinationTip() {
        Logger.e("destinationTip");
        SnackbarUtils.toast(getMvpView().getActivitySearchBinding().mainContent, "destinationTip", Snackbar.LENGTH_SHORT);
    }

    @Override
    public void plan(int id) {
        Logger.e("plan");
        SnackbarUtils.toast(getMvpView().getActivitySearchBinding().mainContent, "plan:"+id, Snackbar.LENGTH_SHORT);
    }

    @Override
    public void planTip() {
        Logger.e("planTip");
        SnackbarUtils.toast(getMvpView().getActivitySearchBinding().mainContent, "planTip", Snackbar.LENGTH_SHORT);
    }

    @Override
    public void user(int id) {
        Logger.e("user");
        SnackbarUtils.toast(getMvpView().getActivitySearchBinding().mainContent, "user:"+id, Snackbar.LENGTH_SHORT);
    }

}
