package com.msc.grus_japonenis.main.userfragment;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.thread.EventThread;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.lib.net.event.Constant;
import com.msc.lib.net.event.UserEvent;
import com.msc.lib.net.AppService;
import com.msc.lib.utils.SnackbarUtils;
import com.orhanobut.logger.Logger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by msc on 2016/6/20.
 */

public class UserFragmentPresenter extends UserFragmentContract.Presenter<UserFragmentContract.View> {

    private MainActivity mActivity;

    public UserFragmentPresenter(@NonNull MainActivity activity){
        mActivity = checkNotNull(activity, "MainActivity cannot be null!");
    }

    @Override
    public void attachView(UserFragmentContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void start() {
        checkViewAttached();
        AppService.getInstance().getUser(mActivity,mActivity.getTaskId());
    }

    /**
     * 用户信息
     */
    @Subscribe(
            thread = EventThread.MAIN_THREAD
    )
    public void result(UserEvent event) {
        if (event.getmEventResult().equals(Constant.Result.SUCCESSS)) {
            Logger.e("成功");
            if (event.getResult() != null) {
                getMvpView().setUserResult(event.getResult());
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
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onClick(int id) {
        switch (id) {
            case 1:
                SnackbarUtils.toast(mActivity.getActivityMainBinding().mainContent, "我的主页", Snackbar.LENGTH_SHORT);
                break;
            case 2:
                SnackbarUtils.toast(mActivity.getActivityMainBinding().mainContent, "消息中心", Snackbar.LENGTH_SHORT);
                break;
            case 3:
                SnackbarUtils.toast(mActivity.getActivityMainBinding().mainContent, "更多", Snackbar.LENGTH_SHORT);
                break;
            case 4:
                SnackbarUtils.toast(mActivity.getActivityMainBinding().mainContent, "我的收藏", Snackbar.LENGTH_SHORT);
                break;
            case 5:
                SnackbarUtils.toast(mActivity.getActivityMainBinding().mainContent, "我的好友", Snackbar.LENGTH_SHORT);
                break;
            case 6:
                SnackbarUtils.toast(mActivity.getActivityMainBinding().mainContent, "意见反馈", Snackbar.LENGTH_SHORT);
                break;
            case 7:
                SnackbarUtils.toast(mActivity.getActivityMainBinding().mainContent, "设置", Snackbar.LENGTH_SHORT);
                break;
        }
    }

}
