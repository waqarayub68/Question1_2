package com.example.waqarayub.assignmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    // Definition of password pattern
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 4 characters
                    "$");

    //String str,passstr;
    private Button Logbutton;
    private Button regbutton;
    EditText mail,pass;
    //String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        Bundle extras=getIntent().getExtras();
//        email=extras.getString("MyName");
//        password=extras.getString("MyPass");
        //Fields Identity
        mail= (EditText) findViewById(R.id.editlog);
        pass=  (EditText) findViewById(R.id.editpass);

        //Login Button Listener
        Logbutton = (Button) findViewById(R.id.buttonlogin);
        Logbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                //String str1 =mail.getText().toString();
                //String str2 = pass.getText().toString();
//                str=getIntent().getExtras().getString("Value");
//                passstr=getIntent().getExtras().getString("PassValue");
                if(validateEmail() && validatePassword())
                    OpenHome_Activity();
            }
        });

        // Register Button Listener
        regbutton = (Button) findViewById(R.id.buttonRegister);
        regbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                OpenRegister_Activity();
            }
        });

    }

    private boolean validateEmail() {
        String str1 =mail.getText().toString();

        if (str1.isEmpty()) {
            mail.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str1).matches()) { //predefine email pattern
            mail.setError("Please enter a valid email address");
            return false;
        } else {
            mail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String str2=pass.getText().toString();
        if (str2.isEmpty()) {
            pass.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(str2).matches()) {
            pass.setError("Password too weak");
            return false;
        } else {
            pass.setError(null);
            return true;
        }
    }


    public void OpenHome_Activity()
    {
        Intent loginintent = new Intent(this,HomeActivity.class);
        startActivity(loginintent);
    }

    public void OpenRegister_Activity()
    {
        Intent registerintent = new Intent(this,RegisterActivity.class);
        startActivity(registerintent);
    }
}
