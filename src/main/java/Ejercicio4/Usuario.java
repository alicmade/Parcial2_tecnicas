package Ejercicio4;

import Ejercicio5.Canoa;
import Ejercicio5.Fragata;
import Ejercicio5.Portaaviones;

import java.util.ArrayList;

public class Usuario {
    private ArrayList<Barco> barcos = new ArrayList<>();
   // Barco[] barcos;
    boolean vivo = false;
    Tablero tablero;

    public Usuario( /*Barco barco*/) throws IllegalArgumentException{
       /* if (barco == null) {
            throw new IllegalArgumentException("El barco no puede ser nulo.");
        }*/

        tablero = new Tablero();
       // this.barcos.add(new Fragata(new Puntos(1, 1), CardinalPoints.CardinalPoint.NORTH));
       // this.barcos =  barcosTablero.toArray(new Barco[barcosTablero.size()]);
    }

    public void agregarBarco(Barco barcoAux) throws Exception {
        if (barcoAux == null) {
            throw new IllegalArgumentException("El barco no puede ser nulo.");
        }
      //  barcos.add(barcoAux);
        barcos.add(barcoAux);
        tablero.depositarBarco(barcoAux);
    }
    public boolean estaVivo() {
        for (Barco barco : barcos) {
            if (barco.hundido()) {
                vivo = true;
            }
        }

        return vivo;
    }


    public boolean muere() {
       return vivo = false;
    }

    public boolean atacar(Puntos punto, Usuario user) {
        try {
            for (Barco barco : user.getBarcosTablero()) {
                if (user.getTablero().getTablero()[punto.getX() - 1][punto.getY() - 1] == '@') {
                    System.out.println("barco ha sido impactado.");
                    barco.disparar(punto);
                    disparo(punto);
                    return true;
                } else {
                    System.out.println("El barco no ha sido impactado.");
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }
                    /*
                        if (barco instanceof Canoa) {
                            System.out.println("Canoa ha sido impactado.");
                            barco.disparar(punto);
                            disparo(punto);
                            barco.hundido();
                            return true;
                        } else if (barco instanceof Fragata) {
                            System.out.println("Fragata ha sido impactado.");
                            barco.disparar(punto);
                            if (barco.hundido()) {
                                System.out.println("Fragata ha sido hundido.");
                            }
                            disparo(punto);
                            return true;
                        } else if (barco instanceof Portaaviones) {
                            System.out.println("Portaaviones ha sido impactado.");
                            barco.disparar(punto);
                            if (barco.hundido()) {
                                System.out.println("Portaaviones ha sido hundido.");
                            }
                            disparo(punto);
                            return true;
                        }
                    }
                }
                System.out.println("El barco no ha sido impactado.");
                return false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
        }*/

        /*
        for (Barco barco : user.getBarcosTablero()) {
            if (barco.disparar(punto)) {
                System.out.println("El barco no ha sido impactado.");
                barco.hundido();
                tablero.marcarImpacto(punto);
                return true;
            }
        }
        if (user.getTablero().getTablero()[punto.getX()-1][punto.getY()-1] == '@') {
            //System.out.println("El barco ya ha sido impactado.");
            return true;}
        if(user.getTablero().getTablero()[punto.getX()-1][punto.getY()-1] == 'X') {
           System.out.println("El barco ya ha sido impactado.");
            return false;
        }if (user.getTablero().getTablero()[punto.getX()-1][punto.getY()-1] == '?') {
            System.out.println("Agua");
            return false;
        }*/


    public void disparo(Puntos punto) throws Exception {
        tablero.marcarImpacto(punto);
        /*
        if (punto == null) {
            throw new IllegalArgumentException("No se perimiten valores nulos.");
        }
        if (!atacar(punto, this)) {
           // System.out.println("El barco no ha sido impactado.");
        }else {
            System.out.println("El barco ha sido impactado.");
            tablero.marcarImpacto(punto);
        }
/*
        barcos.stream().forEach(barco -> {
            try {
                if (barco.disparar(punto)) {
                    barco.hundido();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
            /*if (barco.disparar(punto)) {
                barco.hundido();
            }
        }
            for (int i = 0; i < barcos.size(); i++) {
                if (barcos.get(i).disparar(punto)) {
                    barcos.get(i).hundido();
                }
            }*/

      //  throw new Exception("El punto no esta en el tablero.");
    }
    public void visualizacionComputadora() {
        tablero.visualizarTablero();
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

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
