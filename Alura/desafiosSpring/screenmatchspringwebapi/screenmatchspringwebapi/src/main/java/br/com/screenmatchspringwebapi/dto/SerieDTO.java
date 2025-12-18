package br.com.screenmatchspringwebapi.dto;

import br.com.screenmatchspringwebapi.model.Categoria;
import jakarta.persistence.*;

public record SerieDTO (
                        Long id,
                        String titulo,
                        Double avaliacaoImdb,
                        Integer totalTemporada,
                        Categoria categoria,
                        String descricao,
                        String atores,
                        String poster) {
}
