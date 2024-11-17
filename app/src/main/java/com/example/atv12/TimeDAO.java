package com.example.atv12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

//Otavio Gabriel Ribeiro Scabio - RA 1110482223043

class TimeDao implements ICRUDDao<Time> {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public TimeDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public long insert(Time time) {
        ContentValues values = new ContentValues();
        values.put("nome", time.getNome());
        values.put("cidade", time.getCidade());
        return db.insert("Time", null, values);
    }

    @Override
    public int update(Time time) {
        ContentValues values = new ContentValues();
        values.put("nome", time.getNome());
        values.put("cidade", time.getCidade());
        return db.update("Time", values, "Codigo = ?", new String[]{String.valueOf(time.getCodigo())});
    }

    @Override
    public int delete(long id) {
        return db.delete("Time", "Codigo = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public Time findById(long id) {
        Cursor cursor = db.query("Time", null, "Codigo = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Time time = new Time(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            cursor.close();
            return time;
        }
        return null;
    }

    @Override
    public List<Time> findAll() {
        List<Time> times = new ArrayList<>();
        Cursor cursor = db.query("Time", null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Time time = new Time(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                times.add(time);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return times;
    }
}
