package com.andreemeilio.suaraku.data;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andreemeilio.suaraku.R;
import com.andreemeilio.suaraku.model.JournalModel;

import java.util.ArrayList;

public class ListJournalRecyclerAdapter extends RecyclerView.Adapter<ListJournalRecyclerAdapter.ViewHolder> {

    private ArrayList<JournalModel> listJournal;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_journal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JournalModel item = this.listJournal.get(position);

        holder.itemJudulJournal.setText(item.getJudul());
        holder.itemTanggalJournal.setText(item.getTanggal().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Anda Click" + item.getJudul(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listJournal.size();
    }

    public ListJournalRecyclerAdapter(ArrayList<JournalModel> listItem){
        this.listJournal = listItem;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemJudulJournal, itemTanggalJournal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemJudulJournal = (TextView) itemView.findViewById(R.id.itemJudulJournal);
            itemTanggalJournal = (TextView) itemView.findViewById(R.id.itemTanggalJournal);
        }
    }

}
