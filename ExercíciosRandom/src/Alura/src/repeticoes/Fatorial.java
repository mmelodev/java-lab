package Alura.repeticoes;

import java.util.Scanner;

public class Fatorial {
    static void main() {
        Scanner n = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int numero = n.nextInt();
        int contador = 1;

        for (int i = 1; i <= numero; i++) {
            contador *= i;
        }
        System.out.println("O fatorial de " + numero + " é: " + contador);
    }
}
