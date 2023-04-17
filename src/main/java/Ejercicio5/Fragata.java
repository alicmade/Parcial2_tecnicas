package Ejercicio5;

import Ejercicio4.Barco;
import Ejercicio4.CardinalPoints;
import Ejercicio4.MetodosBarco;
import Ejercicio4.Puntos;

import java.sql.Array;

import static Ejercicio4.CardinalPoints.CardinalPoint.NORTH;
import static Ejercicio4.CardinalPoints.CardinalPoint.SOUTH;

public class Fragata extends Barco implements MetodosBarco {
    //private boolean [] contenedoresAislados;
    int contenedoresAislados = 3;
    public Fragata(Puntos puntoInicial,CardinalPoints.CardinalPoint direction) {
        super(puntoInicial, direction, 3);

       /* contenedoresAislados = new boolean[3];
        contenedoresAislados[0] = true;
        contenedoresAislados[1] = true;
        contenedoresAislados[2] = true;*/
        //super.setImpactos(contenedoresAislados);


    }
/*
    @Override
    public boolean disparar(Puntos punto) {

        if (contenedoresAislados[punto.getX()]) {
            contenedoresAislados[punto.getX()] = false;
            super.setImpactos(contenedoresAislados);
            return true;
        } else if (contenedoresAislados[punto.getY()]) {
            contenedoresAislados[punto.getY()] = false;
            super.setImpactos(contenedoresAislados);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean hundido() {
        if (contenedoresAislados[0] && contenedoresAislados[1] && contenedoresAislados[2]) {
            System.out.println("hundido");
            return true;
        } else {
            return false;
        }
    }*/
    @Override
    public boolean hundido() {
        if (super.getImpactos() == 3) {
            System.out.println("hundido");
            return true;
        } else {
            return false;
        }
}
}
