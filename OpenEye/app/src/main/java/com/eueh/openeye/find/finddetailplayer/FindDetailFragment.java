package com.eueh.openeye.find.finddetailplayer;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.selection.selection_detail.SelctionDeatailBeanParcelable;
import com.eueh.openeye.selection.selection_detail.SelectionDetailAdapter;
import com.eueh.openeye.utils.LiteTool;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import static android.content.Context.SENSOR_SERVICE;


public class FindDetailFragment extends BaseFragment implements View.OnClickListener {
    private JCVideoPlayerStandard ivFeed;
    private TextView tvTitle, tvCategor, tvReleaseTime, tvDescription,
            tvCollectionCount, tvShareCount, tvReplyCount;
    private JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;
    private SensorManager sensorManager;

    private Handler handler;
    private boolean isPlay;

    private Button btnBack;
    private CheckBox btnCollectionCount;
    private boolean isCollectionCount;
    private FindDeatailBeanParcelable bean;

    private ImageView ivBackgroundGauss, ivDownLoad,ivShare;

    @Override
    public int setLayout() {
        return R.layout.fragment_detail_selction;
    }

    @Override
    public void initView(View view) {

        sensorManager = (SensorManager) getContext().getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();

        ivFeed = (JCVideoPlayerStandard) view.findViewById(R.id.iv_detail_fragment_feed_d);


        ivShare = (ImageView) view.findViewById(R.id.iv_find_share);
        ivDownLoad = (ImageView) view.findViewById(R.id.iv_download);
        tvTitle = (TextView) view.findViewById(R.id.tv_detail_fragment_title_d);
        tvCategor = (TextView) view.findViewById(R.id.tv_detail_fragment_categor_d);
        tvReleaseTime = (TextView) view.findViewById(R.id.tv_detail_fragment_releaseTime_d);
        tvDescription = (TextView) view.findViewById(R.id.tv_detail_fragment_description_d);
        tvCollectionCount = (TextView) view.findViewById(R.id.tv_detail_fragment_collectionCount_d);
        tvShareCount = (TextView) view.findViewById(R.id.tv_detail_fragment_shareCount_d);
        tvReplyCount = (TextView) view.findViewById(R.id.tv_detail_fragment_replyCount_d);
        isPlay = false;
        //btnBack = (Button) view.findViewById(R.id.btn_detail_fragment_back_d);
        btnCollectionCount = (CheckBox) view.findViewById(R.id.btn_detail_fragment_collectionCount_d);
        isCollectionCount = false;
        ivBackgroundGauss = (ImageView) view.findViewById(R.id.selection_detail_background_d);

        ivDownLoad.setOnClickListener(this);
        ivShare.setOnClickListener(this);
    }


    @Override
    public void initData() {

        //分享
        ShareSDK.initSDK(getContext());

        //第一次进入加载的数据
        initMyData();
        //背景高斯模糊---毛玻璃效果 ----  在上面那个方法里面写了----因为Glide需要网络解析需要时间
        //给图片设置动画
        // animatethepicture();
        //点击左上角退出
        //cliBack();
        //点赞赞数量+1
        clifavouraddone();


    }


    private void clifavouraddone() {

//111    用数据库存  这样可以有一个id  这样就不会用户重复了
//        SharedPreferences sp = getContext().getSharedPreferences("section_menu_d" , Context.MODE_PRIVATE);
//        boolean iscoll = sp.getBoolean("isCollection" , false ) ;
//        tvCollectionCount.setText(sp.getString("collectionCount" , bean.getCollectionCount() + ""));
//        btnCollectionCount.setChecked(iscoll);

        btnCollectionCount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //b最开始是ture   ture------没收藏   false-----收藏
                if (b) {
                    String collStr = tvCollectionCount.getText().toString();
                    int collAgo = Integer.parseInt(collStr);
                    int collAfter = collAgo + 1;
                    tvCollectionCount.setText(collAfter + "");

//                    LiteTool.getInstance().insertOne();



                } else {
                    String collStr = tvCollectionCount.getText().toString();
                    int collAgo = Integer.parseInt(collStr);
                    int collAfter = collAgo - 1;
                    tvCollectionCount.setText(collAfter + "");


                }
            }
        });

    }

