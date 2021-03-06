package com.msc.grus_japonenis.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.view.inputmethod.InputMethodManager;

import com.dim.library.Tinker;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.grus_japonenis.lib.injection.ApplicationModule;
import com.msc.grus_japonenis.lib.injection.DaggerApplicationComponent;
import com.msc.lib.net.AppService;
import com.msc.lib.utils.GlideUtils;
import com.oneapm.agent.android.OneApmAgent;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;
import javax.inject.Inject;

import me.majiajie.swipeback.utils.ActivityStack;

/**
 * Created by yb.wang on 15/10/28.
 */
public class BaseApplication extends MultiDexApplication {

    @Inject
    AppService appService;

    private static Context mContext;
    private static BaseApplication mApplication;

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
        mApplication = this;

        Tinker.init(this);
        Tinker.setBackgroundPolicy(new Tinker.BackgroundPolicy() {
            @Override
            public boolean isReadyForFix() {
                return true;
            }
        });
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Tinker.onTrimMemory(level);
    }

    public static BaseApplication get() {
        return mApplication;
    }

    public static Context getContext() {
        return mContext;
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

}
