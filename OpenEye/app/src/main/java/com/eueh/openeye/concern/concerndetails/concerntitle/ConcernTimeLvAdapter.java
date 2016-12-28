package com.eueh.openeye.concern.concerndetails.concerntitle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.concern.TimeConversion;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/23.
 */

public class ConcernTimeLvAdapter extends BaseAdapter{
    List<ConcernItemBean.ItemListBean> list;
    Context context;

    public ConcernTimeLvAdapter(Context context) {
        this.context = context;
    }

    public ConcernTimeLvAdapter setList(List<ConcernItemBean.ItemListBean> list) {
        this.list = list;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TimeViewHolder holder = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_time_lv_f, viewGroup, false);
            holder = new TimeViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (TimeViewHolder) view.getTag();
        }
        Glide.with(context).load(list.get(i).getData().getCover().getFeed()).into(holder.timeFeedF);
        holder.timeTitleF.setText(list.get(i).getData().getTitle());
        holder.timeCategoryF.setText(list.get(i).getData().getCategory() + "     /");
        holder.timeLatestF.setText(TimeConversion.conversionTime(list.get(i).getData().getReleaseTime()).substring(14, 19));
        holder.timeNameF.setText(list.get(i).getData().getAuthor().getName());
        return view;
    }

    private class TimeViewHolder {

        private final ImageView timeFeedF;
        private final TextView timeTitleF;
        private final TextView timeCategoryF;
        private final TextView timeLatestF;
        private final TextView timeNameF;

        public TimeViewHolder(View view) {
            timeFeedF = (ImageView) view.findViewById(R.id.iv_item_time_feed_f);
            timeTitleF = (TextView) view.findViewById(R.id.tv_item_time_title_f);
            timeCategoryF = (TextView) view.findViewById(R.id.tv_item_time_category_f);
            timeLatestF = (TextView) view.findViewById(R.id.tv_item_time_latest_release_time_f);
            timeNameF = (TextView) view.findViewById(R.id.tv_item_time_name_f);
        }
    }
}
