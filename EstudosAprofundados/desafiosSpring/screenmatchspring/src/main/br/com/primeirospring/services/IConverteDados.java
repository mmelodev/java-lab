package main.br.com.primeirospring.services;

public interface IConverteDados {
	<T> T obterDados(String json, Class<T> classe);
}
