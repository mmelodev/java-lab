package br.com.carrosaluraspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculos(@JsonAlias("codigo") String numeracao, @JsonAlias("nome") String nomeMarca) {

	@Override
	public final String toString() {
		return "Nome: " + nomeMarca + "\n" + "Numeração: " + numeracao + "\n";
	}
}
