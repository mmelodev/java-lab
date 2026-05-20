package br.com.apivollmed.domain.consulta.validacao;

import br.com.apivollmed.domain.ValidacaoException;
import br.com.apivollmed.domain.consulta.ConsultaRepository;
import br.com.apivollmed.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteEmOutraConsulta implements ValidarAgendamento {
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacienteEmOutraConsulta = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacienteEmOutraConsulta) {
            throw new ValidacaoException("O Paciente está em outra consulta nesse dia.");
        }
    }
}
