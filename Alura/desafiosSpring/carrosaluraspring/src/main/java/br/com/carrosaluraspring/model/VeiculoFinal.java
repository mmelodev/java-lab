package br.com.carrosaluraspring.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VeiculoFinal(@JsonAlias("Valor") String valor,
                           @JsonAlias("Marca") String marca,
                           @JsonAlias("Modelo") String modelo,
                           @JsonAlias("AnoModelo") Integer ano,
                           @JsonAlias("Combustivel") String combustivel) {
    @Override
    public String toString() {
        return String.format("""
            \n*** VEÍCULO ENCONTRADO ***
            Marca: %s
            Modelo: %s
            Ano: %d
            Combustível: %s
            Valor: %s
            **************************
            """, marca, modelo, ano, combustivel, valor);
    }
}
