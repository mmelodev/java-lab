package br.com.livraria.modelos;

public class Quadrinho extends Titulo {
    private String personagemPrincipal;
    private boolean eFiccao;
    private int faixaEtaria;

    public Quadrinho(String nomeLivro, int quantidadePaginas, String autor, int estrelas, double precoLivro, int anoDePublicacao) {
        super(nomeLivro, quantidadePaginas, autor, estrelas, precoLivro, anoDePublicacao);
    }

    public String getPersonagemPrincipal() {
        return personagemPrincipal;
    }

    public boolean iseFiccao() {
        return eFiccao;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }
}
