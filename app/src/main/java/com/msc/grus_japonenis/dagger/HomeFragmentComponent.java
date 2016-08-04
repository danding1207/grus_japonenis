package com.msc.grus_japonenis.dagger;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.grus_japonenis.main.homefragment.DestinationsListAdapter;
import com.msc.grus_japonenis.main.homefragment.HomeFragment;
import com.msc.grus_japonenis.main.homefragment.HomeFragmentViewModel;

import dagger.Component;

/**
 * Created by 杨 on 2015/12/23.
 */
@ActivityScope
@Component(modules = HomeFragmentModule.class,dependencies = ApplicationComponent.class)
public interface HomeFragmentComponent {
    void inject(HomeFragment homeFragment);
    HomeFragmentViewModel viewModel();
    DestinationsListAdapter adapter();
}
