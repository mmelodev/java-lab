package Alura.string_regex;

import java.util.Scanner;

public class ConverterMaiusculasMinusculas {
    static void main() {
        Scanner n = new Scanner(System.in);

        System.out.println("Digite o texto: ");
        String texto = n.next();

        System.out.println("Texto em maiusculas: " + texto.toUpperCase());
        System.out.println("Texto em minusculas: " + texto.toLowerCase());
    }
}
