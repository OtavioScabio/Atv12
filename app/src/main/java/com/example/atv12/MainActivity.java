package com.example.atv12;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TimeDao timeDao;
    private JogadorDao jogadorDao;
    private EditText edtNomeTime, edtCidadeTime;
    private Button btnAddTime, btnViewTimes;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        timeDao = new TimeDao(this);
        timeDao.open(); // Open database connection


        edtNomeTime = findViewById(R.id.edtNomeTime);
        edtCidadeTime = findViewById(R.id.edtCidadeTime);
        btnAddTime = findViewById(R.id.btnAddTime);
        btnViewTimes = findViewById(R.id.btnViewTimes);
        listView = findViewById(R.id.listView);


        btnAddTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edtNomeTime.getText().toString();
                String cidade = edtCidadeTime.getText().toString();
                if (!nome.isEmpty() && !cidade.isEmpty()) {
                    Time time = new Time(0, nome, cidade);
                    timeDao.insert(time);
                    edtNomeTime.setText("");
                    edtCidadeTime.setText("");
                }
            }
        });

        btnViewTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Time> times = timeDao.findAll();
                ArrayAdapter<Time> adapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, times);
                listView.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timeDao.close();
    }
}
