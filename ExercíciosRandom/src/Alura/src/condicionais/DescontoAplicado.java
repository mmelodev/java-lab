package Alura.condicionais;

import java.util.Scanner;

public class DescontoAplicado {
    static void main() {
        Scanner c = new Scanner(System.in);


        System.out.println("Digite o valor da compra: ");
        double compra = c.nextDouble();

        if (compra >= 100){
            double novoValor = compra - (compra * 0.10);
            System.out.println("Desconto de 10% aplicado.\nNovo valor: R$ " + novoValor);
        } else{
            System.out.println("Nenhum valor aplicado.\nValor total: " + compra);
        }
    }
}
