package com.msc.grus_japonenis.base;

import android.app.Application;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
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
public class BaseApplication extends Application {

    @Inject
    AppService appService;


    private static Context mContext;
    private static BaseApplication mApplication;

    ApplicationComponent mApplicationComponent;
    public static InputMethodManager manager = null;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext());
        AppService.getInstance().initService(getApplicationContext());
        GlideUtils.getInstance(getApplicationContext());
        this.registerActivityLifecycleCallbacks(ActivityStack.getInstance());
        OneApmAgent.init(getApplicationContext()).setToken("0894B614C16F0E4F2F8C142592689AA387").start();
        Logger.init("Inspiration");
        manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mContext = getApplicationContext();
        mApplication = this;
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
