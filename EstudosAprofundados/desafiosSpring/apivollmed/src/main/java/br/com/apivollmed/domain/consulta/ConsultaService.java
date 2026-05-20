package br.com.apivollmed.domain.consulta;

import br.com.apivollmed.domain.ValidacaoException;
import br.com.apivollmed.domain.consulta.validacao.ValidarAgendamento;
import br.com.apivollmed.domain.medico.Medico;
import br.com.apivollmed.domain.medico.MedicoRepository;
import br.com.apivollmed.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidarAgendamento> validadores; //pega todas as classes que implementam essa interface, isso aqui é bem legal

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        if (!pacienteRepository.existsById(dados.idPaciente())) { //se não existe paciente com esse id
            throw new ValidacaoException("ID Informado não existe!");
        }
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) { //o id do médico não poder ser nulo
            throw new ValidacaoException("ID Informado não existe!");
        }

        validadores.forEach(v -> v.validar(dados)); //aqui injetando todos os validadores, é importante estudar mais sobre isso -> Design Pattern Strategy mais ou menos

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente()); //O .get() no caso do findById serve para evitar erros, pois o findById retornar um Optional
        //var medico = medicoRepository.findById(dados.idMedico()).get(); -> o algoritmo deve ser para puxar um médico aleatorio do banco de dados, então, vou comentar e alterar essa linha
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data());

        repository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        //algoritmo de puxar medico aleatorio do db caso o id não esteja sendo enviado na requisição
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        //Agora, como o id não foi informado, eu quero escolher o medico aleatorio a partir da Especialidade que estou precisando, ou seja, eu fiz a inclusão do Enum de Especialidade no DTO DadosAgendamentoConsulta

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Nesse caso, Especialidade é Obrigatória.");
        }

        Pageable pageable = PageRequest.of(0, 1);

        Page<Medico> medicos = medicoRepository.escolherMedicoAleatorioPorData(
                dados.especialidade(),
                dados.data(),
                pageable);

        return medicos.getContent().stream()
                .findFirst()
                .orElseThrow(() -> new ValidacaoException("Nenhum médico disponível no momento"));
    }
}


