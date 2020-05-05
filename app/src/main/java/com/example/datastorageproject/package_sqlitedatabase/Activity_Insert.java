package com.example.datastorageproject.package_sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datastorageproject.R;

public class Activity_Insert extends AppCompatActivity {
EditText t1,t2,t3,t4;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__insert);
        t1=findViewById(R.id.userid);
        t2=findViewById(R.id.username);
        t3=findViewById(R.id.userphone);
        t4=findViewById(R.id.useremail);
         dbHelper=Temp.getDbHelper();
    }

    public void insert(View view) {
        String id=t1.getText().toString();
        String name=t2.getText().toString();
        String phone=t3.getText().toString();
        String email=t4.getText().toString();
        if(id.equals("")||name.equals("")||phone.equals("")||email.equals("")){
            Toast.makeText(Activity_Insert.this,"Please fill all the fields",Toast.LENGTH_LONG).show();
        }
        else{
            User user=new User();
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
           int i= dbHelper.insertUser(user);
           if(i==1){
               Toast.makeText(getApplicationContext(),"User Data inserted Successfully",Toast.LENGTH_LONG).show();

           }
           else{
               Toast.makeText(getApplicationContext(),"User Data not inserted Successfully",Toast.LENGTH_LONG).show();
           }

        }
    }
}
