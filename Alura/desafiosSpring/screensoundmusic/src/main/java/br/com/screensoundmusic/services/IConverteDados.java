package br.com.screensoundmusic.services;

public interface IConverteDados {
	<T> T obterDados(String json, Class<T> classe);

}
