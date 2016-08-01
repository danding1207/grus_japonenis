package com.msc.grus_japonenis.main;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;
    private MainPresenter mainPresenter;


    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        mainPresenter = new MainPresenter(mainActivity);
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainPresenter provideMainPresenter() {
        return mainPresenter;
    }

    @Provides
    @ActivityScope
    MainViewModel provideMainViewModel() {
        return new MainViewModel(mainActivity, mainPresenter);
    }

}
