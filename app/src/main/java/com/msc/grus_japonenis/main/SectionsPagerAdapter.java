package com.msc.grus_japonenis.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by msc on 2016/4/13.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] mFragment;
    private String[] sTitles;

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public SectionsPagerAdapter(FragmentManager fm, Fragment[] fragment, String[] titles) {
        super(fm);
        mFragment = fragment;
        sTitles = titles;
    }

    public void setFragment(Fragment[] fragment) {
        mFragment = fragment;
    }

    public void setsTitles(String[] sTitles) {
        this.sTitles = sTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment[position];
    }

    @Override
    public int getCount() {
        return mFragment.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return sTitles[position];
    }

}
