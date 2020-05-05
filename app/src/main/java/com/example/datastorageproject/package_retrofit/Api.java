package com.example.datastorageproject.package_retrofit;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * To make an API call using retrofit we need a java interface
 * where we define all the URLs with the http request type and parameters.
 * In this example we need to perform an http GET with no extra parameters.
 */

public interface Api {

    // we have a BASE_URL. It contains the ROOT URL of our API.
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    //we have an annotation @GET(“marvel”). It means that we are defining an http GET request.
    // And the String passed inside the get is the api name.
    @GET("marvel")

    //we have a method named getHeroes() whose return type is Call.
    // And the type of the Call is a List<>. And type of the List is Hero.
    Call<List<Hero>> getHeroes();
}