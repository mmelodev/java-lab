import br.com.minhalivraria.modelos.colecaoController;

public class Main {

    public static void main(String[] args) {
        colecaoController visualizar = new colecaoController();

        visualizar.visualizarColecao();

        visualizar.mostrarQuantidadeLivrosCadastrados();
    }
}
