package com.lhd.onthi.model;

public class Lop {
    private String maLop;
    private String tenLop;
    private String namHoc;
    private String kiHoc;


    public Lop(String maLop, String tenLop, String namHoc, String kiHoc) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.namHoc = namHoc;
        this.kiHoc = kiHoc;
    }

    public Lop() {
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(String kiHoc) {
        this.kiHoc = kiHoc;
    }
}
