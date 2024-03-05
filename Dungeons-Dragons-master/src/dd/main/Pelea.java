package dd.main;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import dd.core.*;

public class Pelea {
    private List<Personaje> ejercitoHombres;
    private List<Personaje> ejercitoTrolls;
    private List<Personaje> ejercitoMerlin;

    // Modo 1: Batalla entre hombres y trolls --> Batalla entre hombres y Merlin
    public void primerModo(List<Personaje> ejercitoAliado, List<Personaje> ejercitoEnemigo) {
        this.ejercitoHombres = ejercitoAliado;
        this.ejercitoTrolls = ejercitoEnemigo;
        // Crear hombres
        Rey arturo = new Rey("Arturo", new AtaqueEspada());
        ejercitoHombres.add(arturo);

        Caballero lancelot = new Caballero("Lancelot", new AtaqueEspada());
        lancelot.setAtaque(new AtaqueEspada());
        ejercitoHombres.add(lancelot);

        Caballero percival = new Caballero("Percival", new AtaqueArco());
        percival.setAtaque(new AtaqueArco());
        ejercitoHombres.add(percival);

        // Crear trolls
        Random rand = new Random();
        int numTrolls = rand.nextInt(9) + 2; // Entre 2 y 10 trolls
        for (int i = 1; i <= numTrolls; i++) {
            Troll troll = new Troll("Troll " + i, new AtaqueCuchillo());
            int tipoAtaque = rand.nextInt(3); // 0: Espada, 1: Arco, 2: Cuchillo
            switch (tipoAtaque) {
                case 0:
                    troll.setAtaque(new AtaqueEspada());
                    break;
                case 1:
                    troll.setAtaque(new AtaqueArco());
                    break;
                case 2:
                    troll.setAtaque(new AtaqueCuchillo());
                    break;
            }
            ejercitoTrolls.add(troll);
        }
    }

    // Modo 2: Batalla entre hombres y Merlin --> Batalla entre hombres y Merlin

    public void modoFlenqui(List<Personaje> ejercitoAliado, List<Personaje> ejercitoEnemigo) {
        this.ejercitoHombres = crearEjercito();
        this.ejercitoMerlin = crearEjercito();
    }

    private List<Personaje> crearEjercito() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos soldados quieres en tu ejército?");
        int numSoldados = sc.nextInt();
        List<Personaje> ejercito = new ArrayList<>();
        int numMagos = 0;

        for (int i = 0; i < numSoldados; i++) {
            System.out.println("¿Qué tipo de soldado quieres añadir? (1: Rey, 2: Caballero, 3: Mago)");
            int tipoSoldado = sc.nextInt();

            if (tipoSoldado == 3 && numMagos == 0) {
                ejercito.add(new Mago("Merlin", new AtaqueMago()));
                numMagos++;
            } else if (tipoSoldado == 1) {
                ejercito.add(new Rey("Arturo", new AtaqueEspada()));
            } else if (tipoSoldado == 2) {
                ejercito.add(new Caballero("Caballero", new AtaqueEspada()));
            } else {
                System.out.println("Entrada inválida. Por favor, introduce 1 para Rey, 2 para Caballero, o 3 para Mago.");
                i--;
            }
        }
        sc.close();
        return ejercito;
    }

    public void iniciarPelea() {
        Random rand = new Random();
        int turno = 1;
        while (!ejercitoHombres.isEmpty() && !ejercitoTrolls.isEmpty()) {
            System.out.println("Turno " + turno + ":");
    
            // Turno de los hombres
            for (Iterator<Personaje> iterator = ejercitoHombres.iterator(); iterator.hasNext();) {
                Personaje hombre = iterator.next();
                if (!ejercitoTrolls.isEmpty()) {
                    int indexEnemigo = rand.nextInt(ejercitoTrolls.size());
                    Personaje troll = ejercitoTrolls.get(indexEnemigo);
                    int dano = hombre.ataca(troll);
                    System.out.println("[" + hombre.getNombre() + "]" + " ataca a " + troll.getNombre()+ " e inflige " + dano + " de daño");
                    if (troll.getSalud() <= 0) {
                        System.out.println("[" + troll.getNombre() + "]" + " ha muerto!");
                        ejercitoTrolls.remove(indexEnemigo);
                    }
                }
            }
    
            // Turno de los trolls
            for (Iterator<Personaje> iterator = ejercitoTrolls.iterator(); iterator.hasNext();) {
                Personaje troll = iterator.next();
                if (!ejercitoHombres.isEmpty()) {
                    int indexEnemigo = rand.nextInt(ejercitoHombres.size());
                    Personaje hombre = ejercitoHombres.get(indexEnemigo);
                    int dano = troll.ataca(hombre);
                    System.out.println("[" + troll.getNombre() + "]" + " ataca a " + hombre.getNombre()+ " e inflige " + dano + " de daño");
                    if (hombre.getSalud() <= 0) {
                        System.out.println("[" + hombre.getNombre() + "]" + " ha muerto!");
                        ejercitoHombres.remove(indexEnemigo);
                    }
                }
            }
            turno++;
        }
    }
}