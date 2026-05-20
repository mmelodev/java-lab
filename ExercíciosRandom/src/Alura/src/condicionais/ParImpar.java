package Alura.condicionais;

import java.util.Scanner;

public class ParImpar {
    static void main(String[] args) {
        Scanner num = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int numero = num.nextInt();

        if (numero % 2 == 0){
            System.out.println("Número é par");
        } else{
            System.out.println("Número é impar");
        }
    }
}
