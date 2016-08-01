package com.msc.grus_japonenis.launch;

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
    LaunchPresenter provideLaunchPresenter() {
        return new LaunchPresenter(launchActivity);
    }

//    @Provides
//    @ActivityScope
//    EmbellishDialog provideEmbellishDialog(LaunchActivity launchActivity) {
//        return new EmbellishDialog(launchActivity, 4);
//    }

}
