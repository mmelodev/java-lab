package modelos;

import java.util.Scanner;

public class LojaEletronicos {
    public boolean LojaEletronico(){
        while (true){
            Scanner input = new Scanner (System.in);
            System.out.println("\n=====================================\n" +
                    "Bem-Vindo(a) à sua loja de eletrônicos! Trabalhamos a partir do produto que você deseja obter!" +
                    "\nVeja abaixo a lista de opções de produtos que temos diponível e o número correspondente." +
                    "\n=====================================" +
                    "\nOpções:" +
                    "\n1 - Celulares" +
                    "\n2 - Computadores" +
                    "\n3 - SmartWatchs" +
                    "\n4 - Sair da Loja" +
                    "\n=====================================" +
                    "\nDigite a opção que deseja escolher: \n>>");

            int opcao = input.nextInt();

            if (opcao == 4){
                System.out.println("\nAdeus!!\n");
                return false;
            } else if (opcao == 1){

            } else if (opcao == 2){

            } else if (opcao == 3){

            } else {
                System.out.println("Opção inválida, tente novamente!");
            }
        }
    }
}
