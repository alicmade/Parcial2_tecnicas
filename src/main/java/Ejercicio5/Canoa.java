package Ejercicio5;

import Ejercicio4.Barco;
import Ejercicio4.CardinalPoints;
import Ejercicio4.MetodosBarco;
import Ejercicio4.Puntos;

import java.lang.reflect.Array;

import static Ejercicio4.CardinalPoints.CardinalPoint.NORTH;
import static Ejercicio4.CardinalPoints.CardinalPoint.SOUTH;

public class Canoa extends Barco implements MetodosBarco {
   // private static boolean [] contenedoresAislados;
    int contenedoresAislados = 1;

    public Canoa(Puntos puntoInicial, CardinalPoints.CardinalPoint direction) {
        super(puntoInicial, direction, 1);
        //contenedoresAislados = new boolean[1];
      //  contenedoresAislados[0] = false;
        super.setImpactos(contenedoresAislados);
       // super.getImpactos()[0] = false;


    }

/*
    @Override
    public boolean disparar(Puntos punto) {
        if (contenedoresAislados[0]) {
            contenedoresAislados[0] = false;
            super.setImpactos(contenedoresAislados);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean hundido() {
        if (!contenedoresAislados[0]) {
            System.out.println("hundido");
            return true;
        } else {
            return false;
        }
    }*/
    @Override
    public boolean hundido() {
        if (super.getImpactos() == 1) {
            System.out.println("LA CANOA HA SIDO HUNDIDA");
          //  System.out.println("hundido");
            return true;
        } else {
            return false;
        }
    }
}
