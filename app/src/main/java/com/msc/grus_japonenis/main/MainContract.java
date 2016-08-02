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

package com.msc.grus_japonenis.main;

import android.support.annotation.NonNull;
import android.view.View;

import com.msc.grus_japonenis.databinding.ActivityMainBinding;
import com.msc.grus_japonenis.lib.injection.BasePresenter;
import com.msc.grus_japonenis.lib.injection.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface MainContract {

    interface View extends BaseView {

        ActivityMainBinding getActivityMainBinding();

        void showFab();

        void showToolbar();

        void hideFab();

        void hideToolbar();

    }

    abstract class Presenter<T extends View> extends BasePresenter<T> {

        abstract void result(int requestCode, int resultCode);

        abstract boolean toolbarIsHidden();

        abstract boolean toolbarIsShown();

        abstract void setFabIsShown(@NonNull boolean fabIsShown);

        abstract boolean fabIsShown();

        abstract public void search();

        abstract public void add(android.view.View view);

        abstract public void onBackPressed();

        abstract void onDestroy();

    }
}
