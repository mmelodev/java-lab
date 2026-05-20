package br.com.apivollmed.domain.consulta.validacao;

import br.com.apivollmed.domain.ValidacaoException;
import br.com.apivollmed.domain.consulta.DadosAgendamentoConsulta;
import br.com.apivollmed.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteAtivo implements ValidarAgendamento {
    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo) {
            throw new ValidacaoException("O Paciente não está ativo para continuar o agendamento.");
        }
    }
}
