package com.example.henrique.tetopergunta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by henrique on 09/10/15.
 */
public class InserirDados extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void salvar(View view) {
        Intent main_act = new Intent(InserirDados.this, MainActivity.class);
        startActivity(main_act);
    }
}
