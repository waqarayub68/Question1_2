package com.example.waqarayub.assignmentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView e;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        e= (TextView) findViewById(R.id.edittext3);
//        st=getIntent().getExtras().getString("PassValue");
//        e.setText(st);
    }
}
