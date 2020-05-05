package com.example.datastorageproject.package_sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static String key_id="id";
    public static String key_name="name";
    public static String key_phoe="phone";
    public static String key_email="email";
    public static String key_table="user_table";

    public DbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_user="CREATE TABLE "+key_table+"("+key_id+" INTEGER PRIMARY KEY,"+key_name+" TEXT,"+key_email+
                "TEXT,"+key_phoe+"TEXT"+")";
        db.execSQL(create_user);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int insertUser(User user){
        int i=0;
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(key_id,user.getId());
        contentValues.put(key_name,user.getName());
        contentValues.put(key_email,user.getEmail());
        contentValues.put(key_phoe,user.getPhone());
        sqLiteDatabase.insert(key_table,null,contentValues);
         i=1;
        return 1;
    }

    public int inserttUser(String id){
        int i=0;
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete(key_table,key_id+"=?",new String[]{id});
        sqLiteDatabase.close();
        i=1;
        return i;
    }
}

