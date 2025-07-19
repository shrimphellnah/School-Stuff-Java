package metodos;
import java.util.Scanner;

public class MetodoMultiplicadorConstante {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Metodo Multiplicador Constante.");

        System.out.print("Ingrese Xo: ");
        int Xo = sc.nextInt();

        System.out.print("Ingrese a: ");
        int a = sc.nextInt();

        System.out.print("Numero de ri: ");
        int ndado = sc.nextInt();

        int[] datos = new int[ndado];
        double[] resultados = new double[ndado];
        double[] valoresXo = new double[ndado];
        double[] valx1 = new double[ndado];

        int r1, r2, r3;
        int ban[] = { 10000000, 1000000, 100000, 10000, 1000, 100, 10 };
        int n = 0;

        int con = 0;
        int y1 = Xo, y2 = a;
        while (y1 > 0 && y2 > 0) {
            y1 = y1 / 10;
            y2 = y2 / 10;
            con++;
        }

        if (con == 4) {
            System.out.println("+---------+-------------------+----------------+----------------+");
            
            System.out.println("|    n    |         Xn        |         Xn+1   |        Rn      |");
            
            System.out.println("+---------+-------------------+----------------+----------------+");

            boolean foundRepeated = false;
            do {
                
                valoresXo[n] = Xo;
                valx1[n] = a;
                resultados[n] = r1 = Xo * a;
                n++;

                int[] y0 = new int[7];
                int c = 0, cont = 0;
                do {
                    r2 = r1 / ban[cont];
                    y0[c] = r2;
                    r3 = r2 * ban[cont];
                    r1 -= r3;
                    cont++;
                    c++;
                } while (cont < 7);

                int res;
                if (y0[0] == 0 && y0[1] == 0) {
                    res = y0[3] * 1000 + y0[4] * 100 + y0[5] * 10 + y0[6];
                } else {
                    res = y0[2] * 1000 + y0[3] * 100 + y0[4] * 10 + y0[5];
                }

                // verificar si el resultado se repite
                for (int i = 0; i < n - 1; i++) {
                    if (res == datos[i]) {
                        foundRepeated = true;
                        System.out.println("!!!! El algoritmo del metodo de multiplicador constante se degenera con la semilla x = " + res);
                        break;
                    }
                }

                if (foundRepeated) {
                    break; // detener el ciclo si se encuentra un resultado repetido
                }

                datos[n - 1] = res;
                Xo = res;
            } while (n < ndado);

            float[] datos1 = new float[ndado];
            int p = 1;
            for (int g = 0; g < ndado; g++) {
                datos1[g] = datos[g] / 10000f;
                System.out.printf("|%8d | %17.0f | %14d | %14.4f |\n", p, valoresXo[g], datos[g], datos1[g]);
                p++;
            }

            System.out.println("+---------+-------------------+----------------+----------------+");
        }
    }
}