package com.example.henrique.tetopergunta.main;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.henrique.tetopergunta.R;
import com.example.henrique.tetopergunta.banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.banco_de_dados.RespostasInfo;
import com.example.henrique.tetopergunta.fragments_adapter.CustomViewPager;
import com.example.henrique.tetopergunta.fragments_adapter.SimpleTabsAdapter;
import com.example.henrique.tetopergunta.fragments_perguntas.Modulo0;
import com.example.henrique.tetopergunta.fragments_perguntas.Modulo1;
import com.example.henrique.tetopergunta.fragments_perguntas.Modulo2;
import com.example.henrique.tetopergunta.fragments_perguntas.Modulo3;
import com.example.henrique.tetopergunta.fragments_perguntas.Modulo4;
import com.example.henrique.tetopergunta.fragments_perguntas.Modulo5;
import com.example.henrique.tetopergunta.fragments_perguntas.Modulo6;
import com.example.henrique.tetopergunta.fragments_perguntas.ModuloExtra;

import java.util.ArrayList;

/**
 * Created by henrique on 09/10/15.
 */
public class InserirDados extends AppCompatActivity {

    public static Respostas respostas;

    private static TabLayout tabLayout;
    public static CustomViewPager viewPager;
    private static SimpleTabsAdapter tabsAdapter;
    private Menu menu;

    private static Toolbar toolbar;
    public static Modulo0 modulo0;
    public static Modulo1 modulo1;
    public static Modulo2 modulo2;
    public static Modulo3 modulo3;
    public static Modulo4 modulo4;
    public static Modulo5 modulo5;
    public static Modulo6 modulo6;
    public static ModuloExtra moduloExtra;

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

        String id = getIntent().getStringExtra("id");
        respostas = id == null ? new Respostas() : set_respostas(id);
        findViewById(R.id.excel_button).setVisibility(View.GONE);

        modulo0 = new Modulo0();
        modulo1 = new Modulo1();
        modulo2 = new Modulo2();
        modulo3 = new Modulo3();
        modulo4 = new Modulo4();
        modulo5 = new Modulo5();
        modulo6 = new Modulo6();
        moduloExtra = new ModuloExtra();


        //creating tabs and adding them to adapter class
        tabsAdapter.addFragment(modulo0, "Informações");
        tabsAdapter.addFragment(modulo1, "Módulo 1");
        tabsAdapter.addFragment(modulo2, "Módulo 2");
        tabsAdapter.addFragment(modulo3, "Módulo 3");
        tabsAdapter.addFragment(modulo4, "Módulo 4");
        tabsAdapter.addFragment(modulo5, "Módulo 5");
        tabsAdapter.addFragment(modulo6, "Módulo 6");
        tabsAdapter.addFragment(moduloExtra, "Módulo Extra");

        //set up view pager to give a swipe effect
        viewPager.setAdapter(tabsAdapter);
        viewPager.setPagingEnabled(false);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();
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
                    if (save()) {
                        Intent ver_dados = new Intent(InserirDados.this, VerDados.class);
                        ver_dados.putExtra("id", respostas.getNSerie());
                        startActivity(ver_dados);
                    } else {
                        Toast.makeText(InserirDados.this,
                                "Nº série já existente ou não preenchido",
                                Toast.LENGTH_LONG).show();
                        viewPager.setCurrentItem(0);
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(InserirDados.this, "Dados faltando. Revisar todos os módulos.",
                            Toast.LENGTH_LONG).show();
                    viewPager.setCurrentItem(0);
                    menu.findItem(R.id.save_table).setVisible(false);
                    menu.findItem(R.id.next_module).setVisible(true);
                }
                return true;
            case R.id.cancel_table:
                cancel_message();
                return true;
            case R.id.next_module:
                if (viewPager.getCurrentItem() == 1) {
                    modulo1.save();
                    if (modulo3.insertPoint != null && modulo3.insertPoint.getChildCount() > 0) {
                        modulo3.insertPoint.removeAllViews();
                    }
                    for (ArrayList<RespostasInfo> r : InserirDados.respostas.getModAnswers(Respostas.Modulos.MODULO_1)) {
                        View view_2 = getLayoutInflater().inflate(R.layout.mod2_child, modulo2.container, false);
                        ((TextView) view_2.findViewById(R.id.NOME)).setText("NOME: " + r.get(0).resp);
                        modulo2.insertPoint.addView(view_2);

                        try {
                            View view_3 = getLayoutInflater().inflate(R.layout.mod3_child, modulo3.container, false);
                            ((TextView) view_3.findViewById(R.id.NOME)).setText("NOME: " + r.get(0).resp);
                            modulo3.insertPoint.addView(view_3);
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    }
                    InserirDados.modulo2.set_respostas(respostas);
                }

                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                if (viewPager.getCurrentItem() == 7) {
                    menu.findItem(R.id.save_table).setVisible(true);
                    menu.findItem(R.id.next_module).setVisible(false);
                    //tabLayout.setVisibility(View.VISIBLE);
                    //viewPager.setPagingEnabled(true);
                }

                return true;
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
            modulo5.save();
            modulo6.save();
            moduloExtra.save();

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

    public void generate_excel(View view) {

    }

    private void set_next_tab(int next_tab) {
        switch (next_tab) {
            case 2:
                tabsAdapter.addFragment(modulo2, "Módulo 2");
                break;
            case 3:
                tabsAdapter.addFragment(modulo3, "Módulo 3");
                break;
            case 4:
                tabsAdapter.addFragment(modulo4, "Módulo 4");
                break;
            case 5:
                tabsAdapter.addFragment(modulo5, "Módulo 5");
                break;
            case 6:
                tabsAdapter.addFragment(modulo6, "Módulo 6");
                break;
            case 7:
                tabsAdapter.addFragment(moduloExtra, "Módulo Extra");
                break;
        }

        viewPager.setAdapter(tabsAdapter);
    }
}