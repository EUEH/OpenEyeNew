package com.eueh.openeye.find.detailhotbot.time;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.find.detailhotbot.FindDetailHotBotBean;

/**
 * Created by Even on 16/12/24.
 */

public class FindTimeAdapterR extends RecyclerView.Adapter<FindTimeAdapterR.MyViewHolder> {
    private Context context;
    private FindDetailHotBotBean data;

    public FindTimeAdapterR(Context context) {
        this.context = context;
    }

    public void setData(FindDetailHotBotBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_find_hot_bot_even_g,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        Glide.with(context).load(data.getItemList().get(position).getData().getCover().getBlurred()).into(holder.ivBack);
        Glide.with(context).load(data.getItemList().get(position).getData().getCover().getFeed()).into(holder.ivMain);

        holder.tvTop.setText(data.getItemList().get(position).getData().getTitle());
        holder.tvLeft.setText(data.getItemList().get(position).getData().getCategory());
        holder.tvRight.setText(String.valueOf(data.getItemList().get(position).getData().getReleaseTime()));
        holder.tvBot.setText(data.getPgcInfo().getName());


    }

    @Override
    public int getItemCount() {
        return data.getItemList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivBack,ivMain;
        private TextView tvTop,tvLeft,tvRight,tvBot;
        public MyViewHolder(View itemView) {
            super(itemView);
            ivBack = (ImageView) itemView.findViewById(R.id.iv_background_even);
            ivMain = (ImageView) itemView.findViewById(R.id.iv_find_hot_even_g);
            tvTop = (TextView) itemView.findViewById(R.id.tv_find_hot_even_top_g);
            tvLeft = (TextView) itemView.findViewById(R.id.tv_find_hot_even_left_g);
            tvRight = (TextView) itemView.findViewById(R.id.tv_find_hot_even_right_g);
            tvBot = (TextView) itemView.findViewById(R.id.tv_find_hot_even_bot_g);
        }
    }
}
