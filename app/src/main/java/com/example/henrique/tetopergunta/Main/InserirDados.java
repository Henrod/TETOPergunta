package com.example.henrique.tetopergunta.Main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.henrique.tetopergunta.Banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.Fragments_adapter.CustomViewPager;
import com.example.henrique.tetopergunta.Fragments_adapter.SimpleTabsAdapter;
import com.example.henrique.tetopergunta.Fragments_perguntas.Modulo0;
import com.example.henrique.tetopergunta.Fragments_perguntas.Modulo1;
import com.example.henrique.tetopergunta.Fragments_perguntas.Modulo2;
import com.example.henrique.tetopergunta.Fragments_perguntas.Modulo3;
import com.example.henrique.tetopergunta.Fragments_perguntas.Modulo4;
import com.example.henrique.tetopergunta.R;

/**
 * Created by henrique on 09/10/15.
 */
public class InserirDados extends AppCompatActivity {

    public static Respostas respostas;

    private static TabLayout tabLayout;
    private static CustomViewPager viewPager;
    private static SimpleTabsAdapter tabsAdapter;
    private Menu menu;

    private static Toolbar toolbar;
    public static Modulo0 modulo0;
    public static Modulo1 modulo1;
    public static Modulo2 modulo2;
    public static Modulo3 modulo3;
    public static Modulo4 modulo4;

    public static boolean insert_data = false;
    public static boolean not_a_new_person;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        InserirDados.not_a_new_person = true;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (CustomViewPager) findViewById(R.id.tabs_pager);
        tabsAdapter = new SimpleTabsAdapter(getSupportFragmentManager());

        modulo0 = new Modulo0();
        modulo1 = new Modulo1();
        modulo2 = new Modulo2();
        modulo3 = new Modulo3();
        modulo4 = new Modulo4();

        //creating tabs and adding them to adapter class
        tabsAdapter.addFragment(modulo0, "Informações da enquete");
        tabsAdapter.addFragment(modulo1, "Módulo 1");
        tabsAdapter.addFragment(modulo2, "Módulo 2");
        tabsAdapter.addFragment(modulo3, "Módulo 3");
        tabsAdapter.addFragment(modulo4, "Módulo 4");

        //set up view pager to give a swipe effect
        viewPager.setAdapter(tabsAdapter);
        viewPager.setPagingEnabled(false);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String id = getIntent().getStringExtra("id");
        respostas = id == null ? new Respostas() : set_respostas(id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dados, menu);

        menu.findItem(R.id.save_table).setVisible(false);
        this.menu = menu;

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.save_table:
                try {
                    if (save())
                        startActivity(new Intent(InserirDados.this, MainActivity.class));
                    else
                        Toast.makeText(InserirDados.this,
                                "Nº série já existente ou não preenchido",
                                Toast.LENGTH_LONG).show();
                } catch (NullPointerException e) {
                    Toast.makeText(InserirDados.this, "Dados faltando. Revisar todos os módulos.",
                            Toast.LENGTH_LONG).show();
                }
                return true;
            case R.id.cancel_table:
                cancel_message();
                return true;
            case R.id.next_module:
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                if (viewPager.getCurrentItem() == tabLayout.getTabCount() - 1) {
                    menu.findItem(R.id.save_table).setVisible(true);
                    menu.findItem(R.id.next_module).setVisible(false);
                    tabLayout.setVisibility(View.VISIBLE);
                    viewPager.setPagingEnabled(true);
                }
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }

    private boolean save() {
        if (modulo0.save()) {
            modulo1.save();
            modulo2.save();
            modulo3.save();
            modulo4.save();

            if (insert_data) MainActivity.data_handler.update(respostas);
            else MainActivity.data_handler.create(respostas);

            insert_data = false;

            return true;
        }

        return false;
    }

    private void cancel_message() {
        AlertDialog.Builder cancel_message = new AlertDialog.Builder(InserirDados.this);
        cancel_message.setTitle("Cancelar este cadastro? (os novos dados inseridos serão perdidos)");

        cancel_message.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(InserirDados.this, MainActivity.class));
            }
        });

        cancel_message.setCancelable(true);
        cancel_message.create().show();
    }

    private Respostas set_respostas(String id) {
        insert_data = true;
        return MainActivity.data_handler.retrieve(id);
    }
}