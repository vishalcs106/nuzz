package com.example.nuzz.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nuzz.Constants;
import com.example.nuzz.R;
import com.example.nuzz.model.NewsResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vishal on 26-10-2017.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder>{
    ArrayList<NewsResponse.Hit> hits = new ArrayList<>();

    public NewsListAdapter(List<NewsResponse.Hit> hits) {
        this.hits = (ArrayList<NewsResponse.Hit>) hits;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_news_row, parent, false);

        return new NewsListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final NewsResponse.Hit hit = hits.get(position);
        holder.titleTextView.setText(hit.getTitle()+"");
        holder.titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewsViewActivity.class);
                intent.putExtra(Constants.KEY_NEWS_URL, hit.getUrl());
                (v.getContext()).startActivity(intent);
            }
        });
        holder.pointsTextView.setText("  "+hit.getPoints());
        holder.authorTextView.setText(hit.getAuthor());

    }

    @Override
    public int getItemCount() {
        return hits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView, authorTextView, pointsTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            authorTextView = itemView.findViewById(R.id.authorTextView);
            pointsTextView = itemView.findViewById(R.id.pointsTextView);
        }
    }
}
