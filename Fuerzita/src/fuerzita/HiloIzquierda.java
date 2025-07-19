/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuerzita;

/**
 *
 * @author rober
 */
public class HiloIzquierda extends Thread {
    private static final Object lock = new Object();
    private static int panuelo = 0;
    private int maxCount;
    private int step;

    public HiloIzquierda(int maxCount, int step) {
        this.maxCount = maxCount;
        this.step = step;
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                if (panuelo <= -maxCount) {
                    break;
                }

                panuelo += step;
                System.out.println("Izquierda: " + panuelo);

                try {
                    Thread.sleep(100); // Pequeña pausa para visualizar mejor la salida
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

