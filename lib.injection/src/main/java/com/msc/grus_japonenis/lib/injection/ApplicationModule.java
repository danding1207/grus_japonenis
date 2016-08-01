package com.msc.grus_japonenis.lib.injection;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.msc.lib.net.AppService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    public ApplicationModule(AppCompatActivity activity) {
        mApplication = activity.getApplication();
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
//    @ActivityScope
    AppService provideAppService() {
        return AppService.getInstance().initService(mApplication);
    }

}
