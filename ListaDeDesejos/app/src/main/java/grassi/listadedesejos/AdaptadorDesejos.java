package grassi.listadedesejos;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorDesejos extends RecyclerView.Adapter<AdaptadorDesejos.MeuViewHolder> {

    private Context contexto;
    private List<Desejo> itens;

    public AdaptadorDesejos(Context contexto, List<Desejo> itens) {
        this.contexto = contexto;
        this.itens = itens;
    }

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View meuLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_desejos, parent, false);
        return new MeuViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {
        holder.texto.setText(itens.get(position).getNome());

        switch (itens.get(position).getImagem()) {

            case R.drawable.comer:
                holder.icone.setImageResource(R.drawable.comer);
                break;

            case R.drawable.jogar:
                holder.icone.setImageResource(R.drawable.jogar);
                break;

            case R.drawable.viajar:
                holder.icone.setImageResource(R.drawable.viajar);
                break;

            case R.drawable.praia:
                holder.icone.setImageResource(R.drawable.praia);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public class MeuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView icone;
        TextView texto;

        public MeuViewHolder(View itemView) {
            super(itemView);
            icone = itemView.findViewById(R.id.icone);
            texto = itemView.findViewById(R.id.texto);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            notificar();

        }

        private void notificar() {

            Integer indice = getAdapterPosition();

            Intent notificacao = new Intent(contexto, MainActivity.class);

            PendingIntent conteudo = PendingIntent.getActivity(contexto, 0, notificacao,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(contexto);

            builder.setSmallIcon(R.drawable.joinha);
            builder.setContentTitle("Clicou no " + itens.get(indice).getNome());
            builder.setColor(0x4CAF50);
            builder.setContentText("Mas você já sabia disso, né?");

            builder.setContentIntent(conteudo);

            NotificationManager manager = (NotificationManager) contexto.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0, builder.build());
        }
    }
}
