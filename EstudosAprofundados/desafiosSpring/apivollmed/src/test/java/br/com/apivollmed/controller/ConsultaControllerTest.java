package br.com.apivollmed.controller;

import br.com.apivollmed.domain.consulta.ConsultaService;
import br.com.apivollmed.domain.consulta.DadosAgendamentoConsulta;
import br.com.apivollmed.domain.consulta.DadosDetalhamentoConsulta;
import br.com.apivollmed.domain.medico.Especialidade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

    //testes de unidade - mock
    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosAgendamentoConsulta> dadosAgendamentoConsultaJacksonTester; //controller recebe isso

    @Autowired
    private JacksonTester<DadosDetalhamentoConsulta> dadosDetalhamentoConsultaJacksonTester;
    //controller retorna isso

    @MockitoBean //realizar um mock desse consultaService, ou seja, não vai acessar diretamente a classe e nem o db
    private ConsultaService consultaService;

    @Test
    @DisplayName("Deve devolver código http 400 quando informações estão inválidas")
    @WithMockUser
        //usuario mockado = usuario logado ou seja vai sobrepor a segurança de token jwt
    void agendamento_cenario1() throws Exception {
        var response = mvc.perform(post("/consulta"))
                .andReturn().getResponse(); //dispara a requisição

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value()); //devolve o http 400
    }

    @Test
    @DisplayName("Deve devolver código http 200 quando informações estão válidas")
    @WithMockUser
    void agendamento_cenario2() throws Exception {
        var data = LocalDateTime.now().plusHours(1);
        var especialidade = Especialidade.CARDIOLOGIA;

        var dadosDetalhamento = new DadosDetalhamentoConsulta(null, 2L, 5L, data);

        when(consultaService.agendar(any())).thenReturn(dadosDetalhamento);

        var response = mvc.perform(post("/consulta").contentType(MediaType.APPLICATION_JSON).content(dadosAgendamentoConsultaJacksonTester.write(new DadosAgendamentoConsulta(2L, 5L, data, especialidade)).getJson()))
                .andReturn().getResponse(); //simulando a requisição com o json

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = dadosDetalhamentoConsultaJacksonTester.write(dadosDetalhamento).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado); //verificando se o Json recebido está correto
    }
}