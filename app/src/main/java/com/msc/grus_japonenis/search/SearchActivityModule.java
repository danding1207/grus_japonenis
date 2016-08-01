package com.msc.grus_japonenis.search;

import com.msc.grus_japonenis.lib.injection.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class SearchActivityModule {

    private SearchActivity searchActivity;
    private SearchPresenter mainPresenter;


    public SearchActivityModule(SearchActivity searchActivity) {
        this.searchActivity = searchActivity;
        mainPresenter = new SearchPresenter(searchActivity);
    }

    @Provides
    @ActivityScope
    SearchActivity provideSearchActivity() {
        return searchActivity;
    }

    @Provides
    @ActivityScope
    SearchPresenter provideSearchPresenter() {
        return mainPresenter;
    }

    @Provides
    @ActivityScope
    SearchViewModel provideSearchViewModel() {
        return new SearchViewModel(searchActivity, mainPresenter);
    }

}
