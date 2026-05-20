package br.com.apivollmed.infra.security;

import br.com.apivollmed.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component //Nesse cenário, o @Component é um componente genérico, apenas para o Spring carrega a classe corretamente.
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    //essa classe extendida implementa o Filter do jakarta, ou seja, estamos chamando um filter por de baixo dos panos
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //esse metodo garante que vai ser validado apenas uma vez a cada requisição.

        //System.out.println("FILTRO CHAMADO"); -> vai mostrar filtro gerado a cada requisição
        //Agora o filtro precisa chamar alguma coisa, chamar algum metodo, seguir o fluxo da requisição

        //lógica de recuperar o token, mas como isso acontece?
        //O token vai no cabeçalho de um protocolo http, ou seja, no cabeçalho authorization

        //isso que o front-end deve fazer, na requisição deve ser enviado um cabeçalho authorization contendo o token

        //agora vamos recuperar esse cabeçalho

        var tokenJWT = recuperarToken(request);

        //agora vamos validar o token do cabeçalho

        if (tokenJWT != null) {
            var subject = tokenService.getSubjetc(tokenJWT);
            //forçar o spring a considerar essa autenticação com verdadeira
            var usuario = repository.findByLogin(subject);//no subject guardei o login

            //metodos do spring para forçar essa autenticação, estudar mais
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } //se o token não estar nulo, então eu pego o subject

        //System.out.println(subject); //vai mostrar o login do usuario

        filterChain.doFilter(request, response); //encaminha para o próximo filtro, ou seja, está processando o request e o response corretamente, essa é a lógica do filtro. Se eu não quero chamar o próximo? Então apago essa linha
    }

    private String recuperarToken(HttpServletRequest request) {
        //token recuperado
        var authorizationHeader = request.getHeader("Authorization");
        // e se não existir o cabeçalho?
        //if (authorizationHeader == null) {
        //throw new RuntimeException("Token não enviado no cabeçalho Authorization");
        // }
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", ""); //assim consigo tirar o prefixo com esse replace padrão de uma String, é importante ter esse espaço em branco após o Bearer, pois vai evitar o erro 403
        }

        return null; //se não tiver estiver vindo o cabeçalho vou retornar valor nulo

    }
}
