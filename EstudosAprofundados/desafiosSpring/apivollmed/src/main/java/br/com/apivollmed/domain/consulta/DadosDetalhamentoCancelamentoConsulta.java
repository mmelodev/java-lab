package br.com.apivollmed.domain.consulta;

public record DadosDetalhamentoCancelamentoConsulta(Long id, Long idConsulta, MotivoCancelamento motivo) {
    public DadosDetalhamentoCancelamentoConsulta(CancelamentoConsulta cancelamentoConsulta) {
        this(cancelamentoConsulta.getId(), cancelamentoConsulta.getConsultaId().getId(), cancelamentoConsulta.getMotivo());
    }
}
