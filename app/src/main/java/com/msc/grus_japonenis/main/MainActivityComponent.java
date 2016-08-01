package com.msc.grus_japonenis.main;

import com.msc.grus_japonenis.launch.LaunchActivity;
import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;

import dagger.Component;

/**
 * Created by 杨 on 2015/12/23.
 */
@ActivityScope
@Component(modules = MainActivityModule.class,dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
    MainPresenter presenter();
//    MainViewModel viewModel();
}
