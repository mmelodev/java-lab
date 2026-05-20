package Alura.string_regex;

import java.util.Scanner;

public class StringContemSubstring {
    static void main() {
        Scanner t = new Scanner(System.in);
        System.out.println("Digite o texto: ");
        String texto = t.nextLine();
        System.out.println("Digite a palavra: ");
        String palavra = t.nextLine();

        if (texto.contains(palavra)){
            System.out.println("A palavra " + palavra + " está presente no texto");
        } else{
            System.out.println("A palavra não está presente no texto");
        }
    }
}
