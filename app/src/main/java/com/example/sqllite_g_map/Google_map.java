package com.example.sqllite_g_map;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Google_map extends AppCompatActivity {

    EditText lat,lon;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        lat = findViewById(R.id.e1);
        lon = findViewById(R.id.e2);

        b1 = findViewById(R.id.button3);
        b2 = findViewById(R.id.button4);

// opening with lattitude and longittude

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String l1 = lat.getText().toString();
                String l2 = lon.getText().toString();

                String	url="https://www.google.co.in/maps/place/"+l1+"+"+l2+"/@"+l1+","+l2+",19z";
                try{
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                catch (Exception e) {
                    // TODO: handle exception
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });

//        just opening map


        b2.setOnClickListener(v -> {
            String	url="https://www.google.co.in/maps/place/";
            try{
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
            catch (Exception e) {
                // TODO: handle exception
                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}