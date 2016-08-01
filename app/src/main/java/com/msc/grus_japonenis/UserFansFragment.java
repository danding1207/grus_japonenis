package com.msc.grus_japonenis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msc.grus_japonenis.base.BaseFragment;
import com.msc.grus_japonenis.databinding.FragmentFansBinding;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;

/**
 * Created by msc on 2016/3/28.
 */
public class UserFansFragment extends BaseFragment {

    private static UserFansFragment instance;

    private FragmentFansBinding mFragmentFansBinding;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static UserFansFragment newInstance() {
        if (instance == null) {
            instance = new UserFansFragment();
        }
        return instance;
    }

    public UserFansFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mFragmentFansBinding.observableRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFragmentFansBinding.observableRecyclerView.setHasFixedSize(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentFansBinding = FragmentFansBinding.inflate(inflater, container, false);
        return mFragmentFansBinding.getRoot();
//        View rootView = inflater.inflate(R.layout.fragment_fans, container, false);
//        return rootView;
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {
//        DaggerUserFansFragmentComponent.builder()
//                .applicationComponent(appComponent)
//                .userFansFragmentModule(new UserFansFragmentModule(this))
//                .build()
//                .inject(this);
    }

}
