package com.example.henrique.tetopergunta.fragment_show_perguntas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.henrique.tetopergunta.R;
import com.example.henrique.tetopergunta.banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.banco_de_dados.RespostasInfo;
import com.example.henrique.tetopergunta.main.VerDados;

import java.util.ArrayList;
import java.util.LinkedList;

public class Respostas_modulo4 extends Fragment {

    private View view;
    private ViewGroup insertPoint;

    public Respostas_modulo4() {
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
        view = inflater.inflate(R.layout.fragment_respostas_modulo4, container, false);
        insertPoint = (ViewGroup) view.findViewById(R.id.mod4_table);

        for (ArrayList<RespostasInfo> r : VerDados.respostas.getModAnswers(Respostas.Modulos.MODULO_1)) {
            View view = inflater.inflate(R.layout.mod4_child_resps, container, false);
            ((TextView) view.findViewById(R.id.NOME)).setText("NOME: " + r.get(0).resp);
            insertPoint.addView(view);
        }

        setTextViewsWithData();


        return view;
    }

    private void setTextViewsWithData() {
        LinkedList<ArrayList<RespostasInfo>> list = VerDados.respostas.
                getModAnswers(Respostas.Modulos.MODULO_4);

        for (int i = 0; i < insertPoint.getChildCount(); i++) {
            ArrayList<RespostasInfo> resps_por_pessoa = list.get(i);
            View new_view = insertPoint.getChildAt(i);
            //insertPoint.addView(new_view);

            for (RespostasInfo rInfo : resps_por_pessoa)
                switch (rInfo.n_questao) {
                    case 1:
                        ((TextView) new_view.findViewById(R.id.tv_m4q1)).setText(rInfo.resp);
                        break;
                    case 2:
                        ((TextView) new_view.findViewById(R.id.tv_m4q2)).setText(rInfo.resp);
                        break;
                    case 3:
                        ((TextView) new_view.findViewById(R.id.tv_m4q3)).setText(rInfo.resp);
                        break;
                    case 4:
                        ((TextView) new_view.findViewById(R.id.tv_m4q4)).setText(rInfo.resp);
                        break;
                    case 5:
                        ((TextView) new_view.findViewById(R.id.tv_m4q5)).setText(rInfo.resp);
                        break;
                    case 6:
                        ((TextView) new_view.findViewById(R.id.tv_m4q6)).setText(rInfo.resp);
                        break;
                    case 7:
                        ((TextView) new_view.findViewById(R.id.tv_m4q7)).setText(rInfo.resp);
                        break;
                    case 8:
                        ((TextView) new_view.findViewById(R.id.tv_m4q8)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((TextView) new_view.findViewById(R.id.tv_m4q9)).setText(rInfo.resp);
                        break;
                    case 10:
                        ((TextView) new_view.findViewById(R.id.tv_m4q10)).setText(rInfo.resp);
                        break;
                }
        }
    }
}
