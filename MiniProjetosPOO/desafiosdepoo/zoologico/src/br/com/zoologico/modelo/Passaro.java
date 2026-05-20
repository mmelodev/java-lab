package br.com.zoologico.modelo;

public class Passaro extends Animal {

    @Override
    public String fazersom(){
        return "Som de Pássaro";
    }

    @Override
    public String movimentacao(){
        return "Voo rapido e agil";
    }

    @Override
    public String habitat(){
        return "Céu perto de árvores";
    }
}
