public class ErroCasoSenhaOito extends RuntimeException {
    private String mensagem;

    public ErroCasoSenhaOito(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
