package br.com.apivollmed.domain.medico;

import br.com.apivollmed.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedicos(Long id, String nome, String telefone, DadosEndereco endereco) {
}
