package com.andreemeilio.suaraku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
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

    public static ArrayList<JournalModel> listJournal = new ArrayList<>();
    public static ListJournalRecyclerAdapter adapterJournal;

    Button createNewJournal;
    ImageButton historyButton;

    private ActivityResultLauncher<Intent> inputJournalLauncher;

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

        adapterJournal = new ListJournalRecyclerAdapter(listJournal);

        RecyclerView listJournalRecyclerView = findViewById(R.id.listJournalRV);
        listJournalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listJournalRecyclerView.setAdapter(adapterJournal);

        inputJournalLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();

                        if (data != null){
                            Date tanggalJournal = Date.valueOf(data.getStringExtra("tanggalJournal"));
                            String judulJournal = data.getStringExtra("judulJournal");
                            String isiJournal = data.getStringExtra("isiJournal");
                            String bahagiaJournal = data.getStringExtra("bahagiaJournal");
                            String sedihJournal = data.getStringExtra("sedihJournal");
                            String nextToDoJournal = data.getStringExtra("nextToDoJournal");

                            JournalModel modelData = new JournalModel(
                                    tanggalJournal,
                                    judulJournal,
                                    isiJournal,
                                    bahagiaJournal,
                                    sedihJournal,
                                    nextToDoJournal
                            );

                            listJournal.add(modelData);
                            adapterJournal.notifyItemInserted(listJournal.size() - 1);
                        }
                    }
                }
        );

        createNewJournal = findViewById(R.id.createNewJournal);
        createNewJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inputJournalIntent = new Intent(MainActivity.this, input_journal.class);
                inputJournalLauncher.launch(inputJournalIntent);
            }
        });

        historyButton = (ImageButton) findViewById(R.id.historyImageButton);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyList = new Intent(MainActivity.this, HistoryList.class);
                startActivity(historyList);
            }
        });
    }
}