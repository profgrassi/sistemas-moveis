package grassi.top10;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorLinguagens extends RecyclerView.Adapter<AdaptadorLinguagens.MeuViewHolder> {


    private List<Linguagens> itens;

    public AdaptadorLinguagens(List<Linguagens> itens) {
        this.itens = itens;
    }

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View meuLayout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_linguagens, parent, false);
        return new MeuViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {
        holder.nome.setText(itens.get(position).getNome());

        switch (itens.get(position).getSimbolo()) {

            case R.drawable.assembly:
                holder.simbolo.setImageResource(R.drawable.assembly);
                break;

            case R.drawable.c:
                holder.simbolo.setImageResource(R.drawable.c);
                break;

            case R.drawable.csharp:
                holder.simbolo.setImageResource(R.drawable.csharp);
                break;

            case R.drawable.cpp:
                holder.simbolo.setImageResource(R.drawable.cpp);
                break;

            case R.drawable.java:
                holder.simbolo.setImageResource(R.drawable.java);
                break;

            case R.drawable.python:
                holder.simbolo.setImageResource(R.drawable.python);
                break;

            case R.drawable.js:
                holder.simbolo.setImageResource(R.drawable.js);
                break;

            case R.drawable.html:
                holder.simbolo.setImageResource(R.drawable.html);
                break;

            case R.drawable.php:
                holder.simbolo.setImageResource(R.drawable.php);
                break;

            case R.drawable.scala:
                holder.simbolo.setImageResource(R.drawable.scala);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }

    public class MeuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView simbolo;
        TextView nome;

        public MeuViewHolder(View itemView) {
            super(itemView);
            simbolo = itemView.findViewById(R.id.simbolo);
            nome = itemView.findViewById(R.id.nome);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Context contexto = view.getContext();

            WebView webView = new WebView(contexto);

            Integer indice = getAdapterPosition();

            switch (itens.get(indice).getNome()) {

                case "Java":
                    webView.loadUrl(contexto.getString(R.string.java));
                    break;

                case "Assembly":
                    webView.loadUrl(contexto.getString(R.string.assembly));
                    break;

                case "C":
                    webView.loadUrl(contexto.getString(R.string.c));
                    break;

                case "C#":
                    webView.loadUrl(contexto.getString(R.string.csharp));
                    break;

                case "C++":
                    webView.loadUrl(contexto.getString(R.string.cpp));
                    break;

                case "Python":
                    webView.loadUrl(contexto.getString(R.string.python));
                    break;

                case "JS":
                    webView.loadUrl(contexto.getString(R.string.js));
                    break;

                case "HTML":
                    webView.loadUrl(contexto.getString(R.string.html));
                    break;

                case "PHP":
                    webView.loadUrl(contexto.getString(R.string.php));
                    break;

                case "Scala":
                    webView.loadUrl(contexto.getString(R.string.scala));
                    break;
            }
        }
    }
}

