package com.msc.grus_japonenis.publish;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.thread.EventThread;
import com.msc.lib.net.AppService;
import com.msc.lib.net.event.Constant;
import com.msc.lib.net.event.DestinationsSearchEvent;
import com.msc.lib.utils.SnackbarUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Calendar;

import io.valuesfeng.picker.Picker;
import io.valuesfeng.picker.engine.GlideEngine;
import io.valuesfeng.picker.utils.PicturePickerUtils;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by msc on 2016/6/20.
 */

public class PublishPresenter extends PublishContract.Presenter<PublishContract.View> implements DatePickerDialog.OnDateSetListener {

    public static final String DATEPICKER_TAG = "datepicker";
    static final int REQUEST_CODE_CHOOSE = 0123;
    private PublishActivity mActivity;
    private ArrayList<Uri> mSelectedPic = new ArrayList<>();
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;

    public PublishPresenter(@NonNull PublishActivity activity) {
        mActivity = checkNotNull(activity, "MainActivity cannot be null!");
        calendar = Calendar.getInstance();
        datePickerDialog = DatePickerDialog.newInstance(this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), false);
    }

    @Override
    public void attachView(PublishContract.View mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void start() {
        checkViewAttached();
        getMvpView().setDate("旅行日期");
    }

    @Override
    public void result(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
            mSelectedPic.addAll(PicturePickerUtils.obtainResult(data));
            getMvpView().setPic(mSelectedPic);
        }
    }

    @Override
    public void tag() {
        SnackbarUtils.toast(getMvpView().getActivityPublishBinding().mainContent, "添加标签", Snackbar.LENGTH_SHORT);
    }

    @Override
    public void poi() {
        SnackbarUtils.toast(getMvpView().getActivityPublishBinding().mainContent, "查找目的地", Snackbar.LENGTH_SHORT);
    }

    @Override
    public void date() {
//        SnackbarUtils.toast(getMvpView().getActivityPublishBinding().mainContent, "日期", Snackbar.LENGTH_SHORT);
        datePickerDialog.setYearRange(1985, 2028);
        datePickerDialog.setCloseOnSingleTapDay(false);
        datePickerDialog.show(mActivity.getSupportFragmentManager(), DATEPICKER_TAG);


    }

    @Override
    public void publish() {
        SnackbarUtils.toast(getMvpView().getActivityPublishBinding().mainContent, "发布", Snackbar.LENGTH_SHORT);
    }

    @Override
    public void pickpic() {
        Picker.from(mActivity)
                .count(9-mSelectedPic.size())
                .enableCamera(true)
                .setEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);
    }


    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        getMvpView().setDate(year + "-" + month + "-" + day);
    }
}
