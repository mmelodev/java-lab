package Alura.repeticoes;

import java.util.ArrayList;
import java.util.List;

public class SomaDosNumerosPares {
    static void main() {
        List<Integer> numerosPares = new ArrayList<>();
        int contador = 0;

        for(int i = 0; i <= 100; i++){
            if (i % 2 == 0){
                numerosPares.add(i);
                contador += i;
            }
        }

        System.out.println(numerosPares);
        System.out.println("A soma dos números pares de 1 a 100 é " + contador);
    }
}