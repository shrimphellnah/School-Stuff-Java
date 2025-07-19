package turing;

import java.util.Scanner;

public class MQ {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir entrada al usuario
        System.out.print("Ingrese la cadena: ");
        String input = scanner.nextLine();

        System.out.print("Ingrese el estado inicial: ");
        String currentState = scanner.nextLine();

        // Pedir transiciones de estado
        String[][] transitions = new String[100][4];
        int transitionCount = 0;

        System.out.println("Ingrese el salto de estado, lectura/escritura, direccion del cabezal y blanco (en ese orden), separados por coma. Deje en blanco el salto de estado para terminar.");

        while (true) {
            String[] transition = scanner.nextLine().split(",");
            if (transition.length == 1 && transition[0].isEmpty()) {
                break;
            }
            transitions[transitionCount] = transition;
            transitionCount++;
        }

        // Ejecutar la maquina de Turing
        int headPosition = 0;
        int currentStateIndex = 0;
        char[] tape = input.toCharArray();

        while (true) {
            char currentSymbol = tape[headPosition];

            // Buscar transición
            String[] transition = null;
            for (int i = 0; i < transitionCount; i++) {
                String[] currentTransition = transitions[i];
                if (currentTransition[0].equals("q" + currentStateIndex) && currentTransition[1].equals(String.valueOf(currentSymbol))) {
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
            tape[headPosition] = transition[2].charAt(0);
            if (transition[3].equals("Derecha")) {
                headPosition++;
                if (headPosition == tape.length) {
                    char[] newTape = new char[tape.length * 2];
                    System.arraycopy(tape, 0, newTape, 0, tape.length);
                    tape = newTape;
                }
            } else if (transition[3].equals("Izquierda")) {
                headPosition--;
                if (headPosition == -1) {
                    headPosition = 0;
                    char[] newTape = new char[tape.length * 2];
                    System.arraycopy(tape, 0, newTape, tape.length, tape.length);
                    tape = newTape;
                }
            }

            // Cambiar estado
            currentStateIndex = Integer.parseInt(transition[4].substring(1));
            if (transition[4].startsWith("qf")) {
                System.out.println("La cadena es aceptada.");
                return;
            }
        }
    }
}