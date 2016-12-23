package com.eueh.openeye.selection.selection_main;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.eueh.openeye.R;

/**
 * Created by 陈焕栋 on 16/12/21.
 */

public class SelectionMyStyView extends ScrollView {

    private ImageView iv ;
    private int distance;

    public SelectionMyStyView setIv(ImageView iv) {
        this.iv = iv;
        return this;
    }

    public SelectionMyStyView(Context context) {
        super(context);
    }

    public SelectionMyStyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelectionMyStyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //下拉位置
    private float y = 0f;
    //原本宽高
    private int zoomWidth = 0;
    private int zoomHeight = 0;
    //是否正在放大
    private boolean mScaling = false;
    //放大的View
    private View zoomView;

    public void setZoomView(View zoomView) {
        this.zoomView = zoomView;
    }

    //滑动放大系数,系数越大,滑动放大程度越大
    private float mScaleRatio = 1f;

    public void setmScaleRatio(float mScaleRatio) {
        this.mScaleRatio = mScaleRatio;
    }

    //最大放大倍数
    private float mScaleTimes = 3f;

    public void setmScaleTimes(float mScaleTimes) {
        this.mScaleTimes = mScaleTimes;
    }

    //回弹时间系数  系数越小  回弹越快
    private float mReplyRatio = 2f;

    public void setmReplyRatio(float mReplyRatio) {
        this.mReplyRatio = mReplyRatio;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        //不可过度滚动  否则上移后下拉会出现部分空白情况
        setOverScrollMode(OVER_SCROLL_NEVER);
        //获得默认第一个View
        if (getChildAt(0) != null && getChildAt(0) instanceof ViewGroup && zoomView == null) {
            ViewGroup vg = (ViewGroup) getChildAt(0);
            if (vg.getChildCount() > 0) {
                zoomView = vg.getChildAt(0);
            }
        }



    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (zoomWidth <= 0 || zoomHeight <= 0) {
            zoomWidth = zoomView.getMeasuredWidth();
            zoomHeight = zoomView.getMeasuredHeight();
        }
        if (zoomView == null || zoomWidth <= 0 || zoomHeight <= 0) {
            return super.onTouchEvent(ev);
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (!mScaling) {
                    if (getScrollX() == 0) {
                        //y 是你点击的时候距离上面的距离
                        y = ev.getY();  //滑动到顶部时记录位置
                    } else {
                        break;
                    }
                }
                //滑动的距离
                distance = (int) ((ev.getY() - y) * mScaleRatio);

                //当距离超过一定数量后
                if (distance > 500){
                    iv.setImageResource(R.mipmap.headview_three_d);
                }else if (distance > 400){
                    iv.setImageResource(R.mipmap.headview_two_d);
                }else if (distance > 300 ){
                    iv.setImageResource(R.mipmap.headview_one_d);
                }

                if (distance < 0) break;  //若往下滑动
                mScaling = true;
                //自定义方法
                setZoom(distance);



                return true;
            case MotionEvent.ACTION_UP:
                mScaling = false;
                //自定义方法
                replyView();

                if (distance > 200){
                    //每当手指松开则传值
                    iv.setImageResource(R.drawable.headview_anim_d);
                    AnimationDrawable anim = (AnimationDrawable) iv.getDrawable();
                    anim.start();
                }





                break;
        }
        return super.onTouchEvent(ev);
    }

    //方法View方法
    private void setZoom(float s) {
        float scaleTimes = (float) ((zoomWidth + s) / (zoomHeight * 1.0));
        //如果最大放大倍数  直接返回
        if (scaleTimes > mScaleTimes) return;

        ViewGroup.LayoutParams layoutParams = zoomView.getLayoutParams();
        layoutParams.width = (int) (zoomWidth + s);
        layoutParams.height = (int) (zoomHeight * ((zoomWidth + s) / (zoomWidth)));
        //设置控件水平居中
        ((MarginLayoutParams) layoutParams).setMargins(-(layoutParams.width - zoomWidth) / 2, 0, 0, 0);
        zoomView.setLayoutParams(layoutParams);
    }

    //回弹方法
    private void replyView() {
        final float distance = zoomView.getMeasuredWidth() - zoomWidth;
        //设置动画
        ValueAnimator anim = ObjectAnimator.ofFloat(distance, 0.0F).setDuration((long) (distance * mReplyRatio));
        //添加监听
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                setZoom((Float) valueAnimator.getAnimatedValue());
            }
        });
        anim.start();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollListener != null ) onScrollListener.onScroll(1 , t , oldl , oldt);
    }

    private OnScrollListener onScrollListener ;
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    //自己定义的接口
    public  interface  OnScrollListener {
        void onScroll(int scrollx , int scrollY , int oldScrollX , int oldScrollY );
    }

}
