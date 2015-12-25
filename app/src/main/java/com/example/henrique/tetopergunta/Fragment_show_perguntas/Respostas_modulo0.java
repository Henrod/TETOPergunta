package com.example.henrique.tetopergunta.Fragment_show_perguntas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.henrique.tetopergunta.Main.VerDados;
import com.example.henrique.tetopergunta.R;

public class Respostas_modulo0 extends Fragment {

    private View view;
    private Context context;


    public Respostas_modulo0() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_respostas_modulo0, container, false);

        setTextViewsWithData();

        return view;
    }

    private void setTextViewsWithData() {
        String[][] resps = VerDados.respostas.getAnswers();

        ((TextView) view.findViewById(R.id.tv_m0q1)).setText(resps[0][1]);
        ((TextView) view.findViewById(R.id.tv_m0q2)).setText(resps[0][2]);
        ((TextView) view.findViewById(R.id.tv_m0q3)).setText(resps[0][3]);
        ((TextView) view.findViewById(R.id.tv_m0q4)).setText(resps[0][4]);
        ((TextView) view.findViewById(R.id.tv_m0q5)).setText(resps[0][5]);
        ((TextView) view.findViewById(R.id.tv_m0q6)).setText(resps[0][6]);
        ((TextView) view.findViewById(R.id.tv_m0q7)).setText(resps[0][7]);
        ((TextView) view.findViewById(R.id.tv_m0q8)).setText(resps[0][8]);
        ((TextView) view.findViewById(R.id.tv_m0q9)).setText(resps[0][9]);
        ((TextView) view.findViewById(R.id.tv_m0q10)).setText(resps[0][10]);
        ((TextView) view.findViewById(R.id.tv_m0q11)).setText(resps[0][11]);
        ((TextView) view.findViewById(R.id.tv_m0q12)).setText(resps[0][12]);
        ((TextView) view.findViewById(R.id.tv_m0q13)).setText(resps[0][13]);
        ((TextView) view.findViewById(R.id.tv_m0q14)).setText(resps[0][14]);
        ((TextView) view.findViewById(R.id.tv_m0q15)).setText(resps[0][15]);
        ((TextView) view.findViewById(R.id.tv_m0q16)).setText(resps[0][16]);
        ((TextView) view.findViewById(R.id.tv_m0q17)).setText(resps[0][17]);
        ((TextView) view.findViewById(R.id.tv_m0q18)).setText(resps[0][18]);
        ((TextView) view.findViewById(R.id.tv_m0q19)).setText(resps[0][19]);
        ((TextView) view.findViewById(R.id.tv_m0q20)).setText(resps[0][20]);
        ((TextView) view.findViewById(R.id.tv_m0q21)).setText(resps[0][21]);
        ((TextView) view.findViewById(R.id.tv_m0q22)).setText(resps[0][22]);
        ((TextView) view.findViewById(R.id.tv_m0q23)).setText(resps[0][23]);
        ((TextView) view.findViewById(R.id.tv_m0q24)).setText(resps[0][24]);
    }
}
