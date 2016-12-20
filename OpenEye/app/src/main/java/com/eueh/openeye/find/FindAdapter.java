package com.eueh.openeye.find;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.eueh.openeye.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * Created by Even on 16/12/20.
 */

public class FindAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> data;
    //盛放轮播图的url
    private ArrayList<String> dataBannerB;

    public static final int TYPE_ONE = 0;
    //代表第二种类型
    public static final int TYPE_TWO = 1;

    public static final int TYPE_THREE = 2;
    //类型总数
    public static final int TYPE_COUNT = 3;

    public FindAdapter(Context context) {
        this.context = context;
        dataBannerB = new ArrayList<>();

    }

    public void setData(ArrayList<String> data) {
        this.data = data;
        for (int i = 0; i < 5; i++) {
            dataBannerB.add(data.get(i));
        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 3) {
            return TYPE_ONE;
        } else if (position == 3) {
            return TYPE_THREE;
        } else {
            return TYPE_TWO;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderFindR holderFindR = null;
        ViewHolderFindV holderFindV = null;
        viewHolderFindB holderFindB = null;
        if (view == null) {
            switch (getItemViewType(i)) {
                case TYPE_ONE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_findr_g, viewGroup, false);
                    holderFindR = new ViewHolderFindR(view);
                    view.setTag(holderFindR);
                    break;

                case TYPE_TWO:
                    view = LayoutInflater.from(context).inflate(R.layout.item_findv_g, viewGroup, false);
                    holderFindV = new ViewHolderFindV(view);
                    view.setTag(holderFindV);
                    break;

                case TYPE_THREE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_findb_g, viewGroup, false);
                    holderFindB = new viewHolderFindB(view);
                    view.setTag(holderFindB);
                    break;
            }
        } else {
            switch (getItemViewType(i)) {
                case TYPE_ONE:
                    holderFindR = (ViewHolderFindR) view.getTag();
                    break;

                case TYPE_TWO:
                    holderFindV = (ViewHolderFindV) view.getTag();
                    break;
                case TYPE_THREE:
                    holderFindB = (viewHolderFindB) view.getTag();
                    break;
            }
        }
        switch (getItemViewType(i)) {
            //带recview的
            case TYPE_ONE:
                FindRAdapter adapter = new FindRAdapter(context);
                adapter.setData(data);
                holderFindR.rvFindR.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                holderFindR.rvFindR.setAdapter(adapter);
                break;

            //banner中间的
            case TYPE_TWO:
                Banner bannerR = (Banner) view.findViewById(R.id.rv_find_v_g);
                bannerR.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                bannerR.setImageLoader(new MyImage());
                bannerR.setImages(dataBannerB);
                bannerR.setBannerAnimation(Transformer.ZoomOutSlide);
                bannerR.isAutoPlay(false);
                bannerR.setDelayTime(2000);
                bannerR.setIndicatorGravity(BannerConfig.CENTER);
                bannerR.start();

                break;

            //banner下面的
            case TYPE_THREE:
                Banner bannerB = (Banner) view.findViewById(R.id.rv_find_r_g);
                bannerB.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                bannerB.setImageLoader(new MyImage());
                bannerB.setImages(dataBannerB);
                bannerB.setBannerAnimation(Transformer.ZoomOutSlide);
                bannerB.isAutoPlay(false);
                bannerB.setDelayTime(2000);
                bannerB.setIndicatorGravity(BannerConfig.CENTER);
                bannerB.start();

                break;
        }
        return view;
    }

    //recview的缓存类
    class ViewHolderFindR {
        private RecyclerView rvFindR;

        public ViewHolderFindR(View view) {
            rvFindR = (RecyclerView) view.findViewById(R.id.rv_find_r_g);
        }
    }

    //viewpagre 缓存类
    class ViewHolderFindV {
        public ViewHolderFindV(View view) {

        }
    }

    //banner 缓存类
    class viewHolderFindB {
        public viewHolderFindB(View view) {
        }
    }
}
