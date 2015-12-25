package com.example.henrique.tetopergunta.Fragments_perguntas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.henrique.tetopergunta.Main.InserirDados;
import com.example.henrique.tetopergunta.Main.MainActivity;
import com.example.henrique.tetopergunta.R;

public class Modulo0 extends Fragment {

    View view;

    public Modulo0(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_modulo0, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public boolean save() {
        String n_serie = "";
        {
            Editable _n_serie = ((EditText) view.findViewById(R.id.m0q1)).getText();
            if (_n_serie == null) return false;
            n_serie = _n_serie.toString();
        }


        if (n_serie.equals("") || n_serie.isEmpty() || n_serie.length() == 0 ||
                MainActivity.
                        data_handler.
                        retrieve(n_serie).
                        getAnswers()[0][1] != null)
            return false;

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

        InserirDados.respostas.setAnswers(0, answers);

        return true;
    }
}
