package com.msc.grus_japonenis.dagger;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.msc.grus_japonenis.lib.injection.ActivityScope;
import com.msc.grus_japonenis.publish.PublishActivity;
import com.msc.grus_japonenis.publish.PublishPicAdapter;
import com.msc.grus_japonenis.publish.PublishViewModel;

import java.util.Calendar;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class PublishActivityModule {

    private PublishActivity publishActivity;
    private PublishViewModel publishViewModel;

    public PublishActivityModule(PublishActivity publishActivity) {
        this.publishActivity = publishActivity;
        publishViewModel = new PublishViewModel(publishActivity);
    }

    @Provides
    @ActivityScope
    PublishActivity providePublishActivity() {
        return publishActivity;
    }

    @Provides
    @ActivityScope
    DatePickerDialog provideDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        return DatePickerDialog.newInstance(publishViewModel, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);
    }

    @Provides
    @ActivityScope
    PublishViewModel providePublishViewModel() {
        return publishViewModel;
    }

    @Provides
    @ActivityScope
    PublishPicAdapter providePublishPicAdapter() {
        return new PublishPicAdapter(publishActivity, null, publishViewModel);
    }

}
