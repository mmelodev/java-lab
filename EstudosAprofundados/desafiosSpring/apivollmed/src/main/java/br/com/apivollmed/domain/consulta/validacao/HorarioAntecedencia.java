package br.com.apivollmed.domain.consulta.validacao;

import br.com.apivollmed.domain.ValidacaoException;
import br.com.apivollmed.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioAntecedencia implements ValidarAgendamento {
    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var instante = LocalDateTime.now();
        var diferenca = Duration.between(instante, dataConsulta).toMinutes();
        if (diferenca < 30) {
            throw new ValidacaoException("Antecedência de, no mínimo, 30 minutos");
        }
    }
}
