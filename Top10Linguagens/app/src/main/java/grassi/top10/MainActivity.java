package grassi.top10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdaptadorLinguagens adaptador;
    List<Linguagens> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        lista.add(new Linguagens("Python", R.drawable.python));
        lista.add(new Linguagens("Java", R.drawable.java));
        lista.add(new Linguagens("C", R.drawable.c));
        lista.add(new Linguagens("C++", R.drawable.cpp));
        lista.add(new Linguagens("C#", R.drawable.csharp));
        lista.add(new Linguagens("JS", R.drawable.js));
        lista.add(new Linguagens("Assembly", R.drawable.assembly));
        lista.add(new Linguagens("PHP", R.drawable.php));
        lista.add(new Linguagens("HTML", R.drawable.html));
        lista.add(new Linguagens("Scala", R.drawable.scala));

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adaptador = new AdaptadorLinguagens(lista);
        recyclerView.setAdapter(adaptador);
    }

}
