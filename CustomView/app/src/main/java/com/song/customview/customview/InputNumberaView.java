package com.song.customview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
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
    private int max;
    private int min;
    private int step;
    private int defaultValue;
    private boolean disable;
    private int btnBackground;

    private static final String TAG = "InputNumberaView";
    public InputNumberaView(Context context) {
        this(context,null);
    }

    public InputNumberaView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public InputNumberaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取相关属性
        TypedArray typedArray = initAttr(context, attrs);

        //
        typedArray.recycle();
        initView(context);
        //设置事件

        setUpEvent();

    }

    private TypedArray initAttr(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.InputNumberView);
        max = typedArray.getInt(R.styleable.InputNumberView_max,0);
        min = typedArray.getInt(R.styleable.InputNumberView_min,0);
        step = typedArray.getInt(R.styleable.InputNumberView_step,1);
        defaultValue = typedArray.getInt(R.styleable.InputNumberView_defaultValue,0);

        disable = typedArray.getBoolean(R.styleable.InputNumberView_disable,false);
        btnBackground = typedArray.getResourceId(R.styleable.InputNumberView_btnBackground, -1);

        Log.d(TAG, "max -- > " + max);
        Log.d(TAG, "min -- > " + min);
        Log.d(TAG, "step -- > " + step);
        Log.d(TAG, "defaultValue -- > " + defaultValue);
        Log.d(TAG, "disable -- > " + disable);
        Log.d(TAG, "btnBackground -- > " + btnBackground);
        return typedArray;
    }

    private void setUpEvent() {
        minusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                plusBtn.setEnabled(true);

                if (number-step<min){
                    Log.d(TAG, "onClick: already min value ......");
                    return;
                }
                setNumber(number-step);
                if (number-step<min)
                    v.setEnabled(false);
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                minusBtn.setEnabled(true);
                if (number+step>max) {
                    Log.d(TAG, "onClick: already max value ......");
                    return;
                }
                setNumber(number+step);
                if (number+step>max)
                    v.setEnabled(false);
            }
        });
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.input_number_view,this,true);
        minusBtn = this.findViewById(R.id.minus);
        numberEdt = this.findViewById(R.id.number);
        plusBtn = this.findViewById(R.id.plus);
        setDefaultValue(defaultValue);
        setDisable(disable);
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

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
        setNumber(defaultValue);
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
        plusBtn.setEnabled(!disable);
        minusBtn.setEnabled(!disable);
    }

    public int getBtnBackground() {
        return btnBackground;
    }

    public void setBtnBackground(int btnBackground) {
        this.btnBackground = btnBackground;
    }
}
