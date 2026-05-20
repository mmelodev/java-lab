import java.util.*;

public class listaDeNumeroInteiros {
    public static void main(String[] args) {
        List <Integer> listanumeros = new LinkedList();

        listanumeros.add(5);
        listanumeros.add(6);
        listanumeros.add(1);
        listanumeros.add(-6);
        listanumeros.add(10);
        listanumeros.add(0);
        listanumeros.add(53);

        Collections.sort(listanumeros);

        System.out.println(listanumeros);
    }
}
