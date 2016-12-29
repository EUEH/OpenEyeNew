package com.eueh.openeye.concern.author;

import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/28.
 */
public class ConcernAuthorActivity extends BaseActivity{

    private ListView authorLvF;
    private static String URL = "http://baobab.kaiyanapp.com/api/v4/pgcs/all?udid=67c75fadad7140dd8d3d3c40cf87685971fd4523&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    private ConcernAuthorAdapter authorAdapter;
    private TextView tvBack;

    @Override
    public int setLayout() {
        return R.layout.activity_author_f;
    }

    @Override
    public void initView() {
        authorLvF = (ListView) findViewById(R.id.lv_concern_author_f);
        tvBack = (TextView) findViewById(R.id.tv_concern_author_f);
        authorAdapter = new ConcernAuthorAdapter(this);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ConcernAuthorActivity", "点击了");
                finish();
            }
        });
    }

    @Override
    public void initData() {
        NetTool.getInstance().startRequest(URL, ConcernAuthorBean.class, new onHttpCallback<ConcernAuthorBean>() {
            @Override
            public void onSuccess(ConcernAuthorBean response) {
                List<ConcernAuthorBean.ItemListBean> list = response.getItemList();
                authorAdapter.setList(list);
                authorLvF.setAdapter(authorAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
