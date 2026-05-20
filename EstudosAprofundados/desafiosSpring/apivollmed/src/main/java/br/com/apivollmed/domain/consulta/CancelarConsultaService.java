package br.com.apivollmed.domain.consulta;

import br.com.apivollmed.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelarConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private CancelamentoConsultaRepository cancelamentoConsultaRepository;
    @Autowired
    private List<ValidarCancelamento> validadores;

    public DadosDetalhamentoCancelamentoConsulta cancelar(DadosCancelamentoConsulta dados) {
        if (dados.consultaId() == null) {
            throw new ValidacaoException("ID da consulta não pode ser nulo");
        }
        if (!consultaRepository.existsById(dados.consultaId())) {
            throw new ValidacaoException("Essa consulta não existe! Tente novamente.");
        }

        validadores.forEach(v -> v.cancelar(dados));

        if (dados.consultaId() == null || dados.consultaId() == 0) {
            System.out.println("ENTORU NA VALIDAÇÃO");
            throw new ValidacaoException("O ID da consulta não pode ser nulo! Tente novamente");
        }
        if (dados.motivo() == null) {
            throw new ValidacaoException("O Motivo é Obrigatório");
        }
        var consulta = consultaRepository.getReferenceById(dados.consultaId());
        var cancelamento = new CancelamentoConsulta(null, consulta, dados.motivo());
        cancelamentoConsultaRepository.save(cancelamento);
        return new DadosDetalhamentoCancelamentoConsulta(cancelamento);
    }
}
