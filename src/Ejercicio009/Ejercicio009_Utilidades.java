package Ejercicio009;

import java.util.InputMismatchException;
import java.util.Scanner;

    /**
     * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 009 | 2025-10-15
     * Propósito: Maneja la entrada de datos, el sello personalizado y la salida de resultados formateada.
     */
    public class Ejercicio009_Utilidades {

        // Constante para el ancho del cuadro del sello
        private static final int ANCHO = 70;

        /**
         * Muestra el sello personalizado en un cuadro.
         */
        public static void mostrarSelloCorto() {
            String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 009 | 2025-10-15";
            String lineaHorizontal = "─".repeat(ANCHO - 2);

            System.out.println("┌" + lineaHorizontal + "┐");

            // Centrar el texto (Aproximación simple para este sello fijo)
            int padding = (ANCHO - 2 - sello.length()) / 2;
            String espacios = " ".repeat(padding);

            System.out.println("│" + espacios + sello + " ".repeat(ANCHO - 2 - sello.length() - padding) + "│");
            System.out.println("└" + lineaHorizontal + "┘");
        }

        /**
         * Solicita y lee un número entero positivo para el radio.
         * @param scanner Objeto Scanner para la entrada.
         * @return El radio ingresado como entero.
         */
        public static int leerRadio(Scanner scanner) {
            int radio = -1;
            while (radio <= 0) {
                System.out.print("Escriba el radio de un círculo (entero positivo): ");
                try {
                    radio = scanner.nextInt();
                    if (radio <= 0) {
                        System.out.println("ADVERTENCIA: El radio debe ser un entero positivo.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Entrada inválida. Por favor, ingrese un número entero.");
                    scanner.next(); // Limpiar el buffer
                    radio = -1;
                }
            }
            return radio;
        }

        /**
         * Imprime los resultados del círculo, realizando los cálculos en la salida.
         * @param radio El radio del círculo.
         */
        public static void mostrarResultados(int radio) {
            System.out.println("\n--- Resultados del Círculo (Radio = " + radio + ") ---");

            // CÁLCULOS EN INSTRUCCIONES DE SALIDA:
            System.out.printf("Diámetro: %.2f%n",
                    Ejercicio009_Operaciones.calcularDiametro(radio));

            System.out.printf("Circunferencia: %.5f%n",
                    Ejercicio009_Operaciones.calcularCircunferencia(radio));

            System.out.printf("Área: %.5f%n",
                    Ejercicio009_Operaciones.calcularArea(radio));

            System.out.println("-------------------------------------");
        }
    }

