package br.com.screensoundmusic.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosMusica(@JsonAlias("strTrack") String nomeMusica, @JsonAlias("strArtist") String nomeArtista,
		@JsonAlias("strAlbum") String album, @JsonAlias("strGenre") String generoMusica) {

	@Override
	public final String toString() {
		return "\nNome da Música: " + nomeMusica + "\nNome Artista/Grupo: " + nomeArtista + "\nNome Albúm: " + album
				+ "\nGênero: " + generoMusica;
	}

}
