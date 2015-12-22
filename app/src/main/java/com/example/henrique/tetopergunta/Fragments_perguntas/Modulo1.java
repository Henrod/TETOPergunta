package com.example.henrique.tetopergunta.Fragments_perguntas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.henrique.tetopergunta.Main.InserirDados;
import com.example.henrique.tetopergunta.R;

public class Modulo1 extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_modulo1, container, false);

        return view;
    }

    public void save() {
        String[] answers = { "---",
                ((EditText) view.findViewById(R.id.m1q1)).getText().toString(),
                ((Spinner) view.findViewById(R.id.m1q2)).getSelectedItem().toString(),
                ((Spinner) view.findViewById(R.id.m1q3)).getSelectedItem().toString(),
                ((EditText) view.findViewById(R.id.m1q4)).getText().toString(),
                ((Spinner) view.findViewById(R.id.m1q5)).getSelectedItem().toString(),
        };

        InserirDados.respostas.setAnswers(1, answers);
    }

}
