package com.msc.grus_japonenis.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.msc.grus_japonenis.lib.injection.ApplicationComponent;

/**
 * Created by msc on 2016/3/28.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(BaseApplication.get().getComponent());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract void setupActivityComponent(ApplicationComponent appComponent);

}
