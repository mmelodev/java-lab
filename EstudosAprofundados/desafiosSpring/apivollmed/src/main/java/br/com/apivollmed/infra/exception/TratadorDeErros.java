package br.com.apivollmed.infra.exception;

import br.com.apivollmed.domain.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class) //404
    public ResponseEntity trataErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //400
    public ResponseEntity trataErro400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors(); //lista de erros que ocorerram
        return ResponseEntity.badRequest().body(erros.stream().map(dadosErroValidacao::new).toList());//com body não precisa do build
    }

    @ExceptionHandler(ValidacaoException.class) //400
    public ResponseEntity trataErroValidacoes(ValidacaoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    
    //DTO para retornar os campos que eu quero que o clinte veja

    private record dadosErroValidacao(String campo, String mensagem) {
        public dadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage()); //metodos para pegar os campos e mensagems mais simplificadas de erro
        }
    }
}
