package br.com.screensoundmusic.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T obterDados(String json, Class<T> classe) {
		try {
			return mapper.readValue(json, classe);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public String formatarObjetoComoJson(Object objeto) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
