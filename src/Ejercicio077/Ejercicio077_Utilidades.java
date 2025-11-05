package Ejercicio077;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 077 | 2025-10-16
 */
public class Ejercicio077_Utilidades {

    private static final int ANCHO_SELLO = 70;
    private static String idiomaSeleccionado = "es";
    private static final int MIN_BASE = -50;
    private static final int MAX_BASE = 50;
    private static final int MIN_EXP = -10;
    private static final int MAX_EXP = 10;

    // Diccionario de textos (Abreviado para el prompt, completo en el código)
    private static String[][] textos = {
            {"es", "en"}, // 0
            {"*** BIENVENIDO ***", "*** WELCOME ***"}, // 1
            {"Seleccione el idioma:", "Select language:"}, // 2
            {"[1] Español", "[1] Spanish"}, // 3
            {"[2] Inglés", "[2] English"}, // 4
            {"Opción no válida. Intente de nuevo.", "Invalid option. Try again."}, // 5
            {"--- MENÚ DE EJECUCIÓN ---", "--- EXECUTION MENU ---"}, // 6
            {"[1] Ejecutar Programa", "[1] Run Program"}, // 7
            {"[2] Finalizar Programa", "[2] End Program"}, // 8
            {"El programa finalizará.", "The program will end."}, // 9

            // Mensajes del Programa
            {"Generación de Tabla de Potencias (Función vs. Math.pow)", "Power Table Generation (Function vs. Math.pow)"}, // 10
            {"Ingrese el número base inicial (entre " + MIN_BASE + " y " + MAX_BASE + "): ", "Enter the initial base number (between " + MIN_BASE + " and " + MAX_BASE + "): "}, // 11
            {"Ingrese el número base final (entre " + MIN_BASE + " y " + MAX_BASE + "): ", "Enter the final base number (between " + MIN_BASE + " and " + MAX_BASE + "): "}, // 12
            {"ERROR: El número debe estar entre " + MIN_BASE + " y " + MAX_BASE + ".", "ERROR: The number must be between " + MIN_BASE + " and " + MAX_BASE + "."}, // 13
            {"¿Desea que el primer número sea %.2f y el segundo %.2f (1= si, 2 = volver a leer ambos números)? : ", "Do you want the first number to be %.2f and the second %.2f (1= yes, 2 = re-read both numbers)? : "}, // 14
            {"Ingrese el Exponente %d (entero entre " + MIN_EXP + " y " + MAX_EXP + "): ", "Enter Exponent %d (integer between " + MIN_EXP + " and " + MAX_EXP + "): "}, // 15
            {"ERROR: El exponente debe ser un entero entre " + MIN_EXP + " y " + MAX_EXP + ".", "ERROR: The exponent must be an integer between " + MIN_EXP + " and " + MAX_EXP + "."}, // 16
            {"Programa finalizado. Gracias por usar el sistema.", "Program finished. Thank you for using the system."}, // 17
    };

    public static String obtenerTexto(int index) {
        int idiomaIndex = idiomaSeleccionado.equals("es") ? 0 : 1;
        return textos[index][idiomaIndex];
    }

    // --- MÉTODOS DE MENÚ CORREGIDOS (Añadido 'static') ---

