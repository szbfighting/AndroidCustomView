package com.song.customviewdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DashBoard extends View {
    private static final int ANGLE = 120;
    private static final int RADIOUS = 400;
    private static final int LENGTH = 100;
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path dash = new Path();
    private RectF rectF;
    private PathDashPathEffect effect;

    public DashBoard(Context context) {
        super(context);
    }

    public DashBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF = new RectF(getWidth()/2- RADIOUS,getHeight()/2 - RADIOUS,getWidth()/2+RADIOUS,getHeight()/2+RADIOUS);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawArc(rectF,90+ANGLE/2,360-ANGLE,false,paint);

        Path arc = new Path();
        arc.addArc(rectF,90+ANGLE/2,360-ANGLE);
        PathMeasure pathMeasure = new PathMeasure(arc,false);

        dash.addRect(0,0,10,20, Path.Direction.CW);
        effect = new PathDashPathEffect(dash, (pathMeasure.getLength()-10)/20, 0, PathDashPathEffect.Style.ROTATE);
        paint.setPathEffect(effect);

        //画刻度
        canvas.drawArc(rectF,90+ANGLE/2,360-ANGLE,false,paint);
        canvas.drawLine(getWidth()/2,getHeight()/2,
                (float)Math.cos(Math.toRadians(getAngleFromMark(5)))*LENGTH +getWidth()/2,
                (float)Math.sin(Math.toRadians(getAngleFromMark(5)))*LENGTH + getHeight()/2,
                paint);
    }

    int getAngleFromMark(int mark){
        return 90 + ANGLE/2+(360-ANGLE)/20*mark;
    }

}

