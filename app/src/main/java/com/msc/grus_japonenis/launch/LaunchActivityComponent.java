package com.msc.grus_japonenis.launch;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;

import dagger.Component;

/**
 * Created by 杨 on 2015/12/23.
 */
@ActivityScope
@Component(modules = LaunchActivityModule.class,dependencies = ApplicationComponent.class)
public interface LaunchActivityComponent {
    LaunchActivity inject(LaunchActivity launchActivity);
    LaunchPresenter presenter();
}
