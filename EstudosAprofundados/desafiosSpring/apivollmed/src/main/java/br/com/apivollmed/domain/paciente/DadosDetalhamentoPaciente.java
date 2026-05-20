package br.com.apivollmed.domain.paciente;

import br.com.apivollmed.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone, String cpf, String rg,
                                        String dataNascimento, String convenio, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getRg(), paciente.getDataNascimento(), paciente.getConvenio(), paciente.getEndereco());
    }
}
