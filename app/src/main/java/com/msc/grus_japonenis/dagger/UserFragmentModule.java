package com.msc.grus_japonenis.dagger;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.grus_japonenis.main.userfragment.UserFragment;
import com.msc.grus_japonenis.main.userfragment.UserFragmentViewModel;
import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class UserFragmentModule {

    private UserFragment userFragment;
    private MainActivity mainActivity;

    public UserFragmentModule(UserFragment userFragment) {
        this.userFragment = userFragment;
        mainActivity = (MainActivity) userFragment.getActivity();
    }

    @Provides
    @ActivityScope
    UserFragment provideUserFragment() {
        return userFragment;
    }

    @Provides
    @ActivityScope
    UserFragmentViewModel provideUserFragmentViewModel() {
        return new UserFragmentViewModel(mainActivity, userFragment);
    }

}
