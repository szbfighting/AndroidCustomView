package com.song.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.song.customview.customview.InputNumberaView;
import com.song.customview.lagou.PieImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PieImageView imageView = findViewById(R.id.pieImageView);
        imageView.setProgress(45);
    }

    public void toLoginPage(View v){
        startActivity(new Intent(this,LoginActivity.class));
    }
}
