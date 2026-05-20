package modelos;

public class SmartWatch extends Eletronico {
    private boolean aprovaDagua;

    public SmartWatch(String nome, String marca, String modelo, int anoDeLancamento, boolean falsificado, boolean aprovaDagua) {
        super(nome, marca, modelo, anoDeLancamento, falsificado);
        this.aprovaDagua = aprovaDagua;
    }

    public boolean getAprovaDagua() {
        return aprovaDagua;
    }

    @Override
    public String toString() {
        return "\nMarca: " + getMarca() + ", Modelo: " + getModelo() + ", ano de lançamento: " + getAnoDeLancamento();
    }
}
