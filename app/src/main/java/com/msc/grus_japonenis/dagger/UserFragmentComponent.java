package com.msc.grus_japonenis.dagger;

import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.grus_japonenis.main.userfragment.UserFragment;
import com.msc.grus_japonenis.main.userfragment.UserFragmentViewModel;
import dagger.Component;

/**
 * Created by 杨 on 2015/12/23.
 */
@ActivityScope
@Component(modules = UserFragmentModule.class,dependencies = ApplicationComponent.class)
public interface UserFragmentComponent {
    void inject(UserFragment userFragment);
    UserFragmentViewModel viewModel();
}
