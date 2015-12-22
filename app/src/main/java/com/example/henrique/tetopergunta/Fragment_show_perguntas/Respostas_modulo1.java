package com.example.henrique.tetopergunta.Fragment_show_perguntas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.henrique.tetopergunta.Main.VerDados;
import com.example.henrique.tetopergunta.R;

public class Respostas_modulo1 extends Fragment {

    private View view;

    public Respostas_modulo1() {
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
        view = inflater.inflate(R.layout.fragment_respostas_modulo1, container, false);

        setTextViewsWithData();

        return view;
    }

    private void setTextViewsWithData() {
        String[][] resps = VerDados.respostas.getAnswers();

        ((TextView) view.findViewById(R.id.tv_m1q1)).setText(resps[1][1]);
        ((TextView) view.findViewById(R.id.tv_m1q2)).setText(resps[1][2]);
        ((TextView) view.findViewById(R.id.tv_m1q3)).setText(resps[1][3]);
        ((TextView) view.findViewById(R.id.tv_m1q4)).setText(resps[1][4]);
        ((TextView) view.findViewById(R.id.tv_m1q5)).setText(resps[1][5]);

    }
}
