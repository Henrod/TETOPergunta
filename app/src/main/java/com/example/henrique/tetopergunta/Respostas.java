package com.example.henrique.tetopergunta;

/**
 * Created by henrique on 09/10/15.
 */
public class Respostas {

    private long id;
    private String[] respostas;
    private int numeroQuestoes = 10;

    public Respostas() {
        respostas = new String[numeroQuestoes];
    }

    public void setResposta(int index, String resposta) {
        id = 0;
        respostas[index] = resposta;
    }

    public String[] getRespostas() {
        return respostas;
    }

    public int getNumeroQuestoes() {
        return numeroQuestoes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}
