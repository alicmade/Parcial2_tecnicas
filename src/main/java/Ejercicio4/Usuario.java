package Ejercicio4;

import java.util.ArrayList;

public class Usuario {
    ArrayList<Barco> barcos = new ArrayList<>();
   // Barco[] barcos;
    boolean vivo = false;
    Tablero tablero;

    public Usuario( Barco barco) throws IllegalArgumentException{
        if (barco == null) {
            throw new IllegalArgumentException("El barco no puede ser nulo.");
        }
        barcos.add(barco);
        tablero = new Tablero();
       // this.barcos =  barcosTablero.toArray(new Barco[barcosTablero.size()]);
    }

    public void agregarBarco(Barco barcoAux) throws Exception {
        if (barcoAux == null) {
            throw new IllegalArgumentException("El barco no puede ser nulo.");
        }
        barcos.add(barcoAux);
        tablero.depositarBarco(barcoAux);
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
        if (punto.getX() < 0 || punto.getX() > 9 || punto.getY() < 0 || punto.getY() > 9) {
            throw new Exception("El punto no esta en el tablero.");
        }
        for (Barco barco : user.getBarcosTablero()) {
            if (barco.disparar(punto)) {
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
        for (Barco barco : barcos) {
            if (barco.disparar(punto)) {
                barco.hundido();
                return;
            }

        }
    }

    //getters y setters
    public ArrayList<Barco> getBarcosTablero() {
        return barcos;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

}
