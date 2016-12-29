package com.eueh.openeye.concern.concerndetails.concernimage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.eueh.openeye.concern.ConcernBean;

/**
 * Created by 陈小飞 on 16/12/24.
 */
//FragmentStatePagerAdapter   会保存当前界面，以及下一个界面和上一个界面（如果有），最多保存3个，其他会被销毁掉
public class ConcernImageAdapter extends FragmentStatePagerAdapter{


    public static ConcernImageBean concernImageBean;
    public static ConcernBean.ItemListBeanX.DataBeanX data;

    public ConcernImageAdapter setData(ConcernBean.ItemListBeanX.DataBeanX data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    public ConcernImageAdapter(FragmentManager fm) {
        super(fm);
    }

    public ConcernImageAdapter setConcernImageBean(ConcernImageBean concernImageBean) {
        this.concernImageBean = concernImageBean;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public Fragment getItem(int position) {
        return ConcernImageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return data.getCount();

    }


    public static ConcernBean.ItemListBeanX.DataBeanX.ItemListBean getData(int pos){
        return data.getItemList().get(pos);
    }
}
