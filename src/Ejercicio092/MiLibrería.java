/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 092 | 2025-10-23               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio092;

import java.util.Scanner;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // Funciones matemáticas
    public static boolean esPar(float numero) {
        return numero % 2 == 0; // Determina si un número es par
    }

    public static int[] calcularTotales(float[] valores, float[] lista) {
        int[] totales = new int[5]; // [valores, cuadrados, cubos, pares, impares]
        for (int i = 0; i < valores.length; i++) {
            totales[0] += valores[i]; // Suma de valores
            totales[1] += valores[i] * valores[i]; // Suma de cuadrados
            totales[2] += valores[i] * valores[i] * valores[i]; // Suma de cubos
            if (esPar(valores[i])) totales[3]++; // Conteo de pares
            else totales[4]++; // Conteo de impares
        }
        return totales;
    }

    // Validaciones
    public static boolean validarRango(int numero, int min, int max) {
        return numero > min && numero < max;
    }

    public static boolean esRepetido(float[] arreglo, float valor, int pos) {
        for (int i = 0; i < pos; i++) if (arreglo[i] == valor) return true;
        return false;
    }

    // Formato de texto
    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 092 | 2025-10-23                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = Math.max(0, espaciosTotal / 2);
        int espaciosDer = Math.max(0, espaciosTotal - espaciosIzq);
        return " ".repeat(espaciosIzq) + texto + " ".repeat(espaciosDer);
    }

    // Procesamiento de datos
    public static void procesarNumeros(Scanner scanner, String idioma) {
        int cantidad;
        do {
            System.out.print(obtenerTexto("INGRESE_CANTIDAD", idioma));
            if (scanner.hasNextInt()) {
                cantidad = scanner.nextInt();
                scanner.nextLine();
                if (validarRango(cantidad, 10, 100)) break;
            } else {
                scanner.nextLine();
            }
            mostrarError("Número debe estar entre 11 y 99.", idioma);
        } while (true);

        float[] lista = new float[cantidad];
        for (int i = 0; i < cantidad; i++) {
            do {
                System.out.print(obtenerTexto("INGRESE_NUMERO", idioma) + (i + 1) + ": ");
                if (scanner.hasNextFloat()) {
                    float num = scanner.nextFloat();
                    scanner.nextLine();
                    if (validarRango((int)num, 0, cantidad)) {
                        lista[i] = num;
                        break;
                    }
                } else {
                    scanner.nextLine();
                }
                mostrarError("Número debe estar entre 0 y " + cantidad + ".", idioma);
            } while (true);
        }

        float[] valores = new float[5];
        for (int i = 0; i < 5; i++) {
            do {
                System.out.print(obtenerTexto("INGRESE_VALOR", idioma) + (i + 1) + ": ");
                if (scanner.hasNextFloat()) {
                    float num = scanner.nextFloat();
                    scanner.nextLine();
                    if (validarRango((int)num, 0, cantidad) && !esRepetido(valores, num, i)) {
                        valores[i] = num;
                        break;
                    }
                } else {
                    scanner.nextLine();
                }
                mostrarError("Valor inválido o repetido, entre 0 y " + cantidad + ".", idioma);
            } while (true);
        }

        mostrarLista(lista, cantidad, idioma);
        mostrarTabla(valores, lista, idioma);
        int[] totales = calcularTotales(valores, lista);
        mostrarTotales(totales, idioma);
    }

    // Funciones de procesamiento
    public static void iniciarPrograma(Scanner scanner) {
        mostrarSello();
        idiomaActual = seleccionarIdioma(scanner);

        do {
            procesarNumeros(scanner, idiomaActual);
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
    public static void mostrarLista(float[] lista, int cantidad, String idioma) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(obtenerTexto("LISTA_TITULO", idioma), ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cantidad; i++) {
            if (i == cantidad - 1) sb.append(" y ").append(lista[i]).append(".");
            else if (i > 0) sb.append(", ").append(lista[i]);
            else sb.append(lista[i]);
        }
        System.out.println("│ " + sb.toString() + " ".repeat(Math.max(0, ANCHO - 3 - sb.length())) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarTabla(float[] valores, float[] lista, String idioma) {
        System.out.println("\n╔" + "═".repeat(ANCHO - 2) + "╗");
        System.out.println("║" + centrarTexto(obtenerTexto("TABLA_TITULO", idioma), ANCHO - 2) + "║");
        System.out.println("╠" + "═".repeat(ANCHO - 2) + "╣");
        for (int i = 0; i < 5; i++) {
            String fila = String.format("║  %-10.1f  %-10.1f  ║", valores[i], lista[(int)valores[i]]);
            System.out.println(fila + " ".repeat(Math.max(0, ANCHO - 2 - fila.length())) + "║");
        }
        System.out.println("╚" + "═".repeat(ANCHO - 2) + "╝");
    }

    public static void mostrarTotales(int[] totales, String idioma) {
        System.out.println("\n╔" + "═".repeat(ANCHO - 2) + "╗");
        System.out.println("║" + centrarTexto(obtenerTexto("TOTALES_TITULO", idioma), ANCHO - 2) + "║");
        System.out.println("╠" + "═".repeat(ANCHO - 2) + "╣");
        System.out.println("║  " + obtenerTexto("VALORES", idioma) + ": " + totales[0] + " ".repeat(Math.max(0, ANCHO - 25 - String.valueOf(totales[0]).length())) + "║");
        System.out.println("║  " + obtenerTexto("CUADRADOS", idioma) + ": " + totales[1] + " ".repeat(Math.max(0, ANCHO - 25 - String.valueOf(totales[1]).length())) + "║");
        System.out.println("║  " + obtenerTexto("CUBOS", idioma) + ": " + totales[2] + " ".repeat(Math.max(0, ANCHO - 25 - String.valueOf(totales[2]).length())) + "║");
        System.out.println("║  " + obtenerTexto("PARES", idioma) + ": " + totales[3] + " ".repeat(Math.max(0, ANCHO - 25 - String.valueOf(totales[3]).length())) + "║");
        System.out.println("║  " + obtenerTexto("IMPARES", idioma) + ": " + totales[4] + " ".repeat(Math.max(0, ANCHO - 25 - String.valueOf(totales[4]).length())) + "║");
        System.out.println("╚" + "═".repeat(ANCHO - 2) + "╝");
    }

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
            if (respuesta.equals("S") || respuesta.equals("Y") || respuesta.equals("N")) {
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
                case "INGRESE_CANTIDAD": return "Ingrese un número entero entre 11 y 99: ";
                case "INGRESE_NUMERO": return "Ingrese el número ";
                case "INGRESE_VALOR": return "Ingrese el valor ";
                case "LISTA_TITULO": return "LISTA DE NÚMEROS";
                case "TABLA_TITULO": return "TABLA DE VALORES";
                case "TOTALES_TITULO": return "TOTALES CALCULADOS";
                case "VALORES": return "Total de valores";
                case "CUADRADOS": return "Total de cuadrados";
                case "CUBOS": return "Total de cubos";
                case "PARES": return "Total de pares";
                case "IMPARES": return "Total de impares";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "INGRESE_CANTIDAD": return "Enter an integer between 11 and 99: ";
                case "INGRESE_NUMERO": return "Enter the number ";
                case "INGRESE_VALOR": return "Enter the value ";
                case "LISTA_TITULO": return "NUMBER LIST";
                case "TABLA_TITULO": return "VALUE TABLE";
                case "TOTALES_TITULO": return "CALCULATED TOTALS";
                case "VALORES": return "Total of values";
                case "CUADRADOS": return "Total of squares";
                case "CUBOS": return "Total of cubes";
                case "PARES": return "Total of even";
                case "IMPARES": return "Total of odd";
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                default: return "";
            }
        }
    }
}