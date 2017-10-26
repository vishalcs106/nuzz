package com.example.nuzz.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nuzz.App;
import com.example.nuzz.R;
import com.example.nuzz.model.NewsApi;
import com.example.nuzz.model.NewsResponse;
import com.example.nuzz.presenter.NewsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements NewsViewInterface{
    @BindView(R.id.queryEditText)
    EditText queryEditText;
    @BindView(R.id.submitButton)
    Button getNewsButton;
    @BindView(R.id.newsListRecycler)
    RecyclerView newsListRecycler;
    NewsPresenter newsPresenter;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ButterKnife.bind(this);
        newsListRecycler.setLayoutManager(new LinearLayoutManager(this));
        newsPresenter = new NewsPresenter(MainActivity.this);
        getNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(queryEditText.getText().toString().equals("")){
                    Toast.makeText(v.getContext(), "Please enter a query", Toast.LENGTH_LONG).show();
                } else {
                    newsPresenter.getNews(queryEditText.getText().toString());
                }
            }
        });
    }

    @Override
    public void onGetNewsComplete() {
        System.out.print("");
    }

    @Override
    public void onGetNewsError(String message) {
        System.out.print("");
    }

    @Override
    public void onGetNewsSuccess(NewsResponse result) {
        System.out.print("");
        NewsListAdapter adapter = new NewsListAdapter(result.getHits());
        newsListRecycler.setAdapter(adapter);
    }

    @Override
    public Observable<NewsResponse> getNews(String query) {
        return ((App) getApplication()).mRetrofit.create(NewsApi.class).getNews(query);
    }
}
