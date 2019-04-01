package com.rbmhz.dagger2.views.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rbmhz.dagger2.R;
import com.rbmhz.dagger2.pojo.Resp;

import java.util.ArrayList;

public class recycleView extends RecyclerView.Adapter<recycleView.ViewHolder> {

    ArrayList<Resp.data> data;

    public recycleView(ArrayList<Resp.data> data) {
        this.data = data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.tvId.setText(data.get(i).getId());
        viewHolder.tvName.setText(data.get(i).getUserId());
        viewHolder.tvTitle.setText(data.get(i).getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvName;
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId= itemView.findViewById(R.id.tv_id);
            tvName= itemView.findViewById(R.id.tv_name);
            tvTitle= itemView.findViewById(R.id.tv_title);
        }
    }
}
