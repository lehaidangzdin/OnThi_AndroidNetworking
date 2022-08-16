package com.lhd.onthi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.lhd.onthi.model.BangDiem;
import com.lhd.onthi.model.Lop;
import com.lhd.onthi.model.MonHoc;
import com.lhd.onthi.model.Student;

public class DAO {
    private DatabaseHandler dbHandler;
    private SQLiteDatabase db;
    private Context context;

    public DAO(Context context) {
        this.context = context;
        dbHandler = new DatabaseHandler(context);
    }

    public int insertLop(Lop lop) {
        try {
            ContentValues newValues = new ContentValues();
            db = dbHandler.getWritableDatabase();
            // Gán dữ liệu cho mỗi cột.
            newValues.put("MaLop", lop.getMaLop());
            newValues.put("TenLop", lop.getTenLop());
            newValues.put("NamHoc", lop.getNamHoc());
            newValues.put("KyHoc", lop.getKiHoc());
            // Insert hàng dữ liệu vào table
            long result = db.insert("Lop", null, newValues);
            Log.i("Row Insert Result ", String.valueOf(result));
            db.close();

        } catch (Exception ex) {
            Log.e("loi insert lop", "insertLop: " + ex.getMessage());
        }
        return 0;
    }

    public int insertSv(Student student) {
        try {
            ContentValues newValues = new ContentValues();
            db = dbHandler.getWritableDatabase();
            // Gán dữ liệu cho mỗi cột.
            newValues.put("maSv", student.getMaSv());
            newValues.put("maLop", student.getMaLop());
            newValues.put("tenSv", student.getTenSv());
            // Insert hàng dữ liệu vào table
            long result = db.insert("Sv", null, newValues);
            db.close();

        } catch (Exception ex) {
            Log.e("loi insert sv", "insertLop: " + ex.getMessage());
        }
        return 0;
    }

    public int insertBangDiem(BangDiem bangDiem) {
        try {
            ContentValues newValues = new ContentValues();
            db = dbHandler.getWritableDatabase();
            // Gán dữ liệu cho mỗi cột.
            newValues.put("maSv", bangDiem.getMaSv());
            newValues.put("maMon", bangDiem.getMaMon());
            newValues.put("Diem", bangDiem.getDiem());
            // Insert hàng dữ liệu vào table
            long result = db.insert("BangDiem", null, newValues);
            db.close();

        } catch (Exception ex) {
            Log.e("loi insert bang diem", "insert bangdiem: " + ex.getMessage());
        }
        return 0;
    }

    public int insertMonHoc(MonHoc monHoc) {
        try {
            ContentValues newValues = new ContentValues();
            db = dbHandler.getWritableDatabase();
            // Gán dữ liệu cho mỗi cột.
            newValues.put("maMon", monHoc.getMaMon());
            newValues.put("tenMon", monHoc.gettenMon());
            newValues.put("soTin", monHoc.getSoTin());
            // Insert hàng dữ liệu vào table
            long result = db.insert("MonHoc", null, newValues);
            db.close();

        } catch (Exception ex) {
            Log.e("loi insert monhoc", "insert mon hoc: " + ex.getMessage());
        }
        return 0;
    }

    public String getSVDiemTBCaoNhatKi1() {
        db = dbHandler.getReadableDatabase();
        String sql = "SELECT tenSv, AVG(diem) as 'tb' FROM Sv WHERE namHoc like '2020' ORDER BY tb DESC";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null)
            cursor.moveToFirst();
        Student student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2));
        return student.getTenSv();
    }
    public String getSVDiemTBCaoNhatKi1lop12A() {
        db = dbHandler.getReadableDatabase();
        String sql = "SELECT tenSv, AVG(diem) as 'tb' FROM Sv WHERE namHoc like '2020' and tenLop like '12A' ORDER BY tb DESC";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null)
            cursor.moveToFirst();
        Student student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2));
        return student.getTenSv();
    }

    public Student getStudent() {
        db = dbHandler.getReadableDatabase();
        Cursor cursor = db.query("Sv", null, null, null, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Student student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2));
        return student;
    }

}
