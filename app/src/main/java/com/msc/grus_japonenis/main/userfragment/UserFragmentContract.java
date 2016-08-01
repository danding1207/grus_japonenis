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

package com.msc.grus_japonenis.main.userfragment;

import com.msc.grus_japonenis.databinding.FragmentUserBinding;
import com.msc.grus_japonenis.lib.injection.BasePresenter;
import com.msc.grus_japonenis.lib.injection.BaseView;
import com.msc.lib.net.bean.User;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface UserFragmentContract {

    interface View extends BaseView {

        FragmentUserBinding getFragmentUserBinding();

        void setUserResult(User result);

//        DestinationsListAdapter getDestinationsListAdapter();

//        void showFab();
//
//        void showToolbar();
//
//        void hideFab();
//
//        void hideToolbar();

//        void setLoadingIndicator(boolean active);
//
//        void showTasks(List<Task> tasks);
//
//        void showAddTask();
//
//        void showTaskDetailsUi(String taskId);
//
//        void showTaskMarkedComplete();
//
//        void showTaskMarkedActive();
//
//        void showCompletedTasksCleared();
//
//        void showLoadingTasksError();
//
//        void showSuccessfullySavedMessage();
//
//        boolean isActive();
    }

    abstract class Presenter<T extends View> extends BasePresenter<T> {

        abstract void result(int requestCode, int resultCode);

        abstract void onResume();

        abstract void onPause();

        abstract void onClick(int id);

//        abstract void setConvenientBanner(ConvenientBanner convenientBanner);

//        abstract boolean toolbarIsHidden();
//
//        abstract boolean toolbarIsShown();
//
//        abstract void setFabIsShown(@NonNull boolean fabIsShown);
//
//        abstract boolean fabIsShown();
//
//        abstract public void search();
//
//        abstract public void add();
//
//        void loadTasks(boolean forceUpdate);
//
//        void addNewTask();
//
//        void openTaskDetails(@NonNull Task requestedTask);
//
//        void completeTask(@NonNull Task completedTask);
//
//        void activateTask(@NonNull Task activeTask);
//
//        void clearCompletedTasks();
//
//        void setFiltering(TasksFilterType requestType);
//
//        TasksFilterType getFiltering();
    }
}
