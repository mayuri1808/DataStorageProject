package com.example.datastorageproject.package_sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datastorageproject.R;

public class Activity_DeleteUser extends AppCompatActivity {
EditText editText;
Button button;
DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__delete_user);
        editText=findViewById(R.id.edittextid);
        button=findViewById(R.id.deletebutton);



    }


    public void delete(View view) {
        String id=editText.getText().toString();
        if(id.equals("")){
            Toast.makeText(this,"Please Enter the Id",Toast.LENGTH_LONG).show();
        }
        else{
            dbHelper=Temp.getDbHelper();
            int i=dbHelper.inserttUser(id);
            if(i==1){
                Toast.makeText(this,"User Info Deleted",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Something wents wrong",Toast.LENGTH_LONG).show();
            }
        }
    }
}
