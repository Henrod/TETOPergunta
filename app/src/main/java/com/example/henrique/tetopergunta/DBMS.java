package com.example.henrique.tetopergunta;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by henrique on 19/10/15.
 */
public class DBMS {
    private static final String Q1 = "q1";
    private static final String Q2 = "q2";
    private static final String Q3 = "q3";
    private static final String Q4 = "q4";
    private static final String Q5 = "q5";
    private static final String Q6 = "q6";
    private static final String Q7 = "q7";
    private static final String Q8 = "q8";
    private static final String Q9 = "q9";
    private static final String Q10 = "q10";
    private static final String ID = "id";

    private static final String TABLE_NAME = "DADOS_FAMILIA";
    private static final String DB_NAME = "TETO_DB";
    private static final int DB_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXIST " + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Q1 + " TEXT NOT NULL, " + Q2 + " TEXT NOT NULL, " + Q3 + " TEXT NOT NULL, "
            + Q4 + " TEXT NOT NULL, " + Q5 + " TEXT NOT NULL, " + Q6 + " TEXT NOT NULL, "
            + Q7 + " TEXT NOT NULL, " + Q8 + " TEXT NOT NULL, " + Q9 + " TEXT NOT NULL, "
            + Q10 + " TEXT NOT NULL);";

    private static DataBaseHelper dataBaseHelper;
    private static SQLiteDatabase db;

    private static class DataBaseHelper extends SQLiteOpenHelper {

        public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }

    public DBMS (Context context) {
        dataBaseHelper = new DataBaseHelper(context, DB_NAME, null, DB_VERSION);
    }

    public long create (Respostas respostas) {
        db = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (int i = 0; i < respostas.getNumeroQuestoes(); i++) {
            contentValues.put("Q" + i, respostas.getRespostas()[i]);
        }

        long id = db.insert(TABLE_NAME, null, contentValues);

        db.close();

        return id;
    }

    public Respostas retrieve(long id) {
        db = dataBaseHelper.getReadableDatabase();
        String select = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = ?";

        Cursor cursor = db.rawQuery(select, new String[]{String.valueOf(id)});

        Respostas respostas = new Respostas();

        if(cursor.moveToFirst()) {
            do {
                for (int i = 0; i < respostas.getNumeroQuestoes(); i++)
                    respostas.setResposta(i, cursor.getString(i + 1));
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return respostas;
    }

    public void update (Respostas respostas) {
        db = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (int i = 0; i < respostas.getNumeroQuestoes(); i++) {
            contentValues.put("Q" + i, respostas.getRespostas()[i]);
        }

        db.update(TABLE_NAME, contentValues, ID + " = ?",
                new String[]{String.valueOf(respostas.getId())});
        db.close();
    }

    public void delete (long id) {
        db = dataBaseHelper.getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<Respostas> getLista() {
        db = dataBaseHelper.getReadableDatabase();
        String select = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(select, null);

        List<Respostas> lista = new LinkedList<Respostas>();

        if(cursor.moveToFirst()) {
            do {
                Respostas respostas = new Respostas();
                for (int i = 0; i < respostas.getNumeroQuestoes(); i++)
                    respostas.setResposta(i, cursor.getString(i + 1));

                respostas.setId(cursor.getLong(0));
                lista.add(respostas);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return lista;
    }
}