    public static void seleccionarIdioma(Scanner scanner) { // << CORREGIDO
        int opcion = 0;
        while (opcion != 1 && opcion != 2) {
            System.out.println(obtenerTexto(1));
            System.out.println(obtenerTexto(2));
            System.out.println(obtenerTexto(3));
            System.out.println(obtenerTexto(4));
            System.out.print(">");
            try {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion == 1) {
                        idiomaSeleccionado = "es";
                    } else if (opcion == 2) {
                        idiomaSeleccionado = "en";
                    } else {
                        System.out.println(obtenerTexto(5));
                    }
                } else {
                    System.out.println(obtenerTexto(5));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(5));
                scanner.next();
            }
        }
    }

    public static boolean mostrarMenuEjecucion(Scanner scanner) { // << CORREGIDO
        int opcion = 0;
        while (opcion != 1 && opcion != 2) {
            System.out.println("\n" + obtenerTexto(6));
            System.out.println(obtenerTexto(7));
            System.out.println(obtenerTexto(8));
            System.out.print(">");
            try {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion == 2) {
                        System.out.println(obtenerTexto(9));
                        return false;
                    } else if (opcion != 1) {
                        System.out.println(obtenerTexto(5));
                    }
                } else {
                    System.out.println(obtenerTexto(5));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(5));
                scanner.next();
            }
        }
        return true;
    }

    // --- Lógica de I/O y Validación (No necesita cambios, ya eran static) ---

    public static double leerNumeroBase(Scanner scanner, int mensajeIndex) {
        // ... (Implementación de leerNumeroBase) ...
        double valor = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print(obtenerTexto(mensajeIndex));
            try {
                if (scanner.hasNextDouble()) {
                    valor = scanner.nextDouble();
                    if (valor >= MIN_BASE && valor <= MAX_BASE) {
                        entradaValida = true;
                    } else {
                        System.out.println(obtenerTexto(13));
                    }
                } else {
                    System.out.println(obtenerTexto(13));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(13));
                scanner.next();
            }
        }
        return valor;
    }

    public static int leerExponente(Scanner scanner, int indiceExp) {
        // ... (Implementación de leerExponente) ...
        int exponente = Integer.MIN_VALUE;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.printf(obtenerTexto(15), indiceExp);
            try {
                if (scanner.hasNextInt()) {
                    exponente = scanner.nextInt();
                    if (exponente >= MIN_EXP && exponente <= MAX_EXP) {
                        entradaValida = true;
                    } else {
                        System.out.println(obtenerTexto(16));
                    }
                } else {
                    System.out.println(obtenerTexto(16));
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(obtenerTexto(16));
                scanner.next();
            }
        }
        return exponente;
    }

    public static double[] leerYOrdenarBases(Scanner scanner) {
        // ... (Implementación de leerYOrdenarBases) ...
        double num1, num2;
        boolean ordenAceptado = false;

        do {
            num1 = leerNumeroBase(scanner, 11);
            num2 = leerNumeroBase(scanner, 12);

            if (num1 <= num2) {
                ordenAceptado = true;
            } else {
                System.out.printf(obtenerTexto(14), num2, num1);

                int opcion = -1;
                try {
                    if (scanner.hasNextInt()) {
                        opcion = scanner.nextInt();
                        if (opcion == 1) {
                            double temp = num1;
                            num1 = num2;
                            num2 = temp;
                            ordenAceptado = true;
                        } else if (opcion == 2) {
                            System.out.println("Reiniciando lectura de números base...");
                        } else {
                            System.out.println(obtenerTexto(5));
                        }
                    } else {
                        System.out.println(obtenerTexto(5));
                        scanner.next();
                    }
                } catch (InputMismatchException e) {
                    System.out.println(obtenerTexto(5));
                    scanner.next();
                }
            }
        } while (!ordenAceptado);

        return new double[]{num1, num2};
    }

    // --- Métodos de Presentación (No necesita cambios, ya eran static) ---

    public static void mostrarSelloCorto() {
        // ... (Implementación de mostrarSelloCorto) ...
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 077 | 2025-10-16";
        String lineaHorizontal = "─".repeat(ANCHO_SELLO - 2);
        int padding = (ANCHO_SELLO - 2 - sello.length()) / 2;
        String espacios = " ".repeat(padding);

        System.out.println("┌" + lineaHorizontal + "┐");
        System.out.println("│" + espacios + sello + " ".repeat(ANCHO_SELLO - 2 - sello.length() - padding) + "│");
        System.out.println("└" + lineaHorizontal + "┘");
    }

    public static void mostrarEncabezado() {
        System.out.println("\n--- " + obtenerTexto(10) + " ---");
    }

    public static void mostrarTabla(double num1, double num2, int p1, int p2, int p3) {
        final int ANCHO = 15;

        // ... (Implementación de mostrarTabla) ...
        System.out.println("\nTabla de Potencias:");
        System.out.printf("%-" + ANCHO + "s|", "Num");
        System.out.printf("%-" + ANCHO + "s|", "Potencia " + p1);
        System.out.printf("%-" + ANCHO + "s|", "Math.pow(" + p1 + ")");
        System.out.printf("%-" + ANCHO + "s|", "Potencia " + p2);
        System.out.printf("%-" + ANCHO + "s|", "Math.pow(" + p2 + ")");
        System.out.printf("%-" + ANCHO + "s|", "Potencia " + p3);
        System.out.printf("%-" + ANCHO + "s%n", "Math.pow(" + p3 + ")");

        System.out.println("─".repeat(ANCHO * 7 + 6));

        for (double num = num1; num <= num2 + 0.0001; num++) {

            double resP1_func = Ejercicio077_Funciones.calcularPotencia(num, p1);
            double resP2_func = Ejercicio077_Funciones.calcularPotencia(num, p2); // Corregido: Usar Ejercicio077_Funciones
            double resP3_func = Ejercicio077_Funciones.calcularPotencia(num, p3);

            double resP1_math = Math.pow(num, p1);
            double resP2_math = Math.pow(num, p2);
            double resP3_math = Math.pow(num, p3);

            System.out.printf("%-" + ANCHO + ".2f|", num);
            System.out.printf("%-" + ANCHO + ".3f|", resP1_func);
            System.out.printf("%-" + ANCHO + ".3f|", resP1_math);

            System.out.printf("%-" + ANCHO + ".3f|", resP2_func);
            System.out.printf("%-" + ANCHO + ".3f|", resP2_math);

            System.out.printf("%-" + ANCHO + ".3f|", resP3_func);
            System.out.printf("%-" + ANCHO + ".3f%n", resP3_math);
        }
    }
}