package com.example.datastorageproject.package_retrofitpost;

import android.app.Application;

public class MainApplication extends Application {
    ApiManager apiManager;
    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = ApiManager.getInstance();
    }
}
