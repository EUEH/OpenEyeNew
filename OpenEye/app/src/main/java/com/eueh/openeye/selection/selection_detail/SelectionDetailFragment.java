package com.eueh.openeye.selection.selection_detail;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.find.toolg.ToolG;
import com.eueh.openeye.selection.selectiontool.FadeInTextView;
import com.eueh.openeye.utils.LiteTool;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by 陈焕栋 on 16/12/22.
 */

public class SelectionDetailFragment extends BaseFragment implements View.OnClickListener {
    // private ImageView ivFeed;
    private JCVideoPlayerStandard ivFeed;

    private JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;
    private SensorManager sensorManager;

    private TextView tvCollectionCount, tvShareCount, tvReplyCount, tvDescription, tvReleaseTime;

    private FadeInTextView tvTitle, tvCategor;

    private Handler handler;
    private boolean isPlay;

    private Button btnBack;
    private CheckBox btnCollectionCount;
    private boolean isCollectionCount;
    private SelctionDeatailBeanParcelable bean;

    private ImageView ivBackgroundGauss , iv_download;
    private Bundle bundle;

    private int collCount ;





    @Override
    public int setLayout() {
        return R.layout.fragment_detail_selction;
    }

    @Override
    public void initView(View view) {

        sensorManager = (SensorManager) getContext().getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();

        //    ivFeed = (ImageView) view.findViewById(R.id.iv_detail_fragment_feed_d);

        ivFeed = (JCVideoPlayerStandard) view.findViewById(R.id.iv_detail_fragment_feed_d);
        tvTitle = (FadeInTextView) view.findViewById(R.id.tv_detail_fragment_title_d);
        tvCategor = (FadeInTextView) view.findViewById(R.id.tv_detail_fragment_categor_d);
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

        collCount = 0  ;
        //下载的Imageview
        iv_download = (ImageView) view.findViewById(R.id.iv_download);
    }

    @Override
    public void initData() {


        //第一次进入加载的数据
        initMyData();
        //背景高斯模糊---毛玻璃效果 ----  在上面那个方法里面写了----因为Glide需要网络解析需要时间
        //给图片设置动画
        animatethepicture();
        //点击左上角退出
        cliBack();
        //点赞赞数量+1   收藏数据库
        clifavouraddone();
        //点击下载发送广播  开始下载
        iv_download.setOnClickListener(this);


    }


    private void clifavouraddone() {
        //设置默认的是否收藏
        boolean qq = LiteTool.getInstance().queryOne(SelectionCollection.class, "picUrl", bean.getImageFeed());
        btnCollectionCount.setChecked(qq);
        if (qq){
            tvCollectionCount.setText((collCount+1)+"");
        }



        btnCollectionCount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //b最开始是ture   ture------没收藏   false-----收藏

                if (b) {
                    String collStr = tvCollectionCount.getText().toString();
                    int collAgo = Integer.parseInt(collStr);
                    int collAfter = collAgo + 1;
                    tvCollectionCount.setText(collAfter + "");
                    //点击收藏把数据存到数据库里面
                    SelectionCollection sc = new SelectionCollection();
                    sc.setPicUrl(bean.getImageFeed());
                    sc.setTitle(bean.getTitle());
                    sc.setCategory(bean.getCategory());
                    sc.setReleaseTime(bean.getReleaseTime());

                    LiteTool.getInstance().insertOne(sc);
                    Toast.makeText(getContext(), "已加入收藏", Toast.LENGTH_SHORT).show();

                    List<SelectionCollection> list = LiteTool.getInstance().queryAll(SelectionCollection.class);
                    for (SelectionCollection qq : list) {
                        Log.d("SelectionDetailFragment", qq.getId() + "\n" +
                                qq.getPicUrl()
                        );
                    }


                } else {

                    String collStr = tvCollectionCount.getText().toString();
                    int collAgo = Integer.parseInt(collStr);
                    int collAfter = collAgo - 1;
                    tvCollectionCount.setText(collAfter + "");

                    LiteTool.getInstance().deleteOne(SelectionCollection.class, "picUrl", bean.getImageFeed());
                    //查询
                    List<SelectionCollection> list = LiteTool.getInstance().queryAll(SelectionCollection.class);
                    for (SelectionCollection qq : list) {
                        Log.d("SelectionDetailFragment", qq.getId() + "\n" +
                                qq.getPicUrl()
                        );
                    }


                }
            }
        });

    }

    private void cliBack() {
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //getContext不行  getActivity才可以
//                getActivity().finish();
//
//
//            }
//        });
    }

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
        bundle = getArguments();
        bean = new SelctionDeatailBeanParcelable();
        bean = bundle.getParcelable("detail_data_bean_d");
        //     Glide.with(getContext()).load(bean.getImageFeed()).into(ivFeed);

        ivFeed.setUp(bean.getPalyUrl(), ivFeed.SCREEN_LAYOUT_NORMAL, bean.getTitle());

        tvTitle.setText(bean.getTitle(), AnimationUtils.loadAnimation(getContext()
                , R.anim.selection_tv_anim), 200, 18);


        //tvCategor.setText("#" + bean.getCategory() + "  /");
        tvCategor.setText("#" + bean.getCategory() + "  /", AnimationUtils.loadAnimation(getContext()
                , R.anim.selection_tv_anim), 200, 12);

        tvReleaseTime.setText(bean.getReleaseTime() + "");
//        tvReleaseTime.setText(bean.getReleaseTime() + "", AnimationUtils.loadAnimation(getContext()
//                , R.anim.selection_tv_anim), 200, 12);


        tvDescription.setText(bean.getDescription());
//        tvDescription.setText(bean.getDescription() , AnimationUtils.loadAnimation(getContext()
//            , R.anim.selection_tv_anim) , 200 , 12);


        tvCollectionCount.setText(bean.getCollectionCount() + "");
        collCount = bean.getCollectionCount()  ;

        tvShareCount.setText(bean.getShareCount() + "");
        tvReplyCount.setText(bean.getReplyCount() + "");
        //Gilde.asBiemap.into(new Sim)  里面的resource就是那个结果
//        Glide.with(getContext()).load(bean.getBlurred())
//                .asBitmap().into(new SimpleTarget<Bitmap>() {
//            @Override
//            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                ivBackgroundGauss.setImageBitmap(fastblur(getContext(), resource, 50));
//             }
//        });

        Glide.with(getContext()).load(bean.getBlurred()).into(ivBackgroundGauss);

        ivFeed.thumbImageView.setMaxWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        Glide.with(getContext()).load(bean.getImageFeed()).into(ivFeed.thumbImageView);

        Bundle b = getArguments();
        

    }


    public static SelectionDetailFragment newInstance(int pos) {

        Bundle args = new Bundle();
        args.putParcelable("detail_data_bean_d", SelectionDetailAdapter.getDetailData(pos));

        SelectionDetailFragment fragment = new SelectionDetailFragment();
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

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "开始下载", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent("MYBR");

        intent.putExtra("name", bean.getTitle());
        intent.putExtra("url", bean.getPalyUrl());

        getContext().sendBroadcast(intent);
    }




}
