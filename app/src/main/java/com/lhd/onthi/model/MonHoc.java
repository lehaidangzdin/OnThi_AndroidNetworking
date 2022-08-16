package com.lhd.onthi.model;

public class MonHoc {
    private String maMon;
    private String tenMon;
    private String soTin;

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String gettenMon() {
        return tenMon;
    }

    public void settenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getSoTin() {
        return soTin;
    }

    public void setSoTin(String soTin) {
        this.soTin = soTin;
    }

    public MonHoc() {
    }

    public MonHoc(String maMon, String tenMon, String soTin) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTin = soTin;
    }
}
