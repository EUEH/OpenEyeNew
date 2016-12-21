package com.eueh.openeye.find;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;

import java.util.ArrayList;

/**
 * Created by Even on 16/12/20.
 */

public class FindRAdapter extends RecyclerView.Adapter<FindRAdapter.FindRViewHolder> {
    private FindBean.ItemListBeanX data;
    private Context context;

    public FindRAdapter(Context context) {
        this.context = context;
    }

    public void setData(FindBean.ItemListBeanX data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public FindRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_findr_in_g,parent,false);
        FindRViewHolder holder = new FindRViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FindRViewHolder holder, int position) {

        if (position<data.getData().getItemList().size()){
            holder.tvFindRIn.setText(data.getData().getItemList().get(position).getData().getTitle());
            Glide.with(context).load(data.getData().getItemList().get(position).getData().getImage()).into(holder.ivFindRIn);
        }

        if (position ==data.getData().getItemList().size()){
            holder.tvFindRIn.setText(data.getData().getItemList().get(data.getData().getItemList().size()-1).getData().getText());
            holder.tvFindRIn.setTextColor(Color.BLACK);
            Glide.with(context).load("http://img5.imgtn.bdimg.com/it/u=3050077695,3869578428&fm=23&gp=0.jpg").into(holder.ivFindRIn);
        }

    }

    //给position+1  增加一个视图
    @Override
    public int getItemCount() {
        return data.getData().getItemList().size()+1;
    }

    class FindRViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFindRIn;
        private TextView tvFindRIn;
        private RelativeLayout rl;
        public FindRViewHolder(View itemView) {
            super(itemView);
            ivFindRIn = (ImageView) itemView.findViewById(R.id.iv_findr_in_g);

            tvFindRIn = (TextView) itemView.findViewById(R.id.tv_findr_in_g);
            rl = (RelativeLayout) itemView.findViewById(R.id.rl_findr_g);
        }
    }
}
