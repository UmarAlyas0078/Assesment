package com.codesorbit.assesment.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codesorbit.assesment.R;
import com.codesorbit.assesment.models.PostResponse;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    List<PostResponse> responseArrayList;

    public PostAdapter(List<PostResponse> responseArrayList) {
        this.responseArrayList = responseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostResponse postResponse = responseArrayList.get(position);
        holder.lblid.setText(postResponse.getId().toString());
        holder.lblpostid.setText(postResponse.getUserId().toString());
        holder.lbluserbody.setText(postResponse.getBody());
        holder.lblusertitle.setText(postResponse.getTitle());
    }

    @Override
    public int getItemCount() {
        return responseArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView lblpostid, lblid, lblusertitle, lbluserbody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lblid = itemView.findViewById(R.id.lbl_id);
            lblpostid = itemView.findViewById(R.id.lbl_post_id);
            lbluserbody = itemView.findViewById(R.id.lbl_user_body);
            lblusertitle = itemView.findViewById(R.id.lbl_user_title);
        }
    }
}
