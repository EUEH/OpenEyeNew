package com.eueh.openeye.mine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.selection.selection_main.SelectionBean;

import java.util.ArrayList;

/**
 * Created by 陈焕栋 on 17/1/3.
 */

public class MineCollectionAdapter extends BaseAdapter {
    private ArrayList<MineCollectionBean> data;
    private Context context;

    public MineCollectionAdapter(Context context) {
        this.context = context;
    }

    public MineCollectionAdapter setData(ArrayList<MineCollectionBean> data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
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
        ViewHolder holder = null ;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_mine_collection ,viewGroup ,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(data.get(i).getUrlPic()).into(holder.ivFeed);
        holder.tvTitle.setText(data.get(i).getTitle());
        holder.tvCategor.setText(data.get(i).getCategory());
        holder.tvReleaseTime.setText(data.get(i).getReleaseTime()+"");
        return view;
    }

    class ViewHolder {
        private ImageView ivFeed;
        private TextView tvTitle, tvCategor, tvReleaseTime;

        public ViewHolder(View view) {
            ivFeed = (ImageView) view.findViewById(R.id.iv_item_mine_collection_iv_feed_d);
            tvTitle = (TextView) view.findViewById(R.id.iv_item_mine_collection_tv_title_d);
            tvCategor = (TextView) view.findViewById(R.id.iv_item_mine_collection_tv_categor_d);
            tvReleaseTime = (TextView) view.findViewById(R.id.iv_item_mine_collection_tv_releaseTime_d);
        }
    }

}
