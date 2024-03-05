package dd.core;
import java.util.Random;
// Clase para el Ataque con Arco
public class AtaqueArco implements Ataque {
    private final int ataque = 50;

    @Override
    public int lanzaAtaque(Personaje enemigo) {
        Random rand = new Random();
        int acierta = rand.nextInt(2); // 0 o 1
        double factor = rand.nextDouble(); // entre 0 y 1 (no inclusive)
        int damage = (int) (acierta * factor * ataque);
        if (acierta == 0) {
            return 0;
        } else {
            enemigo.recibeDanio(damage);
            return damage;
        }
    }
}
