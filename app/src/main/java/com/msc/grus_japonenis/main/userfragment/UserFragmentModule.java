package com.msc.grus_japonenis.main.userfragment;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.grus_japonenis.main.homefragment.DestinationsListAdapter;
import com.msc.grus_japonenis.main.homefragment.HomeFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class UserFragmentModule {

    private UserFragment userFragment;
    private UserFragmentPresenter userFragmentPresenter;
    private MainActivity mainActivity;

    public UserFragmentModule(UserFragment userFragment) {
        this.userFragment = userFragment;
        mainActivity = (MainActivity) userFragment.getActivity();
        userFragmentPresenter = new UserFragmentPresenter(mainActivity);
    }

    @Provides
    @ActivityScope
    UserFragment provideUserFragment() {
        return userFragment;
    }

    @Provides
    @ActivityScope
    UserFragmentPresenter provideUserFragmentPresenter() {
        return new UserFragmentPresenter(mainActivity);
    }

    @Provides
    @ActivityScope
    UserFragmentViewModel provideUserFragmentViewModel() {
        return new UserFragmentViewModel(mainActivity, userFragmentPresenter);
    }

}
