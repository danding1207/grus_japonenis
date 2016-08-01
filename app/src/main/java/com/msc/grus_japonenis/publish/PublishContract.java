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

import android.content.Intent;
import android.net.Uri;

import com.msc.grus_japonenis.databinding.ActivityPublishBinding;
import com.msc.grus_japonenis.databinding.ActivitySearchBinding;
import com.msc.grus_japonenis.lib.injection.BasePresenter;
import com.msc.grus_japonenis.lib.injection.BaseView;
import com.msc.lib.net.bean.DestinationsSearch;

import java.util.ArrayList;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface PublishContract {

    interface View extends BaseView {
        ActivityPublishBinding getActivityPublishBinding();
        void setPic(ArrayList<Uri> mSelectedPic);
        void setDate(String date);
    }

    abstract class Presenter<T extends View> extends BasePresenter<T> {
        abstract void result(int requestCode, int resultCode, Intent data);
        public abstract void tag();
        public abstract void poi();
        public abstract void date();
        public abstract void publish();
        public abstract void pickpic();
    }
}
