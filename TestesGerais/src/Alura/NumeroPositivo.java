package Alura;

import java.util.Scanner;

public class NumeroPositivo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite um número: \n");
        int numeroUSer = input.nextInt();

        if (numeroUSer < 0) {
            System.out.println("O número digitado é negativo \n");
        } else {
            System.out.println("O número digitado é positivo\n");
        }
    }
}
