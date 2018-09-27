package com.example.waqarayub.question1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open = (Button) findViewById(R.id.button3);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenCal_Activity();
            }
        });

    }

    public void OpenCal_Activity()
    {
        Intent intent = new Intent(this,calculator.class);
        startActivity(intent);
    }
}
