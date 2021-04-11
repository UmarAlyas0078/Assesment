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
import com.codesorbit.assesment.models.SubServicesItem;

import java.util.List;

public class SubItemAdapter extends RecyclerView.Adapter<SubItemAdapter.ViewHolder> {
    Context context;
    private List<SubServicesItem> subItemList;

    SubItemAdapter(List<SubServicesItem> subItemList, Context context) {
        this.subItemList = subItemList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_sub_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubServicesItem subServicesItem = subItemList.get(position);
        if (subServicesItem.getTypeOfData().equals("IMAGE")) {
            holder.tvSubItemTitle.setText(subServicesItem.getSubItemTitle());
            Glide.with(context).asBitmap().load(subServicesItem.getSubItemImage()).into(holder.imgsubitem);
        } else {
            holder.tvSubItemTitle.setText(subServicesItem.getSubItemTitle());
            holder.imgsubitem.getLayoutParams().height = 100;
            holder.imgsubitem.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return subItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSubItemTitle;
        ImageView imgsubitem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSubItemTitle = itemView.findViewById(R.id.tv_sub_item_title);
            imgsubitem = itemView.findViewById(R.id.img_sub_item);
        }
    }
}
