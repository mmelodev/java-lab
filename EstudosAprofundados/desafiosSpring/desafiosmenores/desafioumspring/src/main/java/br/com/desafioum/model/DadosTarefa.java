package br.com.desafioum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DadosTarefa(@JsonProperty("Descrição") String descricao,
                          @JsonProperty("Concluída") Boolean concluida,
                          @JsonProperty("Pessoa Responsável") String pessoaResponsavel) {

    @Override
    public String toString() {
        return "Descrição: " + descricao + "\n" +
                "Concluída: " + concluida + "\n" +
                "Pessoa Responsável: " + pessoaResponsavel + "\n";
    }
}
