package com.msc.grus_japonenis.dagger;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.grus_japonenis.main.MainActivity;
import com.msc.grus_japonenis.main.MainViewModel;

import dagger.Component;

/**
 * Created by 杨 on 2015/12/23.
 */
@ActivityScope
@Component(modules = MainActivityModule.class,dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
    MainViewModel viewModel();
}
