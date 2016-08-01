package com.msc.grus_japonenis.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.msc.grus_japonenis.DetailActivity;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.publish.PublishActivity;
import com.msc.grus_japonenis.search.SearchActivity;
import com.msc.lib.utils.SnackbarUtils;
import com.orhanobut.logger.Logger;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by msc on 2016/6/20.
 */

public class MainPresenter extends MainContract.Presenter<MainContract.View> implements ViewPager.OnPageChangeListener {

    private BaseActivity mActivity;

    private boolean mFabIsShown = false;

    public MainPresenter(@NonNull BaseActivity activity){
        mActivity = checkNotNull(activity, "MainActivity cannot be null!");
    }

    @Override
    public void attachView(MainContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void start() {
        checkViewAttached();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                getMvpView().hideFab();
                getMvpView().showToolbar();
                break;
            case 1:
                getMvpView().showFab();
                getMvpView().showToolbar();
                break;
            case 2:
                getMvpView().hideFab();
                getMvpView().showToolbar();
                break;
            case 3:
                getMvpView().hideFab();
                getMvpView().showToolbar();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean toolbarIsHidden() {
        return ViewCompat.getTranslationY(getMvpView().getActivityMainBinding().appbar) == -getMvpView().getActivityMainBinding().fakeSearchView.getHeight();
    }

    @Override
    public boolean toolbarIsShown() {
        return ViewCompat.getTranslationY(getMvpView().getActivityMainBinding().appbar) == 0.0F;
    }

    @Override
    public void setFabIsShown(boolean fabIsShown) {
        mFabIsShown = fabIsShown;
    }

    @Override
    public boolean fabIsShown() {
        return mFabIsShown;
    }

    @Override
    public void search() {
        Logger.e("Search");
        mActivity.startActivity(new Intent(mActivity, SearchActivity.class));
    }

    @Override
    public void add() {
        Logger.e("add");
//        SnackbarUtils.toast(getMvpView().getActivityMainBinding().mainContent, "add", Snackbar.LENGTH_SHORT);
        mActivity.startActivity(new Intent(mActivity, PublishActivity.class));
    }

    private boolean isExit = false;

    @Override
    public void onBackPressed() {
        if(isExit) {
            mActivity.finish();
        } else {
            isExit = true;
            Observable
                    .timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Long>() {
                        @Override
                        public void onCompleted() {
                        }
                        @Override
                        public void onError(Throwable e) {
                        }
                        @Override
                        public void onNext(Long number) {
                            isExit = false;
                        }
                    });
            SnackbarUtils.toast(getMvpView().getActivityMainBinding().mainContent, "再按一次退出！", "立即", Snackbar.LENGTH_SHORT, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.finish();
                }
            });
        }
    }
}
