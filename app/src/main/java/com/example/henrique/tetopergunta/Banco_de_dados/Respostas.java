package com.example.henrique.tetopergunta.Banco_de_dados;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.example.henrique.tetopergunta.Banco_de_dados.Respostas.Modulos.MAIN;
import static com.example.henrique.tetopergunta.Banco_de_dados.Respostas.Modulos.MODULO_1;

/**
 * Created by henrique on 09/10/15.
 */
public class Respostas {

    public enum Modulos {MAIN, MODULO_0, MODULO_1, MODULO_2,
        MODULO_3, MODULO_4, MODULO_5, MODULO_6}

    private ArrayList<RespostasInfo> main_answers;
    private LinkedList<ArrayList<RespostasInfo>> mod1_answers;

    private String n_serie;
    private long id = 0;

    public Respostas () {
        main_answers = new ArrayList<>();
        mod1_answers = new LinkedList<>();
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

            case MODULO_1:
                while (mod1_answers.size() <= mod_index)
                    mod1_answers.add(new ArrayList<RespostasInfo>());

                Log.d("size infos", mod1_answers.size() + " " + mod_index + " " +
                        respostasInfo.modulo + " " + respostasInfo.n_questao + " " + respostasInfo.resp);

                if (update) {
                    getRespFromIndex(MODULO_1, respostasInfo.modulo, respostasInfo.n_questao, mod_index).
                            resp = respostasInfo.resp;
                } else
                    mod1_answers.get(mod_index).add(respostasInfo);
                break;

            case MODULO_2:
                break;

            case MODULO_3:
                break;

            case MODULO_4:
                break;

            case MODULO_5:
                break;

            case MODULO_6:
                break;

            default:

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

            case MODULO_3:

            case MODULO_4:

            case MODULO_5:

            case MODULO_6:

            default:
                break;
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
}
