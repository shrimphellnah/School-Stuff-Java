package metodos;

import java.util.Scanner;

public class MetodoProductoMedio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Metodo Producto Medio.");

        System.out.print("Ingrese X0: ");
        int semilla1 = scanner.nextInt();

        System.out.print("Ingrese X1: ");
        int semilla2 = scanner.nextInt();

        System.out.print("Ingrese la cantidad de resultados a generar: ");
        int cantidadResultados = scanner.nextInt();

        int[] resultados = new int[cantidadResultados];

        System.out.println("Resultados:");
        
        System.out.println("+------+-------+--------+------------+-------+");
        
        System.out.println("|   y  |   Xi  |   Xi+1 | Xi * Xi+1 |   Ri  |");
        
        System.out.println("+------+-------+--------+------------+-------+");

        for (int i = 0; i < cantidadResultados; i++) {
            
            int producto = semilla1 * semilla2;
            String productoStr = String.format("%08d", producto);
            int resultado = Integer.parseInt(productoStr.substring(2, 6));
            resultados[i] = resultado;
            System.out.printf("|%6d|%7d|%8d|%12d|%7.4f|\n", i, semilla1, semilla2, producto, (double)resultado/10000);
            System.out.println("+------+-------+--------+------------+-------+");
            semilla1 = semilla2;
            semilla2 = resultado;
        }

        System.out.println("-----------------------------------------------");
        System.out.println();
    }
}