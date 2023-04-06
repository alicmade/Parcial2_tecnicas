package Ejercicio4;

import java.sql.Array;
import java.util.Scanner;

public class User {
    private Scanner sc = new Scanner(System.in);
    private String name;
    private Ship[] barcos;
    private boolean[][] tablero;
    private int toques;
    private boolean esMiTurno;
    private int tamanio = 3;

    public User(String name, Ship[] barcos, boolean[][] tablero, int toques, boolean esMiTurno) {
        this.name = name;
        this.barcos = barcos;
        this.tablero = tablero;
        this.toques = toques;
        this.esMiTurno = esMiTurno;
    }

    public User(String name, Ship barcos) {
        this.name = name;
        barcos = new Ship(tamanio);
    }

    public User(Ship... barcos) throws IllegalArgumentException {
        if (barcos == null || barcos.length == 0) {
            throw new IllegalArgumentException("Debe haber al menos un barco en el juego");
        }

        for (Ship barco : barcos) {
            if (barco == null) {
                throw new IllegalArgumentException("No se permiten barcos nulos");
            }
            // Aquí puedes verificar el tipo y valor de los atributos del barco
            // y lanzar la excepción correspondiente si no se cumplen los requisitos.
            // Por ejemplo:
            if (barco.getTamaño() <= 0) {
                throw new IllegalArgumentException("El tamaño del barco debe ser mayor que cero");
            }
        }

        this.barcos = barcos;
    }

    // Programe el método attack(self, Point shot_point, User user). Este método se utiliza para
    //realizar un disparo al usuario user en el punto shot_point. El método devolverá True si cualquiera de los barcos que no han sido hundidos ha sido acertado y falso en caso contrario. Se debe hacer el control de excepciones para este método.
/*
    public boolean attack(int x, int y, User user) {
        boolean tocado = false;
        for (int i = 0; i < user.barcos.length; i++) {
            if (user.barcos[i].disparar(x, y)) {
                tocado = true;
            }
        }
        return tocado;
    }
    //Programe el método is_alive(self) de la clase Usuario. Este método get se utiliza para obtener el atributo is_alive. Este atributo sirve para saber si el usuario aún está vivo.

    public boolean isAlive() {
        boolean vivo = false;
        for (int i = 0; i < barcos.length; i++) {
            if (!barcos[i].isSunk()) {
                vivo = true;
            }
        }
        return vivo;
    }

    //Programe el método die(self) de la clase Usuario. Este método set se utiliza para establecer el atributo __alive en False. De esta forma, es posible matar al usuario.

    public void die() {
        for (int i = 0; i < barcos.length; i++) {
            barcos[i] = null;
        }
    }

    //hacer un menu para que el usuario pueda elegir que barco quiere poner y donde
    //hacer un metodo para que el usuario pueda poner los barcos en el tablero
    
    
    public void ponerBarcos() {
        for (int i = 0; i < barcos.length; i++) {
            System.out.println("Barco " + i + " de tamaño " + barcos[i].getTamaño());
            System.out.println("Introduce la coordenada x del barco");
            int x = sc.nextInt();
            System.out.println("Introduce la coordenada y del barco");
            int y = sc.nextInt();
            Puntos[] punto = new Puntos[]{new Puntos(x, y)};
            barcos[i].setCordenadas(punto);
        }
    }

   //hacer un main para probar los metodos

    public static void main(String[] args) {

        User user = new User("pepe", new Ship(3));
        user.ponerBarcos();


    }*/
}
