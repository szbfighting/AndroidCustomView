package com.song.customview.lagou;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.song.customview.R;

public class CustomToolBar extends RelativeLayout {
    private ImageView leftImage,rightImage;
    private TextView titleTextView;
    private String titleText;
    private int textColor;
    private float titleTextSize;
    private int rightImageId;
    private int leftImageId;

    public CustomToolBar(Context context) {
        this(context,null);
    }

    public CustomToolBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs,context);
        init(context);
    }

    private void initAttrs(AttributeSet attrs,Context context) {
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.CustomToolBar);
        titleText = ta.getString(R.styleable.CustomToolBar_titleText);
        Log.d("TITLETEXT", "initAttrs: "+titleText);
        textColor = ta.getColor(R.styleable.CustomToolBar_myTitleTextColor,Color.WHITE);
        titleTextSize = ta.getDimension(R.styleable.CustomToolBar_titleTextSize,12);
        leftImageId = ta.getResourceId(R.styleable.CustomToolBar_leftImageSrc,R.mipmap.ic_launcher);
        rightImageId = ta.getResourceId(R.styleable.CustomToolBar_rightImageSrc,R.mipmap.ic_launcher);
    }

    private void init(Context context) {
        leftImage = new ImageView(context);
        leftImage.setPadding(12,12,12,12);
        rightImage = new ImageView(context);
        rightImage.setPadding(12,12,12,12);
        leftImage.setImageResource(leftImageId);
        rightImage.setImageResource(rightImageId);
        LayoutParams leftParams = new LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48,getResources().getDisplayMetrics()),(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48,getResources().getDisplayMetrics()));
        leftParams.addRule(ALIGN_PARENT_LEFT,TRUE);
        this.addView(leftImage,leftParams);
        titleTextView = new TextView(context);
        titleTextView.setText(titleText);
        titleTextView.setTextSize(titleTextSize);
        titleTextView.setTextColor(textColor);
        LayoutParams titleParams  = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        titleParams.addRule(CENTER_IN_PARENT,TRUE);
        this.addView(titleTextView,titleParams);
        LayoutParams rightParams = new LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48,getResources().getDisplayMetrics()),(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,48,getResources().getDisplayMetrics()));
        rightParams.addRule(ALIGN_PARENT_RIGHT,TRUE);
        addView(rightImage,rightParams);
    }
}
