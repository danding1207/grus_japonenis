package com.msc.grus_japonenis.dagger;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.grus_japonenis.publish.PublishActivity;
import com.msc.grus_japonenis.publish.PublishPicAdapter;
import com.msc.grus_japonenis.publish.PublishViewModel;

import dagger.Component;

/**
 * Created by 杨 on 2015/12/23.
 */
@ActivityScope
@Component(modules = PublishActivityModule.class,dependencies = ApplicationComponent.class)
public interface PublishActivityComponent {
    PublishActivity inject(PublishActivity mainActivity);
    DatePickerDialog dialog();
    PublishViewModel viewModel();
    PublishPicAdapter adapter();
}
