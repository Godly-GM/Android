package com.example.database_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    TextView t1;

    private DBMS_Class dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        t1=(TextView) findViewById(R.id.t1);

        b1=(Button) findViewById(R.id.button);

        dbHandler = new DBMS_Class(Login.this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!e1.getText().toString().equals("")&&!e2.getText().toString().equals("")){

                    Cursor res = dbHandler.getdata();

                    if(res.getCount()==0){
                        Toast.makeText(getApplicationContext(), "No entry", Toast.LENGTH_SHORT).show();
                    }

                    String flag = "0";

                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()){

                        if(res.getString(1).equals(e1.getText().toString())){
                            if(res.getString(2).equals(e2.getText().toString())){
                                flag = "pass match,both match";
                            }
                            else{
                                flag = "Password not found";
                            }
                        }
                        else{
                            flag = "Username not found";
                        }
                    }
                    Toast.makeText(getApplicationContext(), flag, Toast.LENGTH_SHORT).show();

                    if(flag.equals("0")){
                        Toast.makeText(getApplicationContext(), "username or password mismatch..", Toast.LENGTH_SHORT).show();
                    }
                    else if(flag.equals("pass match,both match")){
                        Intent i =new Intent(getApplicationContext(),Home_page.class);
                        startActivity(i);
                    }
                }

                else{
                    Toast.makeText(getApplicationContext(), "Fill the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}