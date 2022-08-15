package com.example.sqllite_g_map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//check out video for create SQLiteOpenHelper,implemented methods,constructors


public class DB_Class extends SQLiteOpenHelper {
    public DB_Class( Context context) {
        super(context, "My_DB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table User(id INT primary key,name TEXT,phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
        DB.execSQL("drop Table if exists 'User'");
    }

//    insert data

    public Boolean insert_query(String id, String name, String phone)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("phone",phone);

        long result = DB.insert("User",null,contentValues);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }

    }


//    update data

    public Boolean update_query(String name, String id, String phone) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("phone",phone);

        Cursor cursor = DB.rawQuery("Select * from User where id = ?", new String[]{id});
        if (cursor.getCount() > 0) {

            long result = DB.update("User", contentValues, "id=?", new String[]{id});

            if (result == -1) {
                return false;
            }
            else {
                return true;
            }

        }
        else {
            return false;
        }
    }

    //    dalete data
    public Boolean deletedata (String id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from User where id = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = DB.delete("User", "id=?", new String[]{id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    //    display data

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from User", null);
        return cursor;

    }

}
