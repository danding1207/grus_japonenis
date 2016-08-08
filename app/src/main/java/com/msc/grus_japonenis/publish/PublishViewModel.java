/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.msc.grus_japonenis.publish;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import com.fourmob.datetimepicker.date.DatePickerDialog;
import com.msc.grus_japonenis.BR;
import com.msc.grus_japonenis.lib.injection.ViewModel;
import com.msc.lib.utils.SnackbarUtils;
import java.util.ArrayList;
import io.valuesfeng.picker.Picker;
import io.valuesfeng.picker.engine.GlideEngine;
import io.valuesfeng.picker.utils.PicturePickerUtils;

/**
 * Exposes the data to be used in the {@link PublishActivity}.
 * <p>
 * {@link BaseObservable} implements a listener registration mechanism which is notified when a
 * property changes. This is done by assigning a {@link Bindable} annotation to the property's
 * getter method.
 */
public class PublishViewModel extends BaseObservable implements ViewModel, DatePickerDialog.OnDateSetListener {

    public static final int REQUEST_CODE_CHOOSE = 0012;
    public static final String DATEPICKER_TAG = "datepicker";
    private PublishActivity publishActivity;
    private String date;
    private ArrayList<Uri> mSelectedPic = new ArrayList<>();

    public PublishViewModel(PublishActivity publishActivity) {
        this.publishActivity = publishActivity;
    }

    /**  数据绑定 */
    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    /**  生命周期 */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
        setDate("旅行----日期");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroyView() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == Activity.RESULT_OK) {
            mSelectedPic.addAll(PicturePickerUtils.obtainResult(data));
            publishActivity.setPic(mSelectedPic);
        }
    }

    /**  业务处理 */
    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        setDate(year + "-" + (month+1) + "-" + day);
    }

    public void tag() {
        SnackbarUtils.toast(publishActivity.getActivityPublishBinding().mainContent, "添加标签", Snackbar.LENGTH_SHORT);
    }

    public void poi() {
        SnackbarUtils.toast(publishActivity.getActivityPublishBinding().mainContent, "查找目的地", Snackbar.LENGTH_SHORT);
    }

    public void date() {
        publishActivity.showDatePickerDialog();
    }

    public void publish() {
        SnackbarUtils.toast(publishActivity.getActivityPublishBinding().mainContent, "发布", Snackbar.LENGTH_SHORT);
    }

    public void pickpic() {
        Picker.from(publishActivity)
                .count(9-mSelectedPic.size())
                .enableCamera(true)
                .setEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);
    }










}
