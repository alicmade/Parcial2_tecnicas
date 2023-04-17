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
    public void depositarBarco(Barco barco) throws Exception {
        String opcion;
        int filaInicial = barco.getPuntoInicial().getX();
        int columnaInicial = barco.getPuntoInicial().getY();
        int filaaux;
        int filaFinal;
        int columnaaux;
        int columnaFinal;
        int repeticiones;

        switch (barco.getDirection()) {
            case NORTH:
                // hacia el norte, voy decreciendo en filas
                filaFinal = filaInicial - barco.getTamaño();
                if (filaFinal < 0) throw new Exception("El barco no cabe en el tablero.");
                repeticiones = barco.getTamaño();
                filaaux = filaInicial - 1;
                while (repeticiones > 0) {
                    if (tablero[filaaux][columnaInicial - 1] != AGUA)
                        throw new Exception("El barco colisiona con otro barco.");
                    tablero[filaaux][columnaInicial - 1] = BARCO;
                    filaaux--;
                    repeticiones--;
                }
                break;
            case SOUTH:
                // hacia el norte, voy creciendo en filas
                filaFinal = filaInicial + barco.getTamaño();
                if (filaFinal >= FILAS) throw new Exception("El barco no cabe en el tablero.");
                repeticiones = barco.getTamaño();
                filaaux = filaInicial - 1;
                while (repeticiones > 0) {
                    if (tablero[filaaux][columnaInicial - 1] != AGUA)
                        throw new Exception("El barco colisiona con otro barco.");
                    tablero[filaaux][columnaInicial - 1] = BARCO;
                    filaaux++;
                    repeticiones--;
                }
                break;
            case EAST:
                // hacia el este, voy creciendo en columnas
                columnaFinal = columnaInicial + barco.getTamaño();
                if (columnaFinal >= COLUMNAS) throw new Exception("El barco no cabe en el tablero.");
                repeticiones = barco.getTamaño();
                columnaaux = columnaInicial - 1;
                while (repeticiones > 0) {
                    if (tablero[filaInicial - 1][columnaaux] != AGUA)
                        throw new Exception("El barco colisiona con otro barco.");
                    tablero[filaInicial - 1][columnaaux] = BARCO;
                    columnaaux++;
                    repeticiones--;
                }
                break;
            case WEST:
                // hacia el oeste, voy decreciendo en columnas
                columnaFinal = columnaInicial - barco.getTamaño();
                if (columnaFinal < 0) throw new Exception("El barco no cabe en el tablero.");
                repeticiones = barco.getTamaño();
                columnaaux = columnaInicial - 1;
                while (repeticiones > 0) {
                    if (tablero[filaInicial - 1][columnaaux] != AGUA)
                        throw new Exception("El barco colisiona con otro barco.");
                    tablero[filaInicial - 1][columnaaux] = BARCO;
                    columnaaux--;
                    repeticiones--;
                }
                break;
        }
    }
     /*public void depositarBarco(Barco barco) throws Exception {

             /* String opcion;
            int filaInicial = barco.getPuntoInicial().getX();
            int columnaInicial = barco.getPuntoInicial().getY();
            if (barco.getDirection().equals(NORTH) || barco.getDirection().equals(SOUTH)) {
               opcion= "horizontal";
            } else {
                 opcion= "vertical";
            }
            switch (opcion){
                case "horizontal":
                    for (int i = 0 ; i <= barco.getTamaño()-1; i++) {
                        tablero[filaInicial-1][columnaInicial-1] = BARCO;
                        filaInicial++;
                        if (i >= FILAS || tablero[i][columnaInicial] != AGUA) {
                            throw new Exception("El barco no cabe en el tablero o colisiona con otro barco.");
                        }
                    }
                    break;
                case "vertical":
                    for (int i = 0; i <= barco.getTamaño()-1; i++) {
                        tablero[filaInicial-1][columnaInicial-1] = BARCO;
                        columnaInicial ++;
                        if (i >= FILAS || tablero[i][columnaInicial] != AGUA) {
                            throw new Exception("El barco no cabe en el tablero o colisiona con otro barco.");
                        }
                    }
                    break;

            }

            switch (barco.getDirection()) {
                case NORTH:
                   for (int i = 0 ; i <= barco.getTamaño()-1; i++) {
                        tablero[filaInicial-1][columnaInicial-1] = BARCO;
                        filaInicial++;
                    }
                    break;
                case SOUTH:
                    for (int i = 0; i <= barco.getTamaño()-1; i++) {
                        tablero[filaInicial-1][columnaInicial-1] = BARCO;
                        filaInicial ++;
                    }
                    break;
                case EAST:
                    for (int i = 0; i <= barco.getTamaño()-1; i++) {
                        tablero[filaInicial-1][columnaInicial-1] = BARCO;
                        columnaInicial++;
                        if (i >= FILAS || tablero[i][columnaInicial] != AGUA) {
                            throw new Exception("El barco no cabe en el tablero o colisiona con otro barco.");
                        }
                    }
                    break;
                case WEST:
                    for (int i = 0; i <= barco.getTamaño()-1; i++) {
                        tablero[filaInicial-1][columnaInicial-1] = BARCO;
                        columnaInicial++;
                        if (i >= FILAS || tablero[i][columnaInicial] != AGUA) {
                            throw new Exception("El barco no cabe en el tablero o colisiona con otro barco.");
                        }
                    }
                    break;
            }*/


    public void visualizarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void marcarImpacto(Puntos punto) {
        int fila = punto.getX();
        int columna = punto.getY();
        tablero[fila-1][columna-1] = 'X';
    }

    public static char getBARCO() {
        return BARCO;
    }

    public static void setBARCO(char BARCO) {
        Tablero.BARCO = BARCO;
    }

    public static char getBarcoHumano() {
        return barcoHumano;
    }

    public static void setBarcoHumano(char barcoHumano) {
        Tablero.barcoHumano = barcoHumano;
    }

    public static char[][] getTablero() {
        return tablero;
    }

    public static void setTablero(char[][] tablero) {
        Tablero.tablero = tablero;
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

