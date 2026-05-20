package modelos;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Celular extends Eletronico implements apps{
    private String OS;
    private boolean comRoot;

    public Celular(String nome, String marca, String modelo, int anoDeLancamento, boolean falsificado, String OS, boolean comRoot) {
        super(nome, marca, modelo, anoDeLancamento, falsificado);
        this.OS = OS;
        this.comRoot = comRoot;
    }

    public String getOS() {
        return OS;
    }

    public boolean getComRoot() {
        return comRoot;
    }

    @Override
    public void horaEData() {
        DateTimeFormatter datahora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    }

    @Override
    public void fraseFavorita() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite a frase favorita para seu dia: ");
        String fraseFavCelular = input.next();
        System.out.println("\nSua frase favorita do dia foi salva no sistema! :)");
    }

    @Override
    public String toString() {
        return "\nMarca: " + getMarca() + ", Modelo: " + getModelo() + ", ano de lançamento: " + getAnoDeLancamento();
    }
}
