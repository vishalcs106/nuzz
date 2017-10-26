package com.example.nuzz;

import android.app.Application;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vishal on 26-10-2017.
 */

public class App extends Application {
    private static App mInstance;
    public Retrofit mRetrofit;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(new OkHttpClient.Builder()
                        .readTimeout(20, TimeUnit.SECONDS)
                        .connectTimeout(20, TimeUnit.SECONDS)
                        .build())
                .baseUrl(Constants.BASE_URL).build();
    }
    public static synchronized App getInstance() {
        return mInstance;
    }
}
