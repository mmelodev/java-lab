package br.com.viacep.modelos;

import br.com.viacep.records.PessoaComApi;

public class Pessoa {
    private String nome;
    private String profissao;
    private String cep;
    private String logradouro;
    private String cidade;
    private String estado;
    private String ddd;

    public Pessoa (String nome, String profissao, PessoaComApi novaPessoaComApi){
        this.nome = nome;
        this.profissao = profissao;
        this.cep = novaPessoaComApi.cep();
        this.logradouro = novaPessoaComApi.logradouro();
        this.cidade = novaPessoaComApi.localidade();
        this.estado = novaPessoaComApi.estado();
        this.ddd = novaPessoaComApi.ddd();
    }

    public String getNome() {
        return nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getDdd() {
        return ddd;
    }

    @Override
    public String toString() {
        return "\nNome: " + nome +
                "\nProfissão: " + profissao +
                "\nCEP: " + cep +
                "\nLogradouro: " + logradouro +
                "\nCidade: " + cidade +
                "\nEstado: " + estado +
                "\nDDD: " + ddd + "\n";
    }
}
