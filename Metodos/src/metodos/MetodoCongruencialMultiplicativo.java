package metodos;

import java.util.Scanner;
import java.util.HashSet;

public class MetodoCongruencialMultiplicativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Metodo Congruencial Multiplicativo.");
        
        System.out.print("Ingrese el valor de x0: ");
        int x0 = sc.nextInt();
        System.out.print("Ingrese el valor de a: ");
        int a = sc.nextInt();
        System.out.print("Ingrese el valor de m: ");
        int m = sc.nextInt();
        System.out.print("Ingrese valores a generar : ");
        int n = sc.nextInt();
        double xn = x0;

        System.out.println("Valores generados: ");
        System.out.println("---------------------------------------------");
        System.out.println("i\txn\taxn mod m\tri");
        System.out.println("---------------------------------------------");
        
        HashSet<Double> set = new HashSet<>(); // to store unique ri values
        
        for (int i = 0; i < n; i++) {
            double axn = a * xn;
            xn = axn % m;
            double ri = xn / (m - 1.0);
            System.out.printf("%d\t%.0f\t%.0f %% %d = %.0f\t%.4f\n", i+1, xn, axn, m, xn, ri);
            if (set.contains(ri)) {
                System.out.println("El algoritmo del metodo congruencial multiplicativo se degenera en la semilla " + x0);
                break;
            } else {
                set.add(ri);
            }
        }
        System.out.println("---------------------------------------------");
    }
}