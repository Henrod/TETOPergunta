package com.example.henrique.tetopergunta.Banco_de_dados;

/**
 * Created by henrique on 09/10/15.
 */
public class Respostas {

    final public static int[] QUESTIONS_PER_MODULE  = {20, 10, 8, 18, 10, 9, 28 };
    final public static int MODULES = 7;
    final public static int MAX_N_QUESTIONS = 28;

    private String[][] answers;
    private long id = 0;

    public Respostas() {
        // (módulo, questão)
        answers = new String[MODULES + 1][MAX_N_QUESTIONS+ 1];
    }

    public void setAnswers(int mod, String[] answers_array) {
        for (int i = 1; i < answers_array.length; i++)
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
