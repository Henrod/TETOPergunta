package com.example.henrique.tetopergunta.Banco_de_dados;

/**
 * Created by henrique on 26/12/15.
 */
public class RespostasInfo {
    public int modulo, n_questao;
    public String resp;

    public RespostasInfo(int modulo, int n_questao, String resp) {
        this.modulo = modulo;
        this.n_questao = n_questao;
        this.resp = resp;
    }
}
