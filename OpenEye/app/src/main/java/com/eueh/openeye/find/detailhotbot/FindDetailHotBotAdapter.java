package com.eueh.openeye.find.detailhotbot;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Even on 16/12/24.
 */

public class FindDetailHotBotAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>data;
    private String title[] = {"按时间排序","按分享排序"};

    public FindDetailHotBotAdapter(FragmentManager fm) {
        super(fm);
    }

    public FindDetailHotBotAdapter(FragmentManager fm, ArrayList<Fragment> data) {
        super(fm);
        this.data = data;
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
