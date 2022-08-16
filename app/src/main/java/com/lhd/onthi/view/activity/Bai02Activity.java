package com.lhd.onthi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.lhd.onthi.R;
import com.lhd.onthi.database.DAO;
import com.lhd.onthi.databinding.ActivityBai02Binding;
import com.lhd.onthi.model.BangDiem;
import com.lhd.onthi.model.Lop;
import com.lhd.onthi.model.MonHoc;
import com.lhd.onthi.model.Student;

public class Bai02Activity extends AppCompatActivity {

    private ActivityBai02Binding binding;
    private DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bai02);
        dao = new DAO(this);
    }

    public void Add(View view) {
        String maLop = binding.maLop.getText().toString().trim();
        String tenLop = binding.tenLop.getText().toString().trim();
        String namHoc = binding.namHoc.getText().toString().trim();
        String kiHoc = binding.kiHoc.getText().toString().trim();
        String maSv = binding.maSv.getText().toString().trim();
        String tenSv = binding.tenSv.getText().toString().trim();
        String maMon = binding.maMon.getText().toString().trim();
        String tenMon = binding.tenMon.getText().toString().trim();
        String diem = binding.diem.getText().toString().trim();
        String soTin = binding.soTin.getText().toString().trim();
        //
        Lop lop = new Lop(maLop, tenLop, namHoc, kiHoc);
        Student student = new Student(maSv, maLop, tenSv);
        BangDiem bangDiem = new BangDiem(maSv, maMon, diem);
        MonHoc monHoc = new MonHoc(maMon, tenMon, soTin);

        int i = dao.insertBangDiem(bangDiem);
        int i2 = dao.insertLop(lop);
        int i3 = dao.insertMonHoc(monHoc);
        int i4 = dao.insertSv(student);
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            Toast.makeText(this, "insert thanh cong!", Toast.LENGTH_SHORT).show();
        }
    }

    public void getRow(View view) {
        Student student = dao.getStudent();
        Toast.makeText(this, "" + student.getTenSv(), Toast.LENGTH_SHORT).show();
    }

    public void goToBai01(View view) {
        Intent i = new Intent(Bai02Activity.this, MainActivity.class);
        startActivity(i);
    }
}