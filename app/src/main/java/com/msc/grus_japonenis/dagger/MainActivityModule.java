package com.msc.grus_japonenis.dagger;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.grus_japonenis.main.MainViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainViewModel provideMainViewModel() {
        return new MainViewModel(mainActivity);
    }

}
