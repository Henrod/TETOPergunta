package com.example.henrique.tetopergunta.Fragment_show_perguntas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.henrique.tetopergunta.Banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.Banco_de_dados.RespostasInfo;
import com.example.henrique.tetopergunta.Main.VerDados;
import com.example.henrique.tetopergunta.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class Respostas_modulo1 extends Fragment {

    private View view;
    private ViewGroup insertPoint;

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
        insertPoint = (ViewGroup) view.findViewById(R.id.mod1_table);

        setTextViewsWithData(inflater, container);

        return view;
    }

    private void setTextViewsWithData(LayoutInflater inflater, ViewGroup container) {
        ArrayList<RespostasInfo> main_list = VerDados.respostas.getMainAnswers();
        ((TextView) view.findViewById(R.id.tv_m1q10)).setText(main_list.get(24).resp);

        LinkedList<ArrayList<RespostasInfo>> list = VerDados.respostas.
                getModAnswers(Respostas.Modulos.MODULO_1);

        for (ArrayList<RespostasInfo> resps_por_pessoa : list) {
            View new_view = inflater.inflate(R.layout.mod1_child_resps, container, false);
            insertPoint.addView(new_view);

            for (RespostasInfo rInfo : resps_por_pessoa)
                switch (rInfo.n_questao) {
                    case 1:
                        ((TextView) new_view.findViewById(R.id.tv_m1q1)).setText(rInfo.resp);
                        break;
                    case 2:
                        ((TextView) new_view.findViewById(R.id.tv_m1q2)).setText(rInfo.resp);
                        break;
                    case 3:
                        ((TextView) new_view.findViewById(R.id.tv_m1q3)).setText(rInfo.resp);
                        break;
                    case 4:
                        ((TextView) new_view.findViewById(R.id.tv_m1q4)).setText(rInfo.resp);
                        break;
                    case 5:
                        ((TextView) new_view.findViewById(R.id.tv_m1q5)).setText(rInfo.resp);
                        break;
                    case 6:
                        ((TextView) new_view.findViewById(R.id.tv_m1q6)).setText(rInfo.resp);
                        break;
                    case 7:
                        ((TextView) new_view.findViewById(R.id.tv_m1q7)).setText(rInfo.resp);
                        break;
                    case 8:
                        ((TextView) new_view.findViewById(R.id.tv_m1q8)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((TextView) new_view.findViewById(R.id.tv_m1q9)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((TextView) new_view.findViewById(R.id.tv_m1q11)).setText(rInfo.resp);
                        break;
                }
        }
    }
}
