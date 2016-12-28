package com.eueh.openeye.concern.concerndetails.concernimage;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.concern.TimeConversion;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

/**
 * Created by 陈小飞 on 16/12/24.
 */

public class ConcernImageFragment extends BaseFragment implements View.OnClickListener {

    private static String urlme;
    private ImageView ivFeedF;
    private TextView tvTitleF;
    private TextView tvCategoryF;
    private TextView tvReleaseTimeF;
    private TextView tvDescriptionF;
    private TextView tvCollectionCountF;
    private TextView tvShareCountF;
    private TextView tvReplyCountF;
    private static int pos;
    private boolean isPlay;
    private Handler handler;
    private ImageView ivBackF;
    private ImageView ivBackgroundF;

    @Override
    public int setLayout() {
        return R.layout.fragment_concern_image_f;
    }

    @Override
    public void initView(View view) {
        ivFeedF = (ImageView) view.findViewById(R.id.iv_concern_fragment_feed_f);
        ivBackF = (ImageView) view.findViewById(R.id.iv_concern_fragment_back_f);
        ivBackgroundF = (ImageView) view.findViewById(R.id.iv_concern_fragment_background_f);
        tvTitleF = (TextView) view.findViewById(R.id.tv_concern_fragment_title_f);
        tvCategoryF = (TextView) view.findViewById(R.id.tv_concern_fragment_category_f);
        tvReleaseTimeF = (TextView) view.findViewById(R.id.tv_concern_fragment_releaseTime_f);
        tvDescriptionF = (TextView) view.findViewById(R.id.tv_concern_fragment_description_f);
        tvCollectionCountF = (TextView) view.findViewById(R.id.tv_concern_fragment_collectionCount_f);
        tvShareCountF = (TextView) view.findViewById(R.id.tv_concern_fragment_shareCount_f);
        tvReplyCountF = (TextView)view.findViewById(R.id.tv_concern_fragment_replyCount_f);
        ivBackF.setOnClickListener(this);
    }

    @Override
    public void initData() {
        getData();
        //图片变大变小
        getChange();
    }

    private void getChange() {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(ivFeedF, "scaleX", 1, 1.05f, 1),
                ObjectAnimator.ofFloat(ivFeedF, "scaleY", 1, 1.05f, 1)
        );

        set.setDuration(8000).start();

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                AnimatorSet set = new AnimatorSet();
                set.playTogether(
                        ObjectAnimator.ofFloat(ivFeedF, "scaleX", 1, 1.05f, 1),
                        ObjectAnimator.ofFloat(ivFeedF, "scaleY", 1, 1.05f, 1)
                );
                set.setDuration(8000).start();
                return false;
            }
        });

        if (!isPlay) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(8000);
                            handler.sendEmptyMessage(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
            isPlay = !isPlay;
        }
    }

    private void getData() {
        NetTool.getInstance().startRequest(urlme, ConcernImageBean.class, new onHttpCallback<ConcernImageBean>() {
            @Override
            public void onSuccess(ConcernImageBean response) {
                Glide.with(getActivity()).load(response.getItemList().get(pos).getData().getCover().getFeed()).into(ivFeedF);
                Glide.with(getActivity()).load(response.getItemList().get(pos).getData().getCover().getBlurred()).into(ivBackgroundF);
                tvTitleF.setText(response.getItemList().get(pos).getData().getTitle());
                tvCategoryF.setText("#" + response.getItemList().get(pos).getData().getCategory());
                tvReleaseTimeF.setText(TimeConversion.conversionTime(response.getItemList().get(pos).getData().getReleaseTime()).substring(14, 19));
                tvDescriptionF.setText(response.getItemList().get(pos).getData().getDescription());
                tvCollectionCountF.setText(response.getItemList().get(pos).getData().getConsumption().getCollectionCount()+"");
                tvShareCountF.setText(response.getItemList().get(pos).getData().getConsumption().getShareCount()+"");
                tvReplyCountF.setText(response.getItemList().get(pos).getData().getConsumption().getReplyCount()+"");
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public static ConcernImageFragment newInstance(int position) {
        Bundle args = new Bundle();
        pos = ConcernImageAdapter.sendPos();
        ConcernImageFragment fragment = new ConcernImageFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public static String Geturl(String url){
        urlme = url;
        return url;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_concern_fragment_back_f:
                getActivity().finish();
                break;
        }
    }
}
