package Alura.repeticoes;

import java.util.Scanner;

public class PulandoNumerosTerminam5 {
    static void main() {
        Scanner n = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int numero = n.nextInt();

        for (int i = 1; i <= numero; i++){
            if (i % 10 == 5){
                continue;
            }
            System.out.println(i);
        }
    }
}
