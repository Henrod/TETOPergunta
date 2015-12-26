package com.example.henrique.tetopergunta.Fragments_perguntas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.henrique.tetopergunta.Banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.Banco_de_dados.RespostasInfo;
import com.example.henrique.tetopergunta.Main.InserirDados;
import com.example.henrique.tetopergunta.Main.MainActivity;
import com.example.henrique.tetopergunta.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class Modulo1 extends Fragment {

    private View view;
    private ViewGroup insertPoint;
    private Respostas _respostas;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_modulo1, container, false);

        insertPoint = (ViewGroup) view.findViewById(R.id.mod1_table);

        view.findViewById(R.id.mod1_add_person).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = inflater.inflate(R.layout.mod1_child, container, false);
                insertPoint.addView(view);
            }
        });

        if (InserirDados.insert_data) set_respostas(InserirDados.respostas, inflater, container);

        return view;
    }

    public void set_respostas(Respostas respostas, LayoutInflater inflater, ViewGroup container) {
        LinkedList<ArrayList<RespostasInfo>> mod1_list = respostas.getModAnswers(Respostas.Modulos.MODULO_1);

        for (ArrayList<RespostasInfo> resps : mod1_list) {
            View view = inflater.inflate(R.layout.mod1_child, container, false);
            insertPoint.addView(view);

            for (RespostasInfo rInfo : resps) {
                switch (rInfo.n_questao) {
                    case 1:
                        ((EditText) view.findViewById(R.id.m1q1)).setText(rInfo.resp);
                        break;
                    case 2:
                        ((Spinner) view.findViewById(R.id.m1q2)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m1q2), rInfo.resp)
                        );
                        break;
                    case 3:
                        ((Spinner) view.findViewById(R.id.m1q3)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m1q3), rInfo.resp)
                        );
                        break;
                    case 4:
                        ((EditText) view.findViewById(R.id.m1q4)).setText(rInfo.resp);
                        break;
                    case 5:
                        ((Spinner) view.findViewById(R.id.m1q5)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m1q5), rInfo.resp)
                        );
                        break;
                }
            }
        }
    }

    public void save() {
        for (int i = 1; i < insertPoint.getChildCount(); i++) {
            View curr_view = insertPoint.getChildAt(i);

            Log.d("size mod1 a salvar", String.valueOf(InserirDados.respostas.getModAnswers(Respostas.Modulos.MODULO_1).size()));

            String[] answers = { "---",
                    ((EditText) curr_view.findViewById(R.id.m1q1)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m1q2)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m1q3)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m1q4)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m1q5)).getSelectedItem().toString(),
            };

            for (int j = 1; j < 6; j++) {
                InserirDados.respostas.setAnswers(
                        new RespostasInfo(1, j, answers[j]), Respostas.Modulos.MODULO_1, i - 1, InserirDados.insert_data
                );
            }
        }
    }

}
