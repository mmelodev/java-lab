package Alura.repeticoes;

import java.util.Scanner;

public class NomeValido {
    static void main() {
        Scanner n = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = n.next();

        if (nome.length() >= 3){
            System.out.println("Nome '" + nome + "' castrado com sucesso!");
        } else{
            while(nome.length() <= 3){
                System.out.println("Nome inválido. Digite novamente. ");
                System.out.println("Digite seu nome: ");
                nome = n.next();
                if (nome.length() >= 3){
                    System.out.println("Nome '" + nome + "' castrado com sucesso!");
                    break;
                }
            }
        }
    }
}