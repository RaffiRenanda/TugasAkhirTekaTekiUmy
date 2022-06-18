package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tugasakhir.database.DBController;

import java.util.HashMap;

public class HasilActivity extends AppCompatActivity {
    TextView hasil;

    Button  kembali;
    String skr;
    DBController kendaliDatabase = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);



        hasil = findViewById(R.id.textViewHasilNilai);

        kembali = findViewById(R.id.buttonKeHome);

        //menerima data nilai dan menampilkannya kedalam textview
        int nilai = getIntent().getExtras().getInt("value1");

        hasil.setText(String.valueOf(nilai));


        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengirim data ke sqlite
                skr = hasil.getText().toString();
                HashMap<String, String> dataKirim = new HashMap<>();
                dataKirim.put("value", skr);
                kendaliDatabase.tambahData(dataKirim);

                Intent in = new Intent(HasilActivity.this, MainActivity.class);
                startActivity(in);

            }
        });

    }
}