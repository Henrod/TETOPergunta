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
import android.widget.Toast;

import com.example.henrique.tetopergunta.R;
import com.example.henrique.tetopergunta.banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.fragment_show_perguntas.Respostas_modulo0;
import com.example.henrique.tetopergunta.fragment_show_perguntas.Respostas_modulo1;
import com.example.henrique.tetopergunta.fragment_show_perguntas.Respostas_modulo2;
import com.example.henrique.tetopergunta.fragment_show_perguntas.Respostas_modulo3;
import com.example.henrique.tetopergunta.fragment_show_perguntas.Respostas_modulo4;
import com.example.henrique.tetopergunta.fragment_show_perguntas.Respostas_modulo5;
import com.example.henrique.tetopergunta.fragment_show_perguntas.Respostas_modulo6;
import com.example.henrique.tetopergunta.fragment_show_perguntas.Respostas_moduloExtra;
import com.example.henrique.tetopergunta.fragments_adapter.CustomViewPager;
import com.example.henrique.tetopergunta.fragments_adapter.SimpleTabsAdapter;

public class VerDados extends AppCompatActivity {

    public static Respostas respostas;

    private static TabLayout tabLayout;
    private static CustomViewPager viewPager;
    private static SimpleTabsAdapter tabsAdapter;

    private static Respostas_modulo0 modulo0;
    private static Respostas_modulo1 modulo1;
    private static Respostas_modulo2 modulo2;
    private static Respostas_modulo3 modulo3;
    private static Respostas_modulo4 modulo4;
    private static Respostas_modulo5 modulo5;
    private static Respostas_modulo6 modulo6;
    private static Respostas_moduloExtra moduloExtra;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        Toast.makeText(VerDados.this, "Deslize a tela para ver demais módulos. ", Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        id = getIntent().getStringExtra("id");
        respostas = MainActivity.data_handler.retrieve(id);

        viewPager = (CustomViewPager) findViewById(R.id.tabs_pager);
        tabsAdapter = new SimpleTabsAdapter(getSupportFragmentManager());

        modulo0 = new Respostas_modulo0();
        modulo1 = new Respostas_modulo1();
        modulo2 = new Respostas_modulo2();
        modulo3 = new Respostas_modulo3();
        modulo4 = new Respostas_modulo4();
        modulo5 = new Respostas_modulo5();
        modulo6 = new Respostas_modulo6();
        moduloExtra = new Respostas_moduloExtra();

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
        viewPager.setPagingEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ver_dados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.return_page:
                startActivity(new Intent(VerDados.this, MainActivity.class));
                return true;
            case R.id.delete_table:
                message_and_delete_table();
                return true;
            case R.id.edit_table:
                Intent edit = new Intent(VerDados.this, InserirDados.class);
                edit.putExtra("id", id);
                startActivity(edit);
                return true;
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }

    private void message_and_delete_table() {
        AlertDialog.Builder delete_message = new AlertDialog.Builder(VerDados.this);
        delete_message.setTitle("Tem certeza que deseja deletar esta tabela?");

        delete_message.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.data_handler.delete(id);
                startActivity(new Intent(VerDados.this, MainActivity.class));
            }
        });

        delete_message.setCancelable(true);
        delete_message.create().show();
    }

    public void generate_excel(View view) {
        Toast.makeText(VerDados.this, "Gerando tabela. Aguarde...", Toast.LENGTH_LONG).show();
        boolean b = respostas.export_to_excel(VerDados.this);

        String msg = b ? "Tabela Excel gerada com sucesso!" : "Erro. Tente novamente";
        Toast.makeText(VerDados.this, msg, Toast.LENGTH_LONG).show();

    }

}
