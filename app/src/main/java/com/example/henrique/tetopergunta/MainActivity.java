package com.example.henrique.tetopergunta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private ListView lista;
    private List<Respostas> respostasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        respostasList = new LinkedList<Respostas>();

        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(new ListAdapter(MainActivity.this, respostasList));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Respostas resp = new Respostas();
        resp.setResposta(0, "Kenzo");
        respostasList.add(resp);

        resp = new Respostas();
        resp.setResposta(0, "Brócolis");
        respostasList.add(resp);

        resp = new Respostas();
        resp.setResposta(0, "Rodrigues");
        respostasList.add(resp);
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

            viewHolder.textoLista.setText(respostasList.get(position).getRespostas()[0]);

            return convertView;
        }

        class ViewHolder {
            TextView textoLista;
        }
    }
}
