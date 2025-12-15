package br.com.viacep.exceptions;

public class ErroDeServidor extends Throwable {
    private String mensagem;

    public ErroDeServidor(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
