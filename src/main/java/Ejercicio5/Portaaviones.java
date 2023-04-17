package Ejercicio5;

import Ejercicio4.Barco;
import Ejercicio4.CardinalPoints;
import Ejercicio4.MetodosBarco;
import Ejercicio4.Puntos;

import java.lang.reflect.Array;

import static Ejercicio4.CardinalPoints.CardinalPoint.NORTH;
import static Ejercicio4.CardinalPoints.CardinalPoint.SOUTH;

public class Portaaviones extends Barco implements MetodosBarco {
    //private boolean [] contenedoresAislados;
    int contenedoresAislados = 5;
    public Portaaviones(Puntos puntoInicial, CardinalPoints.CardinalPoint direction) {
        super(puntoInicial, direction, 5);
       /* contenedoresAislados = new boolean[5];
        Array.setBoolean(contenedoresAislados, 0, true);
        Array.setBoolean(contenedoresAislados, 1, true);
        Array.setBoolean(contenedoresAislados, 2, true);
        Array.setBoolean(contenedoresAislados, 3, true);
        Array.setBoolean(contenedoresAislados, 4, true);*/
        super.setImpactos(contenedoresAislados);
    }

/*
    @Override
    public boolean disparar(Puntos punto) {
        if (getDirection() == NORTH || getDirection() == SOUTH) {
            if (contenedoresAislados[punto.getY()]) {
                contenedoresAislados[punto.getY()] = false;
                super.setImpactos(contenedoresAislados);
                return true;
            } else {
                return false;
            }
        } else {
            if (contenedoresAislados[punto.getX()]) {
                contenedoresAislados[punto.getX()] = false;
                super.setImpactos(contenedoresAislados);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public  boolean hundido() {
        if (contenedoresAislados[0] && contenedoresAislados[1] && contenedoresAislados[2] && contenedoresAislados[3] && contenedoresAislados[4]) {
            System.out.println("hundido");
            return true;
        } else {
            return false;
        }
    }*/
    @Override
    public boolean hundido() {
        if (super.getImpactos() == contenedoresAislados) {
            System.out.println("hundido");
            return true;
        } else {
            return false;
        }
    }

}
