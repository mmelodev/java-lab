package br.com.viacep.exceptions;

public class ErroDeDigitacaoCep extends Throwable {
    private String mensagem;

    public ErroDeDigitacaoCep(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
