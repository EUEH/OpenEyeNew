package com.eueh.openeye.concern.concerndetails.concerntitle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 陈小飞 on 16/12/23.
 */

public class ConcernTitleVpAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> arrayList;
    String[] str = {"按时间排序", "按分享排序"};

    public ConcernTitleVpAdapter setArrayList(ArrayList<Fragment> arrayList) {
        this.arrayList = arrayList;
        return this;
    }

    public ConcernTitleVpAdapter(FragmentManager fm) {
        super(fm);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
