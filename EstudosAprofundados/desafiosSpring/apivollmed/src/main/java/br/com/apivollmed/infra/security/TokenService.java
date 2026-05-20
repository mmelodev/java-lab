package br.com.apivollmed.infra.security;

import br.com.apivollmed.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    //geração do token JWT coma lib do auth0

    @Value("${api.security.token.secret}") //passando o application.properties
    private String secret; //adicionando no applicatio.propeties
    //api.security.token.secret=${JWT_SECRET:12345678} aqui eu to dizendo pro spring procurar alguma varivel de ambiente, se não encontrar usa essa sequencia númerica
    //em nível de produção é importante deixar tudo isso apenas em variavel de ambiente e configurar no servidor que vai subir o projeto.


    public String gerarToken(Usuario usuario) {
        System.out.println(secret); //vai aparecer no console após alguma requisição de login. Teste -> se eu configurar a variavel de ambiente localmente, vai aparecer no console também?
        try {
            var algoritmo = Algorithm.HMAC256(secret); //aqui recebe uma string que vai ser a senha desse algoritmo que não deve ser compartilhada
            //Criação do token:
            return JWT.create()
                    .withIssuer("API voll.med") //nossa lib / ferramenta -> personalizavel
                    //Ponte com as infos do usuários
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    //o withClaim são todas as informações que eu quero que contenha no token, exemplo cpf do usuário ou alguma preferência específica.
                    //é recomendado adicionar data de expiração do token por segurança
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token jwt - ", exception);
        }
    }

    //agora aqui preciso fazer um metodo que valide as informações do usuário, ou seja, o withSubject acima
    public String getSubjetc(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API voll.med")
                    .build()
                    .verify(tokenJWT) //aqui ele fez a validação, se não tiver lança um erro
                    .getSubject(); //aqui ele puxa aquele Subject
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }

    //metodo para criar a data de expiração, nesse caso foi de 2 horas
    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
