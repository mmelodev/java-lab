package Alura.string_regex;

import java.util.Scanner;

public class SubstituindoParteString {
    static void main() {
        Scanner p = new Scanner(System.in);

        System.out.println("Digite o texto: ");
        String frase = p.nextLine();
        System.out.println("Digite a palavra a ser substituida: ");
        String palavraAntiga = p.nextLine();
        System.out.println("Digite a nova palavra: ");
        String palavraNova = p.nextLine();

        if (!frase.contains(palavraAntiga)){
            System.out.println("Palavra não encontrada!");
        } else {
            System.out.println("Texto modificado: " + frase.replace(palavraAntiga, palavraNova));
        }
    }
}