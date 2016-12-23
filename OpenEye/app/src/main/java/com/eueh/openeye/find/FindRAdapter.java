package com.eueh.openeye.find;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.find.detailrechot.FindDetailHotActivity;
import com.eueh.openeye.find.detailhotbot.FindDetailHotBotActivity;
import com.eueh.openeye.find.detailhotmid.FindDetailHotMidActivity;

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
        View view = LayoutInflater.from(context).inflate(R.layout.item_findr_in_g, parent, false);
        FindRViewHolder holder = new FindRViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FindRViewHolder holder, final int position) {

        if (position < data.getData().getItemList().size()) {
            holder.tvFindRIn.setText(data.getData().getItemList().get(position).getData().getTitle());
            Glide.with(context).load(data.getData().getItemList().get(position).getData().getImage()).into(holder.ivFindRIn);
        }

        if (position == data.getData().getItemList().size()) {
            holder.tvFindRIn.setText(data.getData().getItemList().get(data.getData().getItemList().size() - 1).getData().getText());
            holder.tvFindRIn.setTextColor(Color.BLACK);
            Glide.with(context).load("http://img5.imgtn.bdimg.com/it/u=3050077695,3869578428&fm=23&gp=0.jpg").into(holder.ivFindRIn);
        }

        //图片的监听
        holder.ivFindRIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //先判断不是另外加的那个视图
                if (position < data.getData().getItemList().size()) {
                    //根据Header中id不同,跳转到不同的activity
                    if (data.getData().getHeader().getId() == 1) {
                        Intent intent = new Intent(context, FindDetailHotActivity.class);
                        int idHotG = data.getData().getItemList().get(position).getData().getId();
                     //   intent.getIntExtra("idHotG",idHotG);
                        intent.putExtra("idHotG",idHotG);
                        context.startActivity(intent);

                    }else if (data.getData().getHeader().getId() == 2){
                        Intent intent = new Intent(context, FindDetailHotMidActivity.class);
                        int idHotGM = data.getData().getItemList().get(position).getData().getId();
                        intent.putExtra("idHotGM",idHotGM);
                        context.startActivity(intent);
                    }else {
                        Intent intent = new Intent(context, FindDetailHotBotActivity.class);
                        int idHotGB = data.getData().getItemList().get(position).getData().getId();
                        intent.putExtra("idHotGB",idHotGB);
                        context.startActivity(intent);
                    }

                } else {
                    //这里是最后一个增加的视图的点击要做的事
                    Toast.makeText(context, "hahah", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    //给position+1  增加一个视图
    @Override
    public int getItemCount() {
        return data.getData().getItemList().size() + 1;
    }

    class FindRViewHolder extends RecyclerView.ViewHolder {

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
