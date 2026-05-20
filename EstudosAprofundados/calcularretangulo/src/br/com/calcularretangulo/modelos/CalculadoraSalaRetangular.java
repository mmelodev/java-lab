package br.com.calcularretangulo.modelos;

public class CalculadoraSalaRetangular implements CalculoGeometrico {

    @Override
    public void calcularArea(double altura, double largura) {
        double totalArea = altura * largura;

        System.out.println("Area: " + totalArea);
    }

    @Override
    public void calcularPerimetro(double altura, double largura) {
        double totalPerimetro = 2 * (altura + largura);

        System.out.println("Perimetro: " + totalPerimetro);
    }
}
