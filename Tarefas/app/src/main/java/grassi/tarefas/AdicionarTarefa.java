package grassi.tarefas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class AdicionarTarefa extends AppCompatActivity {

    EditText editText;
    Button botao;
    String tarefa;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_tarefa);
        editText = findViewById(R.id.editText);
        botao = findViewById(R.id.botao);
        db = new DatabaseHelper(this);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarefa = editText.getText().toString();
                db.novaTarefa(tarefa);
                Intent intent = new Intent(AdicionarTarefa.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
