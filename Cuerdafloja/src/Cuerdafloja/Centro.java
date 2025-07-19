package Cuerdafloja;
import java.util.Random;
public class Centro extends Thread {
    protected static final int LIMITE_AVANCE = 1;
    protected static final int META = 5;
    protected static int posicion = 0; // Variable global para la posición
    private int avance;
    
    /*
*Cortez Juearez Edson Alberti
*Vergara Alarcon Roberto
*Perez Perez Michelle
*Solano Ortega Fernando
*/

    public Centro(String nombre) {
        super(nombre);
        this.avance = 0;
    }

    public void run() {
        while (Math.abs(posicion) < META) {
                    int avance = new Random().nextInt(LIMITE_AVANCE) + 1;
        if (getName().equals("Equipo A")) {
            avance *= -1; // Hacer avance negativo para el equipo A
        }
        posicion += avance;
        System.out.println(getName() + " avanza " + avance + " unidades. Posicion actual: " + posicion);

        if (posicion <= -100 || posicion >= 100) {
            if (posicion <= -100) {
                System.out.println(getName() + " ha llegado a la posición -100 y ha ganado!.");
            } else {
                System.out.println(getName() + " ha llegado a la posición 100 y ha ganado!.");
            }
            System.exit(0);
        }
        try {
            // Agregar una pausa de 1 segundo (1000 milisegundos)
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
        }
            
            
            // No es necesario avanzar automáticamente aquí, ya que será controlado por las teclas
        
        System.out.println(getName() + " ha cruzado la línea central y ha ganado!");
        System.exit(0); // Salir del programa al encontrar al ganador
    }
}
