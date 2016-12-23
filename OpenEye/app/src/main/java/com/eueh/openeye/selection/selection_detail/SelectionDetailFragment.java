package com.eueh.openeye.selection.selection_detail;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;

/**
 * Created by 陈焕栋 on 16/12/22.
 */

public class SelectionDetailFragment extends BaseFragment {
    private ImageView ivFeed;
    private TextView tvTitle, tvCategor, tvReleaseTime, tvDescription,
            tvCollectionCount, tvShareCount, tvReplyCount;

    private Handler handler;
    private boolean isPlay ;

    private Button btnBack ;


    @Override
    public int setLayout() {
        return R.layout.fragment_detail_selction;
    }

    @Override
    public void initView(View view) {
        ivFeed = (ImageView) view.findViewById(R.id.iv_detail_fragment_feed_d);
        tvTitle = (TextView) view.findViewById(R.id.tv_detail_fragment_title_d);
        tvCategor = (TextView) view.findViewById(R.id.tv_detail_fragment_categor_d);
        tvReleaseTime = (TextView) view.findViewById(R.id.tv_detail_fragment_releaseTime_d);
        tvDescription = (TextView) view.findViewById(R.id.tv_detail_fragment_description_d);
        tvCollectionCount = (TextView) view.findViewById(R.id.tv_detail_fragment_collectionCount_d);
        tvShareCount = (TextView) view.findViewById(R.id.tv_detail_fragment_shareCount_d);
        tvReplyCount = (TextView) view.findViewById(R.id.tv_detail_fragment_replyCount_d);
        isPlay = false;
        btnBack = (Button) view.findViewById(R.id.btn_detail_fragment_back_d);
    }

    @Override
    public void initData() {
        //第一次进入加载的数据
        initMyData();
        //给图片设置动画
        animatethepicture();
        //点击左上角退出
        cliBack();
        //点赞赞数量+1
        clifavouraddone();


    }

    private void clifavouraddone() {


    }

    private void cliBack() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getContext不行  getActivity才可以
                getActivity().finish();


            }
        });
    }

    private void animatethepicture() {

//        ObjectAnimator animtionX = ObjectAnimator.ofFloat(ivFeed, "scaleX", 1, 1.05f ,1).ofFloat(ivFeed, "scaleY", 1, 1.05f ,1);
//        animtionX.setRepeatCount(-1);
//        animtionX.setDuration(5000);
//        animtionX.start();



        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(ivFeed, "scaleX", 1, 1.05f, 1),
                ObjectAnimator.ofFloat(ivFeed, "scaleY", 1, 1.05f, 1)
        );

        set.setDuration(8000).start();

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                AnimatorSet set = new AnimatorSet();
                set.playTogether(
                        ObjectAnimator.ofFloat(ivFeed, "scaleX", 1, 1.05f, 1),
                        ObjectAnimator.ofFloat(ivFeed, "scaleY", 1, 1.05f, 1)
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

    private void initMyData() {
        Bundle bundle = getArguments();
        SelctionDeatailBeanParcelable bean = new SelctionDeatailBeanParcelable();
        bean = bundle.getParcelable("detail_data_bean_d");
        Glide.with(getContext()).load(bean.getImageFeed()).into(ivFeed);
        tvTitle.setText(bean.getTitle());
        tvCategor.setText("#" + bean.getCategory() + "  /");
        tvReleaseTime.setText(bean.getReleaseTime() + "");
        tvDescription.setText(bean.getDescription());
        tvCollectionCount.setText(bean.getCollectionCount() + "");
        tvShareCount.setText(bean.getShareCount() + "");
        tvReplyCount.setText(bean.getReplyCount() + "");
    }


    public static SelectionDetailFragment newInstance(int pos) {

        Bundle args = new Bundle();
        args.putParcelable("detail_data_bean_d", SelectionDetailAdapter.getDetailData(pos));

        SelectionDetailFragment fragment = new SelectionDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
