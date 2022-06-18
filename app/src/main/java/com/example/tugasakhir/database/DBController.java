package com.example.tugasakhir.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper {
    public DBController(Context context) {
        super(context, "KuisTI", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table kuis (id integer primary key, value text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists kuis");
        onCreate(db);
    }

    public void tambahData(HashMap<String, String> dataQuery) {
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("value", dataQuery.get("value"));


        basisdata.insert("kuis", null, nilai);
        basisdata.close();
    }

    public void UpdateData(HashMap<String,String> dataQuery){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues nilaiUp = new ContentValues();
        nilaiUp.put("value", dataQuery.get("value"));
        db.update("kuis", nilaiUp, "id=?", new String[]{dataQuery.get("id")});
        db.close();
    }

    public void DeleteData (HashMap<String,String> dataQuery){
        SQLiteDatabase dbd = getWritableDatabase();
        dbd.delete("kuis", "id=?", new String[]{dataQuery.get("id")});
        dbd.close();
    }

    public ArrayList<HashMap<String, String>> getAllTeman() {
        ArrayList<HashMap<String, String>> dataTeman;
        dataTeman = new ArrayList<HashMap<String, String>>();
        String query = "select*from kuis";
        SQLiteDatabase basisdata = this.getReadableDatabase();

        Cursor cursor = basisdata.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();


                map.put("id", cursor.getString(0));
                map.put("value", cursor.getString(1));

                dataTeman.add(map);
            } while (cursor.moveToNext());
        }
        basisdata.close();
        return dataTeman;
    }
}