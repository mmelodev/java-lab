import java.util.*;

public class nNumerosDaSequenciaV2 {
    public static void main(String[] args) {
        //1/2 + 2/3 + 3/4 + 4/5 + ...

        Scanner input = new Scanner(System.in);

        System.out.println("Digite um valor do tamanho da sequência: \n>> ");
        int valor = input.nextInt();

        if (valor < 50 && valor > 0){
            for (int i = 1; i <= valor; i++){
                //ainda vou fazer
            }
        } else {
            System.out.println("Valor inválido, tente novamente !"); //poderia colocar esse if/else dentro de uma repetição também
        }
    }
}
