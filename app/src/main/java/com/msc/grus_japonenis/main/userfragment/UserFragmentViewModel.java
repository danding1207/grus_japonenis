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

package com.msc.grus_japonenis.main.userfragment;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.thread.EventThread;
import com.msc.grus_japonenis.BR;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.lib.injection.ViewModel;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.lib.net.AppService;
import com.msc.lib.net.bean.Unread;
import com.msc.lib.net.bean.User;
import com.msc.lib.net.event.Constant;
import com.msc.lib.net.event.UnreadEvent;
import com.msc.lib.net.event.UserEvent;
import com.msc.lib.utils.SnackbarUtils;
import com.orhanobut.logger.Logger;

/**
 * Exposes the data to be used in the {@link MainActivity, UserFragment}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class UserFragmentViewModel extends BaseObservable implements ViewModel {

    private User user;
    private Unread unread;
    private UserFragment userFragment;
    private MainActivity mainActivity;
    private boolean isUserFragmentShow;


    public UserFragmentViewModel(MainActivity mainActivity, UserFragment userFragment) {
        this.mainActivity = mainActivity;
        this.userFragment = userFragment;
    }

    /**  数据绑定 */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        notifyPropertyChanged(BR.userName);
        notifyPropertyChanged(BR.messageIcon);
        notifyPropertyChanged(BR.userHeadPicUrl);
    }

    public void setUserFragmentShow(boolean userFragmentShow) {
        isUserFragmentShow = userFragmentShow;
        notifyPropertyChanged(BR.userFragmentShow);
    }

    @Bindable
    public boolean isUserFragmentShow() {
        return isUserFragmentShow;
    }

    @Bindable
    public String getUserName() {
        return user == null ? null : user.getData().getName();
    }

    @Bindable
    public Drawable getMessageIcon() {
        return user == null || unread == null || (user.getData().getUnread_notifications_count().getComments() +
                user.getData().getUnread_notifications_count().getFavorites() +
                user.getData().getUnread_notifications_count().getFollows() +
                user.getData().getUnread_notifications_count().getLikes() +
                user.getData().getUnread_notifications_count().getSystems() == 0)
                || (unread.getComments() + unread.getFavorites() + unread.getFollows() + unread.getLikes() + unread.getSystems() == 0)
                ? ContextCompat.getDrawable(mainActivity, R.drawable.menu_message_n) :
                ContextCompat.getDrawable(mainActivity, R.drawable.menu_message_h);
    }

    @Bindable
    public String getUserHeadPicUrl() {
        return user == null ? null : user.getData().getPhoto_url();
    }


    public void setUnread(Unread unread) {
        this.unread = unread;
        notifyPropertyChanged(BR.messageIcon);
    }

    /**  生命周期 */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
        AppService.getInstance().getUser(mainActivity, mainActivity.getTaskId());
    }

    public void onResume() {
        AppService.getInstance().getUnread(mainActivity, mainActivity.getTaskId());
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
                setUser(event.getResult());
                setUserFragmentShow(true);
            }
        } else if (event.getmEventResult().equals(Constant.Result.FAIL)) {
//            AppNetSession.doException(gasFeeActivity, event.getThrowable());
            Logger.e("失败");
        }
    }

    /**
     * 用户信息
     */
    @Subscribe(
            thread = EventThread.MAIN_THREAD
    )
    public void result(UnreadEvent event) {
        if (event.getmEventResult().equals(Constant.Result.SUCCESSS)) {
            Logger.e("成功");
            if (event.getResult() != null) {
                setUnread(event.getResult());
            }
        } else if (event.getmEventResult().equals(Constant.Result.FAIL)) {
//            AppNetSession.doException(gasFeeActivity, event.getThrowable());
            Logger.e("失败");
        }
    }

    public void onClick(int id) {
        switch (id) {
            case 1:
                SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "我的主页", Snackbar.LENGTH_SHORT);
                break;
            case 2:
                SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "消息中心", Snackbar.LENGTH_SHORT);
                break;
            case 3:
                SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "更多", Snackbar.LENGTH_SHORT);
                break;
            case 4:
                SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "我的收藏", Snackbar.LENGTH_SHORT);
                break;
            case 5:
                SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "我的好友", Snackbar.LENGTH_SHORT);
                break;
            case 6:
                SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "意见反馈", Snackbar.LENGTH_SHORT);
                break;
            case 7:
                SnackbarUtils.toast(mainActivity.getActivityMainBinding().mainContent, "设置", Snackbar.LENGTH_SHORT);
                break;
        }
    }


}
