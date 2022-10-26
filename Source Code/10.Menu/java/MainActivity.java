package com.example.menu_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(MainActivity.this, "Item_1 Selected", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                return true;
            case R.id.item2:
                Toast.makeText(MainActivity.this, "Item_2 Selected", Toast.LENGTH_SHORT).show();
                Intent i2=new Intent(getApplicationContext(),Second_page.class);
                startActivity(i2);
                return true;
            case R.id.item3:
                Toast.makeText(MainActivity.this, "Item_3 Selected", Toast.LENGTH_SHORT).show();
                Intent i3=new Intent(getApplicationContext(),Third_Page.class);
                startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
