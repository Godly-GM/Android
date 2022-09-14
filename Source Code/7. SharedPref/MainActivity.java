package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);

    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(getApplicationContext(), "ON Pause..", Toast.LENGTH_SHORT).show();

        SharedPreferences sh = getSharedPreferences("Sha1",MODE_PRIVATE);
        SharedPreferences.Editor edit = sh.edit();

        edit.putString("nm",e1.getText().toString());
        edit.putString("ph",e2.getText().toString());
        edit.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplicationContext(), "ON RESUME..", Toast.LENGTH_SHORT).show();

        SharedPreferences sh = getSharedPreferences("Sha1",MODE_PRIVATE);

        String n = sh.getString("nm","");
        String p = sh.getString("ph","");

        e1.setText(n);
        e2.setText(p);
    }
}