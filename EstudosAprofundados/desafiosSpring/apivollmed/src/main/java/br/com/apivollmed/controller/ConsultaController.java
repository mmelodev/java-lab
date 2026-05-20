package br.com.apivollmed.controller;

import br.com.apivollmed.domain.consulta.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private CancelarConsultaService cancelarConsultaService;

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    public ResponseEntity agendamento(@RequestBody @Valid DadosAgendamentoConsulta dados) {

        var dto = consultaService.agendar(dados);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/cancelar")
    public ResponseEntity cancelamento(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        var dto = cancelarConsultaService.cancelar(dados);
        return ResponseEntity.ok(dto);
    }
}
