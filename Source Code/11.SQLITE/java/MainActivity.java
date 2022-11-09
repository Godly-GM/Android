package com.example.database_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;

    private DBMS_Class dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);

        b1=(Button) findViewById(R.id.button);

        dbHandler = new DBMS_Class(MainActivity.this);dbHandler = new DBMS_Class(MainActivity.this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbHandler.save_login(e1.getText().toString(), e2.getText().toString());
                Toast.makeText(MainActivity.this, "login Details Stored.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}