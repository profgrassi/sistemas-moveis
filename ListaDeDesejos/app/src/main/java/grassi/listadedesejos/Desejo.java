package grassi.listadedesejos;

public class Desejo {
    private String nome;
    private Integer imagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }

    public Desejo(String nome, Integer imagem) {
        this.nome = nome;
        this.imagem = imagem;
    }
}
