package Alura.condicionais;

import java.util.Scanner;

public class VerificacaoTriangulo {
    static void main() {
        Scanner l = new Scanner(System.in);

        System.out.println("Digite o primero lado: ");
        int lado1 = l.nextInt();
        System.out.println("Digite o segundo lado: ");
        int lado2 = l.nextInt();
        System.out.println("Digite o terceito lado: ");
        int lado3 = l.nextInt();

        if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1){
            System.out.println("Os lados podem formar um triângulo");
        } else{
            System.out.println("Os lados não podem formar um triângulo");
        }
    }
}
