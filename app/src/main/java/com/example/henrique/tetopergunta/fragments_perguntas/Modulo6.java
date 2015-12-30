package com.example.henrique.tetopergunta.fragments_perguntas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.henrique.tetopergunta.banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.banco_de_dados.RespostasInfo;
import com.example.henrique.tetopergunta.main.InserirDados;
import com.example.henrique.tetopergunta.main.MainActivity;
import com.example.henrique.tetopergunta.R;

import java.util.ArrayList;

public class Modulo6 extends Fragment {

    View view;

    public Modulo6(){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_modulo6, container, false);
        if (InserirDados.insert_data) set_respostas(InserirDados.respostas);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public boolean save() {
        {
            String[] answers = {"---",
                    ((EditText) view.findViewById(R.id.m6q1)).getText().toString(),
                    ((Spinner) view.findViewById(R.id.m6q2)).getSelectedItem().toString(),
                    ((Spinner) view.findViewById(R.id.m6q3)).getSelectedItem().toString(),
                    ((EditText) view.findViewById(R.id.m6q4)).getText().toString(),
                    ((EditText) view.findViewById(R.id.m6q5)).getText().toString(),
                    ((Spinner) view.findViewById(R.id.m6q6)).getSelectedItem().toString(),
                    ((EditText) view.findViewById(R.id.m6q7)).getText().toString(),
                    ((EditText) view.findViewById(R.id.m6q8)).getText().toString(),
                    ((EditText) view.findViewById(R.id.m6q9)).getText().toString(),
                    "---",
                    ((EditText) view.findViewById(R.id.m6q11)).getText().toString(),
                    ((EditText) view.findViewById(R.id.m6q12)).getText().toString(),
                    ((Spinner) view.findViewById(R.id.m6q13)).getSelectedItem().toString(),
                    ((EditText) view.findViewById(R.id.m6q14)).getText().toString(),
                    ((EditText) view.findViewById(R.id.m6q15)).getText().toString(),
                    ((EditText) view.findViewById(R.id.m6q16)).getText().toString(),
                    ((EditText) view.findViewById(R.id.m6q17)).getText().toString(),
                    ((Spinner) view.findViewById(R.id.m6q18)).getSelectedItem().toString(),
                    ((Spinner) view.findViewById(R.id.m6q19)).getSelectedItem().toString(),
                    ((EditText) view.findViewById(R.id.m6q20)).getText().toString(),
                    ((Spinner) view.findViewById(R.id.m6q21)).getSelectedItem().toString(),
                    ((EditText) view.findViewById(R.id.m6q22)).getText().toString(),
                    ((Spinner) view.findViewById(R.id.m6q23)).getSelectedItem().toString(),
                    ((Spinner) view.findViewById(R.id.m6q24)).getSelectedItem().toString(),
                    ((Spinner) view.findViewById(R.id.m6q25)).getSelectedItem().toString(),
                    ((EditText) view.findViewById(R.id.m6q26)).getText().toString(),
                    ((Spinner) view.findViewById(R.id.m6q27)).getSelectedItem().toString(),
                    ((EditText) view.findViewById(R.id.m6q28)).getText().toString(),
            };

            for (int i = 1; i < 29; i++) {
                if (i != 10) {
                    InserirDados.respostas.setAnswers(
                            new RespostasInfo(6, i, answers[i]), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
                    );
                }
            }
        }

        String[] answers = {"---",
                ((Spinner) view.findViewById(R.id.m6q101)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m6q102)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m6q103)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m6q104)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m6q105)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m6q106)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m6q107)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m6q108)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m6q109)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m6q1010)).getSelectedItem().toString(),
        };

        for (int i = 1; i < 11; i++) {
            InserirDados.respostas.setAnswers(
                    new RespostasInfo(6, i + 100, answers[i]), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
            );
        }

        return true;
    }

    public void set_respostas(Respostas respostas) {
        ArrayList<RespostasInfo> resps = respostas.getMainAnswers();

        for (RespostasInfo rInfo : resps) {
            if (rInfo.modulo == 6)
                switch (rInfo.n_questao) {
                    case 1:
                        ((EditText) view.findViewById(R.id.m6q1)).setText(rInfo.resp);
                        break;
                    case 2:
                        ((Spinner) view.findViewById(R.id.m6q2)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q2), rInfo.resp
                        ));
                        break;
                    case 3:
                        ((Spinner) view.findViewById(R.id.m6q3)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q3), rInfo.resp
                        ));
                        break;
                    case 4:
                        ((EditText) view.findViewById(R.id.m6q4)).setText(rInfo.resp);
                        break;
                    case 5:
                        ((EditText) view.findViewById(R.id.m6q5)).setText(rInfo.resp);
                        break;
                    case 6:
                        ((Spinner) view.findViewById(R.id.m6q6)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q6), rInfo.resp
                        ));
                        break;
                    case 7:
                        ((EditText) view.findViewById(R.id.m6q7)).setText(rInfo.resp);
                        break;
                    case 8:
                        ((EditText) view.findViewById(R.id.m6q8)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((EditText) view.findViewById(R.id.m6q9)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((EditText) view.findViewById(R.id.m6q11)).setText(rInfo.resp);
                        break;
                    case 12:
                        ((EditText) view.findViewById(R.id.m6q12)).setText(rInfo.resp);
                        break;
                    case 13:
                        ((Spinner) view.findViewById(R.id.m6q13)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q13), rInfo.resp
                        ));
                        break;
                    case 14:
                        ((EditText) view.findViewById(R.id.m6q14)).setText(rInfo.resp);
                        break;
                    case 15:
                        ((EditText) view.findViewById(R.id.m6q15)).setText(rInfo.resp);
                        break;
                    case 16:
                        ((EditText) view.findViewById(R.id.m6q16)).setText(rInfo.resp);
                        break;
                    case 17:
                        ((EditText) view.findViewById(R.id.m6q17)).setText(rInfo.resp);
                        break;
                    case 18:
                        ((Spinner) view.findViewById(R.id.m6q18)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q18), rInfo.resp
                        ));
                        break;
                    case 19:
                        ((Spinner) view.findViewById(R.id.m6q19)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q19), rInfo.resp
                        ));
                        break;
                    case 20:
                        ((EditText) view.findViewById(R.id.m6q20)).setText(rInfo.resp);
                        break;
                    case 21:
                        ((Spinner) view.findViewById(R.id.m6q21)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q21), rInfo.resp
                        ));
                        break;
                    case 22:
                        ((EditText) view.findViewById(R.id.m6q22)).setText(rInfo.resp);
                        break;
                    case 23:
                        ((Spinner) view.findViewById(R.id.m6q23)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q23), rInfo.resp
                        ));
                        break;
                    case 24:
                        ((Spinner) view.findViewById(R.id.m6q24)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q24), rInfo.resp
                        ));
                        break;
                    case 25:
                        ((Spinner) view.findViewById(R.id.m6q25)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q25), rInfo.resp
                        ));
                        break;
                    case 26:
                        ((EditText) view.findViewById(R.id.m6q26)).setText(rInfo.resp);
                        break;
                    case 27:
                        ((Spinner) view.findViewById(R.id.m6q27)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q27), rInfo.resp
                        ));
                        break;
                    case 28:
                        ((EditText) view.findViewById(R.id.m6q28)).setText(rInfo.resp);
                        break;
                    case 101:
                        ((Spinner) view.findViewById(R.id.m6q101)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                    case 102:
                        ((Spinner) view.findViewById(R.id.m6q102)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                    case 103:
                        ((Spinner) view.findViewById(R.id.m6q103)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                    case 104:
                        ((Spinner) view.findViewById(R.id.m6q104)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                    case 105:
                        ((Spinner) view.findViewById(R.id.m6q105)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                    case 106:
                        ((Spinner) view.findViewById(R.id.m6q106)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                    case 107:
                        ((Spinner) view.findViewById(R.id.m6q107)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                    case 108:
                        ((Spinner) view.findViewById(R.id.m6q108)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                    case 109:
                        ((Spinner) view.findViewById(R.id.m6q109)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                    case 110:
                        ((Spinner) view.findViewById(R.id.m6q1010)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m6q10), rInfo.resp
                        ));
                        break;
                }
        }
    }
}
