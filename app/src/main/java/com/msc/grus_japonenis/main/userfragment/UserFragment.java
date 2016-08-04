package com.msc.grus_japonenis.main.userfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msc.grus_japonenis.base.BaseFragment;
import com.msc.grus_japonenis.dagger.DaggerUserFragmentComponent;
import com.msc.grus_japonenis.dagger.UserFragmentModule;
import com.msc.grus_japonenis.databinding.FragmentUserBinding;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import com.msc.lib.net.bean.Unread;

import javax.inject.Inject;

/**
 * Created by msc on 2016/3/28.
 */
public class UserFragment extends BaseFragment {

    @Inject
    UserFragmentViewModel mViewModel;

    private static UserFragment instance;

    private FragmentUserBinding mFragmentUserBinding;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static UserFragment newInstance() {
        if (instance == null) {
            instance = new UserFragment();
        }
        return instance;
    }

    public UserFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentUserBinding = FragmentUserBinding.inflate(inflater, container, false);
        mFragmentUserBinding.setUserFragmentViewModel(mViewModel);
        return mFragmentUserBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {

    }

    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {
        DaggerUserFragmentComponent.builder()
                .applicationComponent(appComponent)
                .userFragmentModule(new UserFragmentModule(this))
                .build()
                .inject(this);
    }

    public FragmentUserBinding getFragmentUserBinding() {
        return mFragmentUserBinding;
    }

    public void setUnreadResult(Unread result) {
        mViewModel.setUnread(result);
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onResume();
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.onResume();
    }
}
