package br.com.superheroi.modelos;

public class MulherMaravilha extends SuperHeroi{
    @Override
    public void setEnergia(int energia) {
        super.setEnergia(energia = 100);
    }

    @Override
    public void usarpoder() {
        gastoenergia();
    }
}
