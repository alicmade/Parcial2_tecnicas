package Ejercicio4;

public class Barco {
    //para crear un tablero
    private  final int FILAS = 10;
    private  final int COLUMNAS = 10;
    private  final char AGUA = '?';
    private char BARCO = '?';
    private char[][] tablero;

    //para fijar coordenadas
    private Puntos puntoInicial;
    private Puntos puntoFinal;
    //la dirección del barco (vertical u horizontal)
    CardinalPoints.CardinalPoint direction;
    //el tamaño del barco
    private int tamaño;

    private boolean[] impactos;

    //variables auxilires
    int filaInicio;
    int columnaInicio;
    int filaFin;
    int columnaFin;

    //Constructor
    //es importante comprbar si el barco forma una linea recta, pero eso lo he hecho en metodo a hay en la clase usuario
    public Barco(Puntos puntoInicial, Puntos puntoFinal, CardinalPoints.CardinalPoint direction, int tamaño) {
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
        this.direction = direction;
        this.tamaño = tamaño;
        tablero = new char[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = AGUA;
            }
        }

    }

    //Método para saber si el barco ya está
    //hundido. Devuelve true si el barco está hundido.

    public boolean hundido(CardinalPoints.CardinalPoint direccion, int fila, int columna) {
        int tamanoBarco = 0;
        int filaInicio = fila;
        int columnaInicio = columna;
        int filaFin = fila;
        int columnaFin = columna;

        // Determinar el tamaño del barco y las coordenadas de su extremo opuesto
        switch (direccion) {
            case NORTH:
                while (filaInicio >= 0 && tablero[filaInicio][columna] == BARCO) {
                    tamanoBarco++;
                    filaInicio--;
                }
                filaFin = filaInicio + tamanoBarco - 1;
                break;
            case SOUTH:
                while (filaFin < FILAS && tablero[filaFin][columna] == BARCO) {
                    tamanoBarco++;
                    filaFin++;
                }
                filaInicio = filaFin - tamanoBarco + 1;
                break;
            case EAST:
                while (columnaFin < COLUMNAS && tablero[fila][columnaFin] == BARCO) {
                    tamanoBarco++;
                    columnaFin++;
                }
                columnaInicio = columnaFin - tamanoBarco + 1;
                break;
            case WEST:
                while (columnaInicio >= 0 && tablero[fila][columnaInicio] == BARCO) {
                    tamanoBarco++;
                    columnaInicio--;
                }
                columnaFin = columnaInicio + tamanoBarco - 1;
                break;
        }

        // Verificar si todas las casillas del barco están impactadas
        for (int i = filaInicio; i <= filaFin; i++) {
            for (int j = columnaInicio; j <= columnaFin; j++) {
                if (tablero[i][j] == BARCO) {
                    return false;
                }
            }
        }

        // Si se han recorrido todas las casillas del barco sin encontrar ninguna que no esté impactada,
        // el barco está hundido
        System.out.println("El barco está hundido");
        return true;
    }


    //Implementación recibir disparo. El disparo
    //afectará al barco si se encuentra entre el punto de partida y el punto final. No se tendrá en cuenta si el disparo ha sido previamente hecho en el mismo punto o no. No es necesario hacer las comprobaciones para ver si el disparo está fuera del tablero de juego.
    //para el barco a agua entoces es mas facil lueho comprobar si hay algo ahi o no
    public boolean disparar(int x, int y) {
        boolean tocado = false;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (tablero[x][y] == BARCO) {
                    tablero[x][y] = AGUA;
                    tocado = true;
                    System.out.println("El barco ha sido tocado");
                }
            }
        }
        return tocado;
    }

        // este lo he hecho con chatGPT, ns si esta bien

        public boolean recibirDisparo(int fila, int columna) {
            if (direction == direction.NORTH) {
                if (columna == columnaInicio && fila >= filaInicio && fila <= filaFin) {
                    int indice = fila - filaInicio;
                    impactos[indice] = true;
                    return true;
                }
            } else if (direction == direction.EAST) {
                if (fila == filaInicio && columna >= columnaInicio && columna <= columnaFin) {
                    int indice = columna - columnaInicio;
                    impactos[indice] = true;
                    return true;
                }
            } else if (direction == direction.SOUTH) {
                if (columna == columnaInicio && fila >= filaInicio && fila <= filaFin) {
                    int indice = fila - filaInicio;
                    impactos[indice] = true;
                    return true;
                }
            } else { // CardinalPoint.OESTE
                if (fila == filaInicio && columna >= columnaInicio && columna <= columnaFin) {
                    int indice = columna - columnaInicio;
                    impactos[indice] = true;
                    return true;
                }
            }
            return false;
        }

    public void visualizacion() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

//getters y setters
    public char getBARCO() {
        return BARCO;
    }

    public void setBARCO(char BARCO) {
        this.BARCO = BARCO;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public CardinalPoints.CardinalPoint getDirection() {
        return direction;
    }

    public void setDirection(CardinalPoints.CardinalPoint direction) {
        this.direction = direction;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }


}
