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


public class Respostas_modulo6 extends Fragment {

    private View view;

    public Respostas_modulo6() {
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
        view = inflater.inflate(R.layout.fragment_respostas_modulo6, container, false);

        setTextViewsWithData();

        return view;
    }

    private void setTextViewsWithData() {
        ArrayList<RespostasInfo> resps = VerDados.respostas.getMainAnswers();

        for (RespostasInfo rInfo : resps) {
            if (rInfo.modulo == 6)
                switch (rInfo.n_questao) {
                    case 1:
                        ((TextView) view.findViewById(R.id.tv_m6q1)).setText(rInfo.resp);
                        break;
                    case 2:
                        ((TextView) view.findViewById(R.id.tv_m6q2)).setText(rInfo.resp);
                        break;
                    case 3:
                        ((TextView) view.findViewById(R.id.tv_m6q3)).setText(rInfo.resp);
                        break;
                    case 4:
                        ((TextView) view.findViewById(R.id.tv_m6q4)).setText(rInfo.resp);
                        break;
                    case 5:
                        ((TextView) view.findViewById(R.id.tv_m6q5)).setText(rInfo.resp);
                        break;
                    case 6:
                        ((TextView) view.findViewById(R.id.tv_m6q6)).setText(rInfo.resp);
                        break;
                    case 7:
                        ((TextView) view.findViewById(R.id.tv_m6q7)).setText(rInfo.resp);
                        break;
                    case 8:
                        ((TextView) view.findViewById(R.id.tv_m6q8)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((TextView) view.findViewById(R.id.tv_m6q9)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((TextView) view.findViewById(R.id.tv_m6q11)).setText(rInfo.resp);
                        break;
                    case 12:
                        ((TextView) view.findViewById(R.id.tv_m6q12)).setText(rInfo.resp);
                        break;
                    case 13:
                        ((TextView) view.findViewById(R.id.tv_m6q13)).setText(rInfo.resp);
                        break;
                    case 14:
                        ((TextView) view.findViewById(R.id.tv_m6q14)).setText(rInfo.resp);
                        break;
                    case 15:
                        ((TextView) view.findViewById(R.id.tv_m6q15)).setText(rInfo.resp);
                        break;
                    case 16:
                        ((TextView) view.findViewById(R.id.tv_m6q16)).setText(rInfo.resp);
                        break;
                    case 17:
                        ((TextView) view.findViewById(R.id.tv_m6q17)).setText(rInfo.resp);
                        break;
                    case 18:
                        ((TextView) view.findViewById(R.id.tv_m6q18)).setText(rInfo.resp);
                        break;
                    case 19:
                        ((TextView) view.findViewById(R.id.tv_m6q19)).setText(rInfo.resp);
                        break;
                    case 20:
                        ((TextView) view.findViewById(R.id.tv_m6q20)).setText(rInfo.resp);
                        break;
                    case 21:
                        ((TextView) view.findViewById(R.id.tv_m6q21)).setText(rInfo.resp);
                        break;
                    case 22:
                        ((TextView) view.findViewById(R.id.tv_m6q22)).setText(rInfo.resp);
                        break;
                    case 23:
                        ((TextView) view.findViewById(R.id.tv_m6q23)).setText(rInfo.resp);
                        break;
                    case 24:
                        ((TextView) view.findViewById(R.id.tv_m6q24)).setText(rInfo.resp);
                        break;
                    case 25:
                        ((TextView) view.findViewById(R.id.tv_m6q25)).setText(rInfo.resp);
                        break;
                    case 26:
                        ((TextView) view.findViewById(R.id.tv_m6q26)).setText(rInfo.resp);
                        break;
                    case 27:
                        ((TextView) view.findViewById(R.id.tv_m6q27)).setText(rInfo.resp);
                        break;
                    case 28:
                        ((TextView) view.findViewById(R.id.tv_m6q28)).setText(rInfo.resp);
                        break;
                    case 101:
                        ((TextView) view.findViewById(R.id.tv_m6q101)).setText(rInfo.resp);
                        break;
                    case 102:
                        ((TextView) view.findViewById(R.id.tv_m6q102)).setText(rInfo.resp);
                        break;
                    case 103:
                        ((TextView) view.findViewById(R.id.tv_m6q103)).setText(rInfo.resp);
                        break;
                    case 104:
                        ((TextView) view.findViewById(R.id.tv_m6q104)).setText(rInfo.resp);
                        break;
                    case 105:
                        ((TextView) view.findViewById(R.id.tv_m6q105)).setText(rInfo.resp);
                        break;
                    case 106:
                        ((TextView) view.findViewById(R.id.tv_m6q106)).setText(rInfo.resp);
                        break;
                    case 107:
                        ((TextView) view.findViewById(R.id.tv_m6q107)).setText(rInfo.resp);
                        break;
                    case 108:
                        ((TextView) view.findViewById(R.id.tv_m6q108)).setText(rInfo.resp);
                        break;
                    case 109:
                        ((TextView) view.findViewById(R.id.tv_m6q109)).setText(rInfo.resp);
                        break;
                    case 110:
                        ((TextView) view.findViewById(R.id.tv_m6q1010)).setText(rInfo.resp);
                        break;
                }
        }
    }
}
