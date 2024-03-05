package dd.core;
// Clase para el Troll

import java.util.Random;

public class Troll extends Personaje {
    private Random random = new Random();
    public Troll(String nombre, Ataque ataque) {
        super(nombre, 1000, ataque);
        this.salud = 1000;
    }

    @Override
    public int ataca(Personaje enemigo) {
        int acierta = random.nextInt(2);
        float factor = random.nextFloat();
        int ataqueValor = 0;

        if (ataque instanceof AtaqueCuchillo) {
            ataqueValor = 25;
        }

        int valorAtaque = (int) (acierta * factor * ataqueValor);

        if (ataque != null) {
            for (int i = 0; i < 2; i++) {
                ataque.lanzaAtaque(enemigo);
            }
        }

        return valorAtaque;
    }
}
