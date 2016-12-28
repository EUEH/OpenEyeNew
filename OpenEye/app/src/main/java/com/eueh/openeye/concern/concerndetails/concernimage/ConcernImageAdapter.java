package com.eueh.openeye.concern.concerndetails.concernimage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by 陈小飞 on 16/12/24.
 */
//FragmentStatePagerAdapter   会保存当前界面，以及下一个界面和上一个界面（如果有），最多保存3个，其他会被销毁掉
public class ConcernImageAdapter extends FragmentStatePagerAdapter{

    private  static int pos;
    public static ConcernImageBean concernImageBean;

    public ConcernImageAdapter(FragmentManager fm) {
        super(fm);
    }

    public ConcernImageAdapter setConcernImageBean(ConcernImageBean concernImageBean) {

        this.concernImageBean = concernImageBean;
        Log.d("bbbbb", "concernImageBean.getCount():" + concernImageBean.getCount());
        notifyDataSetChanged();
        return this;
    }

    @Override
    public Fragment getItem(int position) {
        pos = position;
        return ConcernImageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return concernImageBean != null ? concernImageBean.getCount() : 0;
    }

    public static final int sendPos (){
        return pos;
    }
}
