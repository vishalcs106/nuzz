package com.example.nuzz.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.nuzz.R;

public class NewsViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_view);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String url = intent.getStringExtra("newsUrl");
        if(url != null) {
            if (!url.equals(""))
                webView.loadUrl(url);
            else {
                Toast.makeText(this, "Invalid Url", Toast.LENGTH_LONG).show();
                finish();
            }
        }else {
            Toast.makeText(this, "Invalid Url", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
