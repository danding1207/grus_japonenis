package com.msc.grus_japonenis.launch;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.dagger.DaggerLaunchActivityComponent;
import com.msc.grus_japonenis.dagger.LaunchActivityModule;
import com.msc.grus_japonenis.databinding.ActivityLaunchBinding;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.lib.net.AppService;
import com.msc.lib.utils.GlideUtils;
import com.oneapm.agent.android.OneApmAgent;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;

import javax.inject.Inject;

import me.majiajie.swipeback.utils.ActivityStack;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LaunchActivity extends BaseActivity {

    @Inject
    LaunchViewModel mViewModel;

    private ActivityLaunchBinding activityLaunchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLaunchBinding = DataBindingUtil.setContentView(this, setContentViewIds());
        /**   Application 初始化操作分离至 LaunchActivity */
        CrashReport.initCrashReport(getApplicationContext());
        AppService.getInstance().initService(getApplicationContext());
        GlideUtils.getInstance(getApplicationContext());
        getApplication().registerActivityLifecycleCallbacks(ActivityStack.getInstance());
        OneApmAgent.init(getApplicationContext()).setToken("0894B614C16F0E4F2F8C142592689AA387").start();
        Logger.init("Inspiration");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {
        DaggerLaunchActivityComponent.builder()
                .applicationComponent(appComponent)
                .launchActivityModule(new LaunchActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int setContentViewIds() {
        return R.layout.activity_launch;
    }

}
