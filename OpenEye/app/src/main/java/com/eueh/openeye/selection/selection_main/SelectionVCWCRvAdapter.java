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

public class SelectionVCWCRvAdapter extends RecyclerView.Adapter {
    private List<SelectionBean.ItemListBeanX.DataBeanX.ItemListBean> data;
    private Context context;

    private static final int TYPEVIDEO = 1;
    private static final int TYPEACTIONCARD = 2;
    private static final int TYPENEWELSE = 3;


    public SelectionVCWCRvAdapter(Context context) {
        this.context = context;
    }

    public SelectionVCWCRvAdapter setData(List<SelectionBean.ItemListBeanX.DataBeanX.ItemListBean> data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getItemViewType(int position) {
        String typeVideo = "video";
        String typeActionCard = "actionCard";

        if (data.get(position).getType().equals(typeVideo)) {
            return TYPEVIDEO;
        } else if (data.get(position).getType().equals(typeActionCard)) {
            return TYPEACTIONCARD;
        } else {
            return TYPENEWELSE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case TYPEVIDEO:
                View viewVideo = LayoutInflater.from(context).inflate(R.layout.item_selection_videocollectionwithcover_recycleview, parent, false);
                holder = new ViewHolderVideo(viewVideo);
                break;
            case TYPEACTIONCARD:
                View viewActionCard = LayoutInflater.from(context).inflate(R.layout.item_selection_videocollectionwithcover_recycleview_other, parent, false);
                holder = new ViewHolderActionCard(viewActionCard);
                break;
            case TYPENEWELSE:
                View viewNewElse = LayoutInflater.from(context).inflate(R.layout.item_selection_fragment_newelse, parent, false);
                holder = new ViewHolderNewElse(viewNewElse);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //位置
        int typeNew = getItemViewType(position);

        switch (typeNew) {
            case TYPEVIDEO:
                ViewHolderVideo holderVideo = (ViewHolderVideo) holder;
                Glide.with(context).load(data.get(position).getData().getCover().getFeed()).into(((ViewHolderVideo) holder).ivCover);
                ((ViewHolderVideo) holder).tvTitle.setText(data.get(position).getData().getTitle());
                ((ViewHolderVideo) holder).tvCategory.setText( "#" + data.get(position).getData().getCategory() + "  /");
                ((ViewHolderVideo) holder).tvReleaseTime.setText(data.get(position).getData().getReleaseTime()+"");
                break;
            case TYPEACTIONCARD:
                ViewHolderActionCard holderActionCard = (ViewHolderActionCard) holder;
                ((ViewHolderActionCard) holder).tvText.setText(data.get(position).getData().getText());
                break;
            case TYPENEWELSE:

                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolderVideo extends RecyclerView.ViewHolder {
        private ImageView ivCover;
        private TextView tvTitle , tvCategory , tvReleaseTime;
        public ViewHolderVideo(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_item_vcwc_cover_d);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_item_vcwc_title_d);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_item_vcwc_category_d);
            tvReleaseTime = (TextView) itemView.findViewById(R.id.tv_item_vcwc_releaseTime_d);
        }
    }

    class ViewHolderActionCard extends RecyclerView.ViewHolder {
        private TextView tvText ;
        public ViewHolderActionCard(View itemView) {
            super(itemView);
            tvText = (TextView) itemView.findViewById(R.id.tv_item_vcwc_other_text_d);
        }
    }

    class ViewHolderNewElse extends RecyclerView.ViewHolder {
        public ViewHolderNewElse(View itemView) {
            super(itemView);
        }
    }


}
