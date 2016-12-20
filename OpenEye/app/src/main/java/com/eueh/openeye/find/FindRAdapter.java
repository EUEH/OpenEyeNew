package com.eueh.openeye.find;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;

import java.util.ArrayList;

/**
 * Created by Even on 16/12/20.
 */

public class FindRAdapter extends RecyclerView.Adapter<FindRAdapter.FindRViewHolder> {
    private ArrayList<String>data;
    private Context context;

    public FindRAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<String> data) {
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

        Glide.with(context).load(data.get(position)).into(holder.ivFindRIn);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class FindRViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFindRIn;
        public FindRViewHolder(View itemView) {
            super(itemView);
            ivFindRIn = (ImageView) itemView.findViewById(R.id.iv_findr_in_g);
        }
    }
}
