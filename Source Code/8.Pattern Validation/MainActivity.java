package com.example.form_validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText nm,ag,ph,pwd;
    Button b1;

    Pattern username_pattern=Pattern.compile("^[A-Za-z]\\w{5,30}$");
    Pattern password_pattern=Pattern.compile("^" +
            "(?=.*[@#$%^&+=])" +
            "(?=\\S+$)" +
            ".{4,}" +
            "$");
    Pattern age_pattern=Pattern.compile("^" +
            "(?=\\S+$)" +
            "[0-9]{1,2}" +
            "$");
    Pattern phone_pattern=Pattern.compile("^(0|91)?[7-9][0-9]{9}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        nm=(EditText) findViewById(R.id.e1);
        pwd=(EditText) findViewById(R.id.e2);
        ph=(EditText) findViewById(R.id.e3);
        ag=(EditText) findViewById(R.id.e4);

        b1=(Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(getApplicationContext(), "Validating...", Toast.LENGTH_SHORT).show();

                String name=nm.getText().toString();
                String age=ag.getText().toString();
                String phone=ph.getText().toString();
                String password=pwd.getText().toString();

                if(name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Name is Empty...", Toast.LENGTH_SHORT).show();
                }
                if(age.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Age is Empty...", Toast.LENGTH_SHORT).show();
                }
                if(phone.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Phone is Empty...", Toast.LENGTH_SHORT).show();
                }
                if(password.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Password is Empty...", Toast.LENGTH_SHORT).show();
                }


                if(!username_pattern.matcher(name).matches()){
                    nm.setError("Enter alphabets 6-30 characters");
                }
                if(!password_pattern.matcher(password).matches()){
                    pwd.setError("Weak Password");
                }
                if(!age_pattern.matcher(age).matches()){
                    ag.setError("Invalid Age");
                }
                if(!phone_pattern.matcher(phone).matches()){
                    ph.setError("Enter 10 digit");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Validation Complete...", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}