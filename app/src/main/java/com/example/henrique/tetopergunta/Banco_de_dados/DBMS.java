package com.example.henrique.tetopergunta.Banco_de_dados;

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
    private static final String M0Q1 = "m0q1";
    private static final String M0Q2 = "m0q2";
    private static final String M0Q3 = "m0q3";
    private static final String M0Q4 = "m0q4";
    private static final String M0Q5 = "m0q5";
    private static final String M0Q6 = "m0q6";
    private static final String M0Q7 = "m0q7";
    private static final String M0Q8 = "m0q8";
    private static final String M0Q9 = "m0q9";
    private static final String M0Q10 = "m0q10";
    private static final String ID = "id";

    private static final String TABLE_NAME = "DADOS_FAMILIA";
    private static final String DB_NAME = "TETO_DB";
    private static final int DB_VERSION = 2;
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + M0Q1 + " TEXT, " + M0Q2 + " TEXT, " + M0Q3 + " TEXT, "
            + M0Q4 + " TEXT, " + M0Q5 + " TEXT, " + M0Q6 + " TEXT, "
            + M0Q7 + " TEXT, " + M0Q8 + " TEXT, " + M0Q9 + " TEXT, "
            + M0Q10 + " TEXT);";

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

        for (int i = 0; i < 2 /*Respostas.MODULES*/; i++)
            for (int j = 1; j < 6 /*Respostas.QUESTIONS_PER_MODULE*/; j++)
                contentValues.put("M" + i + "Q" + j, respostas.getAnswers()[i][j]);


        long id = db.insert(TABLE_NAME, null, contentValues);

        db.close();

        return id;
    }

    public Respostas retrieve(String n_serie) {
        db = dataBaseHelper.getReadableDatabase();
        String select = "SELECT * FROM " + TABLE_NAME + " WHERE " + M0Q1 + " = ?";

        Cursor cursor = db.rawQuery(select, new String[]{String.valueOf(n_serie)});

        Respostas respostas = new Respostas();

        if(cursor.moveToFirst()) {
            do {
                String[] resp = new String[Respostas.QUESTIONS_PER_MODULE + 1];
                for (int i = 0; i < Respostas.MODULES + 1; i++) {
                    for (int j = 1; j < Respostas.QUESTIONS_PER_MODULE + 1; j++) {
                        resp[j] = cursor.getString(j);
                    }
                    respostas.setAnswers(i, resp);
                }
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return respostas;
    }

    public void update (Respostas respostas) {
        db = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for (int i = 0; i < Respostas.MODULES; i++)
            for (int j = 1; j < Respostas.QUESTIONS_PER_MODULE; j++)
                contentValues.put("M" + i + "Q" + j, respostas.getAnswers()[i][j]);

        db.update(TABLE_NAME, contentValues, ID + " = ?",
                new String[]{String.valueOf(respostas.getId())});
        db.close();
    }

    public void delete (String n_serie) {
        db = dataBaseHelper.getWritableDatabase();
        db.delete(TABLE_NAME, M0Q1 + " = ?", new String[]{String.valueOf(n_serie)});
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
                String[] resp = new String[Respostas.QUESTIONS_PER_MODULE + 1];
                for (int i = 0; i < Respostas.MODULES + 1; i++) {
                    for (int j = 1; j < Respostas.QUESTIONS_PER_MODULE + 1; j++)
                        resp[j] = cursor.getString(j);

                    respostas.setAnswers(i, resp);
                }

                respostas.setId(cursor.getLong(0));
                lista.add(respostas);
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();

        return lista;
    }
}