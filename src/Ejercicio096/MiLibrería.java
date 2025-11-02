/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 096 | 2025-10-24               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio096;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // Funciones matemáticas
    public static int sumarArreglo(int[] arreglo) {
        int suma = 0;
        for (int num : arreglo) suma += num;
        return suma;
    }

    public static int contarPares(int[] arreglo) {
        int pares = 0;
        for (int num : arreglo) if (num % 2 == 0) pares++;
        return pares;
    }

    public static int contarImpares(int[] arreglo) {
        int impares = 0;
        for (int num : arreglo) if (num % 2 != 0) impares++;
        return impares;
    }

    public static int mayorMenosMenor(int[] arreglo) {
        int max = Arrays.stream(arreglo).max().getAsInt();
        int min = Arrays.stream(arreglo).min().getAsInt();
        return max - min;
    }

    // Validaciones
    public static boolean validarContinuar(String respuesta) {
        return respuesta.equalsIgnoreCase("S") || respuesta.equalsIgnoreCase("Y") || respuesta.equalsIgnoreCase("N");
    }

    // Formato de texto
    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 096 | 2025-10-24                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = Math.max(0, espaciosTotal / 2);
        int espaciosDer = Math.max(0, espaciosTotal - espaciosIzq);
        return " ".repeat(espaciosIzq) + texto + " ".repeat(espaciosDer);
    }

    // Procesamiento de datos
    public static void procesarVector(Scanner scanner, String idioma) {
        Random rand = new Random();
        int[] vector = new int[100];
        for (int i = 0; i < 100; i++) {
            vector[i] = rand.nextInt(100) + 1; // Números aleatorios entre 1 y 100
        }

        int sumaTotal = sumarArreglo(vector);
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("CÁLCULO DE LA SUMA TOTAL", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Suma = " + vector[0]);
        for (int i = 1; i < 100; i++) {
            System.out.println("│       + " + vector[i]);
        }
        System.out.println("│       = " + sumaTotal + " ".repeat(ANCHO - 13 - String.valueOf(sumaTotal).length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

        Arrays.sort(vector);
        int pares = contarPares(vector);
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("CONTEO DE NÚMEROS PARES", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < 100; i++) {
            if (vector[i] % 2 == 0) System.out.println("│ " + vector[i] + " es par");
        }
        System.out.println("│ Total pares = " + pares + " ".repeat(ANCHO - 18 - String.valueOf(pares).length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

        int impares = contarImpares(vector);
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("CONTEO DE NÚMEROS IMPARES", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < 100; i++) {
            if (vector[i] % 2 != 0) System.out.println("│ " + vector[i] + " es impar");
        }
        System.out.println("│ Total impares = " + impares + " ".repeat(ANCHO - 19 - String.valueOf(impares).length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

        int mayorMenosMenor = mayorMenosMenor(vector);
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("CÁLCULO DE MAYOR MENOS MENOR", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Mayor = " + vector[99]);
        System.out.println("│ Menor = " + vector[0]);
        System.out.println("│ Mayor - Menor = " + mayorMenosMenor + " ".repeat(ANCHO - 18 - String.valueOf(mayorMenosMenor).length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("ARREGLO ORDENADO Y TOTALES", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < 100; i += 10) {
            StringBuilder linea = new StringBuilder("│ ");
            for (int j = i; j < i + 10 && j < 100; j++) {
                linea.append(String.format("%2d", vector[j])).append(" ");
            }
            System.out.println(linea.toString() + " ".repeat(Math.max(0, ANCHO - 3 - linea.length())) + "│");
        }
        System.out.println("│ Total suma = " + sumaTotal + " ".repeat(ANCHO - 17 - String.valueOf(sumaTotal).length()) + "│");
        System.out.println("│ Total pares = " + pares + " ".repeat(ANCHO - 18 - String.valueOf(pares).length()) + "│");
        System.out.println("│ Total impares = " + impares + " ".repeat(ANCHO - 19 - String.valueOf(impares).length()) + "│");
        System.out.println("│ Mayor - Menor = " + mayorMenosMenor + " ".repeat(ANCHO - 18 - String.valueOf(mayorMenosMenor).length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // Funciones de procesamiento
    public static void iniciarPrograma(Scanner scanner) {
        mostrarSello();
        idiomaActual = seleccionarIdioma(scanner);

        do {
            procesarVector(scanner, idiomaActual);
            continuar = preguntarContinuar(scanner, idiomaActual);
        } while (continuar);
    }

    // Selección de idioma
    public static String seleccionarIdioma(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("SELECCIÓN DE IDIOMA / LANGUAGE SELECTION", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            System.out.println("│  1. Español" + " ".repeat(ANCHO - 15) + "│");
            System.out.println("│  2. English" + " ".repeat(ANCHO - 15) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
            System.out.print("Seleccione su idioma / Select language: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1 || opcion == 2) {
                    System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
                    String mensaje = "Idioma seleccionado / Selected language: " + (opcion == 1 ? "Español" : "English");
                    System.out.println("│" + centrarTexto(mensaje, ANCHO - 2) + "│");
                    System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
                    return opcion == 1 ? "ES" : "EN";
                }
            } else {
                scanner.nextLine();
            }
            mostrarError("Opción inválida, intente de nuevo.", "ES");
        } while (true);
    }

    // Formato de salida
    public static void mostrarError(String mensaje, String idioma) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(mensaje, ANCHO - 2) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static boolean preguntarContinuar(Scanner scanner, String idioma) {
        String respuesta;
        do {
            System.out.print("\n" + obtenerTexto("CONTINUAR", idioma));
            respuesta = scanner.nextLine().toUpperCase();
            if (validarContinuar(respuesta)) {
                System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
                System.out.println("│" + centrarTexto(obtenerTexto("CONTINUAR", idioma) + respuesta, ANCHO - 2) + "│");
                System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
                return respuesta.equals("S") || respuesta.equals("Y");
            }
            mostrarError("Opción inválida, intente de nuevo.", idioma);
        } while (true);
    }

    // Procesamiento de textos
    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                default: return "";
            }
        }
    }
}