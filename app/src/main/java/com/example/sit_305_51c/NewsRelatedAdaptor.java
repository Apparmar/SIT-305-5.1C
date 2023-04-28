package com.example.sit_305_51c;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsRelatedAdaptor extends RecyclerView.Adapter<NewsRelatedAdaptor.viewHolder> {

    List <News> newsList;
    Context context;

    public NewsRelatedAdaptor(List <News> newsList, Context context)
    {
        this.newsList = newsList;
        this.context = context;

    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.newsrelated,parent,false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        News news = newsList.get(position);
        holder.newsHeader.setText(news.GetHeading());
        holder.newsDetail.setText(news.GetNewsDetail());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView newsHeader, newsDetail;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            newsHeader = itemView.findViewById(R.id.relNewsHead);
            newsDetail = itemView.findViewById(R.id.relNewsDet);
        }
    }
}
