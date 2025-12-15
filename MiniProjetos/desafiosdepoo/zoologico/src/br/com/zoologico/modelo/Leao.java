package br.com.zoologico.modelo;

public class Leao extends Animal {

    @Override
    public String fazersom(){
        return "Som de Leão";
    }

    @Override
    public String movimentacao(){
        return "Passos rápidos e estratégicos (rei da selva)";
    }

    @Override
    public String habitat(){
        return "Savana";
    }
}
