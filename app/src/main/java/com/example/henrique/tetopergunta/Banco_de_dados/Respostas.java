package com.example.henrique.tetopergunta.Banco_de_dados;

/**
 * Created by henrique on 09/10/15.
 */
public class Respostas {

    final public static int QUESTIONS_PER_MODULE  = 10;
    final public static int MODULES               = 6;

    private String[][] answers;
    private long id = 0;

    public Respostas() {
        // (módulo, questão)
        answers = new String[MODULES + 1][QUESTIONS_PER_MODULE + 1];
    }

    public void setAnswers(int mod, String[] answers_array) {
        //TODO: TROCAR 6 POR QUESTIONS_PER_MODULE
        for (int i = 1; i < 6; i++)
            answers[mod][i] = answers_array[i];
    }

    public String[][] getAnswers() {
        return answers;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return this.id;
    }
}
