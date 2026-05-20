package modelos;

public class Eletronico {
    private String nome;
    private String marca;
    private String modelo;
    private int anoDeLancamento;
    private boolean falsificado;

    public Eletronico (String nome, String marca, String modelo, int anoDeLancamento, boolean falsificado){
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeLancamento = anoDeLancamento;
        this.falsificado = falsificado;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean getFalsificado() {
        return falsificado;
    }

//    @Override
//    public int compareTo(Eletronico outroEletronico) {
//        return Integer.compare(this.anoDeLancamento, outroEletronico.anoDeLancamento);
//    }
}
