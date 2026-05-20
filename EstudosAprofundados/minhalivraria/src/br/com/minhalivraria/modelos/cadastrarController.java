package br.com.minhalivraria.modelos;
import java.util.*;

public class cadastrarController {
    livrosController novoLivro = new livrosController();

    private int id = 0; //nesse caso, vou iniciar em zero
    private int quantidadelivrosCadastrados = 0;


    public void cadastrar(){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do livro: \n");
        String livroAdd = input.next();
        input.nextLine();
        novoLivro.setNome(livroAdd);

        System.out.println("\nDigite o ano de Lançamento: \n");
        int anoDeLancamento = input.nextInt();
        input.nextLine();
        novoLivro.setAnoDeLancamento(anoDeLancamento);

        System.out.println("\nDigite o nome do autor: \n");
        String novoAutor = input.next();
        novoLivro.setNomeDoAutor(novoAutor);

        System.out.println("\nDigite o genero: \n");
        String novoGenero = input.next();
        novoLivro.setGenero(novoGenero);

        System.out.println("\nDigite o preço do livro: \n");
        double preco = input.nextDouble();
        input.nextLine();
        novoLivro.setPreco(preco);

        System.out.println("\nLivro Cadastrado com sucesso!\n");

        id++;
        quantidadelivrosCadastrados++;
    }

    public void mostrarCadastro(){
        System.out.println("***************************\n");
        System.out.println("Cadastro de Livros - Último Livro que foi Cadastrado\n");
        System.out.println("***************************\n");
        System.out.println("Nome do livro: " + novoLivro.getNome() + "\n");
        System.out.println("Ano de Lançamento:  " + novoLivro.getAnoDeLancamento() + "\n");
        System.out.println("Autor: " + novoLivro.getNomeDoAutor() + "\n");
        System.out.println("Genero: " + novoLivro.getGenero() + "\n");
        System.out.println("Preço do Livro: " + novoLivro.getPreco() + "\n");
        System.out.println("ID: " + id + "\n");
        System.out.println("***************************\n");
    }

    public int getQuantidadelivrosCadastrados() {
        return quantidadelivrosCadastrados;
    }
}
