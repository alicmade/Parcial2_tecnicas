package Ejercicio4;

import java.util.ArrayList;

import static Ejercicio4.CardinalPoints.CardinalPoint.NORTH;
import static Ejercicio4.CardinalPoints.CardinalPoint.SOUTH;

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
    protected CardinalPoints.CardinalPoint direction;
    //el tamaño del barco
    private int tamaño;

    private ArrayList<Boolean> impactos;

       public Barco(Puntos puntoInicial, Puntos puntoFinal, int tamaño) throws IllegalAccessError {
           if (tamaño <= 0) {
               throw new IllegalAccessError("El tamaño del barco debe ser mayor que 0.");
              }
           if (!puntoInicial.equals(puntoFinal)) {
               throw new IllegalAccessError("El barco debe tener una longitud mayor que 0.");
              }
            this.puntoInicial = puntoInicial;
            this.puntoFinal = puntoFinal;
            this.tamaño = tamaño;
            if (puntoInicial.getX() == puntoFinal.getX()) {
                this.direction = NORTH;
            } else {
                this.direction = CardinalPoints.CardinalPoint.EAST;
            } if (puntoInicial.getY() == puntoFinal.getY()) {
                this.direction = SOUTH;
            } else {
                this.direction = CardinalPoints.CardinalPoint.WEST;
            }
            this.impactos = new ArrayList<>(tamaño);
            for (int i = 0; i < tamaño; i++) {
                impactos.add(false);
            }

        }

        public boolean hundido() {
            return impactos.stream().allMatch(impacto -> impacto);
            /* otra forma de hacerlo
            for (Boolean impacto : impactos) {
                if (!impacto) {
                    return false;
                }
            }
            * */
        }
        public boolean disparar(Puntos punto) {
            if (punto.getX() == puntoInicial.getX() || punto.getX() > puntoFinal.getX() ||
                    punto.getY() < puntoInicial.getY() || punto.getY() > puntoFinal.getY()) {

                int posicion = 0;
                if (direction == NORTH || direction == SOUTH) {
                    posicion = punto.getY() - puntoInicial.getY();
                } else {
                    posicion = punto.getX() - puntoInicial.getX();
                }
                /*
                switch (direction) {
                    case NORTH:
                        posicion = puntoFinal.getY() - punto.getY();
                        break;
                    case SOUTH:
                        posicion = y - puntoInicial.getY();
                        break;
                    case EAST:
                        posicion = x - puntoInicial.getX();
                        break;
                    case WEST:
                        posicion = puntoFinal.getX() - x;
                        break;
                }*/
                if (impactos.get(posicion)) {
                    return false;
                } else {
                    impactos.set(posicion, true);
                    return true;
                }
            } return false;
        }

}
