package com.example.tugasakhir.model;

public class Teman {
    String id;
    String skor;


    public Teman() {
    }

    public Teman(String id, String skor) {
        this.id = id;
        this.skor = skor;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getSkor() {

        return skor;
    }

    public void setSkor(String skor) {

        this.skor = skor;
    }


}
