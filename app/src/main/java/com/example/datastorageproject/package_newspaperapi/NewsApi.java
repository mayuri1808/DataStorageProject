package com.example.datastorageproject.package_newspaperapi;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewsApi {
    String BASE_URL="http://newsapi.org/v2/";
    //@GET("everything?")
   // Call<List<NewsPaper>> getNewsPaper();
    @GET
    Call<List<NewsPaper>> getNewsPaper(@Url String url);
}
