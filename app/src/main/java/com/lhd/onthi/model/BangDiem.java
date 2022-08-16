package com.lhd.onthi.model;

public class BangDiem {
    private String maSv;
    private String maMon;
    private String diem;

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public BangDiem() {
    }

    public BangDiem(String maSv, String maMon, String diem) {
        this.maSv = maSv;
        this.maMon = maMon;
        this.diem = diem;
    }
}
