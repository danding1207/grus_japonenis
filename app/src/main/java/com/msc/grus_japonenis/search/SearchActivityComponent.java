package com.msc.grus_japonenis.search;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;

import dagger.Component;

/**
 * Created by 杨 on 2015/12/23.
 */
@ActivityScope
@Component(modules = SearchActivityModule.class,dependencies = ApplicationComponent.class)
public interface SearchActivityComponent {
    SearchActivity inject(SearchActivity mainActivity);
    SearchPresenter presenter();
    SearchViewModel viewModel();
}
