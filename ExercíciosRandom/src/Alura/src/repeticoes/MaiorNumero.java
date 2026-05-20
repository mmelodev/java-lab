package Alura.repeticoes;

import java.util.Scanner;

public class MaiorNumero {
    static void main() {
        Scanner n = new Scanner(System.in);

        System.out.println("Digite os números separados por espaço: ");
        String[] valores = n.nextLine().split(" ");
        int maior = Integer.MIN_VALUE;

        for (String numString : valores){
            int num = Integer.parseInt(numString);
            if (num > maior){
                maior = num;
            }
        }

        System.out.println("O maior número é: " + maior);
    }
}