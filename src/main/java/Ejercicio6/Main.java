package Ejercicio6;

import Ejercicio4.CardinalPoints;
import Ejercicio4.Puntos;
import Ejercicio4.Usuario;
import Ejercicio5.Canoa;
import Ejercicio5.Fragata;
import Ejercicio5.Portaaviones;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Puntos punto1 = new Puntos(1, 1);
        Puntos punto2 = new Puntos(2, 2);
        Puntos punto3 = new Puntos(6, 6);
/*
        //Usuario usuario1 = new Usuario("Juan", new Barco(3, columnaInicial, filaFinal, columnaFinal));

        System.out.println("Jugador humano, elija la posición de su barco (fila, columna):");
        Scanner scanner = new Scanner(System.in);
        int fila = scanner.nextInt();
        int columna = scanner.nextInt();
       // usuario1.depositarBarco(fila, columna);

      //  Usuario usuario2 = new Usuario("Bea", new Barco(3, columnaInicial, filaFinal, columnaFinal));
        System.out.println("Jugador humano, elija la posición de su barco (fila, columna):");
        int filaOtroJugador = scanner.nextInt();
        int columnaOtroJugador = scanner.nextInt();
        //usuario2.depositarBarco(filaOtroJugador, columnaOtroJugador);

        boolean jugador1Gana = false;
        boolean jugador2Gana = false;
        boolean turnoJugador= true;
        while (!jugador1Gana && !jugador2Gana) {
            if (jugador1Gana) {
                System.out.println("Jugador dispare (fila, columna):");
                fila = scanner.nextInt();
                columna = scanner.nextInt();
                usuario1.disparo(fila, columna);
                jugador1Gana = usuario1.atacar(fila, columna, usuario1);
                usuario1.getBarcosTablero().get(0).visualizacion();
                turnoJugador = !turnoJugador;

            } else {
                System.out.println("Jugador dispare (fila, columna):");
                fila = scanner.nextInt();
                columna = scanner.nextInt();
                usuario2.disparo(fila, columna);
                jugador2Gana = usuario2.atacar(fila, columna, usuario2);
                //usuario2.visualizacion();
                turnoJugador = !turnoJugador;
            }

        }*/


        Usuario user1 = new Usuario();
        Usuario user2 = new Usuario();

       Canoa canoa1 = crearCanoa();
       Fragata fragata1 = crearFragata();
         Portaaviones portaaviones1 = crearPortaaviones();
        user1.agregarBarco(canoa1);
        user1.agregarBarco(fragata1);
        user1.agregarBarco(portaaviones1);

        user1.visualizacionComputadora();

        user2.atacar(punto1, user1);
        user2.atacar(punto2, user1);
        user2.atacar(new Puntos(punto2.getX()+1, punto2.getY()), user1);
        user2.atacar(new Puntos(punto2.getX()+2, punto2.getY()), user1);

       // user2.disparo(punto1);

        //System.out.println("   ");
       // user1.visualizacionComputadora();
        System.out.println("   ");
        user2.atacar(punto3, user1);
       // user2.disparo(punto3);
        user1.visualizacionComputadora();
        //System.out.println("   ");
        //user1.getTablero().marcarImpacto(punto1);
       // user1.visualizacionComputadora();

    }

    public static Puntos preguntarPunto(){
        System.out.println("Introduce la fila");
        int fila = sc.nextInt();
        System.out.println("Introduce la columna");
        int columna = sc.nextInt();
        Puntos punto = new Puntos(fila, columna);
        return punto;
    }
    public static CardinalPoints.CardinalPoint preguntarOrientacion(){
        System.out.println("Introduce la orientacion");
        System.out.println("1-Norte, 2-Sur, 3-Este, 4-Oeste");
        String opcion = sc.next();
        CardinalPoints.CardinalPoint orientacion = null;
        switch (opcion) {
            case "1":
                orientacion = orientacion.NORTH;
                break;
            case "2":
                orientacion = orientacion.SOUTH;
                break;
            case "3":
                orientacion = orientacion.EAST;
                break;
            case "4":
                orientacion = orientacion.WEST;
                break;
        }
        return orientacion;
    }

    public static Canoa crearCanoa(){
        System.out.println("colocamos la canoa");
        Puntos punto1 = preguntarPunto();
        CardinalPoints.CardinalPoint orientacion1 = preguntarOrientacion();
        Canoa canoa = new Canoa(punto1, orientacion1);
        return canoa;
    }

    public static Fragata crearFragata(){
        System.out.println("colocamos la fragata");
        Puntos punto2 = preguntarPunto();
        CardinalPoints.CardinalPoint orientacion2 = preguntarOrientacion();
        Fragata fragata = new Fragata(punto2, orientacion2);
        return fragata;
    }

    public static Portaaviones crearPortaaviones(){
        System.out.println("colocamos el portaaviones");
        Puntos punto3 = preguntarPunto();
        CardinalPoints.CardinalPoint orientacion3 = preguntarOrientacion();
        Portaaviones portaaviones = new Portaaviones(punto3, orientacion3);
        return portaaviones;
    }
}
