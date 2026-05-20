package br.com.screenmatchspringwebapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Title") String tituloTemp, @JsonAlias("Season") Integer numeroTemp,
		@JsonAlias("Episodes") List<DadosEpisodio> episodios) {

	@Override
	public String toString() {
		return "\nTitulo da Temporada: " + tituloTemp + "\n" + "Número da Temporada: " + numeroTemp + "\n"
				+ "Lista de Episódios: " + episodios + "\n";
	}
}
