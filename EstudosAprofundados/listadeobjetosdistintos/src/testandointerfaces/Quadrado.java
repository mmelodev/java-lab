package testandointerfaces;

public class Quadrado implements Formas {
    private double largura;
    private double altura;

    public Quadrado(double largura, double altura){
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        double areaDoQuadrado = largura * altura;

        return areaDoQuadrado;
    }


    @Override
    public String toString() {
        return "Quadrado";
    }
}
