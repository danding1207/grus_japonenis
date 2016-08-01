package com.msc.grus_japonenis.publish;

import com.msc.grus_japonenis.lib.injection.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 杨 on 2015/12/23.
 */
@Module
public class PublishActivityModule {

    private PublishActivity publishActivity;
    private PublishPresenter publishPresenter;

    public PublishActivityModule(PublishActivity publishActivity) {
        this.publishActivity = publishActivity;
        publishPresenter = new PublishPresenter(publishActivity);
    }

    @Provides
    @ActivityScope
    PublishActivity providePublishActivity() {
        return publishActivity;
    }

    @Provides
    @ActivityScope
    PublishPresenter providePublishPresenter() {
        return publishPresenter;
    }

    @Provides
    @ActivityScope
    PublishViewModel providePublishViewModel() {
        return new PublishViewModel(publishActivity, publishPresenter);
    }

    @Provides
    @ActivityScope
    PublishPicAdapter providePublishPicAdapter() {
        return new PublishPicAdapter(publishActivity, null, publishPresenter);
    }

}
