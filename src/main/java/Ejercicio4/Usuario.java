package Ejercicio4;

import java.util.ArrayList;

public class Usuario {
    String nombre;
    int puntuacion;
    Puntos posicion;

    ArrayList<Barco> barcosTablero = new ArrayList<>();
    boolean vivo = false;

    public Usuario(String nombre, Barco barco) throws IllegalArgumentException{
        if (barco == null) {
            throw new IllegalArgumentException("El barco no puede ser nulo.");
        }
        barcosTablero.add(barco);
        this.nombre = nombre;
    }

    public boolean estaVivo() {
        for (int i = 0; i < barcosTablero.size(); i++) {
         /*   if (!barcosTablero.get(i).hundido()) {
                vivo = true;
            }*/
        }
        return vivo;
    }

    public void muere() {
        for (int i = 0; i < barcosTablero.size(); i++) {
         // barcosTablero.get(i).setPosicion(null);
        }
    }

    public boolean atacar(int x, int y, Usuario user) throws IndexOutOfBoundsException {
        if (x < 0 || x >= 10 || y < 0 || y >= 10) {
            throw new IndexOutOfBoundsException("Coordenadas de disparo fuera de los límites del tablero.");
        }
        boolean tocado = false;
        for (int i = 0; i < user.barcosTablero.size(); i++) {
            if (user.barcosTablero.get(i).disparar(x, y)) {
                tocado = true;
            }
        }
        return tocado;
    }

    public void disparo(int x, int y) {
        for (int i = 0; i < barcosTablero.size(); i++) {
            barcosTablero.get(i).disparar(x, y);
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
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

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

    public Puntos getPosicion() {
        return posicion;
    }

    public void setPosicion(Puntos posicion) {
        this.posicion = posicion;
    }
}
