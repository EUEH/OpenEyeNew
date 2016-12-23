package com.eueh.openeye.concern;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈小飞 on 16/12/21.
 */

public class SecondVpAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    Context context;
    List<ConcernBean.ItemListBeanX.DataBeanX.ItemListBean> list;
    ViewPager viewPager;
    ArrayList<ConcernPointF> points;

    public SecondVpAdapter setPoints(ArrayList<ConcernPointF> points) {
        this.points = points;
        notifyDataSetChanged();
        return this;
    }

    public SecondVpAdapter setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
        return this;
    }

    public SecondVpAdapter(Context context) {
        this.context = context;
    }

    public SecondVpAdapter setList(List<ConcernBean.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.list = list;
        Log.d("--------------", "list.size():" + list.size());
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getCount() {
        return list != null ? Integer.MAX_VALUE : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_concern_second_vp_f, container, false);
        ImageView ivFeedF = (ImageView) view.findViewById(R.id.iv_item_second_vp_feed_f);
        TextView tvTitleF = (TextView) view.findViewById(R.id.tv_item_second_vp_title_f);
        TextView tvCategoryF = (TextView) view.findViewById(R.id.tv_item_second_vp_category_f);
        TextView tvReleaseTimeF = (TextView) view.findViewById(R.id.tv_item_second_vp_releaseTime_f);
        Glide.with(context).load(list.get(position % list.size()).getData().getCover().getFeed()).into(ivFeedF);
        tvTitleF.setText(list.get(position % list.size()).getData().getTitle());
        tvCategoryF.setText(list.get(position % list.size()).getData().getCategory()+ "/ ");
        String min = TimeConversion.conversionTime(list.get(position % list.size()).getData().getReleaseTime()).substring(14, 19);
        tvReleaseTimeF.setText(min);
        container.addView(view);
//        viewPager.addOnPageChangeListener(this);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (container.getChildAt(position) == object){
            container.removeViewAt(position);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("SecondVpAdapter", "123:" + 123);
        int a = position % list.size();
        for (ConcernPointF point : points) {
            point.setSelected(false);
        }
        if (a == position % points.size()){
            points.get(a).setSelected(true);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
