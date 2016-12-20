package com.eueh.openeye.find;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/19.
 */

public class FindFragment extends BaseFragment {
    private ListView lvFindG;
    private ArrayList<String>data;
    private Banner bannerHead;

    @Override
    public int setLayout() {
        return R.layout.fragment_find;
    }

    @Override
    public void initView(View view) {
        lvFindG = (ListView) view.findViewById(R.id.lv_find_g);
        View viewHead = LayoutInflater.from(getContext()).inflate(R.layout.item_find_head_g,null);
        lvFindG.addHeaderView(viewHead);
        bannerHead = (Banner) viewHead.findViewById(R.id.banner_head);
        data = new ArrayList<>();

    }

    @Override
    public void initData() {
        for (int i = 0; i < 30; i++) {
            data.add("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1482205812&di=7ee291f719fbd761c31a311e254c08f1&src=http://img.9ku.com/geshoutuji/singertuji/5/50770/50770_2.jpg");
        }
        FindAdapter findAdapter = new FindAdapter(getContext());
        findAdapter.setData(data);
        lvFindG.setAdapter(findAdapter);

        //头布局轮播
        bannerHead();
    }

    private void bannerHead() {

        bannerHead.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        bannerHead.setImageLoader(new MyImage());
        bannerHead.setImages(data);
        bannerHead.setBannerAnimation(Transformer.ZoomOutSlide);
        bannerHead.isAutoPlay(false);
        bannerHead.setDelayTime(2000);
        bannerHead.setIndicatorGravity(BannerConfig.CENTER);
        bannerHead.start();
    }


}
