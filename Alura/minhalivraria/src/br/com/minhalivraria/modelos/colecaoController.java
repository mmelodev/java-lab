package br.com.minhalivraria.modelos;
import java.util.*;

public class colecaoController {

    Scanner input = new Scanner(System.in);
    cadastrarController novaColecao = new cadastrarController();

    public boolean visualizarColecao(){

        while (true) {

            System.out.println("Você deseja cadastrar um novo livro? {y/n} \n");
            String escolha = input.next();

            if (escolha.equals("y")) {
                novaColecao.cadastrar();
            } else{
                novaColecao.mostrarCadastro();
                return false;
            }

        }
    }

    public void mostrarQuantidadeLivrosCadastrados(){
        System.out.println("\nA Quantidade de Livros Cadastrados: " + novaColecao.getQuantidadelivrosCadastrados() + "\n");
    }


}
