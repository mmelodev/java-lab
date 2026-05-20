package br.com.screenmatchspringjpa.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpisodio(@JsonAlias("Title") String tituloEP, @JsonAlias("Episode") Integer numeroEP,
		@JsonAlias("imdbRating") String avaliacaoEP, @JsonAlias("Released") String data) {

	@Override
	public String toString() {
		return "\nTitulo do Episódio: " + tituloEP + "\n" + "Número do Episódio: " + numeroEP + "\n" + "Avaliação: "
				+ avaliacaoEP + "\n" + "Data de Lançamento: " + data + "\n";
	}
}
