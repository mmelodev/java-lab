package main.br.com.primeirospring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) // ignorar elementos do Json/Jackson que eu não quero.
public record DadosSerie(@JsonAlias("Title") String titulo, @JsonAlias("imdbRating") String avaliacaoImdb,
		@JsonAlias("totalSeasons") Integer totalTemporada) {
	@Override
	public String toString() {
		return "\nTitulo do Série: " + titulo + "\n" + "Avaliação: " + avaliacaoImdb + "\n" + "Total de Temporadas: "
				+ totalTemporada + "\n";
	}
}
