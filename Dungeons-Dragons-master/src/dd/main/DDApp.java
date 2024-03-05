package dd.main;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import dd.core.Personaje;


// Clase principal para la aplicación
public class DDApp {
    public void menu() {
        System.out.println("1. Modo Normal");
        System.out.println("2. Modo Flenquiteriyaki");
        System.out.println("3. Salir");
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        DDApp app = new DDApp();
        switch (valor) {
            case 1:
                System.out.println("Modo Normal");
                app.primerModo();
                break;

            case 2:
                System.out.println("Modo Flenquiteriyaki");
                app.modoFlenqui();
                break;
            default:
                System.out.println("Saliendo...");
                break;
        }
        sc.close();
    }

    public void primerModo() {
        System.out.println("Bienvenido al modo normal");
        System.out.println("Creando personajes...");
        
        List<Personaje> ejercitoAliado = new ArrayList<Personaje>();
        List<Personaje> ejercitoEnemigo = new ArrayList<Personaje>();
        System.out.println("Personajes creados");
        System.out.println("Iniciando pelea...");
        Pelea pelea = new Pelea();
        pelea.primerModo(ejercitoAliado, ejercitoEnemigo);
        pelea.iniciarPelea();

        if (ejercitoAliado.isEmpty()){
            System.out.println("El ejercito enemigo ha ganado");
        } else {
            System.out.println("El ejercito aliado ha ganado");
        }
    }

    public void modoFlenqui() {
        System.out.println("Bienvenido al modo normal");
        System.out.println("Creando personajes...");
        
        List<Personaje> ejercitoAliado = new ArrayList<Personaje>();
        List<Personaje> ejercitoEnemigo = new ArrayList<Personaje>();
        System.out.println("Personajes creados");
        System.out.println("Iniciando pelea...");
        Pelea pelea = new Pelea();
        pelea.modoFlenqui(ejercitoAliado, ejercitoEnemigo);
        pelea.iniciarPelea();
    }

    public static void main(String[] args) {
        DDApp app = new DDApp();
        app.menu();
    }
}