package com.eueh.openeye.concern.concerndetails.concerntitle;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.concern.TimeConversion;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/23.
 */

public class ConcernShareAdapter extends RecyclerView.Adapter<ConcernShareAdapter.ShareViewHolder>{

    Context context;
    List<ConcernShareBean.ItemListBean> list;

    public ConcernShareAdapter(Context context) {
        this.context = context;
    }

    public ConcernShareAdapter setList(List<ConcernShareBean.ItemListBean> list) {
        this.list = list;
        return this;
    }

    @Override
    public ShareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_share_rv_f, parent, false);
        ShareViewHolder holder = new ShareViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ShareViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getData().getCover().getFeed()).into(holder.shareFeedF);
        holder.shareTitleF.setText(list.get(position).getData().getTitle());
        holder.shareCategoryF.setText(list.get(position).getData().getCategory() + "     /");
        holder.shareNameF.setText(list.get(position).getData().getAuthor().getName());
        holder.shareLatestF.setText(TimeConversion.conversionTime(list.get(position).getData().getReleaseTime()).substring(14, 19));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ShareViewHolder extends RecyclerView.ViewHolder {

        private final ImageView shareFeedF;
        private final TextView shareTitleF;
        private final TextView shareCategoryF;
        private final TextView shareLatestF;
        private final TextView shareNameF;

        public ShareViewHolder(View itemView) {
            super(itemView);
            shareFeedF = (ImageView) itemView.findViewById(R.id.iv_item_share_feed_f);
            shareTitleF = (TextView) itemView.findViewById(R.id.tv_item_share_title_f);
            shareCategoryF = (TextView) itemView.findViewById(R.id.tv_item_share_category_f);
            shareLatestF = (TextView) itemView.findViewById(R.id.tv_item_share_latest_release_share_f);
            shareNameF = (TextView) itemView.findViewById(R.id.tv_item_share_name_f);
        }
    }
}
