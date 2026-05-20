package Alura.string_regex;

import java.util.Scanner;

public class RemovendoEspacos {
    static void main() {
        Scanner n = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        String nome = n.nextLine().trim();

        System.out.println("Nome sem espaços: " + nome);
    }
}
