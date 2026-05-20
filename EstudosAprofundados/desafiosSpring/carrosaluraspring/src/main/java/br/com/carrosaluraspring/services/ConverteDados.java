package br.com.carrosaluraspring.services;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class ConverteDados implements IConverteDados {

	ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T obterDados(String json, Class<T> classe) {
		try {
			return mapper.readValue(json, classe);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public <T> List<T> obterLista(String json, Class<T> classe) {
		CollectionType lista = mapper.getTypeFactory().constructCollectionType(List.class, classe); // estudar mais
																									// sobre essa linha
		try {
			return mapper.readValue(json, lista);
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
