package com.example.datastorageproject.package_retrofitpost;

import com.example.datastorageproject.package_sqlitedatabase.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUsersApi {

    @POST("/users")
    Call<User> createUser(@Body User user);
}
