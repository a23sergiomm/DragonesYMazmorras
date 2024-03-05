package dd.core;

public class Mago extends Personaje {
    public Mago(String nombre, Ataque ataque) {
        super(nombre, 5000, ataque);
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        this.salud = 5000;
    }

    @Override
    public int ataca(Personaje enemigo) {
        int valorAtaque = 0;
        if (ataque != null) {
            for (int i = 0; i < 2; i++) {
                ataque.lanzaAtaque(enemigo);
            }
        }
        if (ataque instanceof AtaqueMago) {
            valorAtaque = 200;
        }
        return valorAtaque;
    }
}