package br.com.zoologico.modelo;

public class Elefante extends Animal{

    @Override
    public String fazersom(){
        return "Som de elefante";
    }

    @Override
    public String movimentacao(){
        return "Passos lentos e pesados";
    }

    @Override
    public String habitat(){
        return "Savana";
    }

}
