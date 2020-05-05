package com.example.datastorageproject.package_carapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.datastorageproject.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private DataAdapter dataAdapter;
    private ArrayList<CarModel> carModels=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mProgressBar=(ProgressBar)findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView=(RecyclerView)findViewById(R.id.cars_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getJson();
    }

    private void getJson() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://navneet7k.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<List<CarModel>> call1=request.getJson();
        call1.enqueue(new Callback<List<CarModel>>() {
            @Override
            public void onResponse(Call<List<CarModel>> call, Response<List<CarModel>> response) {
                mProgressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body()!=null) {
                    carModels = new ArrayList<>(response.body());
                    dataAdapter=new DataAdapter(carModels,MainActivity.this);
                    mRecyclerView.setAdapter(dataAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<CarModel>> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,"Oops! Something went wrong!",Toast.LENGTH_SHORT).show();
            }

        });
    }

}
