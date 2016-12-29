package com.eueh.openeye.concern.concerndetails.concerntitle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.concern.concerndetails.concernimage.ConcernImageActivity;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/23.
 */
public class ConcernTimeFragment extends BaseFragment{

    private ListView lvF;
    private ConcernTimeLvAdapter lvAdapter;
    private String FRONT_URL = "http://baobab.kaiyanapp.com/api/v3/pgc/videos?pgcId=";
    private String BACK_URL = "&strategy=date&udid=67c75fadad7140dd8d3d3c40cf87685971fd4523&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    private String url;
    private List<ConcernItemBean.ItemListBean> list;
    private int a;

    @Override
    public int setLayout() {
        return R.layout.fragment_time_f;
    }

    @Override
    public void initView(View view) {
        lvF = (ListView) view.findViewById(R.id.lv_time_f);
        lvAdapter = new ConcernTimeLvAdapter(getActivity());
        final Intent intent = getActivity().getIntent();
        a = intent.getIntExtra("id", 200);
        url = FRONT_URL + a + BACK_URL;
        Log.d("ConcernTimeFragment11", url);


        lvF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intent1 = new Intent(getActivity(), ConcernImageActivity.class);

                intent1.putExtra("urlMe",url);
                Log.d("ConcernTimeFragment", url);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void initData() {
        NetTool.getInstance().startRequest(url, ConcernItemBean.class, new onHttpCallback<ConcernItemBean>() {
            @Override
            public void onSuccess(ConcernItemBean response) {
                list = response.getItemList();
                ConcernTimeLvAdapter lvAdapter = new ConcernTimeLvAdapter(getActivity());
                lvAdapter.setList(list);
                lvF.setAdapter(lvAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
