package Alura.condicionais;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class DiaUtil {
    static void main() {
        List<String> diasDaSemana = Stream.of("segunda", "terça", "quarta", "quinta", "sexta").toList();
        //ou poderia ser apenas -> String[] diasDaSemana = {"segunda", "terça", "quarta", "quinta", "sexta"};

        Scanner d = new Scanner(System.in);
        System.out.println("Digite o dia da semana (em letras minúsculas): ");
        String dia = d.next();

        if (diasDaSemana.contains(dia)){
            System.out.println(dia.toUpperCase() + " é um dia útil");
        } else{
            System.out.println(dia.toUpperCase() + " não é um dia útil");
        }
    }
}
