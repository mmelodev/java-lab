package br.com.apivollmed.domain.consulta.validacao;

import br.com.apivollmed.domain.ValidacaoException;
import br.com.apivollmed.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioFuncionamento implements ValidarAgendamento {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var dataDomingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY); //boolean (true -> domingo)
        var antesDeAbrir = dataConsulta.getHour() < 7;
        var depoisDeAbrir = dataConsulta.getHour() > 18;
        if (dataDomingo || antesDeAbrir || depoisDeAbrir) {
            throw new ValidacaoException("Consulta Fora do Horário de Funcionamento");
        }
    }
}
