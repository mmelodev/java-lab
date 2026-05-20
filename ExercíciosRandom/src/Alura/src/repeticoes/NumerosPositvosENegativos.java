package Alura.repeticoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumerosPositvosENegativos {
    static void main() {
        List<Integer> numPositivos = new ArrayList<>();
        List<Integer> numNegativos = new ArrayList<>();

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um número (ou 'fim' para encerrar): ");
        String f = leitura.next();

        if(f.equalsIgnoreCase("fim")){
            System.out.println("Números Positivos: " + numPositivos);
            System.out.println("Números Negativos: " + numNegativos);
        } else {
            while (!f.equalsIgnoreCase("fim")){
                System.out.println("Digite um número (ou 'fim' para encerrar):");
                f = leitura.next();
                if(f.equalsIgnoreCase("fim")){
                    System.out.println("Números Positivos: " + numPositivos.toArray().length);
                    System.out.println("Números Negativos: " + numNegativos.toArray().length);
                    break;
                }
                int numero = Integer.parseInt(f);
                if (numero >= 0){
                    numPositivos.add(numero);
                } else {
                    numNegativos.add(numero);
                }
            }
        }
    }
}
