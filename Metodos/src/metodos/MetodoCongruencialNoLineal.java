package metodos;

import java.util.HashSet;
import java.util.Scanner;

public class MetodoCongruencialNoLineal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Xo, m, m1, dado, N = 0;
        double Xn, a, b, c;
        
        System.out.println("Metodo Congruencial No Lineal.");

        System.out.print("Valor de Xo: ");
        Xo = sc.nextInt();
        System.out.print("Ingrese m: ");
        m = sc.nextInt();
        System.out.print("Ingrese el valor de a: ");
        a = sc.nextDouble();
        System.out.print("Cual es el valor de b: ");
        b = sc.nextDouble();
        System.out.print("Cual es el valor de c: ");
        c = sc.nextDouble();

        System.out.println("\n");

        System.out.println("\t\t-----------------------------------------------------------------");

        System.out.println(String.format("\t\t| %5s | %12s | %12s | %12s |", "i", "Xo", "Xn", "ri"));

        System.out.println("\t\t-----------------------------------------------------------------");

        HashSet<Integer> seeds = new HashSet<Integer>(); // para poder identificar semillas
        while (!seeds.contains(Xo)) { // genera hasta que llegue una repetida
            
            seeds.add(Xo); // agrega semillas al hash
            N++;
            dado = (int) Math.pow(Xo, 2);
            Xn = ((a * dado) + (b * Xo) + c) % m;
            m1 = m - 1;
            double r = (Xn / m1);
            System.out.println(String.format("\t\t| %5d | %12d | %12d |%12.4f |", N, Xo, (int) Xn, r));
            Xo = (int) Xn;
            
        }

        System.out.println("\t\t-----------------------------------------------------------------");
        System.out.println("\n");
        
        // imprime la degeneracion de la semilla
        System.out.println("El algoritmo de congruencia lineal cuadrática se degenera en la semilla " + Xo);
    }
}