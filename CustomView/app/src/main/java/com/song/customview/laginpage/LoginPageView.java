package com.song.customview.laginpage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.song.customview.R;

public class LoginPageView extends FrameLayout {
    public LoginPageView(@NonNull Context context) {
        this(context,null);
    }

    public LoginPageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoginPageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化属性
        initAttrs(context, attrs);
        //初始化控件
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.login_page_view,this);
    }

    private void initAttrs(@NonNull Context context, @Nullable AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoginPageView);
        int color = a.getColor(R.styleable.LoginPageView_mainColor,-1);
        int verifyCodeSize = a.getInt(R.styleable.LoginPageView_verifyCodeSize,4);
        a.recycle();
    }
}
