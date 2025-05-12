package com.andreemeilio.suaraku.model;

import java.sql.Date;

public class HistoryModel {
    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getJudulJournal(){
        return judulJournal;
    }

    public void setJudulJournal(String judulJournal){
        this.judulJournal = judulJournal;
    }

    public String getTanggalCreated() {
        return tanggalCreated;
    }

    public void setTanggalCreated(String tanggalCreated) {
        this.tanggalCreated = tanggalCreated;
    }

    public String getTanggalUpdated() {
        return tanggalUpdated;
    }

    public void setTanggalUpdated(String tanggalUpdated) {
        this.tanggalUpdated = tanggalUpdated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HistoryModel(String actionName, String judulJournal, String tanggalCreated, String tanggalUpdated, String description) {
        this.actionName = actionName;
        this.judulJournal = judulJournal;
        this.tanggalCreated = tanggalCreated;
        this.tanggalUpdated = tanggalUpdated;
        this.description = description;
    }

    private String actionName;
    private String judulJournal;
    private String tanggalCreated;
    private String tanggalUpdated;
    private String description;
}
