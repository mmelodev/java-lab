package Alura.string_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraindoParteString {
    static void main() {

        Scanner t = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        String arquivo = t.nextLine();

        System.out.println("Nome do arquivo corrigido: " + arquivo.replaceAll("\\.\\w+$", ""));
    }
}
