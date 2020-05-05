package com.example.datastorageproject.package_carapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface RequestInterface {
    @GET("sample_array.json")
    Call<List<CarModel>> getJson();
}
