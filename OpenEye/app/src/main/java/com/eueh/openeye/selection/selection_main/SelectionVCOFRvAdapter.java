package com.eueh.openeye.selection.selection_main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;

import java.util.List;

/**
 * Created by 陈焕栋 on 16/12/21.
 */

public class SelectionVCOFRvAdapter extends RecyclerView.Adapter<SelectionVCOFRvAdapter.MyViewHolder> {
    private List<SelectionBean.ItemListBeanX.DataBeanX.ItemListBean> data;
    private Context context ;

    public SelectionVCOFRvAdapter(Context context) {
        this.context = context;
    }

    public SelectionVCOFRvAdapter setData(List<SelectionBean.ItemListBeanX.DataBeanX.ItemListBean> data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = null ;
        View view = LayoutInflater.from(context).inflate(R.layout.item_selection_videocollectionwithcover_recycleview, parent, false);
        holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).getData().getCover().getFeed()).into(holder.ivCover);
        holder.tvTitle.setText(data.get(position).getData().getTitle());
        holder.tvCategory.setText( "#" + data.get(position).getData().getCategory() + "  /");
        holder.tvReleaseTime.setText(data.get(position).getData().getReleaseTime()+"");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivCover;
        private TextView tvTitle , tvCategory , tvReleaseTime;
        public MyViewHolder(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_item_vcwc_cover_d);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_item_vcwc_title_d);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_item_vcwc_category_d);
            tvReleaseTime = (TextView) itemView.findViewById(R.id.tv_item_vcwc_releaseTime_d);
        }
    }
}
