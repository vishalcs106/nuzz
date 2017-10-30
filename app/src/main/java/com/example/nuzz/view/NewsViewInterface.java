package com.example.nuzz.view;

import com.example.nuzz.model.NewsResponse;

import retrofit2.Response;
import rx.Observable;

/**
 * Created by Vishal on 26-10-2017.
 */

public interface NewsViewInterface {
    void onGetNewsComplete();
    void onGetNewsError(String message);
    void onGetNewsSuccess(NewsResponse result);
}
