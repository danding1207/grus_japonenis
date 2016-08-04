package com.msc.grus_japonenis.dagger;

import com.msc.grus_japonenis.launch.LaunchActivity;
import com.msc.grus_japonenis.launch.LaunchViewModel;
import com.msc.grus_japonenis.lib.injection.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class LaunchActivityModule {

    private LaunchActivity launchActivity;

    public LaunchActivityModule(LaunchActivity launchActivity) {
        this.launchActivity = launchActivity;
    }

    @Provides
    @ActivityScope
    LaunchActivity provideLaunchActivity() {
        return launchActivity;
    }

    @Provides
    @ActivityScope
    LaunchViewModel provideLaunchViewModel() {
        return new LaunchViewModel(launchActivity);
    }

}
