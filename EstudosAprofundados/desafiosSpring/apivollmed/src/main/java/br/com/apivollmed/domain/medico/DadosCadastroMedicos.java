package br.com.apivollmed.domain.medico;

import br.com.apivollmed.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedicos(Long id, @NotBlank String nome, @NotBlank @Email String email,
                                   @NotBlank String telefone, @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
                                   @NotNull Especialidade especialidade, @NotNull @Valid DadosEndereco endereco) {

    @Override
    public String toString() {
        return "Médico" + "nome='" + nome + '\n' + ", email='" + email + '\n' + ", crm='" + crm + '\n'
                + ", especialidade=" + especialidade + "\n" + ", endereco=" + endereco + "\n";
    }
}