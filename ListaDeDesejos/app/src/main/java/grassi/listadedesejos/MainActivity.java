package grassi.listadedesejos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button botao;
    AdaptadorDesejos adaptador;
    List<Desejo> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        botao = findViewById(R.id.botao);

        lista.add(new Desejo("Viajar", R.drawable.viajar));
        lista.add(new Desejo("Comer", R.drawable.comer));
        lista.add(new Desejo("Jogar", R.drawable.jogar));

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adaptador = new AdaptadorDesejos(getApplicationContext(), lista);
        recyclerView.setAdapter(adaptador);
    }

    public void adicionaItem(View view) {
        lista.add(new Desejo("Item #" +
                new Random().nextInt(11), R.drawable.praia));
        adaptador.notifyItemInserted(lista.size()-1);
    }
}
