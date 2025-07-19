package Cuerdafloja;
/*
*Cortez Juearez Edson Alberti
*Vergara Alarcon Roberto
*Perez Perez Michelle
*Solano Ortega Fernando
*/
public class Izquierda extends Centro {
    private static final int LIMITE_IZQUIERDO = -100;

    public Izquierda() {
        super("Equipo A");
    }

    
    public synchronized void avanzar() {
        if (posicion <= LIMITE_IZQUIERDO) {
            System.out.println(getName() + " ha llegado a la posición -100 y ha ganado!.");
            System.exit(0);
        }
    }
}
