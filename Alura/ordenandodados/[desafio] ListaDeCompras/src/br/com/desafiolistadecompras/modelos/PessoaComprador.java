package br.com.desafiolistadecompras.modelos;

public class PessoaComprador {
    private String nomePessoaComprador;
    private double limiteCartaoPessoaComprador;
    private double limiteAtingidoPessoaComprador;

    public PessoaComprador(String nomePessoaComprador, double limiteCartaoPessoaComprador){
        this.nomePessoaComprador = nomePessoaComprador;
        this.limiteCartaoPessoaComprador = limiteCartaoPessoaComprador;
    }

    public String getNomePessoaComprador() {
        return nomePessoaComprador;
    }

    public double getLimiteCartaoPessoaComprador() {
        return limiteCartaoPessoaComprador;
    }

//    public boolean getLimiteAtingidoPessoaComprador() {
//        return limiteAtingidoPessoaComprador;
//    }

    @Override
    public String toString() {
        return "Nome: " + getNomePessoaComprador() + ", Limite: R$ " + getLimiteCartaoPessoaComprador();
    }
}
