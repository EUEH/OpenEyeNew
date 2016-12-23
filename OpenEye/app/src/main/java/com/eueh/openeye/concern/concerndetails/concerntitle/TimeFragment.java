package com.eueh.openeye.concern.concerndetails.concerntitle;

import android.view.View;
import android.widget.ListView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;

/**
 * Created by 陈小飞 on 16/12/23.
 */
public class TimeFragment extends BaseFragment{

    private ListView lvF;
    private TimeLvAdapter lvAdapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_time_f;
    }

    @Override
    public void initView(View view) {
        lvF = (ListView) view.findViewById(R.id.lv_time_f);
        lvAdapter = new TimeLvAdapter(getActivity());
    }

    @Override
    public void initData() {

    }
}
