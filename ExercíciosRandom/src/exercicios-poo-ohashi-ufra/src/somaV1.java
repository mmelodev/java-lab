public class somaV1 {
    static int soma(int numero){
        int nckp = numero;
        int i = 0;
        while (numero > 0){
            i += numero % 10;
            numero /= 10;
        }
        System.out.println("A soma de " + nckp + " é: " + i);
        return i;
    }

    void main(String[] args) {
        soma(123);
    }
}