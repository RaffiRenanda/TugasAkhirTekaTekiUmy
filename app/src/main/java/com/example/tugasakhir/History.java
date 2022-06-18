package com.example.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tugasakhir.TemanAdapter.TemanAdapter;
import com.example.tugasakhir.database.DBController;
import com.example.tugasakhir.model.Teman;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class History extends AppCompatActivity {

    private RecyclerView rv;

    private TemanAdapter adapter;
    private ArrayList<Teman> temanArrayList;
    DBController kendaliDB=new DBController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rv = (RecyclerView) findViewById(R.id.recyclerV);

        BacaData();
        adapter = new TemanAdapter(temanArrayList);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(History.this);
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }


    public void BacaData(){
        ArrayList<HashMap<String,String>> daftarTeman = kendaliDB.getAllTeman();
        temanArrayList = new ArrayList<>();

        for(int i=0; i<daftarTeman.size();i++){
            Teman tm = new Teman();
            tm.setId(daftarTeman.get(i).get("id").toString());
            tm.setSkor(daftarTeman.get(i).get("value").toString());

            temanArrayList.add(tm);
        }
    }
}
