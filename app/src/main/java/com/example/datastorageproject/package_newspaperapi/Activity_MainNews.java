package com.example.datastorageproject.package_newspaperapi;

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

public class Activity_MainNews extends AppCompatActivity {

    //DataAdapter dataAdapter;
    // ArrayList<NewsPaper> newsPaperArrayList=new ArrayList<>();
    RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main_news);

        mProgressBar = findViewById(R.id.progress_barr);
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView = findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//To show list Vertical
        getNewsPaper();
    }

    private void getNewsPaper() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsApi newsApi = retrofit.create(NewsApi.class);
        Call<List<NewsPaper>> call1=newsApi.getNewsPaper("http://newsapi.org/v2/everything?q=bitcoin&from=2020-03-13&sortBy=publishedAt&apiKey=300e401e143940bc91c1d344186b36ea");
       // Call<List<NewsPaper>> call1 = newsApi.getNewsPaper();
        call1.enqueue(new Callback<List<NewsPaper>>() {
            @Override
            public void onResponse(Call<List<NewsPaper>> call, Response<List<NewsPaper>> response) {
                mProgressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<NewsPaper> newsPaperArrayList = new ArrayList<>(response.body());
                    newsPaperArrayList.addAll(response.body());
                    DataAdapter dataAdapter = new DataAdapter(newsPaperArrayList, Activity_MainNews.this);
                    mRecyclerView.setAdapter(dataAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<NewsPaper>> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                Toast.makeText(Activity_MainNews.this, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
