package com.eueh.openeye.find.detailrechot;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.find.MyImage;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * Created by Even on 16/12/23.
 */

public class FindDetailHotAdapter extends BaseAdapter {
    private FindDetailHotBean data;
    private Context context;
    private ArrayList<String> bannerHotGIn;

    //NextPageUrl 的数据
    private FindDetailHotNextBean dataNext;


    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;
    private static final int TYPE_THREE = 2;
    private static final int TYPE_COUNT = 10;

    public FindDetailHotAdapter(Context context) {
        this.context = context;
    }

    public void setData(FindDetailHotBean data, FindDetailHotNextBean dataNext) {
        this.data = data;
        this.dataNext = dataNext;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else if (position == 1) {
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
        return data.getItemList().size() + dataNext.getItemList().size() - 1;
    }

    @Override
    public Object getItem(int i) {
        return data.getItemList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        BannerHot bannerHot = null;
        ViewHolder holder = null;
        ViewMid viewMid = null;
        if (view == null) {
            switch (getItemViewType(i)) {

                case TYPE_ONE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_find_banner_hot, viewGroup, false);
                    bannerHot = new BannerHot(view);
                    view.setTag(bannerHot);
                    break;

                case TYPE_TWO:

                    view = LayoutInflater.from(context).inflate(R.layout.item_find_hot_line_g, viewGroup, false);
                    holder = new ViewHolder(view);
                    view.setTag(holder);
                    break;

                case TYPE_THREE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_find_me_mid_none, viewGroup, false);
                    viewMid = new ViewMid(view);
                    view.setTag(viewMid);
                    break;
            }

        } else {
            switch (getItemViewType(i)) {
                case TYPE_ONE:
                    bannerHot = (BannerHot) view.getTag();
                    break;

                case TYPE_TWO:
                    holder = (ViewHolder) view.getTag();
                    break;

                case TYPE_THREE:
                    viewMid = (ViewMid) view.getTag();
                    break;
            }

        }
        switch (getItemViewType(i)) {
            case TYPE_ONE:

                bannerHot.tvHotTop.setText(data.getItemList().get(i).getData().getHeader().getTitle());
                bannerHot.tvHotMid.setText(data.getItemList().get(i).getData().getItemList().get(0).getData().getTitle());
                bannerHot.tvHotLeft.setText(data.getItemList().get(i).getData().getItemList().get(0).getData().getCategory());
                bannerHot.tvHotRight.setText(String.valueOf(data.getItemList().get(i).getData().getItemList().get(0).getData().getReleaseTime()));

                //轮播
                bannerHotGIn = new ArrayList<>();
                for (int i1 = 0; i1 < data.getItemList().get(i).getData().getItemList().size(); i1++) {
                    bannerHotGIn.add(data.getItemList().get(i).getData().getItemList().get(i1).getData().getCover().getFeed());
                    Log.d("FindDetailHotAdapter", "bannerHotGIn.size():" + bannerHotGIn.size());
                }

                Banner bannerHotG = (Banner) view.findViewById(R.id.banner_banner_hot_g);
                bannerHotG.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                bannerHotG.setImageLoader(new MyImage());
                bannerHotG.setImages(bannerHotGIn);
                bannerHotG.setBannerAnimation(Transformer.Default);
                bannerHotG.isAutoPlay(false);
                bannerHotG.setDelayTime(3000);
                bannerHotG.setIndicatorGravity(BannerConfig.CENTER);
                bannerHotG.start();

                break;

            case TYPE_TWO:

                if (dataNext.getItemList().get(i - 1).getData().getCover() != null) {
                    Glide.with(context).load(dataNext.getItemList().get(i - 1).getData().getCover().getFeed()).into(holder.iv);
                    Glide.with(context).load(dataNext.getItemList().get(i - 1).getData().getCover().getBlurred()).into(holder.ivBackGround);
                }
                if (dataNext.getItemList().get(i - 1).getData().getTitle() != null) {
                    holder.tvMeTop.setText(dataNext.getItemList().get(i - 1).getData().getTitle());
                }

                holder.tvMeLeft.setText(dataNext.getItemList().get(i - 1).getData().getCategory());

                holder.tvMeRight.setText(dataNext.getItemList().get(i - 1).getData().getReleaseTime());
                if (dataNext.getItemList().get(i - 1).getData().getAuthor() != null) {
                    holder.tvMeBot.setText(dataNext.getItemList().get(i - 1).getData().getAuthor().getName());
                }
                break;

            //中间的  最受欢迎的内容
            case TYPE_THREE:
                viewMid.tvMidTextView.setText(dataNext.getItemList().get(i - 1).getData().getText());
                break;
        }


        return view;
    }

    class BannerHot {

        private TextView tvHotTop, tvHotMid, tvHotLeft, tvHotRight;

        public BannerHot(View view) {

            tvHotTop = (TextView) view.findViewById(R.id.tv_hot_top_g);
            tvHotMid = (TextView) view.findViewById(R.id.tv_hot_mid_g);
            tvHotLeft = (TextView) view.findViewById(R.id.tv_hot_left_g);
            tvHotRight = (TextView) view.findViewById(R.id.tv_hot_right_g);
        }
    }

    class ViewHolder {
        private ImageView iv, ivBackGround;
        private TextView tvMeTop, tvMeLeft, tvMeRight, tvMeBot;

        public ViewHolder(View view) {
            ivBackGround = (ImageView) view.findViewById(R.id.iv_background);
            iv = (ImageView) view.findViewById(R.id.iv_find_hot_me_g);
            tvMeTop = (TextView) view.findViewById(R.id.tv_find_hot_me_top_g);
            tvMeLeft = (TextView) view.findViewById(R.id.tv_find_hot_me_left_g);
            tvMeRight = (TextView) view.findViewById(R.id.tv_find_hot_me_right_g);
            tvMeBot = (TextView) view.findViewById(R.id.tv_find_hot_me_bot_g);
        }
    }

    class ViewMid {

        private TextView tvMidTextView;

        public ViewMid(View view) {
            tvMidTextView = (TextView) view.findViewById(R.id.tv_find_hot_midText);
        }
    }
}
