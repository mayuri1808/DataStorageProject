package com.example.datastorageproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To Read Data from raw file in app
        InputStream inputstream;
        inputstream = getResources ().openRawResource(R.raw.myfile);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));

            String str =null;
            while ((str = bufferedReader.readLine()) != null) {
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
            }
            inputstream.close();
            bufferedReader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    }

