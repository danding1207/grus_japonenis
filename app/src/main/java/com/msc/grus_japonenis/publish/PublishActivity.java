package com.msc.grus_japonenis.publish;

import android.annotation.TargetApi;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;
import com.msc.grus_japonenis.R;
import com.msc.grus_japonenis.base.BaseActivity;
import com.msc.grus_japonenis.base.BaseSwipeBackActivity;
import com.msc.grus_japonenis.dagger.DaggerPublishActivityComponent;
import com.msc.grus_japonenis.dagger.PublishActivityModule;
import com.msc.grus_japonenis.databinding.ActivityPublishBinding;
import com.msc.grus_japonenis.databinding.ActivitySearchBinding;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.lib.net.bean.DestinationsSearch;
import com.msc.lib.net.listener.ItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

public class PublishActivity extends BaseSwipeBackActivity {

    @Inject
    PublishViewModel mViewModel;
    @Inject
    PublishPicAdapter mAdapter;
    @Inject
    DatePickerDialog mDialog;

    private ActivityPublishBinding activityPublishBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPublishBinding = DataBindingUtil.setContentView(this, setContentViewIds());
        activityPublishBinding.setPublishViewModel(mViewModel);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public int setContentViewIds() {
        return R.layout.activity_publish;
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {
        DaggerPublishActivityComponent.builder()
                .applicationComponent(appComponent)
                .publishActivityModule(new PublishActivityModule(this))
                .build()
                .inject(this);
    }

    public ActivityPublishBinding getActivityPublishBinding() {
        return activityPublishBinding;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void initView() {
        colorChange(this, ContextCompat.getColor(this, R.color.appToolbarColor));
        setSupportActionBar(activityPublishBinding.toolbar);
        getSupportActionBar().setTitle("写游记");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityPublishBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        activityPublishBinding.recyclerView.setAdapter(mAdapter);

        ItemTouchHelper.Callback helperCallback = new ItemTouchHelperCallback(mAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(helperCallback);
        helper.attachToRecyclerView(activityPublishBinding.recyclerView);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult( requestCode, resultCode, data);
    }

    public void setPic(ArrayList<Uri> mSelectedPic) {
        mAdapter.updata(mSelectedPic);
    }

    public void showDatePickerDialog() {
        mDialog.setYearRange(1985, 2028);
        mDialog.setCloseOnSingleTapDay(false);
        mDialog.show(this.getSupportFragmentManager(), PublishViewModel.DATEPICKER_TAG);
    }
}
