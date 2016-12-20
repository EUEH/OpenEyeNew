package com.eueh.openeye.concern;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.eueh.openeye.R;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/20.
 */

public class ConcernAdapter extends BaseAdapter{
    Context context;
    List<ConcernBean.ItemListBeanX> list;
    public static final int ONE= 1;
    public static final int TWO= 2;

    public ConcernAdapter(Context context) {
        this.context = context;
    }

    public ConcernAdapter setList(List<ConcernBean.ItemListBeanX> list) {
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
    public int getItemViewType(int position) {
        if (position / 3 == 2){
            return ONE;
        }else {
            return TWO;
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ConcernViewHolderFirst first = null;
        ConcernViewHolderSecond second = null;
        if (view == null){
            switch (getItemViewType(i)){
                case ONE:
                    view = LayoutInflater.from(context).inflate(R.layout.item_concern_first_f, viewGroup, false);
                    first = new ConcernViewHolderFirst(view);
                    break;
                case TWO:
                    break;
            }
        }
        return view;
    }

    private class ConcernViewHolderFirst {
        public ConcernViewHolderFirst(View view) {

        }
    }

    private class ConcernViewHolderSecond {
    }
}
