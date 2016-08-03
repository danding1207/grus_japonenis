package com.msc.grus_japonenis.main.homefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.msc.grus_japonenis.base.BaseFragment;
import com.msc.grus_japonenis.databinding.FragmentHomeBinding;
import com.msc.grus_japonenis.lib.injection.ApplicationComponent;
import javax.inject.Inject;

/**
 * Created by msc on 2016/3/28.
 */
public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {

    @Inject
    DestinationsListAdapter mDestinationsListAdapter;
    @Inject
    HomeFragmentPresenter mHomeFragmentPresenter;

    private static HomeFragment instance;

    private FragmentHomeBinding mFragmentHomeBinding;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HomeFragment newInstance() {
        if (instance == null) {
            instance = new HomeFragment();
        }
        return instance;
    }

    public HomeFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        return mFragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHomeFragmentPresenter.attachView(this);
        initView();
        mHomeFragmentPresenter.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        mFragmentHomeBinding.observableRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFragmentHomeBinding.observableRecyclerView.setHasFixedSize(true);
        mFragmentHomeBinding.observableRecyclerView.setScrollViewCallbacks(mHomeFragmentPresenter);
        mFragmentHomeBinding.observableRecyclerView.setAdapter(mDestinationsListAdapter);
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent appComponent) {
        DaggerHomeFragmentComponent.builder()
                .applicationComponent(appComponent)
                .homeFragmentModule(new HomeFragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    public FragmentHomeBinding getFragmentHomeBinding() {
        return mFragmentHomeBinding;
    }

    @Override
    public DestinationsListAdapter getDestinationsListAdapter() {
        return mDestinationsListAdapter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mHomeFragmentPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mHomeFragmentPresenter.onPause();
    }
}
