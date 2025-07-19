package Cuerdafloja;
/*
*Cortez Juearez Edson Alberti
*Vergara Alarcon Roberto
*Perez Perez Michelle
*Solano Ortega Fernando
*/
public class Derecha extends Centro {
    private static final int LIMITE_DERECHO = 100;

    public Derecha() {
        super("Equipo B");
    }

    
    public synchronized void avanzar() {
        if (posicion >= LIMITE_DERECHO) {
            System.out.println(getName() + " ha llegado a la posición 100 y ha ganado!.");
            System.exit(0);
        }
    }
}
