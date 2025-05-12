package com.andreemeilio.suaraku;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andreemeilio.suaraku.data.ListHistoryRecyclerAdapter;
import com.andreemeilio.suaraku.model.HistoryModel;

import java.sql.Date;
import java.util.ArrayList;

public class HistoryList extends AppCompatActivity {

    public static ArrayList<HistoryModel> listDataHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView listHistoryView = findViewById(R.id.listHistoryRV);
        listHistoryView.setLayoutManager(new LinearLayoutManager(this));
        listHistoryView.setAdapter(new ListHistoryRecyclerAdapter(listDataHistory));
    }
}