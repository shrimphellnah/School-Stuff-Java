package metodos;

import java.util.Scanner;

public class MetodoCuadradoMedio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Metodo Cuadrado Medio.");

        System.out.print("Ingrese X0: ");
        int semilla = scanner.nextInt();
        int digitosSemilla = Integer.toString(semilla).length();

        System.out.print("Ingrese la cantidad de ri a generar: ");
        int cantidadNumeros = scanner.nextInt();

        System.out.println("\nGenerando " + cantidadNumeros + " numeros a partir de la X0 " + semilla + " utilizando el metodo del cuadrado medio:\n");

        System.out.println("N\tXn\tXn^2\t\tRi");
        System.out.println("----------------------------------------");

        boolean semillaRepetida = false;
        
        int[] semillasGeneradas = new int[cantidadNumeros];

        for(int i = 0; i < cantidadNumeros; i++) {
            
            int cuadradoSemilla = semilla * semilla;
            
            String cuadradoSemillaStr = Integer.toString(cuadradoSemilla);
            
            int longitudCuadrado = cuadradoSemillaStr.length();
            
            int mitadLongitud = (longitudCuadrado - digitosSemilla) / 2;
            
            String xnStr = cuadradoSemillaStr.substring(mitadLongitud, mitadLongitud + digitosSemilla);
            
            double xn = Double.parseDouble(xnStr) / Math.pow(10, digitosSemilla);

            System.out.format("%-2d\t%-5d\t%-10d\t%-10.5f\n", i+1, semilla, cuadradoSemilla, xn);

            semilla = Integer.parseInt(xnStr);
            
            semillasGeneradas[i] = semilla;

            if (i > 0) {
                
                for (int j = 0; j < i; j++) {
                    
                    if (semilla == semillasGeneradas[j]) {
                        
                        System.out.println("\nEl algoritmo de Metodo Cuadrado Medio se degenera en la semilla x = " + (i+1) + ".\n");
                        semillaRepetida = true;
                        break;
                    }
                }
            }

            if (semillaRepetida) { // si se ha detectado una semilla repetida, salimos del ciclo for
                break;
            }
        }

        scanner.close();
    }
}