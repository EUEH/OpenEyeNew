package com.eueh.openeye.concern;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 陈小飞 on 16/12/21.
 */
public class ConcernPointF extends View{
    int r = 10;
    private boolean isSelected = false;

    @Override
    public void setSelected(boolean selected) {
        isSelected = selected;
        invalidate();
    }

    public ConcernPointF(Context context) {
        super(context);
    }

    public ConcernPointF(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (isSelected){
            paint.setColor(Color.WHITE);
        }else {
            paint.setColor(Color.BLACK);
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, r, paint);
    }
}
