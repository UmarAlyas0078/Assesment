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
import com.codesorbit.assesment.models.HistoryModel;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    Context context;
    ArrayList<HistoryModel> historyModelArrayList;

    public HistoryAdapter(Context context, ArrayList<HistoryModel> historyModelArrayList) {
        this.context = context;
        this.historyModelArrayList = historyModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryModel historyModel = historyModelArrayList.get(position);
        holder.lblhistory.setText(historyModel.getmHistory());
        Glide.with(context).asBitmap().load(historyModel.getmImageId())
                .into(holder.imghistory);
    }

    @Override
    public int getItemCount() {
        return historyModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imghistory;
        TextView lblhistory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghistory = itemView.findViewById(R.id.img_history);
            lblhistory = itemView.findViewById(R.id.lbl_history);
        }
    }
}
