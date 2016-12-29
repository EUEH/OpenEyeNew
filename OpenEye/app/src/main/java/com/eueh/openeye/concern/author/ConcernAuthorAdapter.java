package com.eueh.openeye.concern.author;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by 陈小飞 on 16/12/28.
 */

public class ConcernAuthorAdapter extends BaseAdapter {

    List<ConcernAuthorBean.ItemListBean> list;
    Context context;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int COUNT = 4;

    public ConcernAuthorAdapter(Context context) {
        this.context = context;
    }


    public ConcernAuthorAdapter setList(List<ConcernAuthorBean.ItemListBean> list) {
        this.list = list;
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
        if (type.equals("briefCard") && !type.isEmpty()){
            return TWO;
        }else if (type.equals("leftAlignTextHeader")){
            return ONE;
        }else if (type.equals("videoCollectionWithBrief")){
            return THREE;
        }else {
            return ONE;
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ConcernAuthorViewHolderOne holderOne = null;
        ConcernAuthorViewHolderTwo holderTwo = null;
        ConcernAuthorViewHolderThree holderThree = null;
        if (view == null) {
            switch (getItemViewType(i)) {
                case ONE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_author_one, viewGroup, false);
                    holderOne = new ConcernAuthorViewHolderOne(view);
                    view.setTag(holderOne);
                    break;
                case TWO:
                    view = LayoutInflater.from(context).inflate(R.layout.item_author_two, viewGroup, false);
                    holderTwo = new ConcernAuthorViewHolderTwo(view);
                    view.setTag(holderTwo);
                    break;
                case THREE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_author_three, viewGroup, false);
                    holderThree = new ConcernAuthorViewHolderThree(view);
                    break;
            }
        }else {
            switch (getItemViewType(i)){
                case ONE:
                    holderOne = (ConcernAuthorViewHolderOne) view.getTag();
                    break;
                case TWO:
                    holderTwo = (ConcernAuthorViewHolderTwo) view.getTag();
                    break;
                case THREE:
                    holderThree = (ConcernAuthorViewHolderThree) view.getTag();
                    break;
            }
        }
        switch (getItemViewType(i)){
            case ONE:
                holderOne.textF.setText(list.get(i).getData().getText());
                break;
            case TWO:
                Glide.with(context).load(list.get(i).getData().getIcon()).into(holderTwo.ivIconF);
                holderTwo.tvTitleF.setText(list.get(i).getData().getTitle());
                holderTwo.tvDescriptionF.setText(list.get(i).getData().getDescription());
                break;
            case THREE:
                if (!list.get(i).getData().getHeader().getIcon().isEmpty()) {
                    Glide.with(context).load(list.get(i).getData().getHeader().getIcon()).into(holderThree.ivThreeIconF);
                    Log.d("ConcernAuthorAdapter", list.get(i).getData().getHeader().getIcon());
                }
                holderThree.tvThreeTitleF.setText(list.get(i).getData().getHeader().getTitle());
                holderThree.tvThreeDF.setText(list.get(i).getData().getHeader().getDescription());
                break;
        }
        return view;
    }

    private class ConcernAuthorViewHolderOne {

        private final TextView textF;

        public ConcernAuthorViewHolderOne(View view) {
            textF = (TextView) view.findViewById(R.id.tv_item_author_text_f);
        }
    }

    private class ConcernAuthorViewHolderTwo {

        private final CircleImageView ivIconF;
        private final TextView tvTitleF;
        private final TextView tvDescriptionF;

        public ConcernAuthorViewHolderTwo(View view) {
            ivIconF = (CircleImageView) view.findViewById(R.id.item_iv_author_two_icon_f);
            tvTitleF = (TextView) view.findViewById(R.id.item_tv_author_two_title_f);
            tvDescriptionF = (TextView) view.findViewById(R.id.item_tv_author_two_description_f);
        }
    }


    private class ConcernAuthorViewHolderThree {

        private final CircleImageView ivThreeIconF;
        private final TextView tvThreeTitleF;
        private final TextView tvThreeDF;

        public ConcernAuthorViewHolderThree(View view) {
            ivThreeIconF = (CircleImageView) view.findViewById(R.id.item_iv_author_three_icon_f);
            tvThreeTitleF = (TextView) view.findViewById(R.id.item_tv_author_three_title_f);
            tvThreeDF = (TextView) view.findViewById(R.id.item_tv_author_three_description_f);
        }
    }
}
