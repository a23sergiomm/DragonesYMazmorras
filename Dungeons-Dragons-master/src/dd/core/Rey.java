package dd.core;

import java.util.Random;

public class Rey extends Personaje {
    private Random random = new Random();
    public Rey(String nombre, Ataque ataque) {
        super(nombre, 2000, ataque);
        this.salud = 2000;
    }

    @Override
    public int ataca(Personaje enemigo) {
        int acierta = random.nextInt(2);
        float factor = random.nextFloat();
        int ataqueValor = 0;

        if (ataque instanceof AtaqueEspada) {
            ataqueValor = 100;
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

