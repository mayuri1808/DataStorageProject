package com.example.datastorageproject.package_internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datastorageproject.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DataWriteInFile extends AppCompatActivity {
EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_write_in_file);
        editText=findViewById(R.id.edittext);

    }

    public void save(View view) {

        try {
            String data = editText.getText().toString();//to get data from edit text
            FileOutputStream fileOutputStream = openFileOutput("abcd.txt", MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(data);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            Toast.makeText(DataWriteInFile.this, "Data save Succesfully", Toast.LENGTH_LONG).show();
            editText.setText("");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void load(View view) {
        try {
            FileInputStream fileInputStream = openFileInput("abcd.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            char[] a=new char[100];
            String s="";
            int charRead;
            while ((charRead=inputStreamReader.read(a))>0){
                String readString=String.copyValueOf(a,0,charRead);
                s+=readString;
                a=new char[100];


            }
            editText.setText(s);
            Toast.makeText(DataWriteInFile.this, "Data Loaded Succesfully", Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
