package com.example.calculator_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,plus,b0,minus,mul,b10,div,bC,equal;
    float a,b;
    boolean Addition,Subtract,Multiplication,Division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.editTextTextPersonName);
        b1=findViewById(R.id.button20);
        b2=findViewById(R.id.button21);
        b3=findViewById(R.id.button22);
        b4=findViewById(R.id.button23);
        b5=findViewById(R.id.button24);
        b6=findViewById(R.id.button25);
        b7=findViewById(R.id.button26);
        b8=findViewById(R.id.button27);
        b9=findViewById(R.id.button28);
        plus=findViewById(R.id.button29);
        b0=findViewById(R.id.button30);
        minus=findViewById(R.id.button31);
        mul=findViewById(R.id.button32);
        b10=findViewById(R.id.button33);
        div=findViewById(R.id.button34);
        bC=findViewById(R.id.button35);
        equal=findViewById(R.id.button36);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText(e1.getText() + "1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "9");
            }
        });



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (e1== null) {
                    e1.setText("");
                } else {
                    a = Float.parseFloat(e1.getText() + "");
                    Addition = true;
                    e1.setText(null);
                }
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "0");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(e1.getText() + "");
                Subtract = true;
                e1.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(e1.getText() + "");
                Multiplication = true;
                e1.setText(null);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + ".");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a = Float.parseFloat(e1.getText() + "");
                Division = true;
                e1.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = Float.parseFloat(e1.getText() + "");

                if (Addition == true) {
                    e1.setText(a + b + "");
                    Addition = false;
                }

                if (Subtract == true) {
                    e1.setText(a - b + "");
                    Subtract = false;
                }

                if (Multiplication == true) {
                    e1.setText(a * b + "");
                    Multiplication = false;
                }

                if (Division == true) {
                    e1.setText(a / b + "");
                    Division = false;
                }
            }
        });

        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
            }
        });



    }
}