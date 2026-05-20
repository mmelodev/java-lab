package br.com.apivollmed.domain.consulta.validacao;

import br.com.apivollmed.domain.consulta.DadosAgendamentoConsulta;

public interface ValidarAgendamento {
    void validar(DadosAgendamentoConsulta dados);
}
