public class Carro {
    private String modelo;
    private String marca;
    private int anoDeLancamento;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public String toString() {
        return "Ano de Lançamento: " + getAnoDeLancamento() + ", Marca: " + getMarca() + ", Modelo: " + getModelo();
    }
}
