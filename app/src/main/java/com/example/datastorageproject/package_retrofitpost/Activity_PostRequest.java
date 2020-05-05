package com.example.datastorageproject.package_retrofitpost;

/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.datastorageproject.R;
import com.example.datastorageproject.package_sqlitedatabase.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_PostRequest extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText;
    private EditText jobEditText;
    private Button saveUserButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.name);
        jobEditText = findViewById(R.id.job);
        saveUserButton = findViewById(R.id.save_user);
        progressBar = findViewById(R.id.progress_bar);

        saveUserButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_user:
                User user = new User(nameEditText.getText().toString(), jobEditText.getText().toString());
                progressBar.setVisibility(View.VISIBLE);
                MainApplication.apiManager.createUser(user, new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        progressBar.setVisibility(View.GONE);
                        User responseUser = response.body();
                        if (response.isSuccessful() && responseUser != null) {
                            Toast.makeText(Activity_PostRequest.this,
                                    String.format("User %s with job %s was created at %s with id %s",
                                            responseUser.getName(),
                                            responseUser.getJob(),
                                            responseUser.getCreatedAt(),
                                            responseUser.getId()),
                                    Toast.LENGTH_LONG)
                                    .show();
                        } else {
                            Toast.makeText(Activity_PostRequest.this,
                                    String.format("Response is %s", String.valueOf(response.code()))
                                    , Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(Activity_PostRequest.this,
                                "Error is " + t.getMessage()
                                , Toast.LENGTH_LONG).show();
                    }
                });

                break;
        }
    }
}*/
