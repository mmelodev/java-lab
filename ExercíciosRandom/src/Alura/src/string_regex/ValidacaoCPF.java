package Alura.string_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoCPF {
    static void main() {
        Pattern pattern = Pattern.compile("(\\d{3})\\.(\\d{3})\\.(\\d{3})-(\\d{2})");

        Scanner c = new Scanner(System.in);
        System.out.println("Digite o seu cpf: ");
        String cpf = c.nextLine();
        Matcher matcher = pattern.matcher(cpf);

        if(matcher.find()){
            System.out.println("O CPF " + matcher.group() + " está no formato válido");
        } else{
            System.out.println("O CPF não está no formato válido");
        }

    }
}
