package br.com.rodolfopeixoto.agenda;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import br.com.rodolfopeixoto.agenda.converter.AlunoConverter;
import br.com.rodolfopeixoto.agenda.dao.AlunoDAO;
import br.com.rodolfopeixoto.agenda.modelo.Aluno;

/**
 * Created by rodolfopeixoto on 05/04/17.
 */

public class EnviaAlunosTask extends AsyncTask {
    private Context context;

    public EnviaAlunosTask(Context context) {
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {


        AlunoDAO dao = new AlunoDAO(context);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        AlunoConverter conversor = new AlunoConverter();
        String json = conversor.converteParaJSON(alunos);

        WebClient client = new WebClient();
        String resposta = client.post(json);



//        Toast.makeText(context, resposta, Toast.LENGTH_LONG).show();

        return resposta;
    }

    @Override
    protected void onPostExecute(Object o) {
        Toast.makeText(context, (String) o, Toast.LENGTH_LONG).show();
    }
}
