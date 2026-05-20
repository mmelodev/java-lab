package Alura.repeticoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleAcessosConvidados {
    static void main() {
        List<String> listaConvidados = new ArrayList<>();

        Scanner l = new Scanner(System.in);

        System.out.println("Digite o nome do convidado (ou 'ver' para visualizar a lista, 'sair' para terminar): ");
        String resposta = l.nextLine().trim();

        if (!resposta.equalsIgnoreCase("ver") || !resposta.equalsIgnoreCase("sair")){
            listaConvidados.add(resposta);
        }

        while (!resposta.equalsIgnoreCase("sair")){
            if (resposta.equalsIgnoreCase("ver")){
                System.out.println(listaConvidados);
            }
            System.out.println("Digite o nome do convidado (ou 'ver' para visualizar a lista, 'sair' para terminar): ");
            resposta = l.nextLine().trim();
            if (!resposta.equalsIgnoreCase("ver")){
                String finalResposta = resposta;
                listaConvidados.removeIf(convidado -> convidado.equalsIgnoreCase(finalResposta));
                listaConvidados.add(resposta);
            }
        }
    }
}
