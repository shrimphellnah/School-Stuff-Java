package turing;


import java.util.Scanner;

public class TuringMachine {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir entrada al usuario
        System.out.print("Ingrese la cadena: ");
        String input = scanner.nextLine();

        // Pedir la cinta al usuario
        System.out.print("Ingrese la cinta separada por comas: ");
        String[] tapeArray = scanner.nextLine().split(",");
        char[] tape = new char[tapeArray.length];
        for (int i = 0; i < tapeArray.length; i++) {
            tape[i] = tapeArray[i].charAt(0);
        }

        System.out.print("Ingrese el estado inicial: ");
        String currentState = scanner.nextLine();

        // Pedir transiciones de estado
        String[][] transitions = new String[100][5];
        int transitionCount = 0;

        System.out.println("Ingrese los datos de la transición uno por uno, en el siguiente orden: estado actual, letra actual, estado siguiente, letra siguiente, dirección. Deje en blanco el estado actual para terminar.");

        while (true) {
            String[] transition = new String[5];

            System.out.print("Estado actual: ");
            transition[0] = scanner.nextLine();

            if (transition[0].isEmpty()) {
                break;
            }

            System.out.print("Letra actual: ");
            transition[1] = scanner.nextLine();

            System.out.print("Estado siguiente: ");
            transition[2] = scanner.nextLine();

            System.out.print("Letra siguiente: ");
            transition[3] = scanner.nextLine();

            System.out.print("Dirección (Izquierda/Derecha): ");
            transition[4] = scanner.nextLine();

            transitions[transitionCount] = transition;
            transitionCount++;
        }


        // Ejecutar la maquina de Turing
        int headPosition = 0;
        int currentStateIndex = Integer.parseInt(currentState.substring(1));

        while (true) {
            char currentSymbol = tape[headPosition];

            // Buscar transición
            String[] transition = null;
            for (int i = 0; i < transitionCount; i++) {
                String[] currentTransition = transitions[i];
                if (currentTransition[0].equals(currentState) && currentTransition[1].equals(String.valueOf(currentSymbol))) {
                    transition = currentTransition;
                    break;
                }
            }

            // Si no se encuentra transición, se rechaza la cadena
            if (transition == null) {
                System.out.println("La cadena es rechazada.");
                return;
            }

            // Actualizar cinta y cabezal
            tape[headPosition] = transition[3].charAt(0);
            if (transition[4].equals("Derecha")) {
                headPosition++;
                if (headPosition == tape.length) {
                    char[] newTape = new char[tape.length * 2];
                    System.arraycopy(tape, 0, newTape, 0, tape.length);
                    tape = newTape;
                }
            } else if (transition[4].equals("Izquierda")) {
                headPosition--;
                if (headPosition == -1) {
                    headPosition = 0;
                    char[] newTape = new char[tape.length * 2];
                    System.arraycopy(tape, 0, newTape, tape.length, tape.length);
                    tape = newTape;
                }
            }

            // Cambiar estado
            currentState = transition[4];
            currentStateIndex = Integer.parseInt(currentState.substring(1));
            if (currentState.startsWith("qf")) {
                System.out.println("La cadena es aceptada.");
                return;
            }
        }
    }
}