package br.com.livraria.modelos;
import br.com.livraria.calculos.Avaliacoes;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Avaliacoes {
    private String nomeLivro;
    private int QuantidadePaginas;
    private String autor;
    private int estrelas;
    private double precoLivro;
    private int anoDePublicacao;

    public Titulo(String nomeLivro, int quantidadePaginas, String autor, int estrelas, double precoLivro, int anoDePublicacao) {
        this.nomeLivro = nomeLivro;
        QuantidadePaginas = quantidadePaginas;
        this.autor = autor;
        this.estrelas = estrelas;
        this.precoLivro = precoLivro;
        this.anoDePublicacao = anoDePublicacao;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nomeLivro = meuTituloOmdb.title();
        this.autor = String.valueOf(meuTituloOmdb.author_name());
        this.anoDePublicacao = meuTituloOmdb.first_publish_year();
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public int getQuantidadePaginas() {
        return QuantidadePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public double getPrecoLivro() {
        return precoLivro;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeLivro + ", Autor(a): " + autor + ", Ano de Publicação: " + anoDePublicacao;
    }

    @Override
    public void calcularEstelas(int estrelas) {
        this.estrelas = estrelas;

        if (estrelas >= 0 && estrelas <= 2){
            System.out.println("Esse exemplar está com uma avalição bem ruim");
        } else if (estrelas <= 4){
            System.out.println("Esse exemplar está com uma avalição boa");
        } else if (estrelas == 5){
            System.out.println("Esse exemplar está com uma avalição perfeita");
        } else {
            System.out.println("Número da avaliação inválido, apenas entre 0 e 5 são aceitos.");
        }
    }
}
