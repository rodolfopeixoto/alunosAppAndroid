package br.com.rodolfopeixoto.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.rodolfopeixoto.agenda.modelo.Aluno;

/**
 * Created by rodolfopeixoto on 10/03/17.
 */
public class FormularioHelper {


    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoSite;
    private final RatingBar campoNota;

    public FormularioHelper(FormularioActivity activity){

        campoNome = (EditText) activity.findViewById(R.id.form_nome);
        campoEndereco = (EditText) activity.findViewById(R.id.form_endereco);
        campoTelefone = (EditText) activity.findViewById(R.id.form_telefone);
        campoSite = (EditText) activity.findViewById(R.id.form_site);
        campoNota = (RatingBar) activity.findViewById(R.id.form_nota);
    }

    public Aluno pegaAluno() {
        Aluno aluno = new Aluno();

        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setTelefone(campoTelefone.getText().toString());
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }
}
