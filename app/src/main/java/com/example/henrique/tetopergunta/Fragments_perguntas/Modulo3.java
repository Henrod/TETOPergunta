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

public class Modulo3 extends Fragment {

    public ViewGroup insertPoint;
    private View view;

    public Modulo3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_modulo3, container, false);
        insertPoint = (ViewGroup) view.findViewById(R.id.mod3_table);


        view.findViewById(R.id.mod3_add_person).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InserirDados.not_a_new_person = false;
                View new_view = inflater.inflate(R.layout.mod3_child, container, false);
                insertPoint.addView(new_view);
            }
        });

        set_respostas(InserirDados.respostas, inflater, container);

        return view;
    }

    private void set_respostas(Respostas respostas, LayoutInflater inflater, ViewGroup container) {
        if (InserirDados.insert_data) {
            ArrayList<RespostasInfo> main_list = respostas.getMainAnswers();
            ((Spinner) view.findViewById(R.id.m3q14)).setSelection(MainActivity.get_position_from_array(
                    getResources().getStringArray(R.array.m3q14), main_list.get(25).resp
            ));
            ((Spinner) view.findViewById(R.id.m3q15)).setSelection(MainActivity.get_position_from_array(
                    getResources().getStringArray(R.array.m3q14), main_list.get(26).resp
            ));
            ((Spinner) view.findViewById(R.id.m3q16)).setSelection(MainActivity.get_position_from_array(
                    getResources().getStringArray(R.array.m3q14), main_list.get(27).resp
            ));
            ((Spinner) view.findViewById(R.id.m3q17)).setSelection(MainActivity.get_position_from_array(
                    getResources().getStringArray(R.array.m3q14), main_list.get(28).resp
            ));
            ((Spinner) view.findViewById(R.id.m3q18)).setSelection(MainActivity.get_position_from_array(
                    getResources().getStringArray(R.array.m3q14), main_list.get(29).resp
            ));
        }

        LinkedList<ArrayList<RespostasInfo>> mod3_list = respostas.getModAnswers(Respostas.Modulos.MODULO_3);

        for (ArrayList<RespostasInfo> resps : mod3_list) {
            View view = inflater.inflate(R.layout.mod3_child, container, false);
            insertPoint.addView(view);

            for (RespostasInfo rInfo : resps) {
                switch (rInfo.n_questao) {
                    case 1:
                        ((EditText) view.findViewById(R.id.m3q1)).setText(rInfo.resp);
                        break;
                    case 2:
                        ((Spinner) view.findViewById(R.id.m3q2)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m3q2), rInfo.resp)
                        );
                        break;
                    case 3:
                        ((Spinner) view.findViewById(R.id.m3q3)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m3q3), rInfo.resp)
                        );
                        break;
                    case 4:
                        ((Spinner) view.findViewById(R.id.m3q4)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m3q4), rInfo.resp)
                        );
                        break;
                    case 5:
                        ((Spinner) view.findViewById(R.id.m3q5)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m3q5), rInfo.resp)
                        );
                        break;
                    case 6:
                        ((Spinner) view.findViewById(R.id.m3q6)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m3q6), rInfo.resp)
                        );
                        break;
                    case 7:
                        ((Spinner) view.findViewById(R.id.m3q7)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m3q7), rInfo.resp)
                        );
                        break;
                    case 8:
                        ((EditText) view.findViewById(R.id.m3q8)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((Spinner) view.findViewById(R.id.m3q9)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m3q9), rInfo.resp)
                        );
                        break;
                    case 10:
                        ((EditText) view.findViewById(R.id.m3q10)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((Spinner) view.findViewById(R.id.m3q11)).setSelection(
                                MainActivity.get_position_from_array(
                                        getResources().getStringArray(R.array.m3q11), rInfo.resp)
                        );
                        break;
                    case 12:
                        ((EditText) view.findViewById(R.id.m3q12)).setText(rInfo.resp);
                        break;
                }
            }
        }
    }

    public void save() {
        String m3 = ((Spinner) view.findViewById(R.id.m3q14)).getSelectedItem().toString();
        InserirDados.respostas.setAnswers(
                new RespostasInfo(3, 14, m3), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
        );
        m3 = ((Spinner) view.findViewById(R.id.m3q15)).getSelectedItem().toString();
        InserirDados.respostas.setAnswers(
                new RespostasInfo(3, 15, m3), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
        );
        m3 = ((Spinner) view.findViewById(R.id.m3q16)).getSelectedItem().toString();
        InserirDados.respostas.setAnswers(
                new RespostasInfo(3, 16, m3), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
        );
        m3 = ((Spinner) view.findViewById(R.id.m3q17)).getSelectedItem().toString();
        InserirDados.respostas.setAnswers(
                new RespostasInfo(3, 17, m3), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
        );
        m3 = ((Spinner) view.findViewById(R.id.m3q18)).getSelectedItem().toString();
        InserirDados.respostas.setAnswers(
                new RespostasInfo(3, 18, m3), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
        );

        for (int i = 0; i < insertPoint.getChildCount(); i++) {
            View curr_view = insertPoint.getChildAt(i);

            String[] answers = { "---",
                    ((EditText) curr_view.findViewById(R.id.m3q1)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m3q2)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m3q3)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m3q4)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m3q5)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m3q6)).getSelectedItem().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m3q7)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m3q8)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m3q9)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m3q10)).getText().toString(),
                    ((Spinner) curr_view.findViewById(R.id.m3q11)).getSelectedItem().toString(),
                    ((EditText) curr_view.findViewById(R.id.m3q12)).getText().toString(),
            };

            for (int j = 1; j < 13; j++) {
                RespostasInfo curr_resp = new RespostasInfo(3, j, answers[j]);

                InserirDados.respostas.setAnswers(
                        curr_resp, Respostas.Modulos.MODULO_3, i,
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
