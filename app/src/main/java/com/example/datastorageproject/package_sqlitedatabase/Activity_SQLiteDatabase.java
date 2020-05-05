package com.example.datastorageproject.package_sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.datastorageproject.R;

public class Activity_SQLiteDatabase extends AppCompatActivity {
Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__sqlite_database);

        DbHelper dbHelper=new DbHelper(getApplicationContext(),"MyDatabase",null,1);
        Temp.setDbHelper(dbHelper);//It is to whenever u want to use dbhelper obj then we can get it by Temp getter method

        b1=findViewById(R.id.adduser);
        b2=findViewById(R.id.deleteuser);
        b3=findViewById(R.id.viewuser);
        b4=findViewById(R.id.updateuser);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_SQLiteDatabase.this,Activity_Insert.class);
                startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_SQLiteDatabase.this,Activity_DeleteUser.class);
                startActivity(intent);


            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }
}
