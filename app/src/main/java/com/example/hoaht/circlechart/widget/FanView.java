package com.example.hoaht.circlechart.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author HoaHT
 */

public class FanView extends View {

    private static final int WIDTH_STROKE = 3;
    private static final int WING_PADDING = 20;
    private RectF mRectF;
    private Handler mHandler;
    private Runnable mRunnable;

    public FanView(Context context) {
        this(context, null);
    }

    public FanView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FanView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mRectF = new RectF();
        mHandler = new Handler();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        draArcWithBorder(canvas);
        drawCircleWithBorder(canvas, getWidth() / 2, getHeight() / 4, getWidth() / 4, Color.BLACK, Color.WHITE);
        drawCircleWithBorder(canvas, getWidth() / 2, getHeight() / 4, getWidth() / 25, Color.BLACK, Color.RED);
        mRectF.set(getWidth() / 4, getHeight() / 2, 3 * getWidth() / 4, getHeight() / 2 + 50);
        drawOvalWithBorder(canvas, mRectF, Color.BLACK, Color.GREEN);
        mRectF.set(getWidth() / 2 - getWidth() / 25, getHeight() / 4 - getWidth() / 4 + WING_PADDING,
                getWidth() / 2 + getWidth() / 25, getHeight() / 4 - getWidth() / 25);
        drawOvalWithBorder(canvas, mRectF, Color.BLACK, Color.GREEN);
        mRectF.set(getWidth() / 2 - getWidth() / 25, getHeight() / 4 + getWidth() / 25,
                getWidth() / 2 + getWidth() / 25, getHeight() / 4 + getWidth() / 4 - WING_PADDING);
        drawOvalWithBorder(canvas, mRectF, Color.BLACK, Color.GREEN);
        mRectF.set(getWidth() / 2 - getWidth() / 4 + WING_PADDING, getHeight() / 4 - getWidth() / 25,
                getWidth() / 2 - getWidth() / 25, getHeight() / 4 + getWidth() / 25);
        drawOvalWithBorder(canvas, mRectF, Color.BLACK, Color.GREEN);
        mRectF.set(getWidth() / 2 + getWidth() / 25, getHeight() / 4 - getWidth() / 25,
                getWidth() / 2 + getWidth() / 4 - WING_PADDING, getHeight() / 4 + getWidth() / 25);
        drawOvalWithBorder(canvas, mRectF, Color.BLACK, Color.GREEN);
    }

    private void draArcWithBorder(Canvas canvas) {
        RectF rectF = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(WIDTH_STROKE);
        rectF.set(getWidth() / 4, getHeight() / 4 - getWidth() / 4, getWidth() / 2 + getWidth() / 4,
                getHeight() / 2 + 50);
        canvas.drawArc(rectF, 60, 60, true, paint);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(getWidth() / 4 + WIDTH_STROKE, getHeight() / 4 - getWidth() / 4 + WIDTH_STROKE,
                getWidth() / 2 + getWidth() / 4 - WIDTH_STROKE, getHeight() / 2 + 50 - WIDTH_STROKE);
        canvas.drawArc(rectF, 60, 60, true, paint);
    }

    private void drawCircleWithBorder(Canvas canvas, float cx, float cy, float radius, int colorStroke, int colorFill) {
        Paint paint = new Paint();
        paint.setStrokeWidth(WIDTH_STROKE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(cx, cy, radius, paint);
        paint.setColor(colorStroke);
        paint.setColor(colorFill);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, radius - WIDTH_STROKE, paint);
    }

    private void drawOvalWithBorder(Canvas canvas, RectF rectF, int colorStroke, int colorFill) {
        RectF rectFFill = new RectF();
        rectFFill.set(rectF.left + WIDTH_STROKE, rectF.top + WIDTH_STROKE, rectF.right - WIDTH_STROKE, rectF.bottom - WIDTH_STROKE);
        Paint paint = new Paint();
        paint.setStrokeWidth(WIDTH_STROKE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(colorStroke);
        canvas.drawOval(rectF, paint);
        paint.setColor(colorFill);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(rectFFill, paint);
    }
}
