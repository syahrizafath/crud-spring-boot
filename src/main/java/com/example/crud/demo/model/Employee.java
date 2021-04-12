package com.example.crud.demo.model;

public class Employee {
    private int id, limit_reimbursement;
    private String kode, nama, email, hp, tanggal_masuk, created_date, updated_date;
    
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }
    public int getLimit_reimbursement() {
        return limit_reimbursement;
    }
    public void setLimit_reimbursement(int limit_reimbursement) {
        this.limit_reimbursement = limit_reimbursement;
    }
    public String getUpdated_date() {
        return updated_date;
    }
    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }
    public String getCreated_date() {
        return created_date;
    }
    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }
    public String getTanggal_masuk() {
        return tanggal_masuk;
    }
    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }
    public String getHp() {
        return hp;
    }
    public void setHp(String hp) {
        this.hp = hp;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setId(int id) {
        this.id = id;
    }

    
}
