package com.song.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.song.customview.customview.InputNumberaView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputNumberaView inputNumberaView = findViewById(R.id.inputNumberView);
        inputNumberaView.setOnNumberChangedListener(new InputNumberaView.OnNumberValueChangedListener() {
            @Override
            public void onNumberChange(int value) {
                Toast.makeText(MainActivity.this, "Num : " +value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
