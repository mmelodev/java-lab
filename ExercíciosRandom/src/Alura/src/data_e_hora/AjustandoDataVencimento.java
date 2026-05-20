package Alura.data_e_hora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AjustandoDataVencimento {
    static void main() {
        Scanner d = new Scanner(System.in);

        System.out.println("Digite a data de vencimento original (Ex:2026-01-22): ");
        String dataDeVencimentoOriginal = d.nextLine();
        System.out.println("Adicione o número de meses ao vencimento: ");
        int numeroDeMesesVencimento = d.nextInt();

        LocalDate data = LocalDate.parse(dataDeVencimentoOriginal);
        DateTimeFormatter dataVencimentoFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataFormatada = data.plusMonths(numeroDeMesesVencimento).format(dataVencimentoFormatada);
        System.out.println("Nova data de vencimento: " + dataFormatada);


    }
}
