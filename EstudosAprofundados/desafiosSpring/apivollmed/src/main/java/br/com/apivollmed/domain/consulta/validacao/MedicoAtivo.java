package br.com.apivollmed.domain.consulta.validacao;

import br.com.apivollmed.domain.ValidacaoException;
import br.com.apivollmed.domain.consulta.DadosAgendamentoConsulta;
import br.com.apivollmed.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoAtivo implements ValidarAgendamento {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        var medicoAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoAtivo) {
            throw new ValidacaoException("Esse médico não está atuando no momento.");
        }
    }
}
