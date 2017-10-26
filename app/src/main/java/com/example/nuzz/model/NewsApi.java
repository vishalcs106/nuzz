package com.example.nuzz.model;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Observer;

/**
 * Created by Vishal on 26-10-2017.
 */

public interface NewsApi {
    @GET("/api/v1/search")
    Observable<NewsResponse> getNews(@Query("query") String query);
}
