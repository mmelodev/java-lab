package Alura.data_e_hora;

import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiferencaEntreHoras {
    static void main() {
        Scanner h = new Scanner(System.in);

        System.out.println("Digite a hora de começo dos trabalhos (Ex: 12:30): ");
        String horaDoComeco = h.nextLine();
        System.out.println("Digite a hora de fim dos trabalhos: ");
        String horaFinal = h.nextLine();

        LocalTime horaComeco = LocalTime.parse(horaDoComeco);
        LocalTime horaFim = LocalTime.parse(horaFinal);

        Duration duracao = Duration.between(horaComeco, horaFim);
        System.out.println("Diferença de tempo: " + duracao.toHours() + " horas e " + duracao.toMinutesPart() + " minutos");
    }
}
