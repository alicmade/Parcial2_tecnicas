package Ejercicio5;

import Ejercicio4.Barco;
import Ejercicio4.CardinalPoints;
import Ejercicio4.Puntos;

public class Canoa extends Barco {

    public Canoa(Puntos puntoInicial, Puntos puntoFinal,  CardinalPoints.CardinalPoint direction, int tamaño) {
        super(puntoInicial, puntoFinal, tamaño);
    }
}
