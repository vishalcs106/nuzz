package com.example.nuzz.presenter;

import com.example.nuzz.model.NewsResponse;
import com.example.nuzz.view.MainActivity;
import com.example.nuzz.view.NewsViewInterface;

import rx.Observer;

/**
 * Created by Vishal on 26-10-2017.
 */

public class NewsPresenter extends BasePresenter implements Observer<NewsResponse>{
    NewsViewInterface viewInterface;
    public NewsPresenter(NewsViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(NewsResponse newsResponse) {

    }

    public void getNews(String query){
        unSubscribeAll();
        subscribe(viewInterface.getNews(query), NewsPresenter.this);
    }
}
