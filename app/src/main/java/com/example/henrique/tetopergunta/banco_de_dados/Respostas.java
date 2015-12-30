package com.example.henrique.tetopergunta.banco_de_dados;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.example.henrique.tetopergunta.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import static com.example.henrique.tetopergunta.banco_de_dados.Respostas.Modulos.MAIN;

/**
 * Created by henrique on 09/10/15.
 */
public class Respostas {

    public enum Modulos {MAIN, MODULO_0, MODULO_1, MODULO_2,
        MODULO_3, MODULO_4, MODULO_5, MODULO_6}

    private ArrayList<RespostasInfo> main_answers;
    private LinkedList<ArrayList<RespostasInfo>> mod1_answers;
    private LinkedList<ArrayList<RespostasInfo>> mod2_answers;
    private LinkedList<ArrayList<RespostasInfo>> mod3_answers;
    private LinkedList<ArrayList<RespostasInfo>> mod4_answers;

    private String n_serie;
    private long id = 0;

    public Respostas () {
        main_answers = new ArrayList<>();
        mod1_answers = new LinkedList<>();
        mod2_answers = new LinkedList<>();
        mod3_answers = new LinkedList<>();
        mod4_answers = new LinkedList<>();
    }

    public void setNSerie(String n_serie) {
        this.n_serie = n_serie;
    }

    public String getNSerie(){return n_serie;}

    public void setAnswers(RespostasInfo respostasInfo, Modulos modulos, int mod_index, boolean update) {
        switch (modulos) {
            case MAIN:
                if (update) {
                    getRespFromIndex(MAIN, respostasInfo.modulo, respostasInfo.n_questao, mod_index).
                            resp = respostasInfo.resp;
                } else
                    main_answers.add(respostasInfo);
                break;

            default:
                LinkedList<ArrayList<RespostasInfo>> answers = getModAnswers(modulos);
                while (answers.size() <= mod_index)
                    answers.add(new ArrayList<RespostasInfo>());

                if (update) {
                    getRespFromIndex(modulos, respostasInfo.modulo, respostasInfo.n_questao, mod_index).
                            resp = respostasInfo.resp;
                } else
                    answers.get(mod_index).add(respostasInfo);
                break;
        }
    }

    public ArrayList<RespostasInfo> getMainAnswers() {
        return main_answers;
    }

    public LinkedList<ArrayList<RespostasInfo>> getModAnswers(Modulos modulos) {
        switch (modulos) {
            case MODULO_1:
                return mod1_answers;

            case MODULO_2:
                return mod2_answers;

            case MODULO_3:
                return mod3_answers;

            case MODULO_4:
                return mod4_answers;
        }

        return null;
    }

    public RespostasInfo getRespFromIndex(Modulos modulos, int modulo, int n_questao, int mod_index) {
        ArrayList<RespostasInfo> list;

        list = modulos == MAIN ? getMainAnswers() : getModAnswers(modulos).get(mod_index);

        for (RespostasInfo respostasInfo : list)
            if (respostasInfo.n_questao == n_questao && respostasInfo.modulo == modulo)
                return respostasInfo;

        return null;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return this.id;
    }

