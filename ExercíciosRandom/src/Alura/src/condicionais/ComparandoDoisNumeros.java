package Alura.condicionais;

import java.util.Scanner;

public class ComparandoDoisNumeros {
    static void main() {
        Scanner n = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        double numero1 = n.nextDouble();

        System.out.println("Digite o segundo número: ");
        double numero2 = n.nextDouble();

        if (numero1 > numero2){
            System.out.println("O maior número é " + numero1);
        } else if (numero2 > numero1){
            System.out.println("O maior número é: " + numero2);
        } else{
            System.out.println("Ambos números são iguais");
        }
    }
}
