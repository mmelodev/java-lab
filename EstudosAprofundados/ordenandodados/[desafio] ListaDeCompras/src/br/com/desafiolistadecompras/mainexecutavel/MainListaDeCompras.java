package br.com.desafiolistadecompras.mainexecutavel;

import br.com.desafiolistadecompras.modelos.*;

import java.util.*;

import static java.lang.Double.sum;

public class MainListaDeCompras {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner n = new Scanner(System.in);

        System.out.println("Olá, como vai? Antes de saber mais sobre você, precisamos entender sua situação financeira.\n Digite o limite atual do seu cartão de crédito: \n>> ");
        double limite = input.nextDouble();

        System.out.println("\nPerfeito, agora vamos saber mais sobre você.\n Digite seu nome: \n>> ");
        String nome = n.next();

        var comprador = new PessoaComprador(nome, limite);

        System.out.println("*********************************" +
                "\nBEM-VINDO A LOJA ONLINE, " + comprador.getNomePessoaComprador() +
                "\n*********************************");

        List<Produtos> listadeprodutos = new LinkedList<>();
        Collections.sort(listadeprodutos); // falta só  corrigir esse sort aqui, não aprendi a fazer isso direito ainda
        double totalValorGasto = 0;
        double valorRestanteCartao = comprador.getLimiteCartaoPessoaComprador();

        while (true) {
            Scanner e = new Scanner(System.in);

            System.out.println("\n[ MENU ]\nDigite 1 para lançar uma nova compra. \nDigite 0 para sair do menu.\n>>");

            int escolha = e.nextInt();

            if (totalValorGasto > comprador.getLimiteCartaoPessoaComprador()){
                System.out.println("\nSeu limite foi atingido, aumente seu limite para fazer mais compras!\n");

                System.out.println(listadeprodutos);

                System.out.println("\nNome: " + comprador.getNomePessoaComprador() + "\nLimite: R$ " + comprador.getLimiteCartaoPessoaComprador() + "\nTotal gasto: R$ " + totalValorGasto + "\nSaldo Atual do Cartão: R$ " + valorRestanteCartao);
                break;
            } else if (escolha == 1) {

                Scanner np = new Scanner(System.in);
                Scanner vp = new Scanner(System.in);

                System.out.println("\nDigite o nome do produto que deseja comprar: \n>> ");
                String nomeprod = np.next();

                System.out.println("\nDigite o valor do produto: \n>> ");
                double valorprod = vp.nextDouble();

                var novoProduto = new Produtos(nomeprod, valorprod);

                listadeprodutos.add(novoProduto);

                totalValorGasto += novoProduto.getValorProduto();

                System.out.println("Produto adicionado!");

                for (Produtos valor : listadeprodutos){
                    valorRestanteCartao -= valorprod;
                }
            } else if (escolha == 0) {

                System.out.println(listadeprodutos);

                System.out.println("\nNome: " + comprador.getNomePessoaComprador() + "\nLimite: R$ " + comprador.getLimiteCartaoPessoaComprador() + "\nTotal gasto: R$ " + totalValorGasto + "\nSaldo Atual do Cartão: R$ " + valorRestanteCartao);
                //Exibir relatório final das compras realizadas
                break;
            } else {
                System.out.println("\nOpção inválida, tente novamente");
            }
        }
    }
}
