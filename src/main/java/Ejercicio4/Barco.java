package Ejercicio4;

import java.util.ArrayList;

import static Ejercicio4.CardinalPoints.CardinalPoint.NORTH;
import static Ejercicio4.CardinalPoints.CardinalPoint.SOUTH;

public class Barco {
    //para crear un tablero
    private Tablero tablero;
    //para fijar coordenadas
    private Puntos puntoInicial;


    //la dirección del barco (vertical u horizontal)
    protected CardinalPoints.CardinalPoint direction;
    //el tamaño del barco
    private int tamaño;

    private ArrayList<Boolean> impactos;


    public Barco(Puntos puntoInicial, CardinalPoints.CardinalPoint direction, int tamaño) {
        this.puntoInicial = puntoInicial;
        this.direction = direction;
        this.tamaño = tamaño;
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
    int posicion = 0;
        if (direction == NORTH || direction == SOUTH) {
            posicion = punto.getY() - puntoInicial.getY();
        } else {
            posicion = punto.getX() - puntoInicial.getX();
        }
        if (impactos.get(posicion)) {
            return false;
        } else {
            impactos.set(posicion, true);
            return true;
        }
    }
        /*
        public boolean disparar(Puntos punto) {

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
                }
            if (impactos.get(posicion)) {
                return false;
            } else {
                impactos.set(posicion, true);
                return true;
            }
        } */

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Puntos getPuntoInicial() {
        return puntoInicial;
    }

    public void setPuntoInicial(Puntos puntoInicial) {
        this.puntoInicial = puntoInicial;
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

    public ArrayList<Boolean> getImpactos() {
        return impactos;
    }

    public void setImpactos(ArrayList<Boolean> impactos) {
        this.impactos = impactos;
    }
}
