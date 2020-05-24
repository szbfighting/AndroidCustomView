package com.song.customview.laginpage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.song.customview.R;

public class LoginKeyBoard extends LinearLayout implements View.OnClickListener {

    private static final String TAG = "LoginKeyBoard";
    private OnKeyPressListener listener;

    public LoginKeyBoard(Context context) {
        this(context, null);
    }

    public LoginKeyBoard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginKeyBoard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //
        LayoutInflater.from(context).inflate(R.layout.num_key_pad, this, true);
        initView();
    }

    private void initView() {
        this.findViewById(R.id.number_1).setOnClickListener(this);
        this.findViewById(R.id.number_2).setOnClickListener(this);
        this.findViewById(R.id.number_3).setOnClickListener(this);
        this.findViewById(R.id.number_4).setOnClickListener(this);
        this.findViewById(R.id.number_5).setOnClickListener(this);
        this.findViewById(R.id.number_6).setOnClickListener(this);
        this.findViewById(R.id.number_7).setOnClickListener(this);
        this.findViewById(R.id.number_8).setOnClickListener(this);
        this.findViewById(R.id.number_9).setOnClickListener(this);
        this.findViewById(R.id.number_0).setOnClickListener(this);
        this.findViewById(R.id.back).setOnClickListener(this);
    }

    public void onClick(View v) {
        if (listener == null){
            Log.d(TAG, "OnKeyPressListener is null need not callback ...");
            return;
        }
        if (v.getId() == R.id.back){
            listener.backPress();
        }else {
            listener.onNumberPress(Integer.parseInt(((TextView)v).getText().toString()));
        }
    }

    public void setOnKeyPressListener(OnKeyPressListener listener){
        this.listener = listener;
    }
    public interface OnKeyPressListener{
        void onNumberPress(int number);

        void backPress();
    }
}
