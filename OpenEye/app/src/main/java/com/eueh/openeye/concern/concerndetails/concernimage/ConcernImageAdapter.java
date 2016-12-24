package com.eueh.openeye.concern.concerndetails.concernimage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 陈小飞 on 16/12/24.
 */
//FragmentStatePagerAdapter   会保存当前界面，以及下一个界面和上一个界面（如果有），最多保存3个，其他会被销毁掉
public class ConcernImageAdapter extends FragmentStatePagerAdapter{

    private static ConcernImageBean imageBean;

    public ConcernImageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setImageBean(ConcernImageBean imageBean) {
        this.imageBean = imageBean;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return imageBean.getCount() - 1;
    }

    //把从集合中获取的数据(写个静态方法)
    public static int getMessage(int position){
        return imageBean.getItemList().get(position).getData().getItemList().get(position).getData().getId();
    }
}
