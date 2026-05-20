package br.com.screenmatchspringjpa.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo, @JsonAlias("imdbRating") String avaliacaoImdb,
                         @JsonAlias("totalSeasons") Integer totalTemporada, @JsonAlias("Genre") String categoria,
                         @JsonAlias("Plot") String descricao, @JsonAlias("Actors") String atores,
                         @JsonAlias("Poster") String poster) {
    @Override
    public String toString() {
        return "\nTitulo do Série: " + titulo + "\n" + "Avaliação: " + avaliacaoImdb + "\n" + "Total de Temporadas: "
                + totalTemporada + "\n" +
                "Categoria: " + categoria + "\n" +
                "Descrição: " + descricao + "\n" +
                "Atores: " + atores + "\n" +
                "Poster: " + poster + "\n";
    }
}