//    private void cliBack() {
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //getContext不行  getActivity才可以
//                getActivity().finish();
//
//
//            }
//        });
//    }

    private void animatethepicture() {

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
        bean = new FindDeatailBeanParcelable();
        bean = bundle.getParcelable("detail_data_bean_d");

        ivFeed.setUp(bean.getPalyUrl(), ivFeed.SCREEN_LAYOUT_NORMAL, bean.getTitle());

        tvTitle.setText(bean.getTitle());
        tvCategor.setText("#" + bean.getCategory() + "  /");
        tvReleaseTime.setText(bean.getReleaseTime() + "");
        tvDescription.setText(bean.getDescription());
        tvCollectionCount.setText(bean.getCollectionCount() + "");
        tvShareCount.setText(bean.getShareCount() + "");
        tvReplyCount.setText(bean.getReplyCount() + "");

        Glide.with(getContext()).load(bean.getBlurred()).into(ivBackgroundGauss);

        ivFeed.thumbImageView.setMaxWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        Glide.with(getContext()).load(bean.getImageFeed()).into(ivFeed.thumbImageView);

    }

    public static FindDetailFragment newInstance(int pos) {

        Bundle args = new Bundle();
        args.putParcelable("detail_data_bean_d", FindDetailAdapter.getDetailData(pos));

        FindDetailFragment fragment = new FindDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //高斯模糊   毛玻璃   传入东西实现高斯模糊
    public Bitmap fastblur(Context context, Bitmap sentBitmap, int radius) {

        Bitmap bitmap = sentBitmap.copy(sentBitmap.getConfig(), true);

        if (radius < 1) {
            return (null);
        }

        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        int[] pix = new int[w * h];
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);

        int wm = w - 1;
        int hm = h - 1;
        int wh = w * h;
        int div = radius + radius + 1;

        int r[] = new int[wh];
        int g[] = new int[wh];
        int b[] = new int[wh];
        int rsum, gsum, bsum, x, y, i, p, yp, yi, yw;
        int vmin[] = new int[Math.max(w, h)];

        int divsum = (div + 1) >> 1;
        divsum *= divsum;
        int temp = 256 * divsum;
        int dv[] = new int[temp];
        for (i = 0; i < temp; i++) {
            dv[i] = (i / divsum);
        }

        yw = yi = 0;

        int[][] stack = new int[div][3];
        int stackpointer;
        int stackstart;
        int[] sir;
        int rbs;
        int r1 = radius + 1;
        int routsum, goutsum, boutsum;
        int rinsum, ginsum, binsum;

        for (y = 0; y < h; y++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            for (i = -radius; i <= radius; i++) {
                p = pix[yi + Math.min(wm, Math.max(i, 0))];
                sir = stack[i + radius];
                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);
                rbs = r1 - Math.abs(i);
                rsum += sir[0] * rbs;
                gsum += sir[1] * rbs;
                bsum += sir[2] * rbs;
                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }
            }
            stackpointer = radius;

            for (x = 0; x < w; x++) {

                r[yi] = dv[rsum];
                g[yi] = dv[gsum];
                b[yi] = dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (y == 0) {
                    vmin[x] = Math.min(x + radius + 1, wm);
                }
                p = pix[yw + vmin[x]];

                sir[0] = (p & 0xff0000) >> 16;
                sir[1] = (p & 0x00ff00) >> 8;
                sir[2] = (p & 0x0000ff);

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[(stackpointer) % div];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi++;
            }
            yw += w;
        }
        for (x = 0; x < w; x++) {
            rinsum = ginsum = binsum = routsum = goutsum = boutsum = rsum = gsum = bsum = 0;
            yp = -radius * w;
            for (i = -radius; i <= radius; i++) {
                yi = Math.max(0, yp) + x;

                sir = stack[i + radius];

                sir[0] = r[yi];
                sir[1] = g[yi];
                sir[2] = b[yi];

                rbs = r1 - Math.abs(i);

                rsum += r[yi] * rbs;
                gsum += g[yi] * rbs;
                bsum += b[yi] * rbs;

                if (i > 0) {
                    rinsum += sir[0];
                    ginsum += sir[1];
                    binsum += sir[2];
                } else {
                    routsum += sir[0];
                    goutsum += sir[1];
                    boutsum += sir[2];
                }

                if (i < hm) {
                    yp += w;
                }
            }
            yi = x;
            stackpointer = radius;
            for (y = 0; y < h; y++) {
                pix[yi] = (0xff000000 & pix[yi]) | (dv[rsum] << 16)
                        | (dv[gsum] << 8) | dv[bsum];

                rsum -= routsum;
                gsum -= goutsum;
                bsum -= boutsum;

                stackstart = stackpointer - radius + div;
                sir = stack[stackstart % div];

                routsum -= sir[0];
                goutsum -= sir[1];
                boutsum -= sir[2];

                if (x == 0) {
                    vmin[y] = Math.min(y + r1, hm) * w;
                }
                p = x + vmin[y];

                sir[0] = r[p];
                sir[1] = g[p];
                sir[2] = b[p];

                rinsum += sir[0];
                ginsum += sir[1];
                binsum += sir[2];

                rsum += rinsum;
                gsum += ginsum;
                bsum += binsum;

                stackpointer = (stackpointer + 1) % div;
                sir = stack[stackpointer];

                routsum += sir[0];
                goutsum += sir[1];
                boutsum += sir[2];

                rinsum -= sir[0];
                ginsum -= sir[1];
                binsum -= sir[2];

                yi += w;
            }
        }

        bitmap.setPixels(pix, 0, w, 0, 0, w, h);
        return (bitmap);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    public void onResume() {
        super.onResume();
        Sensor accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(sensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //下载的点击事件
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.iv_download:
                Toast.makeText(getContext(), "下载了奥", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent("MYBR");

                intent.putExtra("name", bean.getTitle());
                intent.putExtra("url", bean.getPalyUrl());

                getContext().sendBroadcast(intent);
                break;

            case R.id.iv_find_share:

                showShare();

                break;
        }


    }

    //QQ分享
    private void showShare() {

        ShareSDK.initSDK(getContext());
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("EUEH");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl(bean.getPalyUrl());
// text是分享文本，所有平台都需要这个字段
        oks.setText(bean.getTitle());
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("See You Again");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(bean.getPalyUrl());

// 启动分享GUI
        oks.show(getContext());

    }
}
