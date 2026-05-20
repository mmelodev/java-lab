package testandointerfaces;

public class Circulo implements Formas{
    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    @Override
    public double calcularArea() {
        double areacirculo = Math.PI * Math.pow(raio, 2);
        return areacirculo;
    }

    @Override
    public String toString() {
        return "Circulo";
    }
}
