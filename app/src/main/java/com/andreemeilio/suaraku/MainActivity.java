package com.andreemeilio.suaraku;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andreemeilio.suaraku.data.ListJournalRecyclerAdapter;
import com.andreemeilio.suaraku.model.JournalModel;

import java.sql.Date;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<JournalModel> listJournalDummy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listJournalDummy = new ArrayList<>();

//        dummy data
        JournalModel dummy1 = new JournalModel(
                Date.valueOf("2025-05-12"),
                "Mencari Kebahagiaan",
                "Saya sedang mencoba mencari kebahagiaan",
                "Mencoba menolong orang lain dengan sekuat tenaga",
                "Saya gagal menolong orang lain",
                "Lebih bijak dalam menolong orang lain"
        );
        JournalModel dummy2 = new JournalModel(
                Date.valueOf("2025-05-12"),
                "Mencari Kebahagiaan",
                "Saya sedang mencoba mencari kebahagiaan",
                "Mencoba menolong orang lain dengan sekuat tenaga",
                "Saya gagal menolong orang lain",
                "Lebih bijak dalam menolong orang lain"
        );
        listJournalDummy.add(dummy1);
        listJournalDummy.add(dummy2);

        RecyclerView listJournalRecyclerView = findViewById(R.id.listJournalRV);
        listJournalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listJournalRecyclerView.setAdapter(new ListJournalRecyclerAdapter(listJournalDummy));
    }
}