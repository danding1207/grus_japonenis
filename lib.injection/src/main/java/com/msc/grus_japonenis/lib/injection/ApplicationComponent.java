package com.msc.grus_japonenis.lib.injection;

import android.app.Application;
import android.content.Context;

import com.msc.lib.net.AppService;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();
    Application application();
    AppService appService();
//    PreferencesHelper preferencesHelper();
//    DatabaseHelper databaseHelper();
//    DataManager dataManager();
//    Bus eventBus();

}
