package Ejercicio4;

import Ejercicio5.Canoa;
import Ejercicio5.Fragata;

import java.util.ArrayList;
import java.util.Map;

import static Ejercicio4.CardinalPoints.CardinalPoint.NORTH;
import static Ejercicio4.CardinalPoints.CardinalPoint.SOUTH;

public abstract class  Barco implements MetodosBarco {
    //para crear un tablero
    private Tablero tablero;
    //para fijar coordenadas
    private Puntos puntoInicial;

    private Puntos puntoFinal;
    //la dirección del barco (vertical u horizontal)
    protected CardinalPoints.CardinalPoint direction;
    //el tamaño del barco
    private int tamaño;
    int impactos = 0;

    protected boolean[] impactosARR = new boolean[tamaño];


    public Barco(Puntos puntoInicial, CardinalPoints.CardinalPoint direction, int tamaño) {
        this.puntoInicial = puntoInicial;
        this.direction = direction;
        this.tamaño = tamaño;
        //hallar el punto final
        if (direction == NORTH || direction == SOUTH) {
            this.puntoFinal = new Puntos(puntoInicial.getX(), puntoInicial.getY() + tamaño - 1);
        } else {
            this.puntoFinal = new Puntos(puntoInicial.getX() + tamaño - 1, puntoInicial.getY());
        }
    }

    public boolean hundido() {
          //  return impactos.stream().allMatch(impacto -> impacto);
             //otra forma de hacerlo
       // System.out.println(impactos.length);
            //for (Boolean impacto : impactos) {
            /*    if (impacto) {
                    System.out.println("hundido");
                    return true;
                }
            }
        if (impactos == tamaño){
                System.out.println("hundido");
                return true;
            } else {
                return false;
            }*/
        return false;
    }
    public boolean disparar(Puntos punto) {
        if (this.puntoInicial.getX() == puntoFinal.getX()){
           for (int i =0; i < tamaño; i++){
                if (punto.getY() >= this.puntoInicial.getY() && punto.getY() <= this.puntoFinal.getY() /*+i*/){
                    impactos++;
                    hundido();
                    return true;
                } else if (punto.getX() <= this.puntoInicial.getX() && punto.getX() >= this.puntoFinal.getX() /*+i*/){
                    impactos++;
                    hundido();
                    return true;
                }
            }
        } else if (this.puntoInicial.getY() == puntoFinal.getY()){

                if (punto.getX() >= this.puntoInicial.getX() && punto.getX() <= this.puntoFinal.getX() /*+i*/){
                    impactos++;
                    hundido();
                    return true;
                } else if (punto.getY() <= this.puntoInicial.getY() && punto.getY() >= this.puntoFinal.getY() /*+i*/){
                    impactos++;
                    hundido();
                    return true;
                }
        }
   /* int posicion = 0;
       if (direction == NORTH || direction == SOUTH) {
            posicion = punto.getY() - puntoInicial.getY();
        } else {
            posicion = punto.getX() - puntoInicial.getX();
        }
        if (impactos[posicion]) {
            System.out.println("impacto repetido");
            return false;
        } else {
            impactos[posicion] = true;
            return true;
        }

        if (punto.getX() == puntoInicial.getX() && punto.getY() == puntoInicial.getY()) {
            impactos[0] = true;
            return true;
        } else if (punto.getX() == puntoInicial.getX() && punto.getY() == puntoInicial.getY() + 1) {
            impactos[1] = true;
            return true;
        } else if (punto.getX() == puntoInicial.getX() && punto.getY() == puntoInicial.getY() + 2) {
            impactos[2] = true;
            return true;
        } else {
            return false;
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
            }*/
        return false;
        }

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

    public Puntos getPuntoFinal() {
        return puntoFinal;
    }


    protected void setImpactos(int contenedoresAislados) {
    }

    public int getImpactos() {
        return impactos;
    }
}
