package com.eueh.openeye.concern;

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
 * Created by 陈小飞 on 16/12/21.
 */

public class ConcernRvAdapter extends RecyclerView.Adapter<ConcernRvAdapter.ConcernViewHolder>{
    Context context;
    List<ConcernBean.ItemListBeanX.DataBeanX.ItemListBean> list;

    public ConcernRvAdapter(Context context) {
        this.context = context;
    }

    public ConcernRvAdapter setList(List<ConcernBean.ItemListBeanX.DataBeanX.ItemListBean> list) {
        this.list = list;
        return this;
    }

    @Override
    public ConcernViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_concern_first_rv_f, parent, false);
        ConcernViewHolder holder = new ConcernViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ConcernViewHolder holder, int position) {
        holder.tvConcernRvCategory.setText("#" + list.get(position).getData().getCategory() + "    /");
        holder.tvConcernRvTitle.setText(list.get(position).getData().getTitle());
        String min = TimeConversion.conversionTime(list.get(position).getData().getReleaseTime()).substring(14, 19);
        holder.tvConcernRvTime.setText(min);
        Glide.with(context).load(list.get(position).getData().getCover().getFeed()).into(holder.ivConcernRvFeed);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ConcernViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivConcernRvFeed;
        private final TextView tvConcernRvTitle;
        private final TextView tvConcernRvCategory;
        private final TextView tvConcernRvTime;

        public ConcernViewHolder(View itemView) {
            super(itemView);
            ivConcernRvFeed = (ImageView) itemView.findViewById(R.id.iv_item_concern_first_rv_feed);
            tvConcernRvTitle = (TextView) itemView.findViewById(R.id.tv_item_concern_first_rv_title);
            tvConcernRvCategory = (TextView) itemView.findViewById(R.id.tv_item_concern_first_rv_category);
            tvConcernRvTime = (TextView) itemView.findViewById(R.id.tv_item_concern_first_rv_releaseTime);
        }
    }

}
