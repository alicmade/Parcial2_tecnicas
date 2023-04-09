package Ejercicio4;

import java.util.ArrayList;

public class Usuario {
    ArrayList<Barco> barcosTablero = new ArrayList<>();
    Barco[] barcos;
    boolean vivo = false;

    public Usuario( Barco barco) throws IllegalArgumentException{
        if (barco == null) {
            throw new IllegalArgumentException("El barco no puede ser nulo.");
        }
        barcosTablero.add(barco);

       // this.barcos =  barcosTablero.toArray(new Barco[barcosTablero.size()]);
    }

    public boolean estaVivo() {
        return vivo;
    }


    public boolean muere() {
       return vivo = false;
    }

    public boolean atacar(Puntos punto, Usuario user) throws Exception {
      if (punto == null || user == null) {
            throw new IllegalArgumentException("No se perimiten valores nulos.");
        }
        if (punto.x < 0 || punto.x > 9 || punto.y < 0 || punto.y > 9) {
            throw new Exception("El punto no esta en el tablero.");
        }
        for (Barco barco : user.getBarcosTablero()) {
            if (barco.disparar(punto.x, punto.y)) {
                return true;
            }
        }
        return false;
    }

    public void disparo(Puntos punto) throws Exception {
        if (punto == null) {
            throw new IllegalArgumentException("No se perimiten valores nulos.");
        }
        if (punto.x < 0 || punto.x > 9 || punto.y < 0 || punto.y > 9) {
            throw new Exception("El punto no esta en el tablero.");
        }
        for (Barco barco : barcosTablero) {
            if (barco.disparar(punto.x, punto.y)) {
                barco.hundido()
                return;
            }

        }
    }



    //la idea esq el usuario diga la posicion inicial (x e y )  y la direccion y el tamaño y se cree el barco
    public Barco crearBarco(int fila, int columna, int longitud, CardinalPoints.CardinalPoint direccion) throws Exception {
        int filaInicial = fila;
        int columnaInicial = columna;
        int filaFinal = fila;
        int columnaFinal = columna;

        switch (direccion) {
            case NORTH:
                filaInicial = fila - longitud + 1;
                break;
            case SOUTH:
                filaFinal = fila + longitud - 1;
                break;
            case EAST:
                columnaFinal = columna + longitud - 1;
                break;
            case WEST:
                columnaInicial = columna - longitud + 1;
                break;
        }

        if (filaInicial < 0 || filaFinal >= 10 || columnaInicial < 0 || columnaFinal >= 10) {
            throw new Exception("El barco no cabe en el tablero.");
        }
        //lo guardo entre dos puntos y asi es mas facil comprobar si en esa zona hay un barco
        Puntos puntoInicial = new Puntos(filaInicial, columnaInicial);
        Puntos puntoFinal = new Puntos(filaFinal, columnaFinal);
        return new Barco(puntoInicial, puntoFinal, direccion, longitud);
    }

    //getters y setters

    public ArrayList<Barco> getBarcosTablero() {
        return barcosTablero;
    }

    public void setBarcosTablero(ArrayList<Barco> barcosTablero) {
        this.barcosTablero = barcosTablero;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

}
