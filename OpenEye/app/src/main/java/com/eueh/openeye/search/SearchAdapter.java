package com.eueh.openeye.search;

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
 * Created by Even on 16/12/28.
 */

public class SearchAdapter extends BaseAdapter {
    private SearchBean data;
    private Context context;

    public SearchAdapter(Context context) {
        this.context = context;
    }

    public void setData(SearchBean data) {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_search_eueh,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(data.getItemList().get(i).getData().getCover().getBlurred()).into(holder.ivBack);
        Glide.with(context).load(data.getItemList().get(i).getData().getCover().getFeed()).into(holder.ivOut);
        holder.tvTop.setText(data.getItemList().get(i).getData().getTitle());
        holder.tvLeft.setText(data.getItemList().get(i).getData().getCategory());
        holder.tvRight.setText(String.valueOf(data.getItemList().get(i).getData().getReleaseTime()));
        return view;
    }

    class ViewHolder {

        private ImageView ivBack, ivOut;
        private TextView tvLeft, tvRight,tvTop;

        public ViewHolder(View view) {
            ivBack = (ImageView) view.findViewById(R.id.iv_search_back);
            ivOut = (ImageView) view.findViewById(R.id.iv_search_out);
            tvLeft = (TextView) view.findViewById(R.id.tv_search_left);
            tvRight = (TextView) view.findViewById(R.id.tv_search_right);
            tvTop = (TextView) view.findViewById(R.id.tv_search_top);
        }
    }
}
