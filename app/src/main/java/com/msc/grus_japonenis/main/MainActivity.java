package com.msc.grus_japonenis.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.View;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.databinding.ActivityMainBinding;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.lib.utils.MCPTool;
import com.msc.lib.widget.CustomTabItem;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainPresenter mPresenter;
    @Inject
    MainViewModel mViewModel;

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, setContentViewIds());
        activityMainBinding.setMainViewModel(mViewModel);
        mPresenter.attachView(this);
        mPresenter.start();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public int setContentViewIds() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .applicationComponent(appComponent)
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public ActivityMainBinding getActivityMainBinding() {
        return activityMainBinding;
    }

    public void initView() {
        colorChange(this, ContextCompat.getColor(this, R.color.appToolbarColor));
        activityMainBinding.container.setOffscreenPageLimit(4);
        activityMainBinding.container.setAdapter(mViewModel.getSectionsPagerAdapter());
        activityMainBinding.container.addOnPageChangeListener(mPresenter);
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.container);
        initTabLayout();
        requestViewPager();


        String ChannelId = MCPTool.getChannelId(this, "18120507", "-1");
        if (!ChannelId.equals("-1")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("打包渠道号：");
            builder.setMessage(ChannelId);
            builder.create().show();
        }

    }

    public void requestViewPager() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        activityMainBinding.container.post(new Runnable() {
            public void run() {
                int height = activityMainBinding.container.getHeight();   // 屏幕高度（像素）
                int height2 = height + activityMainBinding.fakeSearchView.getHeight();
                ((CoordinatorLayout.LayoutParams) activityMainBinding.container.getLayoutParams()).height = height2;
                activityMainBinding.container.requestLayout();
            }
        });
    }

    public void initTabLayout() {
        for (int i = 0; i < mViewModel.getIcon().length; i++) {
            CustomTabItem localCustomTabItem = new CustomTabItem(this);
            localCustomTabItem.configItem(mViewModel.getTitles()[i], mViewModel.getIcon()[i]);
            if (i == 0)
                localCustomTabItem.setSelected(true);
            TabLayout.Tab localTab = activityMainBinding.tabs.getTabAt(i);
            if (localTab == null) {
                localTab = activityMainBinding.tabs.newTab();
                activityMainBinding.tabs.addTab(localTab);
            }
            localTab.setCustomView(localCustomTabItem);
            final TabLayout.Tab finalLocalTab = localTab;
            localCustomTabItem.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramAnonymousView) {
                    if (!finalLocalTab.isSelected())
                        finalLocalTab.select();
                }
            });
        }
    }

    @Override
    public void showFab() {
        if (!mPresenter.fabIsShown()) {
            ViewCompat.animate(activityMainBinding.fab).cancel();
            ViewCompat.animate(activityMainBinding.fab).scaleX(1.0F).scaleY(1.0F).setListener(new ViewPropertyAnimatorListener() {
                public void onAnimationCancel(View paramAnonymousView) {
                }

                public void onAnimationEnd(View paramAnonymousView) {
                }

                public void onAnimationStart(View paramAnonymousView) {
                    activityMainBinding.fab.setVisibility(View.VISIBLE);
                }
            }).setDuration(200L).start();
            mPresenter.setFabIsShown(true);
        }
    }

    @Override
    public void showToolbar() {
        if (ViewCompat.getTranslationY(activityMainBinding.appbar) != 0.0F) {
            ViewCompat.animate(activityMainBinding.appbar).cancel();
            ViewCompat.animate(activityMainBinding.appbar).translationY(0.0F).setDuration(200L).start();
            ViewCompat.animate(activityMainBinding.container).cancel();
            ViewCompat.animate(activityMainBinding.container).translationY(0.0F).setDuration(200L).start();
        }
    }

    @Override
    public void hideFab() {
        if (mPresenter.fabIsShown()) {
            ViewCompat.animate(activityMainBinding.fab).cancel();
            ViewCompat.animate(activityMainBinding.fab).scaleX(0.0F).scaleY(0.0F).setListener(new ViewPropertyAnimatorListener() {
                public void onAnimationCancel(View paramAnonymousView) {
                    activityMainBinding.fab.setVisibility(View.VISIBLE);
                }

                public void onAnimationEnd(View paramAnonymousView) {
                    activityMainBinding.fab.setVisibility(View.GONE);
                }

                public void onAnimationStart(View paramAnonymousView) {
                    activityMainBinding.fab.setVisibility(View.VISIBLE);
                }
            }).setDuration(200L).start();
            mPresenter.setFabIsShown(false);
        }
    }

    @Override
    public void hideToolbar() {
        float f = ViewCompat.getTranslationY(activityMainBinding.appbar);
        int i = activityMainBinding.fakeSearchView.getHeight();
        if (f != -i) {
            ViewCompat.animate(activityMainBinding.appbar).cancel();
            ViewCompat.animate(activityMainBinding.appbar).translationY(-i).setDuration(200L).start();
            ViewCompat.animate(activityMainBinding.container).cancel();
            ViewCompat.animate(activityMainBinding.container).translationY(-i).setDuration(200L).start();
        }
    }

    @Override
    public void onBackPressed() {
        mPresenter.onBackPressed();
    }
}
