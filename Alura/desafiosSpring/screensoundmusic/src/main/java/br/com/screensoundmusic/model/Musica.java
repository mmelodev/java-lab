package br.com.screensoundmusic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "musica")
public class Musica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String nomeMusica;
	private String nomeArtista;
	private String album;
	@Enumerated(EnumType.STRING)
	private Genero generoMusica;

	public Musica(MusicaResponse dados) {
		DadosMusica dadosMusica = dados.track().get(0);

	}
}
