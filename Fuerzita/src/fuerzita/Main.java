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
public class Main {
    public static void main(String[] args) {
        HiloDerecha hiloDerecha = new HiloDerecha(10, 1);
        HiloIzquierda hiloIzquierda = new HiloIzquierda(5, -1);

        hiloDerecha.start();
        hiloIzquierda.start();
    }
}
