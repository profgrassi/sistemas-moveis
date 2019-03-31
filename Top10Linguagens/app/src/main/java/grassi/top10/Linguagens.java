package grassi.top10;

public class Linguagens {

    private String nome;
    private Integer simbolo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(Integer simbolo) {
        this.simbolo = simbolo;
    }

    public Linguagens(String nome, Integer simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }
}
