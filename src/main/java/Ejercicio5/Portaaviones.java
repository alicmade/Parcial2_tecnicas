package Ejercicio5;

import Ejercicio4.Barco;
import Ejercicio4.CardinalPoints;
import Ejercicio4.Puntos;

public class Portaaviones extends Barco {
    public Portaaviones(Puntos puntoInicial, Puntos puntoFinal, CardinalPoints.CardinalPoint direction, int tamaño) {
        super(puntoInicial, puntoFinal, direction, tamaño);
    }
}
