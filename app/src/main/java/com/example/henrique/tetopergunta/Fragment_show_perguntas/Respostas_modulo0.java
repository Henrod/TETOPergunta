package com.example.henrique.tetopergunta.Fragment_show_perguntas;

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

    }
}
