package com.msc.grus_japonenis.dagger;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.search.SearchActivity;
import com.msc.grus_japonenis.search.SearchViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class SearchActivityModule {

    private SearchActivity searchActivity;


    public SearchActivityModule(SearchActivity searchActivity) {
        this.searchActivity = searchActivity;
    }

    @Provides
    @ActivityScope
    SearchActivity provideSearchActivity() {
        return searchActivity;
    }

    @Provides
    @ActivityScope
    SearchViewModel provideSearchViewModel() {
        return new SearchViewModel(searchActivity);
    }

}
