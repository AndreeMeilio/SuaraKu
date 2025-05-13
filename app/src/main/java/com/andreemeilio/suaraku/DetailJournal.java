package com.andreemeilio.suaraku;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailJournal extends AppCompatActivity {

    TextView judulJournal,
            tanggalJournal,
            isiJournal,
            bahagiaJournal,
            sedihJournal,
            nextToDoJournal;

    Button detailHapusJournalButton, detailUbahJournalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_journal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        judulJournal = (TextView) findViewById(R.id.judulJournal);
        tanggalJournal = (TextView) findViewById(R.id.tanggalJournal);
        isiJournal = (TextView) findViewById(R.id.isiJournal);
        bahagiaJournal = (TextView) findViewById(R.id.bahagiaJournal);
        sedihJournal = (TextView) findViewById(R.id.sedihJournal);
        nextToDoJournal = (TextView) findViewById(R.id.nextToDoJournal);

        judulJournal.setText(getIntent().getStringExtra("judulJournal"));
        tanggalJournal.setText(getIntent().getStringExtra("tanggalJournal"));
        isiJournal.setText(getIntent().getStringExtra("isiJournal"));
        bahagiaJournal.setText(getIntent().getStringExtra("bahagiaJournal"));
        sedihJournal.setText(getIntent().getStringExtra("sedihJournal"));
        nextToDoJournal.setText(getIntent().getStringExtra("nextToDoJournal"));
    }
}