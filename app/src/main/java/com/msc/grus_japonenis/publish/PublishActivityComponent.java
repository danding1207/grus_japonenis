package com.msc.grus_japonenis.publish;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;

import dagger.Component;

/**
 * Created by 杨 on 2015/12/23.
 */
@ActivityScope
@Component(modules = PublishActivityModule.class,dependencies = ApplicationComponent.class)
public interface PublishActivityComponent {
    PublishActivity inject(PublishActivity mainActivity);
    PublishPresenter presenter();
    PublishViewModel viewModel();
    PublishPicAdapter adapter();
}
