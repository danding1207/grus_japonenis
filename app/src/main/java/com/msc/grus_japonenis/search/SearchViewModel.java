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

package com.msc.grus_japonenis.search;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.msc.grus_japonenis.BR;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.base.BaseSwipeBackActivity;
import com.msc.lib.net.bean.DestinationsSearch;
import com.orhanobut.logger.Logger;

/**
 * Exposes the data to be used in the {@link SearchContract.View}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class SearchViewModel extends BaseObservable {

    private final SearchPresenter mPresenter;

    private DestinationsSearch destinationsSearch;

    private Context mContext;

    private boolean isProgressBarShow;

    public SearchViewModel(BaseSwipeBackActivity context, SearchPresenter presenter) {
        mContext = context;
        mPresenter = presenter;
    }

    public void setProgressBarShow(boolean progressBarShow) {
        isProgressBarShow = progressBarShow;
        notifyPropertyChanged(BR.progressBarShow);
    }

    public DestinationsSearch getDestinationsSearch() {
        return destinationsSearch;
    }

    public void setDestinationsSearch(DestinationsSearch destinationsSearch) {
        this.destinationsSearch = destinationsSearch;
        Logger.d("setDestinationsSearch");
        notifyPropertyChanged(BR.plan1Topic);
        notifyPropertyChanged(BR.plan2Topic);
        notifyPropertyChanged(BR.plan3Topic);
        notifyPropertyChanged(BR.plan1Des);
        notifyPropertyChanged(BR.plan2Des);
        notifyPropertyChanged(BR.plan3Des);
        notifyPropertyChanged(BR.plan1Url);
        notifyPropertyChanged(BR.plan2Url);
        notifyPropertyChanged(BR.plan3Url);
        notifyPropertyChanged(BR.user1Name);
        notifyPropertyChanged(BR.user2Name);
        notifyPropertyChanged(BR.destination1Name);
        notifyPropertyChanged(BR.destination2Name);
        notifyPropertyChanged(BR.destination3Name);
        notifyPropertyChanged(BR.destination1Url);
        notifyPropertyChanged(BR.destination2Url);
        notifyPropertyChanged(BR.destination3Url);
        notifyPropertyChanged(BR.destination1Des);
        notifyPropertyChanged(BR.destination2Des);
        notifyPropertyChanged(BR.destination3Des);
        notifyPropertyChanged(BR.destinationTip);
        notifyPropertyChanged(BR.destinationsShow);
        notifyPropertyChanged(BR.destinations2Show);
        notifyPropertyChanged(BR.destinations3Show);
        notifyPropertyChanged(BR.destinationsTipShow);
        notifyPropertyChanged(BR.plansShow);
        notifyPropertyChanged(BR.plans2Show);
        notifyPropertyChanged(BR.plans3Show);
        notifyPropertyChanged(BR.plansTipShow);
        notifyPropertyChanged(BR.usersShow);
        notifyPropertyChanged(BR.users2Show);
        notifyPropertyChanged(BR.user1Url);
        notifyPropertyChanged(BR.user2Url);
    }

    public SearchPresenter getPresenter() {
        return mPresenter;
    }

    @Bindable
    public String getPlan1Topic() {
        return isPlansShow()?destinationsSearch.getData().getUser_activities().get(0).getTopic():null;
    }

    @Bindable
    public String getPlan2Topic() {
        return isPlans2Show()?destinationsSearch.getData().getUser_activities().get(1).getTopic():null;
    }

    @Bindable
    public String getPlan3Topic() {
        return isPlans3Show()?destinationsSearch.getData().getUser_activities().get(2).getTopic():null;
    }

    @Bindable
    public String getPlan1Des() {
        return isPlansShow()?destinationsSearch.getData().getUser_activities().get(0).getDescription():null;
    }

    @Bindable
    public String getPlan2Des() {
        return isPlans2Show()?destinationsSearch.getData().getUser_activities().get(1).getDescription():null;
    }

    @Bindable
    public String getPlan3Des() {
        return isPlans3Show()?destinationsSearch.getData().getUser_activities().get(2).getDescription():null;
    }

    @Bindable
    public String getPlan1Url() {
        return isPlansShow()?destinationsSearch.getData().getUser_activities().get(0).getContents().get(0).getPhoto_url():null;
    }

    @Bindable
    public String getPlan2Url() {
        return isPlans2Show()?destinationsSearch.getData().getUser_activities().get(1).getContents().get(0).getPhoto_url():null;
    }

    @Bindable
    public String getPlan3Url() {
        return isPlans3Show()?destinationsSearch.getData().getUser_activities().get(2).getContents().get(0).getPhoto_url():null;
    }


    @Bindable
    public String getUser1Name() {
        return isUsersShow()?destinationsSearch.getData().getUsers().get(0).getName():null;
    }

    @Bindable
    public String getUser2Name() {
        return isUsers2Show()?destinationsSearch.getData().getUsers().get(1).getName():null;
    }

    @Bindable
    public String getUser1Url() {
        return isUsersShow()?destinationsSearch.getData().getUsers().get(0).getPhoto_url():null;
    }

    @Bindable
    public String getUser2Url() {
        return isUsers2Show()?destinationsSearch.getData().getUsers().get(1).getPhoto_url():null;
    }

    @Bindable
    public String getDestination1Name() {
        return isDestinationsShow()?destinationsSearch.getData().getDestinations().get(0).getName():null;
    }

    @Bindable
    public String getDestination2Name() {
        return isDestinations2Show()?destinationsSearch.getData().getDestinations().get(1).getName():null;
    }

    @Bindable
    public String getDestination3Name() {
        return isDestinations3Show()?destinationsSearch.getData().getDestinations().get(2).getName():null;
    }

    @Bindable
    public String getDestination1Url() {
        return isDestinationsShow()?destinationsSearch.getData().getDestinations().get(0).getPhoto_url():null;
    }

    @Bindable
    public String getDestination2Url() {
        return isDestinations2Show()?destinationsSearch.getData().getDestinations().get(1).getPhoto_url():null;
    }

    @Bindable
    public String getDestination3Url() {
        return isDestinations3Show()?destinationsSearch.getData().getDestinations().get(2).getPhoto_url():null;
    }

    @Bindable
    public String getDestination1Des() {
        return isDestinationsShow()?destinationsSearch.getData().getDestinations().get(0).getInspiration_activities_count()+"条旅行灵感":null;
    }

    @Bindable
    public String getDestination2Des() {
        return isDestinations2Show()?destinationsSearch.getData().getDestinations().get(1).getInspiration_activities_count()+"条旅行灵感":null;
    }

    @Bindable
    public String getDestination3Des() {
        return isDestinations3Show()?destinationsSearch.getData().getDestinations().get(2).getInspiration_activities_count()+"条旅行灵感":null;
    }

    @Bindable
    public String getDestinationTip() {
        return isDestinationsTipShow()?destinationsSearch.getData().getHitted_parent_destination_children_count()+"本"+destinationsSearch.getData().getHitted_parent_destination().getName()+"攻略":null;
    }

    @Bindable
    public boolean isDestinationsShow() {
        return destinationsSearch==null?false:destinationsSearch.getData().getDestinations().size() > 0;
    }

    @Bindable
    public boolean isDestinations2Show() {
        return destinationsSearch==null?false:destinationsSearch.getData().getDestinations().size() > 1;
    }

    @Bindable
    public boolean isDestinations3Show() {
        return destinationsSearch==null?false:destinationsSearch.getData().getDestinations().size() > 2;
    }

    @Bindable
    public boolean isDestinationsTipShow() {
        return destinationsSearch==null?false:destinationsSearch.getData().getDestinations().size() > 3;
    }

    @Bindable
    public boolean isPlansShow() {
        return destinationsSearch==null?false:destinationsSearch.getData().getUser_activities().size() > 0;
    }

    @Bindable
    public boolean isPlans2Show() {
        return destinationsSearch==null?false:destinationsSearch.getData().getUser_activities().size() > 1;
    }

    @Bindable
    public boolean isPlans3Show() {
        return destinationsSearch==null?false:destinationsSearch.getData().getUser_activities().size() > 2;
    }

    @Bindable
    public boolean isPlansTipShow() {
        return destinationsSearch==null?false:destinationsSearch.getData().getUser_activities().size() > 3;
    }

    @Bindable
    public boolean isUsersShow() {
        return destinationsSearch==null?false:destinationsSearch.getData().getUsers().size() > 0;
    }

    @Bindable
    public boolean isUsers2Show() {
        return destinationsSearch==null?false:destinationsSearch.getData().getUsers().size() > 1;
    }

    @Bindable
    public boolean isProgressBarShow() {
        return isProgressBarShow;
    }










}
