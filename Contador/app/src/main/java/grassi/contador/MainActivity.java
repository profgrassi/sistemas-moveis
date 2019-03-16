package grassi.contador;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Integer valor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.txtContador);
    }

    public void contar(View view) {
        valor = valor + 1;
        if (valor == 9)
            Toast.makeText(this, "Atingiu "+ valor, Toast.LENGTH_LONG).show();
        tv.setText(Integer.toString(valor));
    }

    public void zerar(View view) {
        valor = 0;
        tv.setText(Integer.toString(valor));
    }
}