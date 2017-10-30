package com.example.nuzz.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.nuzz.R;

import com.example.nuzz.model.NewsResponse;
import com.example.nuzz.presenter.NewsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements NewsViewInterface{
    @BindView(R.id.queryEditText)
    EditText queryEditText;
    @BindView(R.id.submitButton)
    Button getNewsButton;
    @BindView(R.id.newsListRecycler)
    RecyclerView newsListRecycler;
    NewsPresenter newsPresenter;
    Context mContext;
    ProgressDialog progressBar;
    int PAGE_SIZE = 20;
    boolean isLoading = false;
    boolean isLastPage = false;
    int currentPage = 0;
    NewsListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ButterKnife.bind(this);
        initView();

        newsPresenter = new NewsPresenter(MainActivity.this);
        getNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(queryEditText.getText().toString().equals("")){
                    Toast.makeText(v.getContext(), "Please enter a query", Toast.LENGTH_LONG).show();
                } else {
                    progressBar.show();
                    adapter = null;
                    newsPresenter.getNews(queryEditText.getText().toString(), currentPage);
                }
            }
        });
    }

    private void initView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0
                            && totalItemCount >= PAGE_SIZE) {
                        loadMoreItems();
                    }
                }
            }
        };
        progressBar = new ProgressDialog(this);
        progressBar.setMessage(getResources().getString(R.string.getting_news));
        newsListRecycler.setLayoutManager(layoutManager);
        newsListRecycler.addOnScrollListener(recyclerViewOnScrollListener);
    }

    private void loadMoreItems() {
        progressBar.show();
        isLoading = true;
        currentPage += 1;
        newsPresenter.getNews(queryEditText.getText().toString(), currentPage);
    }

    @Override
    public void onGetNewsComplete() {
        isLoading = false;
        try{
            progressBar.dismiss();
        }catch (Exception e){

        }
    }

    @Override
    public void onGetNewsError(String message) {
        isLoading = false;
        try{
            progressBar.dismiss();
        }catch (Exception e){

        }
    }

    @Override
    public void onGetNewsSuccess(NewsResponse result) {
        if(result.getNbPages() == currentPage)
            isLastPage = true;
        if(adapter == null) {
            adapter = new NewsListAdapter(result.getHits());
            newsListRecycler.setAdapter(adapter);
        } else {
            adapter.hits.addAll(result.getHits());
            adapter.notifyDataSetChanged();
        }
    }

}
