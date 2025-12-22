package br.com.screensoundmusic.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MusicaResponse(List<DadosMusica> track) {
}
