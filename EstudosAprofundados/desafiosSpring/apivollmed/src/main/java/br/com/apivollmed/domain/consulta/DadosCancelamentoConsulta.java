package br.com.apivollmed.domain.consulta;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(Long consultaId, @NotNull MotivoCancelamento motivo) {
}
