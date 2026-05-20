public class somaV2 {
    public static int soma(int numero){
        int i = 0;

        while (numero > 0){
            i += numero % 10;
            numero /= 10;
        }

        System.out.println(i);

        return i;
    }

    void main (){
        soma(12346);
    }
}
