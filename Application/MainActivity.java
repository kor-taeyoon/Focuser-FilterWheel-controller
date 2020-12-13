
package com.example.focuser_controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    // 변수
    public int current_position = 0;
    public int current_step = 0;



    // 메인 메소드
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 건드리지 말것. 아직 뭔지 몰름ㅎ
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 뷰 객체 탐색
        TextView text_log = (TextView) findViewById(R.id.text_log);
        TextView text_fc_step = (TextView) findViewById(R.id.text_fc_step);
        TextView text_fc_position = (TextView) findViewById(R.id.text_fc_position);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        Button btn_fc_in = (Button) findViewById(R.id.btn_fc_in) ;
        Button btn_fc_out = (Button) findViewById(R.id.btn_fc_out) ;
        Button btn_fc_up = (Button) findViewById(R.id.btn_fc_up) ;
        Button btn_fc_down = (Button) findViewById(R.id.btn_fc_down) ;



        // 포커서 좌표 갱신 핸들러, 타이머
        @SuppressLint("HandlerLeak")
        Handler handler = new Handler(){
            public void handleMessage(Message msg){
                text_fc_position.setText(Integer.toString(current_position));
            }
        };
        Timer timer = new Timer(true);
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run(){
                Message msg = handler.obtainMessage();
                handler.sendMessage(msg);
            }
        };
        timer.schedule(timerTask, 0, 20);



        // fc IN 버튼 눌림 처리!
        btn_fc_in.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        text_log.setText("들어가는 중..");
                        current_position-=100;
                        vibrator.vibrate(5);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        text_log.setText("이동 끝!");
                        break;
                    }
                }
                return false;
            }
        });


        // fc OUT 버튼 눌림 처리!
        btn_fc_out.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        text_log.setText("나오는 중..");
                        current_position+=100;
                        vibrator.vibrate(5);
                        break;
                    }
                    case MotionEvent.ACTION_UP:{
                        text_log.setText("이동 끝!");
                        break;
                    }
                }
                return false;
            }
        });


        // fc up 버튼 눌림 처리!
        btn_fc_up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        vibrator.vibrate(5);
                        if(current_step == 7){
                            text_log.setText("더 증가시킬 수 없습니다.");
                        }
                        else{
                            current_step++;
                            text_fc_step.setText("uStep: 2^" + Integer.toString(current_step) + " = " + (int)Math.pow(2, current_step));
                            text_log.setText("step up됨.");
                        }
                    }
                }
                return false;
            }
        });


        // fc down 버튼 눌림 처리!
        btn_fc_down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        vibrator.vibrate(5);
                        if(current_step == 0){
                            text_log.setText("더 감소시킬 수 없습니다.");
                        }
                        else{
                            current_step--;
                            text_fc_step.setText("uStep: 2^" + Integer.toString(current_step) + " = " + (int)Math.pow(2, current_step));
                            text_log.setText("step down됨.");
                        }

                        break;
                    }
                }
                return false;
            }
        });


        // fc init 버튼 눌림 처리!
        Button btn_fc_init = (Button) findViewById(R.id.btn_fc_init);
        btn_fc_init.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        text_log.setText("포커서가 초기화됨");
                        current_position = 0;
                        vibrator.vibrate(5);
                        break;
                    }
                }
                return false;
            }
        });



        //여기부터는 필터휠!
        // fw pre 버튼 눌림 처리!
        Button btn_fw_pre = (Button) findViewById(R.id.btn_fw_pre) ;
        btn_fw_pre.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:{
                        text_log.setText("이전 필터로 변경중입니다..");
                        vibrator.vibrate(5);
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
                        text_log.setText("다음 필터로 변경중입니다..");
                        vibrator.vibrate(5);

                        break;
                    }
                }
                return false;
            }
        });








    }
}

