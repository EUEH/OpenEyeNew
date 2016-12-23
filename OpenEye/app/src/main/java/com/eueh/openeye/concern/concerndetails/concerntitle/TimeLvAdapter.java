package com.eueh.openeye.concern.concerndetails.concerntitle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/23.
 */

public class TimeLvAdapter extends BaseAdapter{
    List<ConcernTitleBean.ItemListBean.DataBean> list;
    Context context;

    public TimeLvAdapter(Context context) {
        this.context = context;
    }

    public TimeLvAdapter setList(List<ConcernTitleBean.ItemListBean.DataBean> list) {
        this.list = list;
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
        Glide.with(context).load(list.get(i).getCover().getFeed()).into(holder.feedF);
        return view;
    }

    private class TimeViewHolder {

        private final ImageView feedF;

        public TimeViewHolder(View view) {
            feedF = (ImageView) view.findViewById(R.id.iv_item_time_lv_feed_f);
        }
    }
}
