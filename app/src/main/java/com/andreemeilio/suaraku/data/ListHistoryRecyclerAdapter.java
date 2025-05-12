package com.andreemeilio.suaraku.data;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andreemeilio.suaraku.HistoryDetail;
import com.andreemeilio.suaraku.HistoryList;
import com.andreemeilio.suaraku.R;
import com.andreemeilio.suaraku.model.HistoryModel;

import java.sql.Date;
import java.util.ArrayList;

public class ListHistoryRecyclerAdapter extends RecyclerView.Adapter<ListHistoryRecyclerAdapter.ViewHolder> {

    private ArrayList<HistoryModel> listHistory;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_history_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HistoryModel data = listHistory.get(position);

        holder.itemHistoryActionName.setText(data.getActionName());
        holder.itemHistoryJournal.setText(data.getJudulJournal());

        if (data.getActionName().equals("CREATED")){
            holder.itemHistoryTanggal.setText(data.getTanggalCreated().toString());
        } else if (data.getActionName().equals("UPDATED")){
            holder.itemHistoryTanggal.setText(data.getTanggalUpdated().toString());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent detailHistory = new Intent(v.getContext(), HistoryDetail.class);
                detailHistory.putExtra("actionName", data.getActionName());
                detailHistory.putExtra("judulJournal", data.getJudulJournal());
                detailHistory.putExtra("tanggalCreated", data.getTanggalCreated());
                detailHistory.putExtra("tanggalUpdated", data.getTanggalUpdated());
                detailHistory.putExtra("description", data.getDescription());

                v.getContext().startActivity(detailHistory);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.listHistory.size();
    }

    public ListHistoryRecyclerAdapter(ArrayList<HistoryModel> listHistory){
        this.listHistory = listHistory;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemHistoryJournal, itemHistoryActionName, itemHistoryTanggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemHistoryJournal = (TextView) itemView.findViewById(R.id.itemHistoryJournal);
            itemHistoryActionName = (TextView) itemView.findViewById(R.id.itemHistoryActionName);
            itemHistoryTanggal = (TextView) itemView.findViewById(R.id.itemHistoryTanggal);
        }
    }
}
