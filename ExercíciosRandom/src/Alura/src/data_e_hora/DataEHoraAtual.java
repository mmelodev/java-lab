package Alura.data_e_hora;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class DataEHoraAtual {
    static void main() {
        Scanner t = new Scanner(System.in);
        Boolean ativo = true;

        while (ativo){
            System.out.println("Deseja adicionar uma nova tarefa? (y/n)");
            String resposta = t.nextLine();
            if (resposta.equalsIgnoreCase("y")){
                System.out.println("Digite sua tarefa: ");
                String tarefa = t.nextLine();
                LocalDate dataAtual = LocalDate.now();
                ZonedDateTime horaAtual = ZonedDateTime.now();
                System.out.println("Sua tarefa foi confirmada!\nTarefa: " + tarefa +"\nData: " + dataAtual +" - Hora: " + horaAtual);
            } else{
                System.out.println("Encerrando gerenciador de tarefas.");
                ativo = false;
            }
        }
    }
}
