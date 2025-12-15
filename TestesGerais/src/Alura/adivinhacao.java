package Alura;

import java.util.*;

public class adivinhacao {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int numeroSorte = new Random().nextInt(100);

        int tentativas = 0;

        System.out.println("O número foi sorteado! \n");

        for (int i = 1; i != numeroSorte; i++) {
            System.out.println("Digite um número entre 1 e 100: \n");
            int numeroUSer = input.nextInt();

            if (numeroUSer < 0 || numeroUSer > 100) {
                System.out.println("Número inválido, tente novamente");
                break;
            }
            else if (numeroUSer > numeroSorte){
                System.out.println("Número da Sorte é menor que o digitado");
                tentativas++;
            }
            else if (numeroUSer < numeroSorte){
                System.out.println("Número da Sorte é maior que o digitado");
                tentativas++;
            }
            else {
                System.out.println("Parabéns, você acertou! \n");
                System.out.println("Suas tentativas foram: " + tentativas);
                break;
            }
        }
    }
}