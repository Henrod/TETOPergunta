package com.example.henrique.tetopergunta.fragment_show_perguntas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.henrique.tetopergunta.banco_de_dados.RespostasInfo;
import com.example.henrique.tetopergunta.main.VerDados;
import com.example.henrique.tetopergunta.R;

import java.util.ArrayList;


public class Respostas_moduloExtra extends Fragment {

    private View view;

    public Respostas_moduloExtra() {
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
        view = inflater.inflate(R.layout.fragment_respostas_modulo_extra, container, false);

        setTextViewsWithData();

        return view;
    }

    private void setTextViewsWithData() {
        ArrayList<RespostasInfo> resps = VerDados.respostas.getMainAnswers();

        for (RespostasInfo rInfo : resps) {
                switch (rInfo.modulo) {
                    case 7:
                        ((TextView) view.findViewById(R.id.tv_m7q1)).setText(rInfo.resp);
                        break;
                    case 8:
                        ((TextView) view.findViewById(R.id.tv_m8q1)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((TextView) view.findViewById(R.id.tv_m9q1)).setText(rInfo.resp);
                        break;
                    case 10:
                        ((TextView) view.findViewById(R.id.tv_m10q1)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((TextView) view.findViewById(R.id.tv_m11q1)).setText(rInfo.resp);
                        break;
                }
        }
    }
}