    public boolean export_to_excel(Context context) {
        Toast.makeText(context, "Gerando tabela. Aguarde...", Toast.LENGTH_LONG).show();

        String file_name = getNSerie() + ".xls";

        File sdcard     = Environment.getExternalStorageDirectory();
        File directory  = new File (sdcard.getAbsolutePath() + "/TETO");
        directory.mkdirs();

        File exc_file = new File(directory, file_name);

        WorkbookSettings wbsettings = new WorkbookSettings();
        wbsettings.setLocale(new Locale("pt", "br"));

        try {
            WritableWorkbook workbook = Workbook.createWorkbook(exc_file, wbsettings);

            WritableSheet sheet_modulo0 = workbook.createSheet("Informações da enquete", 0);
            WritableSheet sheet_modulo1 = workbook.createSheet("Módulo 1", 1);
            WritableSheet sheet_modulo2 = workbook.createSheet("Módulo 2", 2);
            WritableSheet sheet_modulo3 = workbook.createSheet("Módulo 3", 3);
            WritableSheet sheet_modulo4 = workbook.createSheet("Módulo 4", 4);
            WritableSheet sheet_modulo5 = workbook.createSheet("Módulo 5", 5);
            WritableSheet sheet_modulo6 = workbook.createSheet("Módulo 6", 6);
            WritableSheet sheet_modulo_extra = workbook.createSheet("Módulo Extra", 7);

            WritableCellFormat cell_format = new WritableCellFormat();
            cell_format.setShrinkToFit(true);
            cell_format.setWrap(true);

            sheet_modulo0.addCell(new Label(0, 0, "Informações da enquete", cell_format));
            sheet_modulo0.addCell(new Label(0, 1, "A - Dados da Comunidade", cell_format));
            sheet_modulo0.addCell(new Label(0, 2, context.getResources().getString(R.string.m0q1), cell_format));
            sheet_modulo0.addCell(new Label(0, 3, context.getResources().getString(R.string.m0q2), cell_format));
            sheet_modulo0.addCell(new Label(0, 4, context.getResources().getString(R.string.m0q3), cell_format));
            sheet_modulo0.addCell(new Label(0, 5, context.getResources().getString(R.string.m0q4), cell_format));
            sheet_modulo0.addCell(new Label(0, 6, "B - Endereço de moradia", cell_format));
            sheet_modulo0.addCell(new Label(0, 7, context.getResources().getString(R.string.m0q5), cell_format));
            sheet_modulo0.addCell(new Label(0, 8, context.getResources().getString(R.string.m0q6), cell_format));
            sheet_modulo0.addCell(new Label(0, 9, context.getResources().getString(R.string.m0q7), cell_format));
            sheet_modulo0.addCell(new Label(0, 10, context.getResources().getString(R.string.m0q8), cell_format));
            sheet_modulo0.addCell(new Label(0, 11, "C - Dados da entrevista", cell_format));
            sheet_modulo0.addCell(new Label(0, 12, context.getResources().getString(R.string.m0q9), cell_format));
            sheet_modulo0.addCell(new Label(0, 13, context.getResources().getString(R.string.m0q10), cell_format));
            sheet_modulo0.addCell(new Label(0, 14, context.getResources().getString(R.string.m0q11), cell_format));
            sheet_modulo0.addCell(new Label(0, 15, context.getResources().getString(R.string.m0q12), cell_format));
            sheet_modulo0.addCell(new Label(0, 16, context.getResources().getString(R.string.m0q13), cell_format));
            sheet_modulo0.addCell(new Label(0, 17, context.getResources().getString(R.string.m0q14), cell_format));
            sheet_modulo0.addCell(new Label(0, 18, context.getResources().getString(R.string.m0q15), cell_format));
            sheet_modulo0.addCell(new Label(0, 19, context.getResources().getString(R.string.m0q16), cell_format));
            sheet_modulo0.addCell(new Label(0, 20, context.getResources().getString(R.string.m0q17), cell_format));
            sheet_modulo0.addCell(new Label(0, 21, context.getResources().getString(R.string.m0q18), cell_format));
            sheet_modulo0.addCell(new Label(0, 22, context.getResources().getString(R.string.m0q19), cell_format));
            sheet_modulo0.addCell(new Label(0, 23, context.getResources().getString(R.string.m0q20), cell_format));
            sheet_modulo0.addCell(new Label(0, 24, context.getResources().getString(R.string.m0q21), cell_format));
            sheet_modulo0.addCell(new Label(0, 25, context.getResources().getString(R.string.m0q22), cell_format));
            sheet_modulo0.addCell(new Label(0, 26, "D - Apresentação", cell_format));
            sheet_modulo0.addCell(new Label(0, 27, "E - Instruções básicas", cell_format));
            for (int i = 2, j = 0; i < 28; i++) {
                if (i != 6 && i != 11)
                    sheet_modulo0.addCell(new Label(1, i, main_answers.get(j++).resp, cell_format));
            }
            for (int i = 0; i < 25; i++) {
                CellView cell = sheet_modulo0.getColumnView(i);
                cell.setAutosize(true);
                sheet_modulo0.setColumnView(i, cell);
            }



            sheet_modulo1.addCell(new Label(0, 0, "Módulo 1", cell_format));
            sheet_modulo1.addCell(new Label(1, 0, context.getResources().getString(R.string.m1q1), cell_format));
            sheet_modulo1.addCell(new Label(2, 0, context.getResources().getString(R.string.m1q2), cell_format));
            sheet_modulo1.addCell(new Label(3, 0, context.getResources().getString(R.string.m1q3), cell_format));
            sheet_modulo1.addCell(new Label(4, 0, context.getResources().getString(R.string.m1q4), cell_format));
            sheet_modulo1.addCell(new Label(5, 0, context.getResources().getString(R.string.m1q5), cell_format));
            sheet_modulo1.addCell(new Label(6, 0, context.getResources().getString(R.string.m1q6), cell_format));
            sheet_modulo1.addCell(new Label(7, 0, context.getResources().getString(R.string.m1q7), cell_format));
            sheet_modulo1.addCell(new Label(8, 0, context.getResources().getString(R.string.m1q8), cell_format));
            sheet_modulo1.addCell(new Label(9, 0, context.getResources().getString(R.string.m1q9), cell_format));
            sheet_modulo1.addCell(new Label(10, 0, context.getResources().getString(R.string.m1q10), cell_format));
            sheet_modulo1.addCell(new Label(11, 0, context.getResources().getString(R.string.m1q11), cell_format));

            sheet_modulo1.addCell(new Label(10, 1, main_answers.get(24).resp, cell_format));
            for (int i = 1; i <= mod1_answers.size(); i++) {
                sheet_modulo1.addCell(new Label(0, i+1, String.valueOf(i), cell_format));
            }
            ArrayList<RespostasInfo> resps;
            for (int i = 0; i < mod1_answers.size(); i++) {
                resps = mod1_answers.get(i);
                for (int j = 0, k = 0; j < resps.size(); j++) {
                    if (j == 9) k++;
                    sheet_modulo1.addCell(new Label(j+1+k, i+2, resps.get(j).resp, cell_format));
                }
            }
            for (int i = 0; i < 11; i++) {
                CellView cell = sheet_modulo1.getColumnView(i);
                cell.setAutosize(true);
                sheet_modulo1.setColumnView(i, cell);
            }


            sheet_modulo2.addCell(new Label(0, 0, "Módulo 2", cell_format));
            sheet_modulo2.addCell(new Label(1, 0, context.getResources().getString(R.string.m2q1), cell_format));
            sheet_modulo2.addCell(new Label(2, 0, context.getResources().getString(R.string.m2q2), cell_format));
            sheet_modulo2.addCell(new Label(3, 0, context.getResources().getString(R.string.m2q3), cell_format));
            sheet_modulo2.addCell(new Label(4, 0, context.getResources().getString(R.string.m2q4), cell_format));
            sheet_modulo2.addCell(new Label(5, 0, context.getResources().getString(R.string.m2q5), cell_format));
            sheet_modulo2.addCell(new Label(6, 0, context.getResources().getString(R.string.m2q6), cell_format));
            sheet_modulo2.addCell(new Label(7, 0, context.getResources().getString(R.string.m2q7), cell_format));
            sheet_modulo2.addCell(new Label(8, 0, context.getResources().getString(R.string.m2q8), cell_format));

            for (int i = 1; i <= mod2_answers.size(); i++) {
                sheet_modulo2.addCell(new Label(0, i, String.valueOf(i), cell_format));
            }
            for (int i = 0; i < mod2_answers.size(); i++) {
                resps = mod2_answers.get(i);
                for (int j = 0; j < resps.size(); j++) {
                    sheet_modulo2.addCell(new Label(j+1, i+1, resps.get(j).resp, cell_format));
                }
            }
            for (int i = 0; i < 9; i++) {
                CellView cell = sheet_modulo2.getColumnView(i);
                cell.setAutosize(true);
                sheet_modulo2.setColumnView(i, cell);
            }




            sheet_modulo3.addCell(new Label(0, 0, "Módulo 3", cell_format));
            sheet_modulo3.addCell(new Label(1, 0, context.getResources().getString(R.string.m3q1), cell_format));
            sheet_modulo3.addCell(new Label(2, 0, context.getResources().getString(R.string.m3q2), cell_format));
            sheet_modulo3.addCell(new Label(3, 0, context.getResources().getString(R.string.m3q3), cell_format));
            sheet_modulo3.addCell(new Label(4, 0, context.getResources().getString(R.string.m3q4), cell_format));
            sheet_modulo3.addCell(new Label(5, 0, context.getResources().getString(R.string.m3q5), cell_format));
            sheet_modulo3.addCell(new Label(6, 0, context.getResources().getString(R.string.m3q6), cell_format));
            sheet_modulo3.addCell(new Label(7, 0, context.getResources().getString(R.string.m3q7), cell_format));
            sheet_modulo3.addCell(new Label(8, 0, context.getResources().getString(R.string.m3q8), cell_format));
            sheet_modulo3.addCell(new Label(9, 0, context.getResources().getString(R.string.m3q9), cell_format));
            sheet_modulo3.addCell(new Label(10, 0, context.getResources().getString(R.string.m3q10), cell_format));
            sheet_modulo3.addCell(new Label(11, 0, context.getResources().getString(R.string.m3q11), cell_format));
            sheet_modulo3.addCell(new Label(12, 0, context.getResources().getString(R.string.m3q12), cell_format));
            sheet_modulo3.addCell(new Label(13, 0, context.getResources().getString(R.string.m3q14), cell_format));
            sheet_modulo3.addCell(new Label(14, 0, context.getResources().getString(R.string.m3q15), cell_format));
            sheet_modulo3.addCell(new Label(15, 0, context.getResources().getString(R.string.m3q16), cell_format));
            sheet_modulo3.addCell(new Label(16, 0, context.getResources().getString(R.string.m3q17), cell_format));
            sheet_modulo3.addCell(new Label(17, 0, context.getResources().getString(R.string.m3q18), cell_format));

            sheet_modulo3.addCell(new Label(13, 1, main_answers.get(25).resp, cell_format));
            sheet_modulo3.addCell(new Label(14, 1, main_answers.get(26).resp, cell_format));
            sheet_modulo3.addCell(new Label(15, 1, main_answers.get(27).resp, cell_format));
            sheet_modulo3.addCell(new Label(16, 1, main_answers.get(28).resp, cell_format));
            sheet_modulo3.addCell(new Label(17, 1, main_answers.get(29).resp, cell_format));
            for (int i = 1; i <= mod3_answers.size(); i++) {
                sheet_modulo3.addCell(new Label(0, i+1, String.valueOf(i), cell_format));
            }
            for (int i = 0; i < mod3_answers.size(); i++) {
                resps = mod3_answers.get(i);
                for (int j = 0; j < resps.size(); j++) {
                    sheet_modulo3.addCell(new Label(j+1, i+2, resps.get(j).resp, cell_format));
                }
            }
            for (int i = 0; i < 17; i++) {
                CellView cell = sheet_modulo3.getColumnView(i);
                cell.setAutosize(true);
                sheet_modulo3.setColumnView(i, cell);
            }



            sheet_modulo4.addCell(new Label(0, 0, "Módulo 4", cell_format));
            sheet_modulo4.addCell(new Label(1, 0, context.getResources().getString(R.string.m4q1), cell_format));
            sheet_modulo4.addCell(new Label(2, 0, context.getResources().getString(R.string.m4q2), cell_format));
            sheet_modulo4.addCell(new Label(3, 0, context.getResources().getString(R.string.m4q3), cell_format));
            sheet_modulo4.addCell(new Label(4, 0, context.getResources().getString(R.string.m4q4), cell_format));
            sheet_modulo4.addCell(new Label(5, 0, context.getResources().getString(R.string.m4q5), cell_format));
            sheet_modulo4.addCell(new Label(6, 0, context.getResources().getString(R.string.m4q6), cell_format));
            sheet_modulo4.addCell(new Label(7, 0, context.getResources().getString(R.string.m4q7), cell_format));
            sheet_modulo4.addCell(new Label(8, 0, context.getResources().getString(R.string.m4q8), cell_format));
            sheet_modulo4.addCell(new Label(9, 0, context.getResources().getString(R.string.m4q9), cell_format));
            sheet_modulo4.addCell(new Label(10, 0, context.getResources().getString(R.string.m4q10), cell_format));

            for (int i = 1; i <= mod4_answers.size(); i++) {
                sheet_modulo4.addCell(new Label(0, i, String.valueOf(i), cell_format));
            }
            for (int i = 0; i < mod4_answers.size(); i++) {
                resps = mod4_answers.get(i);
                for (int j = 0; j < resps.size(); j++) {
                    sheet_modulo4.addCell(new Label(j+1, i+1, resps.get(j).resp, cell_format));
                }
            }
            for (int i = 0; i < 11; i++) {
                CellView cell = sheet_modulo4.getColumnView(i);
                cell.setAutosize(true);
                sheet_modulo4.setColumnView(i, cell);
            }



            sheet_modulo5.addCell(new Label(0, 0, "Módulo 5", cell_format));
            sheet_modulo5.addCell(new Label(0, 1, context.getResources().getString(R.string.m5q1), cell_format));
            sheet_modulo5.addCell(new Label(0, 2, context.getResources().getString(R.string.m5q2), cell_format));
            sheet_modulo5.addCell(new Label(0, 3, context.getResources().getString(R.string.m5q3), cell_format));
            sheet_modulo5.addCell(new Label(0, 4, context.getResources().getString(R.string.m5q4), cell_format));
            sheet_modulo5.addCell(new Label(0, 5, context.getResources().getString(R.string.m5q5), cell_format));
            sheet_modulo5.addCell(new Label(0, 6, context.getResources().getString(R.string.m5q6), cell_format));
            sheet_modulo5.addCell(new Label(0, 7, context.getResources().getString(R.string.m5q7), cell_format));
            sheet_modulo5.addCell(new Label(0, 8, context.getResources().getString(R.string.m5q8), cell_format));
            sheet_modulo5.addCell(new Label(0, 9, context.getResources().getString(R.string.m5q9), cell_format));
            sheet_modulo5.addCell(new Label(0, 10, context.getResources().getString(R.string.m5q10), cell_format));
            sheet_modulo5.addCell(new Label(0, 11, context.getResources().getString(R.string.m5q11), cell_format));
            sheet_modulo5.addCell(new Label(0, 12, context.getResources().getString(R.string.m5q12), cell_format));
            sheet_modulo5.addCell(new Label(0, 13, context.getResources().getString(R.string.m5q13), cell_format));
            sheet_modulo5.addCell(new Label(0, 14, context.getResources().getString(R.string.m5q14), cell_format));
            sheet_modulo5.addCell(new Label(0, 15, context.getResources().getString(R.string.m5q15), cell_format));
            sheet_modulo5.addCell(new Label(0, 16, context.getResources().getString(R.string.m5q16), cell_format));
            sheet_modulo5.addCell(new Label(0, 17, context.getResources().getString(R.string.m5q17), cell_format));
            sheet_modulo5.addCell(new Label(0, 18, context.getResources().getString(R.string.m5q18), cell_format));
            sheet_modulo5.addCell(new Label(0, 19, context.getResources().getString(R.string.m5q19), cell_format));
            sheet_modulo5.addCell(new Label(0, 20, context.getResources().getString(R.string.m5q20), cell_format));
            sheet_modulo5.addCell(new Label(0, 21, context.getResources().getString(R.string.m5q21), cell_format));
            sheet_modulo5.addCell(new Label(0, 22, context.getResources().getString(R.string.m5q22), cell_format));
            sheet_modulo5.addCell(new Label(0, 23, context.getResources().getString(R.string.m5q23), cell_format));
            sheet_modulo5.addCell(new Label(0, 24, context.getResources().getString(R.string.m5q24), cell_format));
            sheet_modulo5.addCell(new Label(0, 25, context.getResources().getString(R.string.m5q25), cell_format));
            sheet_modulo5.addCell(new Label(0, 26, context.getResources().getString(R.string.m5q26), cell_format));
            sheet_modulo5.addCell(new Label(0, 27, context.getResources().getString(R.string.m5q27), cell_format));
            for (int i = 1; i < 28; i++) {
                    sheet_modulo5.addCell(new Label(1, i, main_answers.get(29 + i).resp, cell_format));
            }
            for (int i = 0; i < 28; i++) {
                CellView cell = sheet_modulo5.getColumnView(i);
                cell.setAutosize(true);
                sheet_modulo5.setColumnView(i, cell);
            }



            sheet_modulo6.addCell(new Label(0, 0, "Módulo 6", cell_format));
            sheet_modulo6.addCell(new Label(0, 1, context.getResources().getString(R.string.m6q1), cell_format));
            sheet_modulo6.addCell(new Label(0, 2, context.getResources().getString(R.string.m6q2), cell_format));
            sheet_modulo6.addCell(new Label(0, 3, context.getResources().getString(R.string.m6q3), cell_format));
            sheet_modulo6.addCell(new Label(0, 4, context.getResources().getString(R.string.m6q4), cell_format));
            sheet_modulo6.addCell(new Label(0, 5, context.getResources().getString(R.string.m6q5), cell_format));
            sheet_modulo6.addCell(new Label(0, 6, context.getResources().getString(R.string.m6q6), cell_format));
            sheet_modulo6.addCell(new Label(0, 7, context.getResources().getString(R.string.m6q7), cell_format));
            sheet_modulo6.addCell(new Label(0, 8, context.getResources().getString(R.string.m6q8), cell_format));
            sheet_modulo6.addCell(new Label(0, 9, context.getResources().getString(R.string.m6q9), cell_format));
            sheet_modulo6.addCell(new Label(0, 10, context.getResources().getString(R.string.m6q10), cell_format));
                sheet_modulo6.addCell(new Label(0, 11, "\t" + context.getResources().getString(R.string.m6q101), cell_format));
                sheet_modulo6.addCell(new Label(0, 12, "\t" + context.getResources().getString(R.string.m6q102), cell_format));
                sheet_modulo6.addCell(new Label(0, 13, "\t" + context.getResources().getString(R.string.m6q103), cell_format));
                sheet_modulo6.addCell(new Label(0, 14, "\t" + context.getResources().getString(R.string.m6q104), cell_format));
                sheet_modulo6.addCell(new Label(0, 15, "\t" + context.getResources().getString(R.string.m6q105), cell_format));
                sheet_modulo6.addCell(new Label(0, 16, "\t" + context.getResources().getString(R.string.m6q106), cell_format));
                sheet_modulo6.addCell(new Label(0, 17, "\t" + context.getResources().getString(R.string.m6q107), cell_format));
                sheet_modulo6.addCell(new Label(0, 18, "\t" + context.getResources().getString(R.string.m6q108), cell_format));
                sheet_modulo6.addCell(new Label(0, 19, "\t" + context.getResources().getString(R.string.m6q109), cell_format));
                sheet_modulo6.addCell(new Label(0, 20, "\t" + context.getResources().getString(R.string.m6q1010), cell_format));
            sheet_modulo6.addCell(new Label(0, 21, context.getResources().getString(R.string.m6q11), cell_format));
            sheet_modulo6.addCell(new Label(0, 22, context.getResources().getString(R.string.m6q12), cell_format));
            sheet_modulo6.addCell(new Label(0, 23, context.getResources().getString(R.string.m6q13), cell_format));
            sheet_modulo6.addCell(new Label(0, 24, context.getResources().getString(R.string.m6q14), cell_format));
            sheet_modulo6.addCell(new Label(0, 25, context.getResources().getString(R.string.m6q15), cell_format));
            sheet_modulo6.addCell(new Label(0, 26, context.getResources().getString(R.string.m6q16), cell_format));
            sheet_modulo6.addCell(new Label(0, 27, context.getResources().getString(R.string.m6q17), cell_format));
            sheet_modulo6.addCell(new Label(0, 28, context.getResources().getString(R.string.m6q18), cell_format));
            sheet_modulo6.addCell(new Label(0, 29, context.getResources().getString(R.string.m6q19), cell_format));
            sheet_modulo6.addCell(new Label(0, 30, context.getResources().getString(R.string.m6q20), cell_format));
            sheet_modulo6.addCell(new Label(0, 31, context.getResources().getString(R.string.m6q21), cell_format));
            sheet_modulo6.addCell(new Label(0, 32, context.getResources().getString(R.string.m6q22), cell_format));
            sheet_modulo6.addCell(new Label(0, 33, context.getResources().getString(R.string.m6q23), cell_format));
            sheet_modulo6.addCell(new Label(0, 34, context.getResources().getString(R.string.m6q24), cell_format));
            sheet_modulo6.addCell(new Label(0, 35, context.getResources().getString(R.string.m6q25), cell_format));
            sheet_modulo6.addCell(new Label(0, 36, context.getResources().getString(R.string.m6q26), cell_format));
            sheet_modulo6.addCell(new Label(0, 37, context.getResources().getString(R.string.m6q27), cell_format));
            for (int i = 1; i < 38; i++) {
                sheet_modulo6.addCell(new Label(1, i, main_answers.get(56 + i).resp, cell_format));
            }
            for (int i = 0; i < 38; i++) {
                CellView cell = sheet_modulo6.getColumnView(i);
                cell.setAutosize(true);
                sheet_modulo6.setColumnView(i, cell);
            }




            sheet_modulo_extra.addCell(new Label(0, 0, "Módulo Extra - Respondido fora de casa", cell_format));
            sheet_modulo_extra.addCell(new Label(0, 1, context.getResources().getString(R.string.m7q1), cell_format));
            sheet_modulo_extra.addCell(new Label(0, 4, context.getResources().getString(R.string.m8q1), cell_format));
            sheet_modulo_extra.addCell(new Label(0, 7, context.getResources().getString(R.string.m9q1), cell_format));
            sheet_modulo_extra.addCell(new Label(0, 10, context.getResources().getString(R.string.m10q1), cell_format));
            sheet_modulo_extra.addCell(new Label(0, 13, context.getResources().getString(R.string.m11q1), cell_format));

            sheet_modulo_extra.addCell(new Label(0, 2, main_answers.get(94).resp, cell_format));
            sheet_modulo_extra.addCell(new Label(0, 5, main_answers.get(95).resp, cell_format));
            sheet_modulo_extra.addCell(new Label(0, 8, main_answers.get(96).resp, cell_format));
            sheet_modulo_extra.addCell(new Label(0, 11, main_answers.get(97).resp, cell_format));
            sheet_modulo_extra.addCell(new Label(0, 14, main_answers.get(98).resp, cell_format));

            CellView cell = sheet_modulo_extra.getColumnView(0);
            cell.setAutosize(true);
            sheet_modulo_extra.setColumnView(0, cell);


            workbook.write();
            workbook.close();
            Toast.makeText(context, "Tabela Excel gerada com sucesso!", Toast.LENGTH_LONG).show();

        } catch (IOException | WriteException e) {
            e.printStackTrace();
            Toast.makeText(context, "Erro. Tente novamente.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
