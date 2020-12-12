package com.example.focuser_controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text_log = (TextView) findViewById(R.id.testtext);
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        // fc IN 버튼 눌림 처리!
        Button btn_fc_in = (Button) findViewById(R.id.btn_fc_in) ;
        btn_fc_in.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        text_log.setText("IN 시작");
                        vibrator.vibrate(10);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        text_log.setText("IN 중단");
                        vibrator.vibrate(10);
                        break;
                    }
                }
                return false;
            }
        });


        // fc OUT 버튼 눌림 처리!
        Button btn_fc_out = (Button) findViewById(R.id.btn_fc_out) ;
        btn_fc_out.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        text_log.setText("OUT 전송");
                        vibrator.vibrate(10);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        text_log.setText("OUT 중단");
                        vibrator.vibrate(10);
                        break;
                    }
                }
                return false;
            }
        });


        // fw pre 버튼 눌림 처리!
        Button btn_fw_pre = (Button) findViewById(R.id.btn_fw_pre) ;
        btn_fw_pre.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        text_log.setText("이전 필터로 변경");
                        vibrator.vibrate(10);
                        break;
                    }
                }
                return false;
            }
        });


        // fw next 버튼 눌림 처리!
        Button btn_fw_next = (Button) findViewById(R.id.btn_fw_next) ;
        btn_fw_next.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        text_log.setText("다음 필터로 변경");
                        vibrator.vibrate(10);
                        break;
                    }
                }
                return false;
            }
        });


    }

}
