package br.com.apivollmed.domain.paciente;

import br.com.apivollmed.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroPaciente(Long id, @NotBlank String nome, @NotBlank @Email String email,
                                    @NotBlank String telefone, @NotBlank String cpf, String rg,
                                    @NotNull LocalDate dataNascimento, @NotBlank String convenio,
                                    @NotNull DadosEndereco endereco) {
}
