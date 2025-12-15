package br.com.tabuada.modelo;

public class TabuadaMultiplicacao implements Tabuada {

    @Override
    public void minhatabuada(int numero) {
        for(int i=1; i<=10; i++){
            System.out.println(i+" x "+numero+" = "+(numero*i));
        }
    }
}
