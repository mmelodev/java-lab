package exceptions;

public class ErrorCasoZero extends RuntimeException {

    private String mensagem;

    public ErrorCasoZero(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
