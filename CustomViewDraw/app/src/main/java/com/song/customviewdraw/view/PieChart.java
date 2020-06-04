package com.song.customviewdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.song.customviewdraw.Utils;


public class PieChart extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF bounds = new RectF();
    public static final int RADIOUS = (int)Utils.dp2dx(150);
    public PieChart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bounds.set(getWidth()/2 - RADIOUS,getHeight()/2-RADIOUS,getWidth()/2+RADIOUS,getHeight()/2+RADIOUS);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawarc(canvas,"#2979FF",(int)Utils.dp2dx(150),0,60);
        drawarc(canvas,"#FF7929",(int)Utils.dp2dx(140),60,120);
        drawarc(canvas,"#29FF79",(int)Utils.dp2dx(130),180,80);
        drawarc(canvas,"#99FF29",(int)Utils.dp2dx(120),260,100);
    }

    private void drawarc(Canvas canvas,String color,int radious,int start,int sweep) {
        paint.setColor(Color.parseColor(color));
        canvas.drawArc(getWidth()/2 - radious,getHeight()/2-radious,getWidth()/2+radious,getHeight()/2+radious,start,sweep,true,paint);
    }
}
