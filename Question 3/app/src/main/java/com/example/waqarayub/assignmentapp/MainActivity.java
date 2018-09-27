package com.example.waqarayub.assignmentapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        try {
//            Bundle extras = getIntent().getExtras();
//            email = extras.getString("MyName");
//            password = extras.getString("MyPass");
//        }
//        catch (Exception e)
//        {}
//        //Gradient
////        RelativeLayout RL = findViewById(R.id.layout1);
////        AnimationDrawable AD= (AnimationDrawable) RL.getBackground();
////        AD.setEnterFadeDuration(2000);
////        AD.setExitFadeDuration(4000);
////        AD.start();

        //Logo Timer
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
               // finish();
            }
        },5000);
    }
}
