package com.msc.grus_japonenis.launch;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.databinding.ActivityLaunchBinding;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import javax.inject.Inject;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LaunchActivity extends BaseActivity implements LaunchContract.View {

    @Inject
    LaunchPresenter mPresenter;

    private ActivityLaunchBinding activityLaunchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLaunchBinding = DataBindingUtil.setContentView(this, setContentViewIds());
        mPresenter.attachView(this);
//        mLaunchActivityPrattachViewesenter.initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.result(requestCode, resultCode);
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
