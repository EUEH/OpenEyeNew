package com.eueh.openeye.selection.selection_detail;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Created by 陈焕栋 on 16/12/22.
 */

public class SelectionDetailAdapter extends FragmentStatePagerAdapter {
    private static SelectionDetailBean data ;


////  对外提供方法  /////////////////////////////////////////////////////////////////////////////////////////


    public static SelctionDeatailBeanParcelable getDetailData (int pos) {
        if (data.getIssueList().get(0).getItemList().get(pos).getType().equals("video")){
            SelctionDeatailBeanParcelable bean = new SelctionDeatailBeanParcelable();
            bean.setImageFeed(data.getIssueList().get(0).getItemList().get(pos).getData().getCover().getFeed());
            bean.setTitle(data.getIssueList().get(0).getItemList().get(pos).getData().getTitle());
            bean.setDescription(data.getIssueList().get(0).getItemList().get(pos).getData().getDescription());
            bean.setCategory(data.getIssueList().get(0).getItemList().get(pos).getData().getCategory());
            bean.setPalyUrl(data.getIssueList().get(0).getItemList().get(pos).getData().getPlayUrl());
            bean.setReleaseTime((int) data.getIssueList().get(0).getItemList().get(pos).getData().getReleaseTime());
            bean.setShareCount(data.getIssueList().get(0).getItemList().get(pos).getData().getConsumption().getShareCount());
            bean.setReplyCount(data.getIssueList().get(0).getItemList().get(pos).getData().getConsumption().getReplyCount());
            bean.setCollectionCount(data.getIssueList().get(0).getItemList().get(pos).getData().getConsumption().getCollectionCount());
            bean.setBlurred(data.getIssueList().get(0).getItemList().get(pos).getData().getCover().getBlurred());

            //传位置为了数据库数据库收藏
            bean.setPos(pos);

            return bean ;
        }else {
            SelctionDeatailBeanParcelable bean = new SelctionDeatailBeanParcelable();
            return bean ;
        }
    }



    public SelectionDetailAdapter setData(SelectionDetailBean data) {
        //!!!!!!!!!!!如果不能从返回的fragment复用里面改变返回的值就从传过来的数据data里面移除////////////////////////
        //!!!!!!!!!!!如果有解决不了的异常就用try  chath 捕获 ////////////////////////
        try {
            for (SelectionDetailBean.IssueListBean.ItemListBean itemListBean : data.getIssueList().get(0).getItemList()) {
                if (!itemListBean.getType().equals("video")){
                    data.getIssueList().get(0).getItemList().remove(itemListBean);
                }
            }
        }catch (ConcurrentModificationException e){
        }
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    public SelectionDetailAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return SelectionDetailFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return data.getIssueList().get(0).getCount()-1;
    }
}
