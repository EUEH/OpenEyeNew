package com.eueh.openeye.find;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
    private FindBean data;

    private FindBeanNextPage dataNext;

    //放轮播图
    private ArrayList<String> dataBanner;

    //中间的好像轮播图(第三种不同行布局)
    private ArrayList<String> dataBannerMid;

    //盛放最底下BOT中的轮播图+++


    //四种类型
    public static final int TYPE_ONE = 0;

    public static final int TYPE_TWO = 1;

    public static final int TYPE_THREE = 2;

    public static final int TYPE_FOUR = 3;
    //类型总数
    public static final int TYPE_FIVE = 4;

    public static final int TYPE_COUNT = 20;

    public FindAdapter(Context context) {
        this.context = context;
    }

    //传递两个实体类
    public void setData(FindBean data, FindBeanNextPage dataNext) {
        this.data = data;
        this.dataNext = dataNext;
        dataBanner = new ArrayList<>();
        dataBannerMid = new ArrayList<>();

        for (int j = 0; j < data.getItemList().get(0).getData().getItemList().size(); j++) {
            dataBanner.add(data.getItemList().get(0).getData().getItemList().get(j).getData().getImage());
        }
        for (int i = 0; i < data.getItemList().get(4).getData().getItemList().size(); i++) {
            dataBannerMid.add(data.getItemList().get(4).getData().getItemList().get(i).getData().getImage());
        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        //顶部banner
        String ONE = data.getItemList().get(0).getType();
        //嵌套recview的
        String TWO = data.getItemList().get(1).getType();
        //里面是轮播图的
        String THREE = data.getItemList().get(4).getType();
        //还有一种是加载17条数据的//

        if (position < data.getItemList().size()) {
            if (data.getItemList().get(position).getType().equals(ONE)) {
                return TYPE_ONE;
            } else if (data.getItemList().get(position).getType().equals(TWO)) {
                return TYPE_TWO;
            } else if (data.getItemList().get(position).getType().equals(THREE)) {
                return TYPE_THREE;
            }  else {
                return TYPE_FOUR;
            }
        } else if (position ==(data.getItemList().size() + dataNext.getItemList().size()-2)){
            return TYPE_FIVE;
        }else {
            return TYPE_FOUR;
        }

    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return data.getItemList().size() + dataNext.getItemList().size()-1;
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
        BannerTop bannerTop = null;
        ViewRec viewRec = null;
        ViewBanner viewBanner = null;
        ViewBot viewBot = null;
        ViewEnd viewEnd = null;

        if (view == null) {
            switch (getItemViewType(i)) {
                case TYPE_ONE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_find_head_g, viewGroup, false);
                    bannerTop = new BannerTop(view);
                    view.setTag(bannerTop);
                    break;

                case TYPE_TWO:
                    view = LayoutInflater.from(context).inflate(R.layout.item_findr_g, viewGroup, false);
                    viewRec = new ViewRec(view);
                    view.setTag(viewRec);
                    break;

                case TYPE_THREE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_findb_g, viewGroup, false);
                    viewBanner = new ViewBanner(view);
                    view.setTag(viewBanner);
                    break;
                case TYPE_FOUR:
                    view = LayoutInflater.from(context).inflate(R.layout.item_findv_g, viewGroup, false);
                    viewBot = new ViewBot(view);
                    view.setTag(viewBot);
                    break;
                case TYPE_FIVE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_finde_g, viewGroup, false);
                    viewEnd = new ViewEnd(view);
                    view.setTag(viewEnd);
                    break;


            }
        } else {
            switch (getItemViewType(i)) {
                case TYPE_ONE:
                    bannerTop = (BannerTop) view.getTag();
                    break;

                case TYPE_TWO:
                    viewRec = (ViewRec) view.getTag();
                    break;
                case TYPE_THREE:
                    viewBanner = (ViewBanner) view.getTag();
                    break;
                case TYPE_FOUR:
                    viewBot = (ViewBot) view.getTag();
                    break;
                case TYPE_FIVE:
                    viewEnd = (ViewEnd) view.getTag();
                    break;

            }
        }
        switch (getItemViewType(i)) {
            //顶部banner
            case TYPE_ONE:

                Banner bannerHead = (Banner) view.findViewById(R.id.banner_head);
                bannerHead.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                bannerHead.setImageLoader(new MyImage());
                bannerHead.setImages(dataBanner);
                bannerHead.setBannerAnimation(Transformer.Default);
                bannerHead.isAutoPlay(true);
                bannerHead.setDelayTime(3000);
                bannerHead.setIndicatorGravity(BannerConfig.CENTER);
                bannerHead.start();
                break;

            //第二种嵌套rec
            case TYPE_TWO:
                if (data.getItemList().get(i).getData().getHeader().getTitle() != null) {
                    viewRec.tvFindR.setText(data.getItemList().get(i).getData().getHeader().getTitle());
                }
                FindRAdapter adapter = new FindRAdapter(context);
                adapter.setData(data.getItemList().get(i));
                viewRec.rvFindR.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                viewRec.rvFindR.setAdapter(adapter);

                break;

            //第三种加载banner
            case TYPE_THREE:

                viewBanner.tvBannerMid.setText(data.getItemList().get(i).getData().getHeader().getTitle());

                Banner banner = (Banner) view.findViewById(R.id.banner_r_g);
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                banner.setImageLoader(new MyImage());
                banner.setImages(dataBannerMid);
                banner.setBannerAnimation(Transformer.Default);
                banner.isAutoPlay(true);
                banner.setDelayTime(3000);
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.start();
                break;

            //加载17条的那种
            case TYPE_FOUR:

                viewBot.tvCategory.setText(dataNext.getItemList().get(i-4).getData().getHeader().getTitle());
                viewBot.tvSubTitle.setText(dataNext.getItemList().get(i-4).getData().getHeader().getSubTitle());
                viewBot.tvTitle.setText(dataNext.getItemList().get(i-4).getData().getItemList().get(0).getData().getTitle());
                viewBot.tvLeft.setText(dataNext.getItemList().get(i-4).getData().getItemList().get(0).getData().getCategory());
                viewBot.tvRight.setText(String.valueOf(dataNext.getItemList().get(i-4).getData().getItemList().get(0).getData().getReleaseTime()));

                //每个位置i 对应一个 dataBannerBot 的集合
                ArrayList<String> dataBannerBot = new ArrayList<>();
                //根据位置不同,每个位置生成5个图片
                for (int i1 = 0; i1 < dataNext.getItemList().get(i - data.getItemList().size() + 1).getData().getItemList().size(); i1++) {
                    dataBannerBot.add(dataNext.getItemList().get(i - data.getItemList().size() + 1).getData().getItemList().get(i1).getData().getCover().getFeed());
                }

                Banner bannerBot = (Banner) view.findViewById(R.id.rv_find_v_g);
                bannerBot.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                bannerBot.setImageLoader(new MyImage());
                bannerBot.setImages(dataBannerBot);
                bannerBot.setBannerAnimation(Transformer.Default);
                bannerBot.isAutoPlay(false);
                bannerBot.setDelayTime(3000);
                bannerBot.setIndicatorGravity(BannerConfig.CENTER);
                bannerBot.start();
                break;

            //最后的TheEnd视图
            case TYPE_FIVE:

                break;

        }
        return view;
    }

    //顶部banner
    class BannerTop {
        public BannerTop(View view) {

        }
    }

    //第二种嵌套rec
    class ViewRec {
        private RecyclerView rvFindR;

        private TextView tvFindR;

        public ViewRec(View view) {
            rvFindR = (RecyclerView) view.findViewById(R.id.rv_find_r_g);
            tvFindR = (TextView) view.findViewById(R.id.tv_findr);

        }
    }

    //第三种加载banner
    class ViewBanner {
        private TextView tvBannerMid;

        public ViewBanner(View view) {
            tvBannerMid = (TextView) view.findViewById(R.id.tv_banner_mid);
        }
    }

    //加载17条的那种
    class ViewBot {

        private TextView tvCategory,tvSubTitle,tvTitle,tvLeft,tvRight;
        public ViewBot(View view) {

            tvCategory = (TextView) view.findViewById(R.id.tv_category_g);
            tvSubTitle = (TextView) view.findViewById(R.id.tv_subTitle_g);
            tvTitle = (TextView) view.findViewById(R.id.title_g);
            tvLeft = (TextView) view.findViewById(R.id.tv_left_g);
            tvRight = (TextView) view.findViewById(R.id.tv_right_g);

        }
    }

    //最后的TheEnd
    class ViewEnd {
        public ViewEnd(View view) {

        }
    }
}
