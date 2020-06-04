package com.song.customviewdraw.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class TestView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public TestView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        path.addRect(getWidth()/2-150,getHeight()/2-300,getWidth()/2+150,getHeight()/2, Path.Direction.CCW);
        path.addCircle(getWidth()/2,getHeight()/2,150, Path.Direction.CW);
        //path.addCircle(getWidth()/2,getHeight()/2,350, Path.Direction.CCW);
        //path.addCircle(getWidth()/2,getHeight()/2,400, Path.Direction.CCW);
        //canvas.drawLine(100,100,200,200,paint);
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        /*paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);*/
        canvas.drawPath(path,paint);
        //canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/3,paint);
    }


}
