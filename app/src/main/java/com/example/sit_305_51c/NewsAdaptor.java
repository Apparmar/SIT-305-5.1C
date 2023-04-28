package com.example.sit_305_51c;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdaptor extends RecyclerView.Adapter<NewsAdaptor.viewHolder> {

    List <News> newsList;
    Context context;
    ItemClickListener clickListener;
    public NewsAdaptor(List <News> newsList, Context context,ItemClickListener clickListener)
    {
        this.newsList = newsList;
        this.context = context;
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.newsdetail,parent,false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        News news = newsList.get(position);
        holder.newsHeaderDet.setText(news.GetHeading());
        holder.newsDetail.setText(news.GetNewsDetail());

        holder.newsHeaderDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(newsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView newsHeaderDet, newsDetail;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            newsHeaderDet = itemView.findViewById(R.id.relNewsHead);
            newsDetail = itemView.findViewById(R.id.relNewsDet);
        }
    }

    public interface ItemClickListener{
        public void onItemClick(News news);
    }
}
