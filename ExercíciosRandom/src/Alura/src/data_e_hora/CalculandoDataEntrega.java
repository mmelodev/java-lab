package Alura.data_e_hora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculandoDataEntrega {
    static void main() {
        int prazoEmDias = 10;
        Scanner d = new Scanner(System.in);

        System.out.println("Digite a data de inicio (Ex:2026-01-22): ");
        String data = d.nextLine();

        LocalDate dataa = LocalDate.parse(data);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataIncio = dataa.plusDays(prazoEmDias).format(formatador);
        System.out.println("Data de entrega: " + dataIncio);

    }
}
