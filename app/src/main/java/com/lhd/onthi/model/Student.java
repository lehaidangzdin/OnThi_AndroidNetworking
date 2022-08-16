package com.lhd.onthi.model;

public class Student {
    private String maSv;
    private String maLop;
    private String tenSv;

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public Student(String string, String cursorString, String s, String string1) {
    }

    public Student(String maSv, String maLop, String tenSv) {
        this.maSv = maSv;
        this.maLop = maLop;
        this.tenSv = tenSv;
    }
}
