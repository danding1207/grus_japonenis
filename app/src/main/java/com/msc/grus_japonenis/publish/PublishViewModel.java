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

package com.msc.grus_japonenis.publish;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.msc.grus_japonenis.BR;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.base.BaseSwipeBackActivity;
import com.msc.lib.net.bean.DestinationsSearch;
import com.orhanobut.logger.Logger;

/**
 * Exposes the data to be used in the {@link PublishContract.View}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class PublishViewModel extends BaseObservable {

    private final PublishPresenter mPresenter;
    private Context mContext;
    private String date;

    public PublishViewModel(BaseSwipeBackActivity context, PublishPresenter presenter) {
        mContext = context;
        mPresenter = presenter;
    }

    public PublishPresenter getPresenter() {
        return mPresenter;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public String getDate() {
        return date;
    }

}
