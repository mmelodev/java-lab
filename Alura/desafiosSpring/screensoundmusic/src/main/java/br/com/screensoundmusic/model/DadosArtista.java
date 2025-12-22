package br.com.screensoundmusic.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosArtista(@JsonAlias("strArtist") String nomeArtista, @JsonAlias("strGenre") String genero,
		@JsonAlias("intBornYear") Integer dataNascimento, @JsonAlias("strBiographyEN") String descricaoEN,
		@JsonAlias("strBiographyPT") String descricaoPT, @JsonAlias("strCountry") String nacionalidade,
		@JsonAlias("intMembers") Integer membrosGrupo) {

	@Override
	public final String toString() {
		return "\nNome do Artista (ou Grupo): " + nomeArtista + "\nGênero Musical: " + genero
				+ "\nAno de Inicio (ou Nascimento): " + dataNascimento + "\nBiografia(EN): " + descricaoEN
				+ "Biografia(PT): " + descricaoPT + "\nNacionalidade: " + nacionalidade + "\nMembros do Grupo: "
				+ membrosGrupo;
	}

}
