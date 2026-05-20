package br.com.desafioum.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;

public class Tarefa {
    private String descricao;
    private boolean concluida;
    private String pessoaResponsavel;

    public Tarefa(@JsonProperty("Descrição") String descricao, @JsonProperty("Concluída") boolean concluida, @JsonProperty("Pessoa Responsável") String pessoaResponsavel) {
        this.descricao = descricao;
        this.concluida = concluida;
        this.pessoaResponsavel = pessoaResponsavel;
    }

    @JsonProperty ("Descrição")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @JsonProperty("Concluída")
    public boolean setConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    @JsonProperty("Pessoa Responsável")
    public String getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    public void setPessoaResponsavel(String pessoaResponsavel) {
        this.pessoaResponsavel = pessoaResponsavel;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricao + "\n" +
                "Concluída: " + concluida + "\n" +
                "Pessoa Responsável: " + pessoaResponsavel + "\n";
    }
}
