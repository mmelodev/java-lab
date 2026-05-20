package br.com.rpgbasico.gameplay;

import java.util.*;

public class menuDoJogo {
    public boolean mainMenu(){

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        while (true){
            System.out.println("\nIdade Média RPG Básico\n\n" +
                    "****************************************************\n\n" +
                    "Escolha uma das opções abaixo: \n");

            System.out.println("Jogar (Digite 1): \n" +
                    "Sair (Digite 2): \n");
            int opcao = input.nextInt();
            if (opcao == 1){

                System.out.println("Jogo Iniciado!\n");
                System.out.println("********************************************************\n\n");
                System.out.println("Deseja pular a história (s/n)");
                String opcao2 = input2.next();
                if (opcao2.equals("s")){
                    primeiraparte novoJogo = new primeiraparte();
                    novoJogo.capituloUm();
                } else if (opcao2.equals("n")){
                    historia novaHistoria = new historia();
                    novaHistoria.introducao();
                }
            } if (opcao == 2){
                return false;
            }
            return false;
        }

    }
}
