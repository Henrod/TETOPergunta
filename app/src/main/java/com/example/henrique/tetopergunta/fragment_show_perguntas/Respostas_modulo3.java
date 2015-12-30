package com.example.henrique.tetopergunta.fragment_show_perguntas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.henrique.tetopergunta.banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.banco_de_dados.RespostasInfo;
import com.example.henrique.tetopergunta.main.VerDados;
import com.example.henrique.tetopergunta.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class Respostas_modulo3 extends Fragment {

    private View view;
    private ViewGroup insertPoint;

    public Respostas_modulo3() {
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
        view = inflater.inflate(R.layout.fragment_respostas_modulo3, container, false);

        insertPoint = (ViewGroup) view.findViewById(R.id.mod3_table);

        setTextViewsWithData(inflater, container);

        return view;
    }

    private void setTextViewsWithData(LayoutInflater inflater, ViewGroup container) {
        ArrayList<RespostasInfo> main_list = VerDados.respostas.getMainAnswers();
        ((TextView) view.findViewById(R.id.tv_m3q14)).setText(main_list.get(25).resp);
        ((TextView) view.findViewById(R.id.tv_m3q15)).setText(main_list.get(26).resp);
        ((TextView) view.findViewById(R.id.tv_m3q16)).setText(main_list.get(27).resp);
        ((TextView) view.findViewById(R.id.tv_m3q17)).setText(main_list.get(28).resp);
        ((TextView) view.findViewById(R.id.tv_m3q18)).setText(main_list.get(29).resp);

        LinkedList<ArrayList<RespostasInfo>> list = VerDados.respostas.
                getModAnswers(Respostas.Modulos.MODULO_3);

        for (ArrayList<RespostasInfo> resps_por_pessoa : list) {
            View new_view = inflater.inflate(R.layout.mod3_child_resps, container, false);
            insertPoint.addView(new_view);

            for (RespostasInfo rInfo : resps_por_pessoa)
                switch (rInfo.n_questao) {
                    case 1:
                        ((TextView) new_view.findViewById(R.id.tv_m3q1)).setText(rInfo.resp);
                        break;
                    case 2:
                        ((TextView) new_view.findViewById(R.id.tv_m3q2)).setText(rInfo.resp);
                        break;
                    case 3:
                        ((TextView) new_view.findViewById(R.id.tv_m3q3)).setText(rInfo.resp);
                        break;
                    case 4:
                        ((TextView) new_view.findViewById(R.id.tv_m3q4)).setText(rInfo.resp);
                        break;
                    case 5:
                        ((TextView) new_view.findViewById(R.id.tv_m3q5)).setText(rInfo.resp);
                        break;
                    case 6:
                        ((TextView) new_view.findViewById(R.id.tv_m3q6)).setText(rInfo.resp);
                        break;
                    case 7:
                        ((TextView) new_view.findViewById(R.id.tv_m3q7)).setText(rInfo.resp);
                        break;
                    case 8:
                        ((TextView) new_view.findViewById(R.id.tv_m3q8)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((TextView) new_view.findViewById(R.id.tv_m3q9)).setText(rInfo.resp);
                        break;
                    case 10:
                        ((TextView) new_view.findViewById(R.id.tv_m3q10)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((TextView) new_view.findViewById(R.id.tv_m3q11)).setText(rInfo.resp);
                        break;
                    case 12:
                        ((TextView) new_view.findViewById(R.id.tv_m3q12)).setText(rInfo.resp);
                        break;
                }
        }
    }
}
