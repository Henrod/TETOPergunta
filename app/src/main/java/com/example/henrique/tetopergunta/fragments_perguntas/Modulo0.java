package com.example.henrique.tetopergunta.fragments_perguntas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
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

public class Modulo0 extends Fragment {

    View view;

    public Modulo0(){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_modulo0, container, false);
        if (InserirDados.insert_data) set_respostas(InserirDados.respostas);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public boolean save() {
        String n_serie;
        {
            Editable _n_serie = ((EditText) view.findViewById(R.id.m0q1)).getText();
            if (_n_serie == null) return false;
            n_serie = _n_serie.toString();
        }

        if (!InserirDados.insert_data && (n_serie.equals("")  ||
                MainActivity.data_handler.retrieve(n_serie).getNSerie() != null)) {
            return false;
        }

        String[] answers = { "---",
                n_serie,
                ((EditText) view.findViewById(R.id.m0q2)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q3)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q4)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q5)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q6)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q7)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q8)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q9)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q10)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q11)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q12)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q13)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q14)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q15)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q16)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q17)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q18)).getText().toString(),
                ((Spinner)  view.findViewById(R.id.m0q19)).getSelectedItem().toString(),
                ((EditText) view.findViewById(R.id.m0q20)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q21)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q22)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q23)).getText().toString(),
                ((EditText) view.findViewById(R.id.m0q24)).getText().toString(),
        };

        InserirDados.respostas.setNSerie(n_serie);

        for (int i = 1; i < 25; i++) {
            InserirDados.respostas.setAnswers(
                    new RespostasInfo(0, i, answers[i]), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
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
                        ((EditText) view.findViewById(R.id.m0q1)).setText(rInfo.resp);
                        break;
                    case 2:
                        ((EditText) view.findViewById(R.id.m0q2)).setText(rInfo.resp);
                        break;
                    case 3:
                        ((EditText) view.findViewById(R.id.m0q3)).setText(rInfo.resp);
                        break;
                    case 4:
                        ((EditText) view.findViewById(R.id.m0q4)).setText(rInfo.resp);
                        break;
                    case 5:
                        ((EditText) view.findViewById(R.id.m0q5)).setText(rInfo.resp);
                        break;
                    case 6:
                        ((EditText) view.findViewById(R.id.m0q6)).setText(rInfo.resp);
                        break;
                    case 7:
                        ((EditText) view.findViewById(R.id.m0q7)).setText(rInfo.resp);
                        break;
                    case 8:
                        ((EditText) view.findViewById(R.id.m0q8)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((EditText) view.findViewById(R.id.m0q9)).setText(rInfo.resp);
                        break;
                    case 10:
                        ((EditText) view.findViewById(R.id.m0q10)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((EditText) view.findViewById(R.id.m0q11)).setText(rInfo.resp);
                        break;
                    case 12:
                        ((EditText) view.findViewById(R.id.m0q12)).setText(rInfo.resp);
                        break;
                    case 13:
                        ((EditText) view.findViewById(R.id.m0q13)).setText(rInfo.resp);
                        break;
                    case 14:
                        ((EditText) view.findViewById(R.id.m0q14)).setText(rInfo.resp);
                        break;
                    case 15:
                        ((EditText) view.findViewById(R.id.m0q15)).setText(rInfo.resp);
                        break;
                    case 16:
                        ((EditText) view.findViewById(R.id.m0q16)).setText(rInfo.resp);
                        break;
                    case 17:
                        ((EditText) view.findViewById(R.id.m0q17)).setText(rInfo.resp);
                        break;
                    case 18:
                        ((EditText) view.findViewById(R.id.m0q18)).setText(rInfo.resp);
                        break;
                    case 19:
                        ((Spinner) view.findViewById(R.id.m0q19)).setSelection(
                                MainActivity.get_position_from_array(getResources().
                                        getStringArray(R.array.m0q19), rInfo.resp)
                        );
                        break;
                    case 20:
                        ((EditText) view.findViewById(R.id.m0q20)).setText(rInfo.resp);
                        break;
                    case 21:
                        ((EditText) view.findViewById(R.id.m0q21)).setText(rInfo.resp);
                        break;
                    case 22:
                        ((EditText) view.findViewById(R.id.m0q22)).setText(rInfo.resp);
                        break;
                    case 23:
                        ((EditText) view.findViewById(R.id.m0q23)).setText(rInfo.resp);
                        break;
                    case 24:
                        ((EditText) view.findViewById(R.id.m0q24)).setText(rInfo.resp);
                        break;
                }
        }
    }
}
