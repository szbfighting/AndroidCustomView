package com.song.customview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.song.customview.R;

public class InputNumberaView extends RelativeLayout {

    private int number = 0;
    private View minusBtn;
    private EditText numberEdt;
    private View plusBtn;
    private OnNumberValueChangedListener listener = null;

    public InputNumberaView(Context context) {
        this(context,null);
    }

    public InputNumberaView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public InputNumberaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取相关属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.InputNumberView);
        int max = typedArray.getInt(R.styleable.InputNumberView_max,0);
        int min = typedArray.getInt(R.styleable.InputNumberView_min,0);
        int step = typedArray.getInt(R.styleable.InputNumberView_step,0);
        boolean disable = typedArray.getBoolean(R.styleable.InputNumberView_disable,false);
        int btnBaackground = typedArray.getResourceId(R.styleable.InputNumberView_btnBackground, -1);

        //
        typedArray.recycle();
        initView(context);
        //设置事件
        minusBtn = this.findViewById(R.id.minus);
        numberEdt = this.findViewById(R.id.number);
        plusBtn = this.findViewById(R.id.plus);
        setUpEvent();

    }

    private void setUpEvent() {
        minusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setNumber(number-1);
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                setNumber(number+1);
            }
        });
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.input_number_view,this,true);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        numberEdt.setText(String.valueOf(number));
        if (listener!=null)
            listener.onNumberChange(number);
    }

    public interface OnNumberValueChangedListener{
        void onNumberChange(int value);
    }

    public void setOnNumberChangedListener(OnNumberValueChangedListener listener){
        this.listener = listener;
    }
}
