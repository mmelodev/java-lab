package br.com.apivollmed.controller;

import br.com.apivollmed.domain.medico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroMedicos dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);

        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        //isso é um tópico que deve ser estudo aprofundadamente, mas o UriComponentsBuilder se trata de metódo do Spring para pegar toda a URI e converter para um cabeçalho que possa ser usado de outras formas, como no ResponseEntity, ou seja, o Spring vai fazer esse trabalho de encurtar o caminho encontrado (a URI completa) e aqui só preciso especificar o endpoint (medicos/{id}).
        //status 201

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
        // return ResponseEntity.created(uri -> cabeçalho).body(dto que vai ser apresentado como corpo da requisição);
        //É importante seguir essa estrutura, pois queremos gerar o código 201 HTTP o código de created, o mais interessante para esse método POST, e o status 201 tem algumas regras de estrutura.
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicos>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);

        return ResponseEntity.ok(page); //Devolve código 200 devolvendo o objeto page como retorno da requisição
    }

    @PutMapping
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico)); //foi importante, pois quero devolver a requisição todos os dados do médico incluindo os dados atualizados, então criei um DTO com um construtor que recebe o objeto Medico, lembrando que apontar diretamente para a entidade JPA, medico nesse caso, não é recomendado
        //status 200
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build(); //a ‘build’ serve para construir o objeto noContent do ResponseEntity -> Nesse caso vai retornar o status 204 de No Content (boa prática)
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico)); //http 200
        //exibir as informações de um médico específico.
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarPorId(@PathVariable Long id, @RequestBody DadosAtualizacaoMedicos dados) {
        var medico = repository.getReferenceById(id);
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico)); //200
    }

    // lembrando que vou precisar usar essa estrutura para pacientes também:
    // controllers, entity, dto e etc
}
