package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tugasakhir.database.DBController;

import java.util.HashMap;

public class HasilRemidi extends AppCompatActivity {
    TextView hasil;

    Button kembali;
    String skr, id;
    DBController controler = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_remidi);


        hasil = findViewById(R.id.textViewHasilNilai);

        kembali = findViewById(R.id.buttonKeHome);

        //menerima data nilai dan menampilkannya kedalam textview
        int nilai = getIntent().getExtras().getInt("value1");
        id = getIntent().getStringExtra("id");

        hasil.setText(String.valueOf(nilai));


        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengirim data ke sqlite
                skr = hasil.getText().toString();
                HashMap<String, String> values = new HashMap<>();
                values.put("id",id);
                values.put("value", skr);
                controler.UpdateData(values);

                Intent in = new Intent(HasilRemidi.this, History.class);
                startActivity(in);

            }
        });
    }
}