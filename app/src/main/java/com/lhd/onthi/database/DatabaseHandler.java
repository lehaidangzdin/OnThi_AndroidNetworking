package com.lhd.onthi.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "schoolManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "students";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String DBLop = "CREATE TABLE Lop(MaLop TEXT, TenLop TEXT, NamHoc TEXT, KyHoc TEXT)";
        db.execSQL(DBLop);
        //
        String DBSv = "CREATE TABLE Sv(maSv TEXT, maLop TEXT, tenSv TEXT)";
        db.execSQL(DBSv);
        //
        String DBBangDiem = "CREATE TABLE BangDiem(maSv TEXT, maMon TEXT, Diem TEXT)";
        db.execSQL(DBBangDiem);
        //
        String DBMonHoc = "CREATE TABLE MonHoc(maMon TEXT PRIMARY KEY, tenMon TEXT, soTin TEXT)";
        db.execSQL(DBMonHoc);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String dbLop = String.format("DROP TABLE IF EXISTS %s", "Lop");
        db.execSQL(dbLop);
        //
        String dbSv = String.format("DROP TABLE IF EXISTS %s", "Sv");
        db.execSQL(dbSv);
        //
        String dbBangDiem = String.format("DROP TABLE IF EXISTS %s", "BangDiem");
        db.execSQL(dbBangDiem);
        //
        String dbMonHoc = String.format("DROP TABLE IF EXISTS %s", "MonHoc");
        db.execSQL(dbMonHoc);

        onCreate(db);
    }
}
