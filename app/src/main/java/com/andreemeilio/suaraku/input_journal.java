package com.andreemeilio.suaraku;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.andreemeilio.suaraku.model.HistoryModel;
import com.andreemeilio.suaraku.model.JournalModel;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

public class input_journal extends AppCompatActivity {

    EditText judulJournal,
            isiJournal,
            bahagiaJournal,
            sedihJournal,
            nextToDoJournal;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_input_journal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        judulJournal = (EditText) findViewById(R.id.judulJournalingEditText);
        isiJournal = (EditText) findViewById(R.id.isiJournalingEditText);
        bahagiaJournal = (EditText) findViewById(R.id.bahagiaJournalingEditText);
        sedihJournal = (EditText) findViewById(R.id.sedihJournalingEditText);
        nextToDoJournal = (EditText) findViewById(R.id.nextToDoJournalingEditText);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!judulJournal.getText().toString().isEmpty() && !isiJournal.getText().toString().isEmpty()){
                    Date dateCreated = Date.valueOf(LocalDate.now().toString());

                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("tanggalJournal", dateCreated.toString());
                    resultIntent.putExtra("judulJournal", judulJournal.getText().toString());
                    resultIntent.putExtra("isiJournal", isiJournal.getText().toString());
                    resultIntent.putExtra("bahagiaJournal", bahagiaJournal.getText().toString());
                    resultIntent.putExtra("sedihJournal", sedihJournal.getText().toString());
                    resultIntent.putExtra("nextToDoJournal", nextToDoJournal.getText().toString());

                    setResult(RESULT_OK, resultIntent);
                    // History
                    HistoryModel history = new HistoryModel(
                            "CREATED",
                            judulJournal.getText().toString(),
                            dateCreated.toString(),
                            "-",
                            "Anda menambahkan data journal baru dengan judul " + judulJournal.getText().toString()
                    );
                    HistoryList.listDataHistory.add(history);

                    finish();
                } else {
                    Toast.makeText(input_journal.this, "Masukkan judul dan isi journal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}