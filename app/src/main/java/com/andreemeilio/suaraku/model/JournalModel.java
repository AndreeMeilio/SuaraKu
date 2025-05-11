package com.andreemeilio.suaraku.model;

import java.sql.Date;

public class JournalModel {
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getKebahagiaan() {
        return kebahagiaan;
    }

    public void setKebahagiaan(String kebahagiaan) {
        this.kebahagiaan = kebahagiaan;
    }

    public String getKesedihan() {
        return kesedihan;
    }

    public void setKesedihan(String kesedihan) {
        this.kesedihan = kesedihan;
    }

    public String getNextToDo() {
        return nextToDo;
    }

    public void setNextToDo(String nextToDo) {
        this.nextToDo = nextToDo;
    }

    public JournalModel(Date tanggal, String judul, String isi, String kebahagiaan, String kesedihan, String nextToDo) {
        this.tanggal = tanggal;
        this.judul = judul;
        this.isi = isi;
        this.kebahagiaan = kebahagiaan;
        this.kesedihan = kesedihan;
        this.nextToDo = nextToDo;
    }

    private Date tanggal;
    private String judul;
    private String isi;
    private String kebahagiaan;
    private String kesedihan;
    private String nextToDo;
}
