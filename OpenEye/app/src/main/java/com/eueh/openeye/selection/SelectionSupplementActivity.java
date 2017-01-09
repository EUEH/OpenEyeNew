package com.eueh.openeye.selection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;


/**
 * Created by 陈焕栋 on 17/1/7.
 */

public class SelectionSupplementActivity extends BaseActivity implements View.OnTouchListener, TextWatcher {

    private ViewGroup vg;
    private LinearLayout ll;
    private int _yDelta;

    private TextInputLayout lay;
    private EditText et;
    private Button btn;
    private ImageView iv ;


    @Override
    public int setLayout() {
        return R.layout.activity_selection_supplement;
    }

    @Override
    public void initView() {
        vg = (ViewGroup) findViewById(R.id.selection_supplement_vg);
        ll = (LinearLayout) findViewById(R.id.selection_supplement_ll);
        lay = (TextInputLayout) findViewById(R.id.selection_supplement_lay);
        et = (EditText) findViewById(R.id.selection_supplement_ed);
        btn = (Button) findViewById(R.id.selection_supplement_btn);
        iv = (ImageView) findViewById(R.id.selection_supplement_iv);
    }

    @Override
    public void initData() {
        //设置布局参数
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                1080, 4000);
        layoutParams.topMargin = 1500;
        ll.setLayoutParams(layoutParams);
        ll.setOnTouchListener(this);

        //设置文字监听
        et.addTextChangedListener(this);

        //点击按钮生成二维码
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contentString = et.getText().toString();
                if (!contentString.equals("")) {
                    //根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
                    Bitmap qrCodeBitmap = EncodingUtils.createQRCode(contentString, 350, 350, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                    iv.setImageBitmap(qrCodeBitmap);
                } else {
                    Toast.makeText(SelectionSupplementActivity.this, "内容不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int Y = (int) motionEvent.getRawY();
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                _yDelta = Y - layoutParams.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                int dis = Y - _yDelta;
                if (dis > 1600) {
                    dis = 1600;
                } else if (dis < 800) {
                    dis = 800;
                }
                layoutParams1.topMargin = dis;
                view.setLayoutParams(layoutParams1);
                break;
        }
        vg.invalidate();

        return true;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.length() > 15) {
            lay.setError("文字超过15位");
        } else {
            lay.setError(null);
        }


    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}






