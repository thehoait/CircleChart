package com.example.hoaht.circlechart.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * @author HoaHT
 */

public class ChartCircle extends View {

    private int mNumber;
    private RectF mRectF;
    private Paint mPaint;
    private Random rnd = new Random();

    public ChartCircle(Context context) {
        this(context, null);
    }

    public ChartCircle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChartCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRectF = new RectF();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mRectF.set(0, 0, getWidth(), getHeight());
        for (int i = 0; i < mNumber; i++) {
            mPaint.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            canvas.drawArc(mRectF, 360 / mNumber * i, 360 / mNumber, true, mPaint);
        }
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 5, mPaint);
    }

    public void setData(int number) {
        mNumber = number;
    }
}
