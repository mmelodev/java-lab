package br.com.livraria.modelos;

public class Biografia extends Titulo {
    private String pessaoDaBiografia;
    private boolean temFotos;

    public Biografia(String nomeLivro, int quantidadePaginas, String autor, int estrelas, double precoLivro, int anoDePublicacao) {
        super(nomeLivro, quantidadePaginas, autor, estrelas, precoLivro, anoDePublicacao);
    }

    public String getPessaoDaBiografia() {
        return pessaoDaBiografia;
    }

    public boolean isTemFotos() {
        return temFotos;
    }
}
