package br.com.livraria.modelos;

public class Poema extends Titulo {
    private String temaDoPoema;
    private String tipoPoema;

    public Poema(String nomeLivro, int quantidadePaginas, String autor, int estrelas, double precoLivro, int anoDePublicacao) {
        super(nomeLivro, quantidadePaginas, autor, estrelas, precoLivro, anoDePublicacao);
    }

    public String getTipoPoema() {
        return tipoPoema;
    }

    public String getTemaDoPoema() {
        return temaDoPoema;
    }
}
