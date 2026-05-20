package br.com.apivollmed.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    //mudar de statefull para stateless

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    //anotação serve para devolver o objeto para o spring, ou seja, para o objeto ser usado de fato pelo string
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(c -> c.disable()).sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authorizeHttpRequests(req -> req.requestMatchers("/login").permitAll()
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll() //permissão para documentação do spring doc acessar a API
                        //agora garantimos que toda requisição com essa URL seja permitida sem o token
                        .anyRequest().authenticated()//para outras requisições é necessário estár autenticado, ou seja, com o token
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) //aqui estou garantindo com meu filtro venha antes do filtro de segurança do spring
                .build();
        //sintaxe com a atualização do spring security
        //desabilitar csrf pois o token já faz a proteção do csrf
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
        //esse metodo é apenas para criar o authenticationManager que vou usar no AutenticacaoController, pois eu não consigo usar o @Autowired direto no AuthenticationManager
        //basicamente ensinando pro Spring, por isso vou usar novamente o @Bean para injetar um objeto em algum lugar
    }

    //agora vamos trabalhar com encriptação de senhas no spring
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //reflexão -> no dia a dia, o cliente vai acessar uma página que contém uma requisição POST para fazer um cadastro, porém o cliente obviamente não vai passar uma senha encriptada, então, preciso de algum algoritmo que nesse meio termo converta automaticamente a senha que o cliente adicionou para o BCript e realize o INSERT no banco de dados com essa senha encriptada, daí aqui no java consigo utilizar esse PasswordEncoder para desencriptar.
    }
}
