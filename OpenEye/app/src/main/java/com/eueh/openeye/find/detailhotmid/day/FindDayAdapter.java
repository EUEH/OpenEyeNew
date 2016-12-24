package com.eueh.openeye.find.detailhotmid.day;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;

/**
 * Created by Even on 16/12/23.
 */

public class FindDayAdapter extends BaseAdapter {
    private Context context;
    private FindDayBean data;

    public FindDayAdapter(Context context) {
        this.context = context;
    }

    public void setData(FindDayBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.getItemList().size();
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
        ViewHolder holder = null;
        if (view == null){
           view = LayoutInflater.from(context).inflate(R.layout.item_find_hot_mid_in_ll_g,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(data.getItemList().get(i).getData().getCover().getBlurred()).into(holder.ivBack);
        Glide.with(context).load(data.getItemList().get(i).getData().getCover().getFeed()).into(holder.ivSee);

        holder.tvTop.setText(data.getItemList().get(i).getData().getTitle());
        holder.tvLeft.setText(data.getItemList().get(i).getData().getCategory());
        holder.tvRight.setText(String.valueOf(data.getItemList().get(i).getData().getReleaseTime()));
        return view;
    }
    class ViewHolder{

        private ImageView ivSee,ivBack;
        private TextView tvTop,tvLeft,tvRight;
        public ViewHolder(View view) {
            ivBack = (ImageView) view.findViewById(R.id.iv_find_see_background);
            ivSee = (ImageView) view.findViewById(R.id.iv_find_see_g);
            tvTop = (TextView) view.findViewById(R.id.tv_find_see_top_g);
            tvLeft = (TextView) view.findViewById(R.id.tv_find_see_left_g);
            tvRight = (TextView) view.findViewById(R.id.tv_find_see_right_g);
        }
    }
}
