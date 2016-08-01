package com.msc.grus_japonenis;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.msc.grus_japonenis.base.BaseFragment;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;

/**
 * Created by msc on 2016/3/28.
 */
public class MyPlanFragment extends BaseFragment {

    private static MyPlanFragment instance;
    private Activity activity;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MyPlanFragment newInstance() {
        if (instance == null) {
            instance = new MyPlanFragment();
        }
        return instance;
    }

    public MyPlanFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_plans, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initdata();
    }

    private void initdata() {
    }


    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {

    }
}
