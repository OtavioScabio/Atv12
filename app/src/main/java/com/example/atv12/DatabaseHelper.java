package com.example.atv12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "app.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_TIME =
            "CREATE TABLE Time (Codigo INTEGER PRIMARY KEY, nome VARCHAR(50), cidade VARCHAR(80))";

    private static final String CREATE_TABLE_JOGADOR =
            "CREATE TABLE Jogador (id INTEGER PRIMARY KEY, nome VARCHAR(100), data_nasc VARCHAR(10), " +
                    "altura DECIMAL(4,2), peso DECIMAL(4,1), TimeCodigo INTEGER, FOREIGN KEY(TimeCodigo) REFERENCES Time(Codigo))";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TIME);
        db.execSQL(CREATE_TABLE_JOGADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Time");
        db.execSQL("DROP TABLE IF EXISTS Jogador");
        onCreate(db);
    }
}
