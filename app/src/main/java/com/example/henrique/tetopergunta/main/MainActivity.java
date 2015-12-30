package com.example.henrique.tetopergunta.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.henrique.tetopergunta.banco_de_dados.DBMS;
import com.example.henrique.tetopergunta.banco_de_dados.Respostas;
import com.example.henrique.tetopergunta.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Respostas> respostasList;
    public static DBMS data_handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data_handler = new DBMS(MainActivity.this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        respostasList = data_handler.getLista();
        ListView lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(new ListAdapter(MainActivity.this, respostasList));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Respostas resposta_get = respostasList.get(position);
                Intent dados = new Intent(MainActivity.this, VerDados.class);

                dados.putExtra("id", resposta_get.getNSerie());

                startActivity(dados);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.new_table:
                startActivity(new Intent(MainActivity.this, InserirDados.class));
                return true;
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }

    private class ListAdapter extends BaseAdapter {

        private List<Respostas> respostasList;
        private LayoutInflater layoutInflater;

        public ListAdapter(Context context, List<Respostas> respostasList){
            this.respostasList = respostasList;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return respostasList.size();
        }

        @Override
        public Object getItem(int position) {
            return respostasList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.list_layout, null);
                viewHolder = new ViewHolder();
                viewHolder.textoLista = (TextView) convertView.findViewById(R.id.textoLista);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.textoLista.setText(respostasList.get(position).getNSerie());

            return convertView;
        }

        class ViewHolder {
            TextView textoLista;
        }
    }

    public static int get_position_from_array(String[] array, String data){
        for(int i = 0; i < array.length; i++)
            if (array[i].contentEquals(data))
                return i;

        return 0;
    }
}
