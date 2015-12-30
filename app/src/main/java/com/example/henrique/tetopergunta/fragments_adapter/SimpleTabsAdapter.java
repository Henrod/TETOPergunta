package com.example.henrique.tetopergunta.fragments_adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henrique on 18/12/15.
 */
public class SimpleTabsAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> FragmentList = new ArrayList<Fragment>();
    private final List<String> FragmentTitles = new ArrayList<String>();

    public SimpleTabsAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        FragmentList.add(fragment);
        FragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentTitles.get(position);
    }

}