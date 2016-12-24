package com.eueh.openeye.find.detailhotmid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Even on 16/12/23.
 */

public class FindDetailHotMidAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>data;
    private String[] title = {"周排行","月排行","总排行"};

    public FindDetailHotMidAdapter(FragmentManager fm, ArrayList<Fragment> data) {
        super(fm);
        this.data = data;
    }

    public FindDetailHotMidAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
