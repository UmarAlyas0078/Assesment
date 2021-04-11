package com.codesorbit.assesment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codesorbit.assesment.R;
import com.codesorbit.assesment.models.NewsModel;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    Context context;
    ArrayList<NewsModel> newsModelsList;

    public NewsAdapter(Context context, ArrayList<NewsModel> newsModels) {
        this.context = context;
        this.newsModelsList = newsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsModel newsModel = newsModelsList.get(position);
        holder.tvdescription.setText(newsModel.getmDescription());
        Glide.with(context).asBitmap().load(newsModel.getmImageId())
                .into(holder.imgNews);
    }

    @Override
    public int getItemCount() {
        return newsModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgNews;
        TextView tvdescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNews = itemView.findViewById(R.id.img_news);
            tvdescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
