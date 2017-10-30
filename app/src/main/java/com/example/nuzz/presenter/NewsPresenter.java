package com.example.nuzz.presenter;

import com.example.nuzz.App;
import com.example.nuzz.model.NewsApi;
import com.example.nuzz.model.NewsResponse;
import com.example.nuzz.view.MainActivity;
import com.example.nuzz.view.NewsViewInterface;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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
        viewInterface.onGetNewsComplete();
    }

    @Override
    public void onError(Throwable e) {
        viewInterface.onGetNewsError(e.getMessage());
    }

    @Override
    public void onNext(NewsResponse newsResponse) {
        viewInterface.onGetNewsSuccess(newsResponse);
    }

    public void getNews(String query){
        unSubscribeAll();
        Subscription subscription = App.getInstance().mRetrofit.create(NewsApi.class).getNews(query)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(NewsPresenter.this);
        configureSubscription().add(subscription);
    }
}
