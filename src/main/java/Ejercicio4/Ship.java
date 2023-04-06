package Ejercicio4;

public class Ship {


    CardinalPoints.CardinalPoint direction;
    int tamaño;
    Puntos[] cordenadas;

    public Ship(int tamaño) {
        this.tamaño = tamaño;
        cordenadas = new Puntos[tamaño];
        //cordenadas[0] = new Puntos(0, 0);
        direction = CardinalPoints.CardinalPoint.EAST;
    }

    public void move() {
        switch (direction) {
            case NORTH:
              //  cordenadas[0].setY(cordenadas[0].getY() + 1);
                break;
            case SOUTH:
                //cordenadas[0].setY(cordenadas[0].getY() - 1);
                break;
            case EAST:
              //  cordenadas[0].setX(cordenadas[0].getX() + 1);
                break;
            case WEST:
               // cordenadas[0].setX(cordenadas[0].getX() - 1);
                break;
        }
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

    public Puntos[] getCordenadas() {
        return cordenadas;
    }

    public void setCordenadas(Puntos[] cordenadas) {
        this.cordenadas = cordenadas;
    }

    //metodo para saber si el barco se ha hundido
    public boolean isSunk() {
        boolean hundido = true;
        for (int i = 0; i < cordenadas.length; i++) {
            if (cordenadas[i] != null) {
                hundido = false;
            }
        }
        return hundido;
    }

    //Programe el método get_shot(self, shot_point). Implementación recibir disparo. El disparo
    //afectará al barco si se encuentra entre el punto de partida y el punto final. No se tendrá en cuenta si el disparo ha sido previamente hecho en
    // el mismo punto o no. No es necesario hacer las comprobaciones para ver si el disparo está fuera del tablero de juego.

/*
    public boolean disparar(int x, int y) {
        boolean tocado = false;
        for (int i = 0; i < cordenadas.length; i++) {
            if (cordenadas[i].getX() == x && cordenadas[i].getY() == y) {
                cordenadas[i] = null;
                tocado = true;
            }
        }
        return tocado;
    }
*/

}
