package com.msc.grus_japonenis.search;

import android.annotation.TargetApi;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.base.BaseSwipeBackActivity;
import com.msc.grus_japonenis.databinding.ActivitySearchBinding;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.lib.net.bean.DestinationsSearch;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

public class SearchActivity extends BaseSwipeBackActivity implements SearchContract.View {

    @Inject
    SearchPresenter mPresenter;
    @Inject
    SearchViewModel mViewModel;

    private ActivitySearchBinding activitySearchBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySearchBinding = DataBindingUtil.setContentView(this, setContentViewIds());
        activitySearchBinding.setSearchViewModel(mViewModel);
        mPresenter.attachView(this);
        initView();
        mPresenter.start();
    }

    @Override
    public int setContentViewIds() {
        return R.layout.activity_search;
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {
        DaggerSearchActivityComponent.builder()
                .applicationComponent(appComponent)
                .searchActivityModule(new SearchActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    public ActivitySearchBinding getActivitySearchBinding() {
        return activitySearchBinding;
    }

    @Override
    public void setSearchText(String text) {
        activitySearchBinding.etSearch.setText(text);

        RxTextView.textChangeEvents(activitySearchBinding.etSearch)
                .debounce(400, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TextViewTextChangeEvent>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(TextViewTextChangeEvent onTextChangeEvent) {
                        if (!TextUtils.isEmpty(onTextChangeEvent.text().toString()))
                            mPresenter.serach("full_text", onTextChangeEvent.text().toString());
                    }
                });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void initView() {
        colorChange(this, ContextCompat.getColor(this, R.color.appToolbarColor));
        setSupportActionBar(activitySearchBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setSearchResult(DestinationsSearch result) {
        mViewModel.setDestinationsSearch(result);
    }

    @Override
    public void showProgressBar() {
        mViewModel.setProgressBarShow(true);
    }

    @Override
    public void dismissProgressBar() {
        mViewModel.setProgressBarShow(false);
    }

}
