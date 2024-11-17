package com.example.atv12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

//Otavio Gabriel Ribeiro Scabio - RA 1110482223043

class JogadorDao implements ICRUDDao<Jogador> {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public JogadorDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    @Override
    public long insert(Jogador jogador) {
        ContentValues values = new ContentValues();
        values.put("nome", jogador.getNome());
        values.put("data_nasc", jogador.getDataNasc());
        values.put("altura", jogador.getAltura());
        values.put("peso", jogador.getPeso());
        values.put("TimeCodigo", jogador.getTimeCodigo());
        return db.insert("Jogador", null, values);
    }

    @Override
    public int update(Jogador jogador) {
        ContentValues values = new ContentValues();
        values.put("nome", jogador.getNome());
        values.put("data_nasc", jogador.getDataNasc());
        values.put("altura", jogador.getAltura());
        values.put("peso", jogador.getPeso());
        values.put("TimeCodigo", jogador.getTimeCodigo());
        return db.update("Jogador", values, "id = ?", new String[]{String.valueOf(jogador.getId())});
    }

    @Override
    public int delete(long id) {
        return db.delete("Jogador", "id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public Jogador findById(long id) {
        Cursor cursor = db.query("Jogador", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            Jogador jogador = new Jogador(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                    cursor.getDouble(3), cursor.getDouble(4), cursor.getInt(5));
            cursor.close();
            return jogador;
        }
        return null;
    }

    @Override
    public List<Jogador> findAll() {
        List<Jogador> jogadores = new ArrayList<>();
        Cursor cursor = db.query("Jogador", null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Jogador jogador = new Jogador(cursor.getInt(0), cursor.getString(1), cursor.getString(2),
                        cursor.getDouble(3), cursor.getDouble(4), cursor.getInt(5));
                jogadores.add(jogador);
            } while (cursor.moveToNext());
            cursor.close();
        }
        return jogadores;
    }
}

