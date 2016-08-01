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

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.Fragment;

import com.msc.grus_japonenis.MyPlanFragment;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.UserFansFragment;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.main.SectionsPagerAdapter;
import com.msc.grus_japonenis.main.userfragment.UserFragment;
import com.orhanobut.logger.Logger;

/**
 * Exposes the data to be used in the {@link HomeFragmentContract.View}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class HomeFragmentViewModel extends BaseObservable {

    private boolean mFabIsShown = false;
    private static final int[] sIcon = new int[]{R.drawable.icon_tab_home, R.drawable.icon_tab_trip, R.drawable.icon_tab_plan, R.drawable.icon_tab_my};
    private static final String[] sTitles = new String[]{"攻略", "游记", "行程", "我的"};
    private static final Fragment[] sFragment = new Fragment[]{HomeFragment.newInstance(), UserFansFragment.newInstance(), MyPlanFragment.newInstance(), UserFragment.newInstance()};

    private final HomeFragmentContract.Presenter mPresenter;

    private SectionsPagerAdapter adapter;

    private Context mContext;

    public HomeFragmentViewModel(BaseActivity context, HomeFragmentContract.Presenter presenter) {
        mContext = context;
        mPresenter = presenter;
        adapter = new SectionsPagerAdapter(context.getSupportFragmentManager(), sFragment, sTitles);
    }

    @Bindable
    public SectionsPagerAdapter getSectionsPagerAdapter() {
        return adapter;
    }

    public HomeFragmentContract.Presenter getPresenter() {
        Logger.e("getPresenter");
        return mPresenter;
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

//    public void setTaskListSize(int taskListSize) {
//        mTaskListSize = taskListSize;
//        notifyPropertyChanged(BR.noTaskIconRes);
//        notifyPropertyChanged(BR.noTasksLabel);
//        notifyPropertyChanged(BR.currentFilteringLabel);
//        notifyPropertyChanged(BR.notEmpty);
//        notifyPropertyChanged(BR.tasksAddViewVisible);
//    }
}
