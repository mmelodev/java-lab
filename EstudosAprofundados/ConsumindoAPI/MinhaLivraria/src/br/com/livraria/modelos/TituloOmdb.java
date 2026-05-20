package br.com.livraria.modelos;

import java.util.List;

public record TituloOmdb(String title, List<String> author_name, int first_publish_year) {}

