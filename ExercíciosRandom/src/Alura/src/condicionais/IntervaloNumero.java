package Alura.condicionais;

import java.util.Scanner;

public class IntervaloNumero {
    static void main() {
        Scanner n = new Scanner(System.in);

        System.out.println("Digite o valor do empréstimo: ");
        double emprestimo = n.nextDouble();

        if (emprestimo >= 1000 && emprestimo <= 5000){
            System.out.println("O valor " + emprestimo + ", está dentro do intervalo permitido para empréstimo.");
        } else{
            System.out.println("O valor " + emprestimo + ", não está dentro do intervalo permitido para empréstimo.");
        }
    }
}
