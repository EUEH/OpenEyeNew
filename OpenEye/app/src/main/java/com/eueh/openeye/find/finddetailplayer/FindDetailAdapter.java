package com.eueh.openeye.find.finddetailplayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.eueh.openeye.selection.selection_detail.SelctionDeatailBeanParcelable;
import com.eueh.openeye.selection.selection_detail.SelectionDetailBean;
import com.eueh.openeye.selection.selection_detail.SelectionDetailFragment;

import java.util.ConcurrentModificationException;



public class FindDetailAdapter extends FragmentStatePagerAdapter {
    private static FindPlayerDetailBean data ;



////  对外提供方法  /////////////////////////////////////////////////////////////////////////////////////////


    public static FindDeatailBeanParcelable getDetailData (int pos) {
        if (data.getItemList().get(pos).getType().equals("video")){
            FindDeatailBeanParcelable bean = new FindDeatailBeanParcelable();
            bean.setImageFeed(data.getItemList().get(pos).getData().getCover().getFeed());
            bean.setTitle(data.getItemList().get(pos).getData().getTitle());
            bean.setDescription(data.getItemList().get(pos).getData().getDescription());
            bean.setCategory(data.getItemList().get(pos).getData().getCategory());
            bean.setPalyUrl(data.getItemList().get(pos).getData().getPlayUrl());
            bean.setReleaseTime((int) data.getItemList().get(pos).getData().getReleaseTime());
            bean.setShareCount(data.getItemList().get(pos).getData().getConsumption().getShareCount());
            bean.setReplyCount(data.getItemList().get(pos).getData().getConsumption().getReplyCount());
            bean.setCollectionCount(data.getItemList().get(pos).getData().getConsumption().getCollectionCount());
            bean.setBlurred(data.getItemList().get(pos).getData().getCover().getBlurred());
            return bean ;
        }else {
            FindDeatailBeanParcelable bean = new FindDeatailBeanParcelable();
            return bean ;
        }
    }



    public FindDetailAdapter setData(FindPlayerDetailBean data) {
        //!!!!!!!!!!!如果不能从返回的fragment复用里面改变返回的值就从传过来的数据data里面移除////////////////////////
        //!!!!!!!!!!!如果有解决不了的异常就用try  chath 捕获 ////////////////////////

        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    public FindDetailAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return FindDetailFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return data.getCount();
    }
}
