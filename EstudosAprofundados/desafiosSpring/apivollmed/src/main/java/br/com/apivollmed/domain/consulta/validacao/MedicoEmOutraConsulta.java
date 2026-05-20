package br.com.apivollmed.domain.consulta.validacao;

import br.com.apivollmed.domain.ValidacaoException;
import br.com.apivollmed.domain.consulta.ConsultaRepository;
import br.com.apivollmed.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoEmOutraConsulta implements ValidarAgendamento {
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoEmOutraConsulta = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoEmOutraConsulta) {
            throw new ValidacaoException("Médico(a) estará em outra consulta no para esse horário.");
        }
    }
}
