package com.andreemeilio.suaraku;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HistoryDetail extends AppCompatActivity {

    TextView actionName,
            judulJournal,
            tanggalCreated,
            tanggalUpdated,
            description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        actionName = (TextView) findViewById(R.id.historyActionNameValue);
        judulJournal = (TextView) findViewById(R.id.historyJudulValue);
        tanggalCreated = (TextView) findViewById(R.id.historyTanggalCreatedValue);
        description = (TextView) findViewById(R.id.historyDescriptionValue);

        if (getIntent().getStringExtra("actionName") != null){
            actionName.setText(getIntent().getStringExtra("actionName"));
        } else {
            actionName.setText("-");
        }

        if (getIntent().getStringExtra("judulJournal") != null){
            judulJournal.setText(getIntent().getStringExtra("judulJournal"));
        } else {
            judulJournal.setText("-");
        }

        if (getIntent().getStringExtra("tanggalCreated") != null){
            tanggalCreated.setText(getIntent().getStringExtra("tanggalCreated"));
        } else {
            tanggalCreated.setText("-");
        }

        if (getIntent().getStringExtra("description") != null){
            description.setText(getIntent().getStringExtra("description"));
        } else {
            description.setText("-");
        }

    }
}