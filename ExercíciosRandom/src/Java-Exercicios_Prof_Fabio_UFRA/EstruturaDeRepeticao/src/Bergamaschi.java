public class Bergamaschi {
    public static void main(String[] args) {

        int numero = 1;
        int numero2 = 1;
        int numero3 = 1;
        int proximo;

        System.out.println(numero);
        System.out.println(numero2);
        System.out.println(numero3);

        for (int i = 0; i <= 20; i++){
            proximo = numero + numero2 + numero3;
            System.out.println(proximo + "");

            numero = numero2;
            numero2 = numero3;
            numero3 = proximo;
        }

    }
}
