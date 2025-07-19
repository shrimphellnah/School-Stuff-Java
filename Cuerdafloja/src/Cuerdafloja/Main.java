package Cuerdafloja;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;

/*
*Cortez Juearez Edson Alberti
*Vergara Alarcon Roberto
*Perez Perez Michelle
*Solano Ortega Fernando
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Comienza el juego de cuerda floja...");

        Centro equipoA = new Izquierda();
        Centro equipoB = new Derecha();

        equipoA.start();
        equipoB.start();

        Frame frame = new Frame("Cuerda Floja");
        frame.setSize(400, 200);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
