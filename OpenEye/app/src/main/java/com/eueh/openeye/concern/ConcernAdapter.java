package com.eueh.openeye.concern;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.concern.concerndetails.concerntitle.ConcernTitleActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 陈小飞 on 16/12/20.
 */

public class ConcernAdapter extends BaseAdapter {
    Context context;
    List<ConcernBean.ItemListBeanX> list;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int COUNT = 3;
    private ConcernViewHolderFirst first;
    private ConcernViewHolderSecond second;
    private ArrayList<ConcernPointF> points;
    private boolean flag = false;

    public ConcernAdapter(Context context) {
        this.context = context;
    }

    public ConcernAdapter setList(List<ConcernBean.ItemListBeanX> list) {
        this.list = list;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        //判断字符段要用equals
        String type = list.get(position).getType();
        if (type.equals("videoCollectionWithBrief")) {
            return ONE;
        } else {
            return TWO;
        }
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        first = null;
        second = null;
        if (view == null) {
            switch (getItemViewType(i)) {
                case ONE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_concern_first_f, viewGroup, false);
                    first = new ConcernViewHolderFirst(view);
                    view.setTag(first);
                    break;
                case TWO:
                    view = LayoutInflater.from(context).inflate(R.layout.item_concern_second_f, viewGroup, false);
                    second = new ConcernViewHolderSecond(view);
                    view.setTag(second);
                    break;
            }
        } else {
            switch (getItemViewType(i)) {
                case ONE:
                    first = (ConcernViewHolderFirst) view.getTag();
                    break;
                case TWO:
                    second = (ConcernViewHolderSecond) view.getTag();
                    break;
            }
        }
        switch (getItemViewType(i)) {
            case ONE:
                Glide.with(context).load(list.get(i).getData().getHeader().getIcon()).into(first.firstIconF);
                first.firstTitleF.setText(list.get(i).getData().getHeader().getTitle());
                first.firstDescriptionF.setText(String.valueOf(list.get(i).getData().getHeader().getDescription()));
                first.ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, ConcernTitleActivity.class);
                        intent.putExtra("id", list.get(i).getData().getHeader().getId());
                        Log.d("ConcernAdapter", "list.get(i).getData().getHeader().getId():" + list.get(i).getData().getHeader().getId());
                        context.startActivity(intent);
                    }
                });
                setRv(first, i);
                break;
            case TWO:
                second.secondTitleF.setText(list.get(i).getData().getHeader().getTitle());
                second.secondSubTitleF.setText(String.valueOf(list.get(i).getData().getHeader().getSubTitle()));
                getViewPager(i);
                break;
        }
        return view;
    }

    //viewPage
    private void getViewPager(int p) {

        SecondVpAdapter vpAdapter = new SecondVpAdapter(context);
        List<ConcernBean.ItemListBeanX.DataBeanX.ItemListBean> b = list.get(p).getData().getItemList();
        vpAdapter.setList(b);
        second.secondVpF.setAdapter(vpAdapter);
        vpAdapter.setViewPager(second.secondVpF);
        for (int a = 0; a < b.size(); a++) {
            ConcernPointF concernPointF = new ConcernPointF(context);
            if (a == 0){
                concernPointF.setSelected(true);
            }
            points = new ArrayList<>();
            points.add(concernPointF);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
            params.leftMargin = 20;
            params.rightMargin = 20;
            second.secondLF.addView(concernPointF, params);
        }
        vpAdapter.setPoints(points);
    }


    //嵌套的Rv  顾彬是逗13
    private void setRv(ConcernViewHolderFirst first, int p) {
        ConcernRvAdapter rvAdapter = new ConcernRvAdapter(context);
        List<ConcernBean.ItemListBeanX.DataBeanX.ItemListBean> bean = list.get(p).getData().getItemList();
        rvAdapter.setList(bean);
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        first.rvConcernF.setLayoutManager(manager);
        first.rvConcernF.setAdapter(rvAdapter);
    }

    private class ConcernViewHolderFirst {

        private final CircleImageView firstIconF;
        private final TextView firstTitleF;
        private final TextView firstDescriptionF;
        private final RecyclerView rvConcernF;
        private final LinearLayout ll;

        public ConcernViewHolderFirst(View view) {
            firstIconF = (CircleImageView) view.findViewById(R.id.item_iv_first_icon_f);
            firstTitleF = (TextView) view.findViewById(R.id.item_tv_first_header_title_f);
            firstDescriptionF = (TextView) view.findViewById(R.id.item_tv_first_header_description_f);
            rvConcernF = (RecyclerView) view.findViewById(R.id.rv_item_concern);
            ll = (LinearLayout) view.findViewById(R.id.ll_item_first_f);
        }
    }

    private class ConcernViewHolderSecond {

        private final TextView secondTitleF;
        private final TextView secondSubTitleF;
        private final ViewPager secondVpF;
        private final LinearLayout secondLF;

        public ConcernViewHolderSecond(View view) {
            secondTitleF = (TextView) view.findViewById(R.id.tv_item_second_title_f);
            secondSubTitleF = (TextView) view.findViewById(R.id.tv_item_second_subTitle_f);
            secondVpF = (ViewPager) view.findViewById(R.id.vp_item_second_f);
            secondLF = (LinearLayout) view.findViewById(R.id.ll_item_second_f);
        }
    }

}
