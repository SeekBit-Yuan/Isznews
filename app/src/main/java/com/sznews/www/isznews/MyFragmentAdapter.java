package com.sznews.www.isznews;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Yuan on 2016/11/14.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter{
    private final int PAGE_COUNT = 3;
    private final String[] titles;
    private Context context;
    private List<Fragment> fragments;

    public MyFragmentAdapter(List<Fragment> fragments, String[] titles, FragmentManager fm) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
