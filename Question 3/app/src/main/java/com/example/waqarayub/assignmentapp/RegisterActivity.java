package com.example.waqarayub.assignmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    //Defining the Pattern for Password field
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

    Button registerButton ;
    EditText emailfield,passfield,namefield,nameLfield;
    String str1,str2,str3,str4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Creating Relavant objects by ID
        registerButton = findViewById(R.id.button);
        emailfield= (EditText) findViewById(R.id.editText13);
        passfield = (EditText) findViewById(R.id.passText1);
        namefield = (EditText) findViewById(R.id.editText7);
        nameLfield = (EditText) findViewById(R.id.editText8);


        // Action listener of Registor Button
                registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //str2=passfield.getText().toString();
                //str1=emailfield.getText().toString();
//                getIntent().putExtra( "Value",str1);
//                getIntent().putExtra( "PassValue",str2);
//                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
//                intent.putExtra("MyName",str1);
//                intent.putExtra("MyPass",str2);
                if(validateEmail() && validatePassword() && validateUsername() && validateLUsername())
                    OpenHome_Activity();

            }
        });

    }
    // Function Definations
    private boolean validateEmail() {
        str1=emailfield.getText().toString();

        if (str1.isEmpty()) {
            emailfield.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(str1).matches()) { // Predefine Pattern for Email
            emailfield.setError("Please enter a valid email address");
            return false;
        } else {
            emailfield.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        str2=passfield.getText().toString();
        if (str2.isEmpty()) {
            passfield.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(str2).matches()) {
            passfield.setError("Password too weak");
            return false;
        } else {
            passfield.setError(null);
            return true;
        }
    }


    private boolean validateUsername() {
        str3 = namefield.getText().toString().trim();

        if (str3.isEmpty()) {
            namefield.setError("Field can't be empty");
            return false;
        } else if (namefield.length() > 15) {
            namefield.setError("Username too long");
            return false;
        } else {
            namefield.setError(null);
            return true;
        }
    }

    private boolean validateLUsername() {
        str4 = namefield.getText().toString().trim();

        if (str4.isEmpty()) {
            nameLfield.setError("Field can't be empty");
            return false;
        } else if (namefield.length() > 15) {
            nameLfield.setError("Username too long");
            return false;
        } else {
            nameLfield.setError(null);
            return true;
        }
    }

    public void OpenHome_Activity()
    {
        Intent loginintent = new Intent(this,HomeActivity.class);
        startActivity(loginintent);
    }
}
