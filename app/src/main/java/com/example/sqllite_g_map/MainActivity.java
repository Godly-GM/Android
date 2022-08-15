package com.example.sqllite_g_map;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText id, nm, phn;
    Button insert, update, delete, view;

    DB_Class DB;

    String user_id,name,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.id);
        nm = findViewById(R.id.nm);
        phn = findViewById(R.id.phn);

        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);

        DB = new DB_Class(this);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user_id = id.getText().toString();
                name = nm.getText().toString();
                phone = phn.getText().toString();

               Boolean inserting_data = DB.insert_query(user_id,name,phone);

               if(inserting_data == true){
                   Toast.makeText(getApplicationContext(),"Date inserted",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
               }

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_id = id.getText().toString();
                name = nm.getText().toString();
                phone = phn.getText().toString();

                Boolean inserting_data = DB.update_query(user_id,name,phone);

                if(inserting_data == true){
                    Toast.makeText(getApplicationContext(),"Date updated",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i = id.getText().toString();

                Boolean checkudeletedata = DB.deletedata(i);

                if(checkudeletedata==true)
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID :"+res.getString(0)+"\n");
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("Phone :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

    }
}