package br.com.apivollmed.domain.paciente;

import br.com.apivollmed.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPacientes(@NotNull Long id, String nome, String email, String telefone,
                                        DadosEndereco endereco) {
}
