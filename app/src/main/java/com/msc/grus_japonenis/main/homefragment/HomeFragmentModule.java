package com.msc.grus_japonenis.main.homefragment;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.main.MainActivity;
import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class HomeFragmentModule {

    private HomeFragment homeFragment;
    private HomeFragmentPresenter homeFragmentPresenter;
    private MainActivity mainActivity;

    public HomeFragmentModule(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        mainActivity = (MainActivity) homeFragment.getActivity();
        homeFragmentPresenter = new HomeFragmentPresenter(mainActivity);
    }

    @Provides
    @ActivityScope
    HomeFragment provideHomeFragment() {
        return homeFragment;
    }

    @Provides
    @ActivityScope
    HomeFragmentPresenter provideHomeFragmentPresenter() {
        return new HomeFragmentPresenter(mainActivity);
    }

    @Provides
    @ActivityScope
    DestinationsListAdapter provideDestinationsListAdapter() {
        return new DestinationsListAdapter(mainActivity, homeFragmentPresenter);
    }

//    @Provides
//    @ActivityScope
//    MainViewModel provideMainViewModel() {
//        return new MainViewModel(mainActivity, mainPresenter);
//    }

}
