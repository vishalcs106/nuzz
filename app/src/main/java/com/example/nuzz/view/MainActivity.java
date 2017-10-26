package com.example.nuzz.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nuzz.App;
import com.example.nuzz.R;
import com.example.nuzz.model.NewsApi;
import com.example.nuzz.model.NewsResponse;
import com.example.nuzz.presenter.NewsPresenter;

import butterknife.BindView;
import retrofit2.Response;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements NewsViewInterface{
    @BindView(R.id.queryEditText)
    EditText queryEditText;
    @BindView(R.id.submitButton)
    Button getNewsButton;
    NewsPresenter newsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsPresenter = new NewsPresenter(MainActivity.this);
        getNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsPresenter.getNews(queryEditText.getText().toString());
            }
        });
    }

    @Override
    public void onGetNewsComplete() {

    }

    @Override
    public void onGetNewsError(String message) {

    }

    @Override
    public void onGetNewsSuccess(Response<NewsResponse> result) {

    }

    @Override
    public Observable<NewsResponse> getNews(String query) {
        return (Observable<NewsResponse>) ((App)getApplicationContext()).mRetrofit.create(NewsApi.class);
    }
}
