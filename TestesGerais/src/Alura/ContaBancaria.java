package Alura;

import java.util.*;

public class ContaBancaria {
    public static void main(String[] args) {

        //No contexto de "mundo real", iriamos tirar os dados de um banco de dados, nesse caso vamos definir valores pré-existentes

        boolean sistemaLigado = true;
        double saldoBancario = 0; //irei começar no zero e usuário vai adicionar mais grana.

        Scanner n = new Scanner(System.in);
        Scanner tc = new Scanner(System.in);
        Scanner oe = new  Scanner(System.in);

        System.out.println("*****************************\n");
        System.out.println("Bem-vindo ao seu Banco!\n");
        System.out.println("*****************************\n");

        //Aqui posso criar um sistema local de login para acessar o banco com dados pré-existentes

        System.out.println("Digite seu nome completo: \n");
        String nome = n.next();

        System.out.println("\nDigite o seu tipo de conta: \n");
        String tipoConta = tc.next();

        System.out.println("*****************************\n");
        System.out.println("Dados do Cliente - Seu Banco\n");
        System.out.println("Nome Completo: " + nome + "\n");
        System.out.println("Tipo de Conta Digitado: " + tipoConta + "\n");
        System.out.println("Saldo Bancário: " +  saldoBancario + "\n");
        System.out.println("*****************************\n");

        while (sistemaLigado) {
            System.out.println("\n| Menu de Opções |\n");
            System.out.println("\n|1. Saque|\n|2. Deposito|\n|3. Transferencia|\n|4. Ver Saldo|\n|5. Sair da Operação|\n");

            System.out.print(">> ");
            int opcaoEscolhida = oe.nextInt();

            if (opcaoEscolhida == 1) {
                Scanner qs = new Scanner(System.in);

                System.out.println("\nDigite a quantidade para o saque: \n");
                int quantidadeSaque = qs.nextInt();

                if (quantidadeSaque > saldoBancario) {
                    System.out.println("\nErro! Saldo Bancário é Insuficiente\n");
                } else if  (quantidadeSaque == 0) {
                    System.out.println("\nNenhum valor foi retirado\n");
                } else{
                    saldoBancario -= quantidadeSaque;

                    System.out.println("\nSaque feito com sucesso!\n");
                }
            } else if(opcaoEscolhida == 2) {
                Scanner qd = new Scanner(System.in);

                System.out.println("\nDigite a quantidade para o deposito: \n");
                int quantidadeDeposito = qd.nextInt();

                if(quantidadeDeposito < 0){
                    System.out.println("Erro! O valor do depósito não pode ser negativo\n");
                } else if(quantidadeDeposito == 0){
                    System.out.println("Nenhum valor foi depositado\n");
                } else{
                    saldoBancario += quantidadeDeposito;

                    System.out.println("\nDeposito feito com sucesso!");
                }

            } else if (opcaoEscolhida == 3) {
                Scanner qt = new Scanner(System.in);
                Scanner cp = new Scanner(System.in);
                Scanner nomept = new Scanner(System.in);

                System.out.println("\nNome da pessoa para quem vai transferir: \n");
                String nomePessoa = nomept.next();

                System.out.println("Chave pix da pessoa para quem vai transferir: \n");
                int chavePix = cp.nextInt();

                System.out.println("Quanto você vai transferir em (R$): \n");
                double quantidadeTransferencia = qt.nextDouble();

                //Aqui posso validar os tipos primitivos para impedir que o usuário digite um número no nomePessoa

                if (saldoBancario < quantidadeTransferencia){
                    System.out.println("Erro! Saldo Bancário Insuficiente\n");
                } else if (quantidadeTransferencia == 0) {
                    System.out.println("Nenhum valor foi transferido\n");
                } else{
                    saldoBancario -= quantidadeTransferencia;
                    System.out.println("\nTransferencia feito com sucesso!\n");
                    System.out.println("*****************************\n");
                    System.out.println("\n| Comprovante da Transferência | \n");

                    System.out.println("\nQuem Enviou - Seu Banco\n");
                    System.out.println("Nome: " + nome + "\n");
                    System.out.println("Tipo de Conta Digitado: " + tipoConta + "\n");


                    System.out.println("\nQuem Recebeu- Seu Banco\n");
                    System.out.println("Nome: " + nomePessoa + "\n");
                    System.out.println("Chave pix: " + chavePix + "\n\n");

                    System.out.println("O valor da trasnferência: R$" + quantidadeTransferencia + "\n");

                }

            } else  if (opcaoEscolhida == 4) {
                System.out.println("\n*****************************\n");
                System.out.println("Dados do Cliente - Seu Banco\n");
                System.out.println("Nome Completo: " + nome + "\n");
                System.out.println("Tipo de Conta Digitado: " + tipoConta + "\n");
                System.out.println("Saldo Bancário: " +  saldoBancario + "\n");
                System.out.println("*****************************\n");
            } else  if (opcaoEscolhida == 5) {
                break;
            } else {
                System.out.println("\nNúmero escolhido é inválido, tente novamente\n");
            }
        }
    }
}
