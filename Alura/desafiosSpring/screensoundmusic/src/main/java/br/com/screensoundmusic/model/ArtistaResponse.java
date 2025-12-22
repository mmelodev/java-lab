package br.com.screensoundmusic.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ArtistaResponse(List<DadosArtista> artists) {
}
