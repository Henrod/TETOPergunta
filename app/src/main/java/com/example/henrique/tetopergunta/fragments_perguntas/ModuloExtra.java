package com.example.henrique.tetopergunta.fragments_perguntas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.henrique.tetopergunta.banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.banco_de_dados.RespostasInfo;
import com.example.henrique.tetopergunta.main.InserirDados;
import com.example.henrique.tetopergunta.R;

import java.util.ArrayList;

public class ModuloExtra extends Fragment {

    View view;

    public ModuloExtra(){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_modulo_extra, container, false);
        if (InserirDados.insert_data) set_respostas(InserirDados.respostas);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public boolean save() {
        String[] answers = {"---",
                ((EditText) view.findViewById(R.id.m7q1)).getText().toString(),
                ((EditText) view.findViewById(R.id.m8q1)).getText().toString(),
                ((EditText) view.findViewById(R.id.m9q1)).getText().toString(),
                ((EditText) view.findViewById(R.id.m10q1)).getText().toString(),
                ((EditText) view.findViewById(R.id.m11q1)).getText().toString()
        };

        for (int i = 1; i < 6; i++) {
            InserirDados.respostas.setAnswers(
                    new RespostasInfo(i + 6, 1, answers[i]), Respostas.Modulos.MAIN, 0, InserirDados.insert_data
            );
        }
        return true;
    }

    public void set_respostas(Respostas respostas) {
        ArrayList<RespostasInfo> resps = respostas.getMainAnswers();

        for (RespostasInfo rInfo : resps) {
                switch (rInfo.modulo) {
                    case 7:
                        ((EditText) view.findViewById(R.id.m7q1)).setText(rInfo.resp);
                        break;
                    case 8:
                        ((EditText) view.findViewById(R.id.m8q1)).setText(rInfo.resp);
                        break;
                    case 9:
                        ((EditText) view.findViewById(R.id.m9q1)).setText(rInfo.resp);
                        break;
                    case 10:
                        ((EditText) view.findViewById(R.id.m10q1)).setText(rInfo.resp);
                        break;
                    case 11:
                        ((EditText) view.findViewById(R.id.m11q1)).setText(rInfo.resp);
                        break;
                }
        }
    }
}
