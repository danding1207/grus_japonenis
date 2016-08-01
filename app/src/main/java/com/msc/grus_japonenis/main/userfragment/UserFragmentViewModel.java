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

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.msc.grus_japonenis.BR;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.lib.net.bean.User;
import com.orhanobut.logger.Logger;

/**
 * Exposes the data to be used in the {@link UserFragmentContract.View}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class UserFragmentViewModel extends BaseObservable {

    private final UserFragmentPresenter mPresenter;
    private User user;
    private Context mContext;
    private boolean isUserFragmentShow;

    public UserFragmentViewModel(BaseActivity context, UserFragmentPresenter presenter) {
        mContext = context;
        mPresenter = presenter;
    }

    public UserFragmentPresenter getPresenter() {
        return mPresenter;
    }

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
        return user == null || (user.getData().getUnread_notifications_count().getComments() +
                user.getData().getUnread_notifications_count().getFavorites() +
                user.getData().getUnread_notifications_count().getFollows() +
                user.getData().getUnread_notifications_count().getLikes() +
                user.getData().getUnread_notifications_count().getSystems() == 0) ?
                ContextCompat.getDrawable(mContext, R.drawable.menu_message_n) :
                ContextCompat.getDrawable(mContext, R.drawable.menu_message_h);
    }

    @Bindable
    public String getUserHeadPicUrl() {
        return user == null ? null : user.getData().getPhoto_url();
    }


}
