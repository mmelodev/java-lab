package br.com.apivollmed.controller;

import br.com.apivollmed.domain.usuario.DadosAutenticacao;
import br.com.apivollmed.domain.usuario.Usuario;
import br.com.apivollmed.infra.security.TokenDadosJWT;
import br.com.apivollmed.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha()); //precisa chamar esse DTO do próprio spring UsernamePasswor...
        var authentication = manager.authenticate(authToken); //usuario atenticado no sistema
        //agora o controller deve retornar o token (no stateless preciso validar o token seguindo o padrão JWT)
        //https://www.jwt.io/
        //adicionei a lib do auth0 no pom.xml

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new TokenDadosJWT(tokenJWT)); //gerando token para o objeto usuário, o ideal é utilizar o DTO do nosso tokenService, da mesma forma que os outros controllers recebem outros DTOs também.
    }
}
