package Ejercicio4;

import java.util.Arrays;

import static Ejercicio4.CardinalPoints.CardinalPoint.*;

public class Tablero {
    private static final int FILAS = 10;
    private static final int COLUMNAS = 10;
    private static final char AGUA = '?';
    private static char BARCO = '@';

    private static char barcoHumano = '?';
    private static char[][] tablero;

    public Tablero() {
        tablero = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            Arrays.fill(tablero[i], AGUA);
        }
    }
    public void visualizacion() {
            for (int i = 0; i < FILAS; i++) {
                for (int j = 0; j < COLUMNAS; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println();
            }
    }

    public void depositarBarco(Barco barco) throws Exception {
        int filaInicial = barco.getPuntoInicial().getX();
            int columnaInicial = barco.getPuntoInicial().getY();


            switch (barco.getDirection()) {
                case NORTH:
                    for (int i = barco.getPuntoInicial().getX(); i <= barco.getTamaño(); i++) {
                        if (i >= COLUMNAS || tablero[filaInicial][i] != AGUA) {
                            throw new Exception("El barco no cabe en el tablero o colisiona con otro barco.");
                        }
                        tablero[i][columnaInicial] = BARCO;
                    }
                    break;
                case SOUTH:
                    for (int i = barco.getPuntoInicial().getX(); i >= barco.getTamaño(); i--) {
                        if (i >= COLUMNAS || tablero[filaInicial][i] != AGUA) {
                            throw new Exception("El barco no cabe en el tablero o colisiona con otro barco.");
                        }
                        tablero[i][columnaInicial] = BARCO;
                    }
                    break;
                case EAST:
                    for (int i = barco.getPuntoInicial().getY(); i <= barco.getTamaño(); i++) {
                        tablero[filaInicial][i] = BARCO;
                        if (i >= FILAS || tablero[i][columnaInicial] != AGUA) {
                            throw new Exception("El barco no cabe en el tablero o colisiona con otro barco.");
                        }
                    }
                    break;
                case WEST:
                    for (int i = barco.getPuntoInicial().getY(); i >= barco.getTamaño(); i--) {
                        if (i >= FILAS || tablero[i][columnaInicial] != AGUA) {
                            throw new Exception("El barco no cabe en el tablero o colisiona con otro barco.");
                        }
                        tablero[filaInicial][i] = BARCO;
                    }
                    break;
            }
    }

/*

    private static char[][] tableroHumano;

    public static int filaBarco = (int) (Math.random() * 4);
    public static int columnaBarco = (int) (Math.random() * 4);

    public static int filaHumana =0;
    public static int columnaHumana =0;

    tableroHumano = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            Arrays.fill(tableroHumano[i], AGUA);
        }
         public void depositarBarco(int fila, int columna) {
        filaHumana = fila;
        columnaHumana = columna;
        tableroHumano[fila][columna] = barcoHumano;
    }
 */

/*
    public void visualizacionComputadora() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tableroHumano[i][j] + " ");
            }
            System.out.println();
        }
    }*/


/*
    public static boolean dispararHumano(int filaDisparo, int columnaDisparo){
        if (filaDisparo == filaBarco && columnaDisparo == columnaBarco) {
            // El jugador ha acertado la celda ocupada por el barco
            System.out.println("Tocado y hundido");
            tablero[filaDisparo][columnaDisparo] = 'X';
            return true;
        } else {
            // El jugador no ha acertado la celda ocupada por el barco
            System.out.println("Agua");
            tablero[filaDisparo][columnaDisparo] = '~';
        }
        return false;
    }
    public static boolean dispararComputadora (){
        int filaDisparo = (int) (Math.random() * 4);
        int columnaDisparo = (int) (Math.random() * 4);
        if (filaDisparo == filaHumana && columnaDisparo == columnaHumana) {
            // El jugador ha acertado la celda ocupada por el barco
            System.out.println("Computadora: Tocado y hundido");
            tableroHumano[filaDisparo][columnaDisparo] = 'X';
            return true;
        } else {
            // El jugador no ha acertado la celda ocupada por el barco
            System.out.println("Computadora: Agua");
            tableroHumano[filaDisparo][columnaDisparo] = '~';
        }
        return false;
    }
     public static boolean disparar(int filaDisparo, int columnaDisparo){
        if (filaDisparo == filaBarco && columnaDisparo == columnaBarco) {
            // El jugador ha acertado la celda ocupada por el barco
            System.out.println("Tocado y hundido");
            tablero[filaDisparo][columnaDisparo] = 'X';
            return true;
        } else {
            // El jugador no ha acertado la celda ocupada por el barco
            System.out.println("Agua");
            tablero[filaDisparo][columnaDisparo] = '~';
        }
        return false;
    }
     public void depositarBarcoAleatorio() {
        tablero[filaBarco][columnaBarco] = BARCO;
    }

   */
}

