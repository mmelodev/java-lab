package br.com.apivollmed.domain.consulta.validacao;

import br.com.apivollmed.domain.ValidacaoException;
import br.com.apivollmed.domain.consulta.Consulta;
import br.com.apivollmed.domain.consulta.ConsultaRepository;
import br.com.apivollmed.domain.consulta.DadosCancelamentoConsulta;
import br.com.apivollmed.domain.consulta.ValidarCancelamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioAntecedenciaCancelamento implements ValidarCancelamento {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Override
    public void cancelar(DadosCancelamentoConsulta dados) {
        Consulta consulta = consultaRepository.findById(dados.consultaId()).orElseThrow(() -> new ValidacaoException("Consulta não encontrada"));

        LocalDateTime dataConsulta = consulta.getData();
        var instante = LocalDateTime.now();
        var diferenca = Duration.between(instante, dataConsulta).toHours();
        if (diferenca < 24) {
            throw new ValidacaoException("Antecedência de, no mínimo, 24 horas para cancelar uma consulta");
        }
        if (dataConsulta.isBefore(LocalDateTime.now())) {
            throw new ValidacaoException("Não é possível cancelar consultas passadas");
        }
    }
}
