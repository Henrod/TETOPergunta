package com.example.henrique.tetopergunta.Banco_de_dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Henrique Rodrigues on 19/10/15.
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
    private static final String M0Q11 = "m0q11";
    private static final String M0Q12 = "m0q12";
    private static final String M0Q13 = "m0q13";
    private static final String M0Q14 = "m0q14";
    private static final String M0Q15 = "m0q15";
    private static final String M0Q16 = "m0q16";
    private static final String M0Q17 = "m0q17";
    private static final String M0Q18 = "m0q18";
    private static final String M0Q19 = "m0q19";
    private static final String M0Q20 = "m0q20";
    private static final String M0Q21 = "m0q21";
    private static final String M0Q22 = "m0q22";
    private static final String M0Q23 = "m0q23";
    private static final String M0Q24 = "m0q24";

    private static final String M1Q1 = "m1q1";
    private static final String M1Q2 = "m1q2";
    private static final String M1Q3 = "m1q3";
    private static final String M1Q4 = "m1q4";
    private static final String M1Q5 = "m1q5";
    private static final String M1Q6 = "m1q6";
    private static final String M1Q7 = "m1q7";
    private static final String M1Q8 = "m1q8";
    private static final String M1Q9 = "m1q9";
    private static final String M1Q10 = "m1q10";
    private static final String M1Q11 = "m1q11";

    private static final String M2Q1 = "m2q1";
    private static final String M2Q2 = "m2q2";
    private static final String M2Q3 = "m2q3";
    private static final String M2Q4 = "m2q4";
    private static final String M2Q5 = "m2q5";
    private static final String M2Q6 = "m2q6";
    private static final String M2Q7 = "m2q7";
    private static final String M2Q8 = "m2q8";

    private static final String M3Q1 = "m3q1";
    private static final String M3Q2 = "m3q2";
    private static final String M3Q3 = "m3q3";
    private static final String M3Q4 = "m3q4";
    private static final String M3Q5 = "m3q5";
    private static final String M3Q6 = "m3q6";
    private static final String M3Q7 = "m3q7";
    private static final String M3Q8 = "m3q8";
    private static final String M3Q9 = "m3q9";
    private static final String M3Q10 = "m3q10";
    private static final String M3Q11 = "m3q11";
    private static final String M3Q12 = "m3q12";
    private static final String M3Q13 = "m3q13";
    private static final String M3Q14 = "m3q14";
    private static final String M3Q15 = "m3q15";
    private static final String M3Q16 = "m3q16";
    private static final String M3Q17 = "m3q17";
    private static final String M3Q18 = "m3q18";

    private static final String M4Q1 = "m4q1";
    private static final String M4Q2 = "m4q2";
    private static final String M4Q3 = "m4q3";
    private static final String M4Q4 = "m4q4";
    private static final String M4Q5 = "m4q5";
    private static final String M4Q6 = "m4q6";
    private static final String M4Q7 = "m4q7";
    private static final String M4Q8 = "m4q8";
    private static final String M4Q9 = "m4q9";
    private static final String M4Q10 = "m4q10";

    private static final String M5Q1 = "m5q1";
    private static final String M5Q2 = "m5q2";
    private static final String M5Q3 = "m5q3";
    private static final String M5Q4 = "m5q4";
    private static final String M5Q5 = "m5q5";
    private static final String M5Q6 = "m5q6";
    private static final String M5Q7 = "m5q7";
    private static final String M5Q8 = "m5q8";
    private static final String M5Q9 = "m5q9";
    private static final String M5Q10 = "m5q10";
    private static final String M5Q11 = "m5q11";
    private static final String M5Q12 = "m5q12";
    private static final String M5Q13 = "m5q13";
    private static final String M5Q14 = "m5q14";
    private static final String M5Q15 = "m5q15";
    private static final String M5Q16 = "m5q16";
    private static final String M5Q17 = "m5q17";
    private static final String M5Q18 = "m5q18";
    private static final String M5Q19 = "m5q19";
    private static final String M5Q20 = "m5q20";
    private static final String M5Q21 = "m5q21";
    private static final String M5Q22 = "m5q22";
    private static final String M5Q23 = "m5q23";
    private static final String M5Q24 = "m5q24";
    private static final String M5Q25 = "m5q25";
    private static final String M5Q26 = "m5q26";
    private static final String M5Q27 = "m5q27";


    private static final String M6Q1 = "m6q1";
    private static final String M6Q2 = "m6q2";
    private static final String M6Q3 = "m6q3";
    private static final String M6Q4 = "m6q4";
    private static final String M6Q5 = "m6q5";
    private static final String M6Q6 = "m6q6";
    private static final String M6Q7 = "m6q7";
    private static final String M6Q8 = "m6q8";
    private static final String M6Q9 = "m6q9";
    private static final String M6Q10 = "m6q10";
    private static final String M6Q11 = "m6q11";
    private static final String M6Q12 = "m6q12";
    private static final String M6Q13 = "m6q13";
    private static final String M6Q14 = "m6q14";
    private static final String M6Q15 = "m6q15";
    private static final String M6Q16 = "m6q16";
    private static final String M6Q17 = "m6q17";
    private static final String M6Q18 = "m6q18";
    private static final String M6Q19 = "m6q19";
    private static final String M6Q20 = "m6q20";
    private static final String M6Q21 = "m6q21";
    private static final String M6Q22 = "m6q22";
    private static final String M6Q23 = "m6q23";
    private static final String M6Q24 = "m6q24";
    private static final String M6Q25 = "m6q25";
    private static final String M6Q26 = "m6q26";
    private static final String M6Q27 = "m6q27";
    private static final String M6Q28 = "m6q28";

    private static final String ID = "id";
    private static final String N_SERIE = "n_serie";

    private static final String MAIN_TABLE_NAME = "DADOS_FAMILIA";
    private static final String MOD1_TABLE_NAME = "DADOS_MOD1";
    private static final String MOD2_TABLE_NAME = "DADOS_MOD2";
    private static final String MOD3_TABLE_NAME = "DADOS_MOD3";
    private static final String MOD4_TABLE_NAME = "DADOS_MOD4";

    private static final String DB_NAME = "TETO_DB";
    private static final int DB_VERSION = 13;
    private static final String CREATE_MAIN_TABLE = "CREATE TABLE IF NOT EXISTS " + MAIN_TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + M0Q1 +    " TEXT, " + M0Q2 +  " TEXT, " + M0Q3 +  " TEXT, "
            + M0Q4 +    " TEXT, " + M0Q5 +  " TEXT, " + M0Q6 +  " TEXT, "
            + M0Q7 +    " TEXT, " + M0Q8 +  " TEXT, " + M0Q9 +  " TEXT, "
            + M0Q10 +   " TEXT, " + M0Q11 + " TEXT, " + M0Q12 + " TEXT, "
            + M0Q13 +   " TEXT, " + M0Q14 + " TEXT, " + M0Q15 + " TEXT, "
            + M0Q16 +   " TEXT, " + M0Q17 + " TEXT, " + M0Q18 + " TEXT, "
            + M0Q19 +   " TEXT, " + M0Q20 + " TEXT, " + M0Q21 +  " TEXT, "
            + M0Q22 +   " TEXT, " + M0Q23 +  " TEXT, "
            + M0Q24 +   " TEXT, " + M1Q10 +   " TEXT, "
            + M3Q14 + " TEXT, " + M3Q15 + " TEXT, "
            + M3Q16 +   " TEXT, " + M3Q17 + " TEXT, " + M3Q18 + " TEXT, "
            + M5Q1 +  " TEXT, " + M5Q2 +  " TEXT, "
            + M5Q3 +    " TEXT, " + M5Q4 +  " TEXT, " + M5Q5 +  " TEXT, "
            + M5Q6 +    " TEXT, " + M5Q7 +  " TEXT, " + M5Q8 +  " TEXT, "
            + M5Q9 +    " TEXT, "
            + M5Q10 +  " TEXT, " + M5Q11 +  " TEXT, "
            + M5Q12 +    " TEXT, " + M5Q13 +  " TEXT, " + M5Q14 +  " TEXT, "
            + M5Q15 +    " TEXT, " + M5Q16 +  " TEXT, " + M5Q17 +  " TEXT, "
            + M5Q18 +    " TEXT, "
            + M5Q19 +  " TEXT, " + M5Q20 +  " TEXT, "
            + M5Q21 +    " TEXT, " + M5Q22 +  " TEXT, " + M5Q23 +  " TEXT, "
            + M5Q24 +    " TEXT, " + M5Q25 +  " TEXT, " + M5Q26 +  " TEXT, "
            + M5Q27 +    " TEXT, "
            + M6Q1 +    " TEXT, " + M6Q2 +  " TEXT, " + M6Q3 +  " TEXT, "
            + M6Q4 +    " TEXT, " + M6Q5 +  " TEXT, " + M6Q6 +  " TEXT, "
            + M6Q7 +    " TEXT, " + M6Q8 +  " TEXT, " + M6Q9 +  " TEXT, "
            + M6Q10 +   " TEXT, " + M6Q11 + " TEXT, " + M6Q12 + " TEXT, "
            + M6Q13 +   " TEXT, " + M6Q14 + " TEXT, " + M6Q15 + " TEXT, "
            + M6Q16 +   " TEXT, " + M6Q17 + " TEXT, " + M6Q18 + " TEXT, "
            + M6Q19 +   " TEXT, " + M6Q20 + " TEXT, " + M6Q21 + " TEXT, "
            + M6Q22 +   " TEXT, " + M6Q23 + " TEXT, " + M6Q24 + " TEXT, "
            + M6Q25 +   " TEXT, " + M6Q26 + " TEXT, " + M6Q27 + " TEXT, "
            + M6Q28 +   " TEXT"
            + ");";

    private static final String CREATE_TABLE_MOD1 = "CREATE TABLE IF NOT EXISTS "
            + MOD1_TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + N_SERIE +  " TEXT, "
            + M1Q1 + " TEXT, " + M1Q2 +  " TEXT, " + M1Q3 +  " TEXT, "
            + M1Q4 + " TEXT, " + M1Q5 +  " TEXT, " + M1Q6 +  " TEXT, "
            + M1Q7 + " TEXT, " + M1Q8 +  " TEXT, " + M1Q9 +  " TEXT, "
            + M1Q11+ " TEXT"
            +");";

    private static final String CREATE_TABLE_MOD2 = "CREATE TABLE IF NOT EXISTS "
            + MOD2_TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + N_SERIE +  " TEXT, "
            + M2Q1 + " TEXT, " + M2Q2 +  " TEXT, " + M2Q3 +  " TEXT, "
            + M2Q4 + " TEXT, " + M2Q5 +  " TEXT, " + M2Q6 +  " TEXT, "
            + M2Q7 + " TEXT, " + M2Q8 + " TEXT"
            +");";

    private static final String CREATE_TABLE_MOD3 = "CREATE TABLE IF NOT EXISTS "
            + MOD3_TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + N_SERIE +  " TEXT, "
            + M3Q1 +    " TEXT, " + M3Q2 +  " TEXT, " + M3Q3 +  " TEXT, "
            + M3Q4 +    " TEXT, " + M3Q5 +  " TEXT, " + M3Q6 +  " TEXT, "
            + M3Q7 +    " TEXT, " + M3Q8 +  " TEXT, " + M3Q9 +  " TEXT, "
            + M3Q10 +   " TEXT, " + M3Q11 + " TEXT, " + M3Q12 + " TEXT"
            +");";

    private static final String CREATE_TABLE_MOD4 = "CREATE TABLE IF NOT EXISTS "
            + MOD4_TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + N_SERIE +  " TEXT, "
            + M4Q1 +    " TEXT, " + M4Q2 +  " TEXT, " + M4Q3 +  " TEXT, "
            + M4Q4 +    " TEXT, " + M4Q5 +  " TEXT, " + M4Q6 +  " TEXT, "
            + M4Q7 +    " TEXT, " + M4Q8 +  " TEXT, " + M4Q9 +  " TEXT, "
            + M4Q10 +   " TEXT"
            +");";


    private static DataBaseHelper dataBaseHelper;
    private static SQLiteDatabase db;

    private static class DataBaseHelper extends SQLiteOpenHelper {

        public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(CREATE_MAIN_TABLE);
            db.execSQL(CREATE_TABLE_MOD1);
            db.execSQL(CREATE_TABLE_MOD2);
            db.execSQL(CREATE_TABLE_MOD3);
            db.execSQL(CREATE_TABLE_MOD4);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + MAIN_TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + MOD1_TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + MOD2_TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + MOD3_TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + MOD4_TABLE_NAME);
            onCreate(db);
        }
    }

    public DBMS (Context context) {
        dataBaseHelper = new DataBaseHelper(context, DB_NAME, null, DB_VERSION);
    }

    public void create (Respostas respostas) {
        db = dataBaseHelper.getWritableDatabase();
        ContentValues main_values = new ContentValues();
        ContentValues mod1_values = new ContentValues();
        ContentValues mod2_values = new ContentValues();
        ContentValues mod3_values = new ContentValues();
        ContentValues mod4_values = new ContentValues();

        for (RespostasInfo rInfo : respostas.getMainAnswers()) {
            main_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
        } db.insert(MAIN_TABLE_NAME, null, main_values);


        for (ArrayList<RespostasInfo> list : respostas.getModAnswers(Respostas.Modulos.MODULO_1)) {
            for (RespostasInfo rInfo : list) {
                mod1_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
            } mod1_values.put(N_SERIE, respostas.getNSerie());

            db.insert(MOD1_TABLE_NAME, null, mod1_values);
        }

        for (ArrayList<RespostasInfo> list : respostas.getModAnswers(Respostas.Modulos.MODULO_2)) {
            for (RespostasInfo rInfo : list) {
                mod2_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
            } mod2_values.put(N_SERIE, respostas.getNSerie());

            db.insert(MOD2_TABLE_NAME, null, mod2_values);
        }

        for (ArrayList<RespostasInfo> list : respostas.getModAnswers(Respostas.Modulos.MODULO_3)) {
            for (RespostasInfo rInfo : list) {
                mod3_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
            } mod3_values.put(N_SERIE, respostas.getNSerie());

            db.insert(MOD3_TABLE_NAME, null, mod3_values);
        }

        for (ArrayList<RespostasInfo> list : respostas.getModAnswers(Respostas.Modulos.MODULO_4)) {
            for (RespostasInfo rInfo : list) {
                mod4_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
            } mod4_values.put(N_SERIE, respostas.getNSerie());

            db.insert(MOD4_TABLE_NAME, null, mod4_values);
        }

        db.close();
    }

    public Respostas retrieve(String n_serie) {
        db = dataBaseHelper.getReadableDatabase();

        String select = "SELECT * FROM " + MAIN_TABLE_NAME + " WHERE " + M0Q1 + " = ?";
        Cursor cursor_main = db.rawQuery(select, new String[]{String.valueOf(n_serie)});

        select = "SELECT * FROM " + MOD1_TABLE_NAME + " WHERE " + N_SERIE + " = ?";
        Cursor cursor_mod1 = db.rawQuery(select, new String[]{String.valueOf(n_serie)});

        select = "SELECT * FROM " + MOD2_TABLE_NAME + " WHERE " + N_SERIE + " = ?";
        Cursor cursor_mod2 = db.rawQuery(select, new String[]{String.valueOf(n_serie)});

        select = "SELECT * FROM " + MOD3_TABLE_NAME + " WHERE " + N_SERIE + " = ?";
        Cursor cursor_mod3 = db.rawQuery(select, new String[]{String.valueOf(n_serie)});

        select = "SELECT * FROM " + MOD4_TABLE_NAME + " WHERE " + N_SERIE + " = ?";
        Cursor cursor_mod4 = db.rawQuery(select, new String[]{String.valueOf(n_serie)});

        Respostas respostas = new Respostas();
        int modulo, n_ques;
        String resp;
        RespostasInfo rInfo;
        String[] columns_name;

        if(cursor_main.moveToFirst()) {
            do {
                respostas.setNSerie(n_serie);

                columns_name = cursor_main.getColumnNames();

                for (int i = 1; i < cursor_main.getColumnCount(); i++) {
                    modulo = Integer.valueOf(columns_name[i].substring(1, 2));
                    n_ques = Integer.valueOf(columns_name[i].substring(3));
                    resp = cursor_main.getString(i);

                    rInfo = new RespostasInfo(modulo, n_ques, resp);
                    respostas.setAnswers(rInfo, Respostas.Modulos.MAIN, 0, false);
                }
            } while (cursor_main.moveToNext());
        }

        int n = 0;
        if(cursor_mod1.moveToFirst()) {
            do {
                columns_name = cursor_mod1.getColumnNames();

                for (int i = 2; i < cursor_mod1.getColumnCount(); i++) {
                    modulo = Integer.valueOf(columns_name[i].substring(1, 2));
                    n_ques = Integer.valueOf(columns_name[i].substring(3));
                    resp = cursor_mod1.getString(i);

                    rInfo = new RespostasInfo(modulo, n_ques, resp);
                    respostas.setAnswers(rInfo, Respostas.Modulos.MODULO_1, n, false);
                }
                n++;
            } while (cursor_mod1.moveToNext());
        }

        n = 0;
        if(cursor_mod2.moveToFirst()) {
            do {
                columns_name = cursor_mod2.getColumnNames();

                for (int i = 2; i < cursor_mod2.getColumnCount(); i++) {
                    modulo = Integer.valueOf(columns_name[i].substring(1, 2));
                    n_ques = Integer.valueOf(columns_name[i].substring(3));
                    resp = cursor_mod2.getString(i);

                    rInfo = new RespostasInfo(modulo, n_ques, resp);
                    respostas.setAnswers(rInfo, Respostas.Modulos.MODULO_2, n, false);
                }
                n++;
            } while (cursor_mod2.moveToNext());
        }

        n = 0;
        if(cursor_mod3.moveToFirst()) {
            do {
                columns_name = cursor_mod3.getColumnNames();

                for (int i = 2; i < cursor_mod3.getColumnCount(); i++) {
                    modulo = Integer.valueOf(columns_name[i].substring(1, 2));
                    n_ques = Integer.valueOf(columns_name[i].substring(3));
                    resp = cursor_mod3.getString(i);

                    rInfo = new RespostasInfo(modulo, n_ques, resp);
                    respostas.setAnswers(rInfo, Respostas.Modulos.MODULO_3, n, false);
                }
                n++;
            } while (cursor_mod3.moveToNext());
        }

        n = 0;
        if(cursor_mod4.moveToFirst()) {
            do {
                columns_name = cursor_mod4.getColumnNames();

                for (int i = 2; i < cursor_mod4.getColumnCount(); i++) {
                    modulo = Integer.valueOf(columns_name[i].substring(1, 2));
                    n_ques = Integer.valueOf(columns_name[i].substring(3));
                    resp = cursor_mod4.getString(i);

                    rInfo = new RespostasInfo(modulo, n_ques, resp);
                    respostas.setAnswers(rInfo, Respostas.Modulos.MODULO_4, n, false);
                }
                n++;
            } while (cursor_mod4.moveToNext());
        }

        db.close();

        cursor_main.close();
        cursor_mod1.close();
        cursor_mod2.close();
        cursor_mod3.close();
        cursor_mod4.close();

        return respostas;
    }

    public void update (Respostas respostas) {
        db = dataBaseHelper.getWritableDatabase();
        ContentValues main_values = new ContentValues();
        ContentValues mod1_values;
        ContentValues mod2_values;
        ContentValues mod3_values;
        ContentValues mod4_values;

        for (RespostasInfo rInfo : respostas.getMainAnswers()) {
            main_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
        } db.update(MAIN_TABLE_NAME, main_values, M0Q1 + " = ?", new String[]{respostas.getNSerie()});


        db.delete(MOD1_TABLE_NAME, N_SERIE + "= ?", new String[]{respostas.getNSerie()});
        for (ArrayList<RespostasInfo> list : respostas.getModAnswers(Respostas.Modulos.MODULO_1)) {
            mod1_values = new ContentValues();

            for (RespostasInfo rInfo : list) {
                mod1_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
            } mod1_values.put(N_SERIE, respostas.getNSerie());

            db.insert(MOD1_TABLE_NAME, null, mod1_values);
        }

        db.delete(MOD2_TABLE_NAME, N_SERIE + "= ?", new String[]{respostas.getNSerie()});
        for (ArrayList<RespostasInfo> list : respostas.getModAnswers(Respostas.Modulos.MODULO_2)) {
            mod2_values = new ContentValues();

            for (RespostasInfo rInfo : list) {
                mod2_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
            } mod2_values.put(N_SERIE, respostas.getNSerie());

            db.insert(MOD2_TABLE_NAME, null, mod2_values);
        }

        db.delete(MOD3_TABLE_NAME, N_SERIE + "= ?", new String[]{respostas.getNSerie()});
        for (ArrayList<RespostasInfo> list : respostas.getModAnswers(Respostas.Modulos.MODULO_3)) {
            mod3_values = new ContentValues();

            for (RespostasInfo rInfo : list) {
                mod3_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
            } mod3_values.put(N_SERIE, respostas.getNSerie());

            db.insert(MOD3_TABLE_NAME, null, mod3_values);
        }

        db.delete(MOD4_TABLE_NAME, N_SERIE + "= ?", new String[]{respostas.getNSerie()});
        for (ArrayList<RespostasInfo> list : respostas.getModAnswers(Respostas.Modulos.MODULO_4)) {
            mod4_values = new ContentValues();

            for (RespostasInfo rInfo : list) {
                mod4_values.put("m" + rInfo.modulo + "q" + rInfo.n_questao, rInfo.resp);
            } mod4_values.put(N_SERIE, respostas.getNSerie());

            db.insert(MOD4_TABLE_NAME, null, mod4_values);
        }

        db.close();
    }

    public void delete (String n_serie) {
        db = dataBaseHelper.getWritableDatabase();
        db.delete(MAIN_TABLE_NAME, M0Q1 + " = ?", new String[]{n_serie});
        db.delete(MOD1_TABLE_NAME, N_SERIE+"= ?", new String[]{n_serie});
        db.delete(MOD2_TABLE_NAME, N_SERIE+"= ?", new String[]{n_serie});
        db.delete(MOD3_TABLE_NAME, N_SERIE+"= ?", new String[]{n_serie});
        db.delete(MOD4_TABLE_NAME, N_SERIE+"= ?", new String[]{n_serie});
        db.close();
    }

    public List<Respostas> getLista() {
        db = dataBaseHelper.getReadableDatabase();

        Cursor main_cursor = db.rawQuery("SELECT " + M0Q1 + " FROM " + MAIN_TABLE_NAME, null);

        List<Respostas> lista = new LinkedList<>();

        if(main_cursor.moveToFirst()) {
            do {
                Respostas respostas = new Respostas();

                String n_serie = main_cursor.getString(main_cursor.getColumnIndex(M0Q1));
                respostas.setNSerie(n_serie);
                respostas.setId(main_cursor.getLong(0));
                lista.add(respostas);
            } while (main_cursor.moveToNext());
        }

        db.close();
        main_cursor.close();

        return lista;
    }
}