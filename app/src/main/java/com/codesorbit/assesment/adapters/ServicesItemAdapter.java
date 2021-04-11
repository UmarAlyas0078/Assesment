package com.codesorbit.assesment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codesorbit.assesment.R;
import com.codesorbit.assesment.models.ServicesItem;

import java.util.List;

public class ServicesItemAdapter extends RecyclerView.Adapter<ServicesItemAdapter.ViewHolder> {
    private final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private final List<ServicesItem> servicesItemArrayList;
    Context context;

    public ServicesItemAdapter(List<ServicesItem> servicesItemArrayList, Context context) {
        this.servicesItemArrayList = servicesItemArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ServicesItem servicesItem = servicesItemArrayList.get(position);
        SubItemAdapter subItemAdapter = new SubItemAdapter(servicesItem.getSubItemList(), context);
        holder.rvSubItem.setAdapter(subItemAdapter);
        holder.rvSubItem.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return servicesItemArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView rvSubItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rvSubItem = itemView.findViewById(R.id.rv_sub_item);
        }
    }
}
