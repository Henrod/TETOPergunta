package com.example.henrique.tetopergunta.Fragments_perguntas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class Modulo5 extends Fragment {

    View view;

    public Modulo5(){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_modulo5, container, false);
        if (InserirDados.insert_data) set_respostas(InserirDados.respostas);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public boolean save() {
        String[] answers = { "---",
                ((Spinner) view.findViewById(R.id.m5q1)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m5q2)).getSelectedItem().toString(),
                ((EditText) view.findViewById(R.id.m5q3)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q4)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q5)).getText().toString(),
                ((Spinner) view.findViewById(R.id.m5q6)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m5q7)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m5q8)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m5q9)).getSelectedItem().toString(),
                ((EditText) view.findViewById(R.id.m5q10)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q11)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q12)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q13)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q14)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q15)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q16)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q17)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q18)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q19)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q20)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q21)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q22)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q23)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q24)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q25)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q26)).getText().toString(),
                ((EditText) view.findViewById(R.id.m5q27)).getText().toString(),
        };

        for (int i = 1; i < 28; i++) {
            InserirDados.respostas.setAnswers(
                    new RespostasInfo(5, i, answers[i]), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
            );
        }

        return true;
    }

    public void set_respostas(Respostas respostas) {
        ArrayList<RespostasInfo> resps = respostas.getMainAnswers();

        for (RespostasInfo rInfo : resps) {
            if (rInfo.modulo == 0)
                switch (rInfo.n_questao) {
                    case 1:
                        ((Spinner) view.findViewById(R.id.m5q1)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m5q1), rInfo.resp
                        ));
                        break;
                    case 2:
                        ((Spinner) view.findViewById(R.id.m5q2)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m5q2), rInfo.resp
                        ));
                        break;
                    case 3:
                        ((EditText) view.findViewById(R.id.m5q3)).setText(rInfo.resp);
                        break;
                    case 4:
                        ((EditText) view.findViewById(R.id.m5q4)).setText(rInfo.resp);
                        break;
                    case 5:
                        ((EditText) view.findViewById(R.id.m5q5)).setText(rInfo.resp);
                        break;
                    case 6:
                        ((Spinner) view.findViewById(R.id.m5q6)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m5q6), rInfo.resp
                        ));
                        break;
                    case 7:
                        ((Spinner) view.findViewById(R.id.m5q7)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m5q7), rInfo.resp
                        ));
                        break;
                    case 8:
                        ((Spinner) view.findViewById(R.id.m5q8)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m5q8), rInfo.resp
                        ));
                        break;
                    case 9:
                        ((Spinner) view.findViewById(R.id.m5q9)).setSelection(MainActivity.get_position_from_array(
                                getResources().getStringArray(R.array.m5q9), rInfo.resp
                        ));
                        break;
                    case 10:
                        ((EditText) view.findViewById(R.id.m5q10)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((EditText) view.findViewById(R.id.m5q11)).setText(rInfo.resp);
                        break;
                    case 12:
                        ((EditText) view.findViewById(R.id.m5q12)).setText(rInfo.resp);
                        break;
                    case 13:
                        ((EditText) view.findViewById(R.id.m5q13)).setText(rInfo.resp);
                        break;
                    case 14:
                        ((EditText) view.findViewById(R.id.m5q14)).setText(rInfo.resp);
                        break;
                    case 15:
                        ((EditText) view.findViewById(R.id.m5q15)).setText(rInfo.resp);
                        break;
                    case 16:
                        ((EditText) view.findViewById(R.id.m5q16)).setText(rInfo.resp);
                        break;
                    case 17:
                        ((EditText) view.findViewById(R.id.m5q17)).setText(rInfo.resp);
                        break;
                    case 18:
                        ((EditText) view.findViewById(R.id.m5q18)).setText(rInfo.resp);
                        break;
                    case 19:
                        ((EditText) view.findViewById(R.id.m5q19)).setText(rInfo.resp);
                        break;
                    case 20:
                        ((EditText) view.findViewById(R.id.m5q20)).setText(rInfo.resp);
                        break;
                    case 21:
                        ((EditText) view.findViewById(R.id.m5q21)).setText(rInfo.resp);
                        break;
                    case 22:
                        ((EditText) view.findViewById(R.id.m5q22)).setText(rInfo.resp);
                        break;
                    case 23:
                        ((EditText) view.findViewById(R.id.m5q23)).setText(rInfo.resp);
                        break;
                    case 24:
                        ((EditText) view.findViewById(R.id.m5q24)).setText(rInfo.resp);
                        break;
                    case 25:
                        ((EditText) view.findViewById(R.id.m5q25)).setText(rInfo.resp);
                        break;
                    case 26:
                        ((EditText) view.findViewById(R.id.m5q26)).setText(rInfo.resp);
                        break;
                    case 27:
                        ((EditText) view.findViewById(R.id.m5q27)).setText(rInfo.resp);
                        break;
                }
        }
    }
}
