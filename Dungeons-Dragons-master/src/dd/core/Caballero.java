package dd.core;
// Clase para el Caballero

public class Caballero extends Personaje {
    public Caballero(String nombre, Ataque ataque) {
        super(nombre, 1500, ataque);
        this.salud = 1500;
    }

    @Override
    public int ataca(Personaje enemigo) {
        int valorAtaque = 0;
        if (ataque != null) {
            for (int i = 0; i < 2; i++) {
                ataque.lanzaAtaque(enemigo);
            }
        }
        if (ataque instanceof AtaqueEspada) {
            valorAtaque = 75;
        } else if (ataque instanceof AtaqueArco) {
            valorAtaque = 50;
        }
        return valorAtaque;
    }
}

