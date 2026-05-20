package Alura.repeticoes;

import java.util.Scanner;

public class ContagemDegraus {
    static void main() {
        Scanner v = new Scanner(System.in);

        System.out.println("Digite a quantidade de degraus: ");
        int degraus = v.nextInt();

        for (int i = 1; i <= degraus; i++){
            System.out.println("Subindo o degrau " + i);
            if (i == degraus){
                System.out.println("Você chegou no topo!");
            }
        }
    }
}
