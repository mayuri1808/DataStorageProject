package com.example.datastorageproject.package_sharedpreferences;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.datastorageproject.R;

public class Activity_Login extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);

        b1=(Button)findViewById(R.id.button);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n  = ed1.getText().toString();
                String ph = ed2.getText().toString();
                String e  = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Phone, ph);
                editor.putString(Email, e);
                editor.commit();
                Toast.makeText(Activity_Login.this,"Thanks",Toast.LENGTH_LONG).show();
            }
        });

        loadData();
    }
    public void loadData(){
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String name=sharedpreferences.getString("Name","n");
        String phone=sharedpreferences.getString("Phone","ph");
        String email=sharedpreferences.getString("Email","e");
        ed1.setText(String.valueOf(name));
        ed2.setText(String.valueOf(phone));
        ed3.setText(String.valueOf(email));

    }

}
