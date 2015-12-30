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
        ArrayList<RespostasInfo> resps = VerDados.respostas.getMainAnswers();

        for (RespostasInfo rInfo : resps) {
            if (rInfo.modulo == 0)
                switch (rInfo.n_questao) {
                    case 1:
                        ((TextView) view.findViewById(R.id.tv_m0q1)).setText(rInfo.resp);
                        break;
                    case 2:
                        ((TextView) view.findViewById(R.id.tv_m0q2)).setText(rInfo.resp);
                        break;
                    case 3:
                        ((TextView) view.findViewById(R.id.tv_m0q3)).setText(rInfo.resp);
                        break;
                    case 4:
                        ((TextView) view.findViewById(R.id.tv_m0q4)).setText(rInfo.resp);
                        break;
                    case 5:
                        ((TextView) view.findViewById(R.id.tv_m0q5)).setText(rInfo.resp);
                        break;
                    case 6:
                        ((TextView) view.findViewById(R.id.tv_m0q6)).setText(rInfo.resp);
                        break;
                    case 7:
                        ((TextView) view.findViewById(R.id.tv_m0q7)).setText(rInfo.resp);
                        break;
                    case 8:
                        ((TextView) view.findViewById(R.id.tv_m0q8)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((TextView) view.findViewById(R.id.tv_m0q9)).setText(rInfo.resp);
                        break;
                    case 10:
                        ((TextView) view.findViewById(R.id.tv_m0q10)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((TextView) view.findViewById(R.id.tv_m0q11)).setText(rInfo.resp);
                        break;
                    case 12:
                        ((TextView) view.findViewById(R.id.tv_m0q12)).setText(rInfo.resp);
                        break;
                    case 13:
                        ((TextView) view.findViewById(R.id.tv_m0q13)).setText(rInfo.resp);
                        break;
                    case 14:
                        ((TextView) view.findViewById(R.id.tv_m0q14)).setText(rInfo.resp);
                        break;
                    case 15:
                        ((TextView) view.findViewById(R.id.tv_m0q15)).setText(rInfo.resp);
                        break;
                    case 16:
                        ((TextView) view.findViewById(R.id.tv_m0q16)).setText(rInfo.resp);
                        break;
                    case 17:
                        ((TextView) view.findViewById(R.id.tv_m0q17)).setText(rInfo.resp);
                        break;
                    case 18:
                        ((TextView) view.findViewById(R.id.tv_m0q18)).setText(rInfo.resp);
                        break;
                    case 19:
                        ((TextView) view.findViewById(R.id.tv_m0q19)).setText(rInfo.resp);
                        break;
                    case 20:
                        ((TextView) view.findViewById(R.id.tv_m0q20)).setText(rInfo.resp);
                        break;
                    case 21:
                        ((TextView) view.findViewById(R.id.tv_m0q21)).setText(rInfo.resp);
                        break;
                    case 22:
                        ((TextView) view.findViewById(R.id.tv_m0q22)).setText(rInfo.resp);
                        break;
                    case 23:
                        ((TextView) view.findViewById(R.id.tv_m0q23)).setText(rInfo.resp);
                        break;
                    case 24:
                        ((TextView) view.findViewById(R.id.tv_m0q24)).setText(rInfo.resp);
                        break;
                }
        }
    }
}
