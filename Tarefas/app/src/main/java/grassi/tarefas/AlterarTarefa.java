package grassi.tarefas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AlterarTarefa extends AppCompatActivity {
    EditText editText;
    Button botao;
    DatabaseHelper db;
    int posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final List<Tarefa> lista = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alterar_tarefa);
        editText = findViewById(R.id.editText);
        botao = findViewById(R.id.botao);
        Bundle bundle = getIntent().getExtras();
        posicao = Integer.parseInt(bundle.getString("posicao"));
        db = new DatabaseHelper(this);
        lista.addAll(db.listarTarefas());
        editText.setText(lista.get(posicao).getTarefa());
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tarefa tarefa = lista.get(posicao);
                tarefa.setTarefa(editText.getText().toString());
                db.alterarTarefa(tarefa);
                MainActivity.atualizarAdaptador();
                Intent intent = new Intent(AlterarTarefa.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
