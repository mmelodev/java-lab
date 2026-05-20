import java.util.*;

public class nNumerosDaSequenciaV1 {
    public static void main(String[] args) {
        //2, 5, 10, 17, 26, ....

        int numero = 2;
        int numero2 = 3;

        Scanner input = new Scanner(System.in);

        System.out.println("Digite um valor do tamanho da sequência: \n>> ");
        int valor = input.nextInt();

        System.out.println(numero);

        if (valor < 100 && valor > 0){
            for (int i = 1; i <= valor; i++){
                numero += numero2;
                System.out.println(numero + "");
                numero2 += 2;
            }
        } else {
            System.out.println("Valor inválido, tente novamente !");
        }

    }
}
