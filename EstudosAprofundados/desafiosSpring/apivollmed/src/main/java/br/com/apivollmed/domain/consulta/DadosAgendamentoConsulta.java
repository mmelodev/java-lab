package br.com.apivollmed.domain.consulta;

import br.com.apivollmed.domain.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(Long idMedico, @NotNull Long idPaciente, @NotNull @Future LocalDateTime data,
                                       Especialidade especialidade) {
}
