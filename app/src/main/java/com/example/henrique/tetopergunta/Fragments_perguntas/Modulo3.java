package com.example.henrique.tetopergunta.Fragments_perguntas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.henrique.tetopergunta.R;

public class Modulo3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_modulo3, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
