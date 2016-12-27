package com.eueh.openeye.concern.concerndetails.concernimage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

/**
 * Created by 陈小飞 on 16/12/24.
 */

public class ConcernImageFragment extends BaseFragment{

    private static String urlme;
    private ImageView ivFeedF;
    private TextView tvTitleF;
    private TextView tvCategoryF;
    private TextView tvReleaseTimeF;
    private TextView tvDescriptionF;
    private TextView tvCollectionCountF;
    private TextView tvShareCountF;
    private TextView tvReplyCountF;

    @Override
    public int setLayout() {
        return R.layout.fragment_concern_image_f;
    }

    @Override
    public void initView(View view) {
        ivFeedF = (ImageView) view.findViewById(R.id.iv_concern_fragment_feed_f);
        tvTitleF = (TextView) view.findViewById(R.id.tv_concern_fragment_title_f);
        tvCategoryF = (TextView) view.findViewById(R.id.tv_concern_fragment_category_f);
        tvReleaseTimeF = (TextView) view.findViewById(R.id.tv_concern_fragment_releaseTime_f);
        tvDescriptionF = (TextView) view.findViewById(R.id.tv_concern_fragment_description_f);
        tvCollectionCountF = (TextView) view.findViewById(R.id.tv_concern_fragment_collectionCount_f);
        tvShareCountF = (TextView) view.findViewById(R.id.tv_concern_fragment_shareCount_f);
        tvReplyCountF = (TextView)view.findViewById(R.id.tv_concern_fragment_replyCount_f);
    }

    @Override
    public void initData() {
        getData();
    }

    private void getData() {
        NetTool.getInstance().startRequest(urlme, ConcernImageBean.class, new onHttpCallback<ConcernImageBean>() {
            @Override
            public void onSuccess(ConcernImageBean response) {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public static ConcernImageFragment newInstance(int position) {
        Bundle args = new Bundle();
        int  pos = ConcernImageAdapter.sendPos();
        ConcernImageFragment fragment = new ConcernImageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public static String Geturl(String url){
        urlme = url;
        return url;
    }
}
