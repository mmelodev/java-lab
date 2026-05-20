package br.com.apivollmed.domain.medico;

import br.com.apivollmed.domain.consulta.Consulta;
import br.com.apivollmed.domain.endereco.DadosEndereco;
import br.com.apivollmed.domain.paciente.DadosCadastroPaciente;
import br.com.apivollmed.domain.paciente.Paciente;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDataBase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test") //se conecta com application-test.properties
//uma recomendação é criar outro db apenas para os testes. -> nesse caso apivollmed_test
class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    void escolherMedicoAleatorioPorData() {
    }

    //cada metodo de teste é isolado, tese acontece -> registros são deletados do db

    @Test
    @DisplayName("Deveria devolver null quando unico médico cadastrado não está disponível na data")
    void escolherMedicoAleatorioPorDataCenario1() {
        //given ou arrange
        var proximaSegundaAs10 = LocalDateTime.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);

        var medico = cadastrarMedico("Medico", "medioco@vollmed", 234, Especialidade.CARDIOLOGIA);
        var paciente = cadastrarPaciente("Paciente", "paciente@email.com", 00000000000);
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);

        //when ou cat
        var medicoLivre = repository.escolherMedicoAleatorioPorData(Especialidade.CARDIOLOGIA, proximaSegundaAs10);

        //assert
        assertThat(medicoLivre).isNull();

        //isso aqui é um pouco da estrutura de trabalho de um QA, pelo menos, a lógica e a ordem das ações -> Dado que, quando, quero.
    }

    @Test
    @DisplayName("Deveria devolver null quando ele estiver disponivel na data")
    void escolherMedicoAleatorioPorDataCenario2() {
        var proximaSegundaAs10 = LocalDateTime.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);

        var medico = cadastrarMedico("Medico", "medioco@vollmed", 234, Especialidade.CARDIOLOGIA);

        var medicoLivre = repository.escolherMedicoAleatorioPorData(Especialidade.CARDIOLOGIA, proximaSegundaAs10);
        assertThat(medicoLivre).isEqualTo(medico);
    }

    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        em.persist(new Consulta(null, medico, paciente, data));
    }

    private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade) {
        var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
        em.persist(medico);
        return medico;
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private DadosCadastroMedicos dadosMedico(String nome, String email, String crm, Especialidade especialidade) {
        return new DadosCadastroMedicos(
                nome,
                email,
                "61999999999",
                crm,
                especialidade,
                dadosEndereco()
        );
    }

    private DadosCadastroPaciente dadosPaciente(String nome, String email, String cpf) {
        return new DadosCadastroPaciente(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }


}