package metodos;
import java.util.Arrays;
import java.util.Scanner;

public class MetodoCongruencialAditivo {
    public static void main(String[] args) {
        
        System.out.println("Metodo Congruencial Aditivo.");

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresar m: ");
        int m = sc.nextInt();
        System.out.print("Cuantas ri desea generar?: ");
        int nR = sc.nextInt();
        System.out.print("Cuantas X ingresara?: ");
        int nX = sc.nextInt();

        int[] dato = new int[nX];
        int[] d = new int[nX + nR];

        System.out.println("\n");

        for (int i = 0; i < nX; i++) {
            System.out.print("\t\tx" + (i + 1) + ": ");
            dato[i] = sc.nextInt();
            d[i] = dato[i];
        }

        int fu = dato[nX - 1];
        int h = nX;

        // Crear la tabla
        System.out.println("Tabla de resultados");
        System.out.println("+-----+--------------------------+-------+--------+");
        System.out.println("|  N  |          Operacion        |   Xn  |   ri   |");
        System.out.println("+-----+--------------------------+-------+--------+");

        for (int N = nX + 1; N <= nX + nR; N++) {
            int g;
            if (h >= nX) {
                g = d[h - nX];
            } else {
                g = dato[h];
            }
            double Xn = (fu + g) % m;
            double r = Xn / (m - 1);
            d[h] = (int) Xn;
            String op;
            if (h >= nX) {
                op = String.format("%6d + %6d mod %6d", fu, g, m);
            } else {
                op = String.format("%6d + %6d mod %6d", fu, dato[h], m);
            }
            System.out.printf("| %3d | %s | %5d | %.6f |\n", N, op, (int) Xn, r);
            fu = (int) Xn;
            h++;
        }

        System.out.println("+-----+--------------------------+-------+--------+");
    }
}