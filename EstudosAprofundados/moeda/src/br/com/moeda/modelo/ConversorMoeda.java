package br.com.moeda.modelo;

import java.util.*;

public class ConversorMoeda implements ConversaoFinanceira {

    @Override
    public void converterDolarParaReal(int usd) {
        double conversao = usd * 5.45;

        System.out.println("A conversão em Real para sua quantidade de Doláres é de: R$ " + conversao);
    }

}
