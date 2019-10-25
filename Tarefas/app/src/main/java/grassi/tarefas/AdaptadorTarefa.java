package grassi.tarefas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorTarefa extends RecyclerView.Adapter<AdaptadorTarefa.MyViewHolder> {
    private Context contexto;
    private List<Tarefa> tarefas;
    private DatabaseHelper databaseHelper;

    public AdaptadorTarefa(Context contexto, List<Tarefa> tarefas, DatabaseHelper dbHelper) {
        this.contexto = contexto;
        this.tarefas = tarefas;
        this.databaseHelper = dbHelper;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_tarefas, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Tarefa tarefa = tarefas.get(position);

        holder.tarefa.setText(tarefa.getTarefa());

        holder.apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apagaTarefa(position);
            }
        });

        holder.editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto, AlterarTarefa.class);
                intent.putExtra("posicao", String.valueOf(position));
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }

    private void apagaTarefa(int position) {
        databaseHelper.apagarTarefa(tarefas.get(position));
        tarefas.remove(position);
        MainActivity.atualizarAdaptador();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tarefa;
        ImageView apagar;
        ImageView editar;

        public MyViewHolder(View view) {
            super(view);
            tarefa = view.findViewById(R.id.tarefa);
            apagar = view.findViewById(R.id.apagar);
            editar = view.findViewById(R.id.editar);
        }
    }
}
