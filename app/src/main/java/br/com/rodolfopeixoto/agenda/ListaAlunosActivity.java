package br.com.rodolfopeixoto.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        String[] alunos = { "Rodolfo Peixoto", "Carla Bravo", "Amanda Oliveira", "Pedro Rodrigues", "Pedro Perrone"};
        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);
        listaAlunos.setAdapter(adapter);


        Button buttonAddAluno = (Button) findViewById(R.id.lista_alunos_button);
        buttonAddAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntentVaiParaOFormulario = new Intent(ListaAlunosActivity.this, FormularioActivity.class);
                startActivity(IntentVaiParaOFormulario);
            }
        });
    }
}
