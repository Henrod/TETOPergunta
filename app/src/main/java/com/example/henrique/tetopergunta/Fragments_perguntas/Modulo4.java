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

public class Modulo4 extends Fragment {

    public ViewGroup insertPoint;
    private View view;

    public Modulo4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_modulo4, container, false);
        insertPoint = (ViewGroup) view.findViewById(R.id.mod4_table);


        view.findViewById(R.id.mod4_add_person).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InserirDados.not_a_new_person = false;
                View new_view = inflater.inflate(R.layout.mod4_child, container, false);
                insertPoint.addView(new_view);
            }
        });

        set_respostas(InserirDados.respostas, inflater, container);

        return view;
    }

    private void set_respostas(Respostas respostas, LayoutInflater inflater, ViewGroup container) {
        LinkedList<ArrayList<RespostasInfo>> mod4_list = respostas.getModAnswers(Respostas.Modulos.MODULO_4);

        for (ArrayList<RespostasInfo> resps : mod4_list) {
            View view = inflater.inflate(R.layout.mod4_child, container, false);
            insertPoint.addView(view);

            for (RespostasInfo rInfo : resps) {
                switch (rInfo.n_questao) {
                    case 1:
                        ((Spinner) view.findViewById(R.id.m4q1)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m4q1), rInfo.resp)
                        );
                        break;
                    case 2:
                        ((Spinner) view.findViewById(R.id.m4q2)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m4q2), rInfo.resp)
                        );
                        break;
                    case 3:
                        ((EditText) view.findViewById(R.id.m4q3)).setText(rInfo.resp);
                        break;
                    case 4:
                        ((Spinner) view.findViewById(R.id.m4q4)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m4q4), rInfo.resp)
                        );
                        break;
                    case 5:
                        ((Spinner) view.findViewById(R.id.m4q5)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m4q5), rInfo.resp)
                        );
                        break;
                    case 6:
                        ((EditText) view.findViewById(R.id.m4q6)).setText(rInfo.resp);
                        break;
                    case 7:
                        ((Spinner) view.findViewById(R.id.m4q7)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m4q7), rInfo.resp)
                        );
                        break;
                    case 8:
                        ((EditText) view.findViewById(R.id.m4q8)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((Spinner) view.findViewById(R.id.m4q9)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m4q9), rInfo.resp)
                        );
                        break;
                    case 10:
                        ((EditText) view.findViewById(R.id.m4q10)).setText(rInfo.resp);
                        break;

                }
            }
        }
    }

    public void save() {
        for (int i = 0; i < insertPoint.getChildCount(); i++) {
            View curr_view = insertPoint.getChildAt(i);

            String[] answers = { "---",
                    ((Spinner) curr_view.findViewById(R.id.m4q1)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m4q2)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m4q3)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m4q4)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m4q5)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m4q6)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m4q7)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m4q8)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m4q9)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m4q10)).getText().toString(),
            };

            for (int j = 1; j < 11; j++) {
                RespostasInfo curr_resp = new RespostasInfo(4, j, answers[j]);

                InserirDados.respostas.setAnswers(
                        curr_resp, Respostas.Modulos.MODULO_4, i,
                        InserirDados.insert_data && InserirDados.not_a_new_person
                );

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
