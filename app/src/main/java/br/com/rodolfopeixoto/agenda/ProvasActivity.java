package br.com.rodolfopeixoto.agenda;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.rodolfopeixoto.agenda.modelo.Prova;

public class ProvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction tx = fragmentManager.beginTransaction();
        tx.replace(R.id.frame_principal, new ListaProvaFragment());

        if(estaNoModoPaisagem()){
            tx.replace(R.id.frame_secundario, new DetalhesProvaFragment());
        }
        tx.commit();

    }

    private boolean estaNoModoPaisagem() {
        return getResources().getBoolean(R.bool.modoPaisagem);
    }

    public void selecionaProva(Prova prova) {

        FragmentManager manager = getSupportFragmentManager();
        if(!estaNoModoPaisagem()) {
            FragmentTransaction tx = manager.beginTransaction();
            DetalhesProvaFragment detalhesProvaFragment = new DetalhesProvaFragment();

            Bundle parametros = new Bundle();
            parametros.putSerializable("prova",prova);

            detalhesProvaFragment.setArguments(parametros);
            tx.replace(R.id.frame_principal, detalhesProvaFragment);
            tx.addToBackStack(null);
            tx.commit();
        }else{
            DetalhesProvaFragment detalhesFragment = (DetalhesProvaFragment) manager.findFragmentById(R.id.frame_secundario);
            detalhesFragment.populaCamposCom(prova);

        }


    }
}
