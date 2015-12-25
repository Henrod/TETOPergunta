package com.example.henrique.tetopergunta.Fragments_perguntas;

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

import com.example.henrique.tetopergunta.Banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.Main.InserirDados;
import com.example.henrique.tetopergunta.Main.MainActivity;
import com.example.henrique.tetopergunta.R;

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
        String n_serie = "";
        {
            Editable _n_serie = ((EditText) view.findViewById(R.id.m0q1)).getText();
            if (_n_serie == null) return false;
            n_serie = _n_serie.toString();
        }


        if (!InserirDados.insert_data && (n_serie.equals("") || n_serie.isEmpty() || n_serie.length() == 0 ||
                MainActivity.data_handler.retrieve(n_serie).getAnswers()[0][1] != null))
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

    public void set_respostas(Respostas respostas) {
        String[][] resps = respostas.getAnswers();

        ((EditText) view.findViewById(R.id.m0q1)).setText(resps[0][1]);
        ((EditText) view.findViewById(R.id.m0q2)).setText(resps[0][2]);
        ((EditText) view.findViewById(R.id.m0q3)).setText(resps[0][3]);
        ((EditText) view.findViewById(R.id.m0q4)).setText(resps[0][4]);
        ((EditText) view.findViewById(R.id.m0q5)).setText(resps[0][5]);
        ((EditText) view.findViewById(R.id.m0q6)).setText(resps[0][6]);
        ((EditText) view.findViewById(R.id.m0q7)).setText(resps[0][7]);
        ((EditText) view.findViewById(R.id.m0q8)).setText(resps[0][8]);
        ((EditText) view.findViewById(R.id.m0q9)).setText(resps[0][9]);
        ((EditText) view.findViewById(R.id.m0q10)).setText(resps[0][10]);
        ((EditText) view.findViewById(R.id.m0q11)).setText(resps[0][11]);
        ((EditText) view.findViewById(R.id.m0q12)).setText(resps[0][12]);
        ((EditText) view.findViewById(R.id.m0q13)).setText(resps[0][13]);
        ((EditText) view.findViewById(R.id.m0q14)).setText(resps[0][14]);
        ((EditText) view.findViewById(R.id.m0q15)).setText(resps[0][15]);
        ((EditText) view.findViewById(R.id.m0q16)).setText(resps[0][16]);
        ((EditText) view.findViewById(R.id.m0q17)).setText(resps[0][17]);
        ((EditText) view.findViewById(R.id.m0q18)).setText(resps[0][18]);
        ((Spinner)  view.findViewById(R.id.m0q19)).setSelection(
                        InserirDados.get_position_from_array(getResources().
                        getStringArray(R.array.m0q19), resps[0][19])
        );
        ((EditText) view.findViewById(R.id.m0q20)).setText(resps[0][20]);
        ((EditText) view.findViewById(R.id.m0q21)).setText(resps[0][21]);
        ((EditText) view.findViewById(R.id.m0q22)).setText(resps[0][22]);
        ((EditText) view.findViewById(R.id.m0q23)).setText(resps[0][23]);
        ((EditText) view.findViewById(R.id.m0q24)).setText(resps[0][24]);

    }
}
