package metodos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MetodoCongruencialLineal {
    public static void main(String[] args) {
        
        System.out.println("Metodo Congruencial Lineal.");
        
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el valor de a: ");
        int a = input.nextInt();

        System.out.print("Ingrese el valor de c: ");
        int c = input.nextInt();

        System.out.print("Ingrese el valor de x0: ");
        int x0 = input.nextInt();

        System.out.print("Ingrese el valor de m: ");
        int m = input.nextInt();

        int xi = x0;
        double ri;

        System.out.println("i\t xi\t\t axi+c\t\t (axi+c)modm\t ri");

        Set<Double> rSet = new HashSet<>(); // Set para almacenar valores ri

        for (int i = 1; i <= 10; i++) {
            int a_xi_c = a * xi + c;
            xi = a_xi_c % m;
            ri = (double) xi / (m - 1);
            ri = Math.round(ri * 10000.0) / 10000.0;
            
            if (rSet.contains(ri)) {
                System.out.println("El algoritmo del metodo congruencial lineal se degenera con la semilla x = " + x0);
                break; // detiene el programa
            }
            rSet.add(ri); // agrega ri al programa

            System.out.println(i + "\t " + xi + "\t\t " + a + "" + xi + "+" + c + "\t\t " + a_xi_c + " mod " + m + "\t " + ri);
        }
    }
}