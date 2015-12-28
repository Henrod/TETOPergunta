package com.example.henrique.tetopergunta.Fragments_perguntas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class Modulo2 extends Fragment {

    LayoutInflater inflater;
    public ViewGroup insertPoint;
    ViewGroup container;
    View view;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;

        view = inflater.inflate(R.layout.activity_modulo2, container, false);

        insertPoint = (ViewGroup) view.findViewById(R.id.mod2_table);

        view.findViewById(R.id.mod2_add_person).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InserirDados.not_a_new_person = false;
                View view = inflater.inflate(R.layout.mod2_child, container, false);
                insertPoint.addView(view);
            }
        });

        set_respostas(InserirDados.respostas, inflater, container);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        save();
    }

    @Override
    public void onStop() {
        super.onStop();
        save();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        save();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        save();
    }

    public void save() {
        for (int i = 0; i < insertPoint.getChildCount(); i++) {
            View curr_view = insertPoint.getChildAt(i);

            String[] answers = { "---",
                    ((Spinner) curr_view.findViewById(R.id.m2q1)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m2q2)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m2q3)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m2q4)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m2q5)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m2q6)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m2q7)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m2q8)).getSelectedItem().toString(),
            };

            for (int j = 1; j < 9; j++) {
                RespostasInfo curr_resp = new RespostasInfo(2, j, answers[j]);

                InserirDados.respostas.setAnswers(
                        curr_resp, Respostas.Modulos.MODULO_2, i,
                        InserirDados.insert_data && InserirDados.not_a_new_person
                );

            }
        }
    }

    private void set_respostas(Respostas respostas, LayoutInflater inflater, ViewGroup container) {

        LinkedList<ArrayList<RespostasInfo>> mod2_list = respostas.getModAnswers(Respostas.Modulos.MODULO_2);

        for (ArrayList<RespostasInfo> resps : mod2_list) {
            View view = inflater.inflate(R.layout.mod2_child, container, false);
            insertPoint.addView(view);

            for (RespostasInfo rInfo : resps) {
                switch (rInfo.n_questao) {
                    case 1:
                        ((Spinner) view.findViewById(R.id.m2q1)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m2q1), rInfo.resp)
                        );
                        break;
                    case 2:
                        ((Spinner) view.findViewById(R.id.m2q2)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m2q2), rInfo.resp)
                        );
                        break;
                    case 3:
                        ((Spinner) view.findViewById(R.id.m2q3)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m2q3), rInfo.resp)
                        );
                        break;
                    case 4:
                        ((Spinner) view.findViewById(R.id.m2q4)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m2q4), rInfo.resp)
                        );
                        break;
                    case 5:
                        ((Spinner) view.findViewById(R.id.m2q5)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m2q5), rInfo.resp)
                        );
                        break;
                    case 6:
                        ((EditText) view.findViewById(R.id.m2q6)).setText(rInfo.resp);
                        break;
                    case 7:
                        ((Spinner) view.findViewById(R.id.m2q7)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m2q7), rInfo.resp)
                        );
                        break;
                    case 8:
                        ((Spinner) view.findViewById(R.id.m2q8)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m2q8), rInfo.resp)
                        );
                        break;
                }
            }
        }
    }
}
