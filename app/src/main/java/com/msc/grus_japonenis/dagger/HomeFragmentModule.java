package com.msc.grus_japonenis.dagger;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.grus_japonenis.main.homefragment.DestinationsListAdapter;
import com.msc.grus_japonenis.main.homefragment.HomeFragment;
import com.msc.grus_japonenis.main.homefragment.HomeFragmentViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class HomeFragmentModule {

    private HomeFragment homeFragment;
    private MainActivity mainActivity;
    private HomeFragmentViewModel homeFragmentViewModel;

    public HomeFragmentModule(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        mainActivity = (MainActivity) homeFragment.getActivity();
        homeFragmentViewModel = new HomeFragmentViewModel(mainActivity, homeFragment);
    }

    @Provides
    @ActivityScope
    HomeFragment provideHomeFragment() {
        return homeFragment;
    }

    @Provides
    @ActivityScope
    HomeFragmentViewModel provideHomeFragmentViewModel() {
        return homeFragmentViewModel;
    }

    @Provides
    @ActivityScope
    DestinationsListAdapter provideDestinationsListAdapter() {
        return new DestinationsListAdapter(mainActivity, homeFragmentViewModel);
    }

}
