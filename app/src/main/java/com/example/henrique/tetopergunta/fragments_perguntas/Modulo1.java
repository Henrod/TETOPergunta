package com.example.henrique.tetopergunta.fragments_perguntas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.henrique.tetopergunta.R;
import com.example.henrique.tetopergunta.banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.banco_de_dados.RespostasInfo;
import com.example.henrique.tetopergunta.main.InserirDados;
import com.example.henrique.tetopergunta.main.MainActivity;

import java.util.ArrayList;
import java.util.LinkedList;

public class Modulo1 extends Fragment {

    public View view;
    private ViewGroup insertPoint;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_modulo1, container, false);

        insertPoint = (ViewGroup) view.findViewById(R.id.mod1_table);

        view.findViewById(R.id.mod1_add_person).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InserirDados.not_a_new_person = false;
                View view = inflater.inflate(R.layout.mod1_child, container, false);
                insertPoint.addView(view);
            }
        });

        set_respostas(InserirDados.respostas, inflater, container);

        return view;
    }

    public void set_respostas(Respostas respostas, LayoutInflater inflater, ViewGroup container) {
        if (InserirDados.insert_data) {
            ArrayList<RespostasInfo> main_list = respostas.getMainAnswers();
            ((EditText) view.findViewById(R.id.m1q10)).setText(main_list.get(24).resp);
        }

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
                    case 6:
                        ((EditText) view.findViewById(R.id.m1q6)).setText(rInfo.resp);
                        break;
                    case 7:
                        ((Spinner) view.findViewById(R.id.m1q7)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m1q7), rInfo.resp)
                        );
                        break;
                    case 8:
                        ((Spinner) view.findViewById(R.id.m1q8)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m1q8), rInfo.resp)
                        );
                        break;
                    case 9:
                        ((Spinner) view.findViewById(R.id.m1q9)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m1q9), rInfo.resp)
                        );
                        break;
                    case 11:
                        ((EditText) view.findViewById(R.id.m1q11)).setText(rInfo.resp);
                        break;
                }
            }
        }
    }

    public void save() {
        Log.d("CHAMEI", "1 salvo");
        String m1q10 = ((EditText) view.findViewById(R.id.m1q10)).getText().toString();
        InserirDados.respostas.setAnswers(
                new RespostasInfo(1, 10, m1q10), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
        );

        for (int i = 0; i < insertPoint.getChildCount(); i++) {
            View curr_view = insertPoint.getChildAt(i);

            String[] answers = { "---",
                    ((EditText) curr_view.findViewById(R.id.m1q1)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m1q2)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m1q3)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m1q4)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m1q5)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m1q6)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m1q7)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m1q8)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m1q9)).getSelectedItem().toString(),
                    "---",
                    ((EditText) curr_view.findViewById(R.id.m1q11)).getText().toString(),
            };

            for (int j = 1; j < 12; j++) {
                if (j != 10) {
                    RespostasInfo curr_resp = new RespostasInfo(1, j, answers[j]);

                    InserirDados.respostas.setAnswers(
                            curr_resp, Respostas.Modulos.MODULO_1, i,
                            InserirDados.insert_data && InserirDados.not_a_new_person
                    );
                }
            }
        }
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
}
