package com.example.tugasakhir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.example.tugasakhir.TemanAdapter.ImgAdapter;

public class MainActivity extends AppCompatActivity {
    Button teknik, ekonomi, pai, dokter;
    ViewPager viewPag;
    ImgAdapter adapter;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.history){
            Intent i = new Intent(MainActivity.this, History.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPag = findViewById(R.id.ImgPager);
        adapter = new ImgAdapter(this);
        viewPag.setAdapter(adapter);
        teknik = findViewById(R.id.buttonTeknik);
        ekonomi = findViewById(R.id.buttonEkonomi);
        pai = findViewById(R.id.buttonAgama);
        dokter = findViewById(R.id.buttonKedokteran);


        teknik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FakTeknik.class);
                startActivity(i);
            }
        });

        ekonomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FakEkonomi.class);
                startActivity(i);
            }
        });

        pai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, FakAgama.class);
                startActivity(i);
            }
        });

        dokter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=  new Intent(MainActivity.this, FakDokter.class);
                startActivity(i);
            }
        });
    }
}