package br.com.superheroi.modelos;

public class SuperHeroi {
    private int energia;

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void usarpoder(){
        System.out.println("Usar Poder");
    }


    public void gastoenergia(){
        if (energia instanceof Integer){
            energia--;
        }
    }
}
