package com.example.nuzz.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Vishal on 31-10-2017.
 */

public class SearchQuery extends BaseObservable {
    String query;
    public SearchQuery(String query){
        this.query = query;
    }
    @Bindable
    public String getQuery(){
        return query;
    }

    public void setQuery(String query){
        this.query = query;
    }
}
