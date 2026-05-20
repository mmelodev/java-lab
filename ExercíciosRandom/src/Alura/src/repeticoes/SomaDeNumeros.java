package Alura.repeticoes;

public class SomaDeNumeros {
    static void main() {
        int[] valores = {10, 20, 30, 40, 50};
        int contador = 0;

        for (int i = 0; i < valores.length; i++){
            contador += valores[i];
        }

        System.out.println("A soma total das receitas é: " + contador);
    }
}
