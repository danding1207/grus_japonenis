package com.msc.grus_japonenis.launch;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.main.MainActivity;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Func1;

import static com.google.common.base.Preconditions.checkNotNull;

import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by msc on 2016/6/20.
 */

public class LaunchPresenter extends LaunchContract.Presenter<LaunchContract.View> {

    private BaseActivity mActivity;

    public LaunchPresenter(@NonNull BaseActivity activity){
        mActivity = checkNotNull(activity, "BaseActivity cannot be null!");
    }

    @Override
    public void attachView(LaunchContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void start() {
        checkViewAttached();
        Observable.timer(2, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
                .map(new Func1<Long, Object>() {
                    @Override
                    public Object call(Long aLong) {
                        mActivity.startActivity(new Intent(mActivity, MainActivity.class));
                        mActivity.finish();
                        return null;
                    }
                }).subscribe();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

}
