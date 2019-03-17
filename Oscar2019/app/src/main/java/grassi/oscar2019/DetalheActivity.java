package grassi.oscar2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetalheActivity extends AppCompatActivity {

    TextView titulo, genero, resumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        titulo = findViewById(R.id.titulo);
        genero = findViewById(R.id.genero);
        resumo = findViewById(R.id.resumo);

        Bundle dados = getIntent().getExtras();

        switch (dados.getInt("id")) {

            case R.id.br:
                titulo.setText(R.string.titulo_br);
                genero.setText(R.string.genero_br);
                resumo.setText(R.string.resumo_br);
                break;

            case R.id.og:
                titulo.setText(R.string.titulo_og);
                genero.setText(R.string.genero_og);
                resumo.setText(R.string.resumo_og);
                break;

            case R.id.pn:
                titulo.setText(R.string.titulo_pn);
                genero.setText(R.string.genero_pn);
                resumo.setText(R.string.resumo_pn);
                break;

            case R.id.ro:
                titulo.setText(R.string.titulo_ro);
                genero.setText(R.string.genero_ro);
                resumo.setText(R.string.resumo_ro);
                break;
        }
    }
}


