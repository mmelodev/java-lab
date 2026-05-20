package Alura.data_e_hora;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FormatandoDataEHora {
    static void main() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String data = dataAtual.format(formatadorData);

        ZonedDateTime horaAtual = ZonedDateTime.now();
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
        String hora = horaAtual.format(formatadorHora);

        System.out.println("Data formatada: " + data);
        System.out.println("Hora formatada: " + hora);
    }
}
