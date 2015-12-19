package com.example.henrique.tetopergunta.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.henrique.tetopergunta.Banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.Fragments_adapter.SimpleTabsAdapter;
import com.example.henrique.tetopergunta.Fragments_perguntas.Modulo0;
import com.example.henrique.tetopergunta.Fragments_perguntas.Modulo2;
import com.example.henrique.tetopergunta.Fragments_perguntas.Modulo3;
import com.example.henrique.tetopergunta.R;

/**
 * Created by henrique on 09/10/15.
 */
public class InserirDados extends AppCompatActivity {

    public static Respostas respostas;

    private static TabLayout tabLayout;
    private static ViewPager viewPager;
    private static SimpleTabsAdapter tabsAdapter;

    private static Toolbar toolbar;
    private static Modulo0 modulo0;
    private static Modulo2 modulo2;
    private static Modulo3 modulo3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        respostas = new Respostas();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.tabs_pager);
        tabsAdapter = new SimpleTabsAdapter(getSupportFragmentManager());

        modulo0 = new Modulo0();
        modulo2 = new Modulo2();
        modulo3 = new Modulo3();

        //creating tabs and adding them to adapter class
        tabsAdapter.addFragment(modulo0, "Informações da enquete");
        tabsAdapter.addFragment(modulo2, "Módulo 2");
        tabsAdapter.addFragment(modulo3, "Módulo 3");

        //set up view pager to give a swipe effect
        viewPager.setAdapter(tabsAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.save_table:
                if (save())
                    startActivity(new Intent(InserirDados.this, MainActivity.class));
                else
                    Toast.makeText(InserirDados.this,
                            "Nº série já existente ou não preenchido",
                            Toast.LENGTH_LONG).show();
                return true;
            case R.id.cancel_table:
                startActivity(new Intent(InserirDados.this, MainActivity.class));
                return true;
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }

    private boolean save() {
        if (modulo0.save()) {

            MainActivity.data_handler.create(respostas);

            return true;
        }

        return false;
    }
}
