package com.msc.grus_japonenis.main.homefragment;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.grus_japonenis.main.MainActivityModule;

import dagger.Component;

/**
 * Created by 杨 on 2015/12/23.
 */
@ActivityScope
@Component(modules = HomeFragmentModule.class,dependencies = ApplicationComponent.class)
public interface HomeFragmentComponent {
//    MainViewModel viewModel();
    void inject(HomeFragment homeFragment);
    HomeFragmentPresenter presenter();
    DestinationsListAdapter adapter();
}
