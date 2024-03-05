package dd.core;
// Clase abstracta para los personajes
public abstract class Personaje {
    public String nombre;
    public int salud;
    public Ataque ataque;
    public int saludOriginal;

    public Personaje(String nombre, int salud, Ataque ataque) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public Ataque getAtaque() {
        return this.ataque;
    }

    public int getSalud() {
        return this.salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int ataca(Personaje enemigo) {
        // lógica de ataque...
        int ataque = this.ataque.lanzaAtaque(enemigo);
        return ataque;
    }

    public void recibeDanio(int danio) {
        this.salud -= danio;
    }

    @Override
    public String toString() {
        return "[" + nombre + ": " + salud + "]";
    }
}

