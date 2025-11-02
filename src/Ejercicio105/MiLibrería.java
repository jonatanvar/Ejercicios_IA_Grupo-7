/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 105 | 2025-10-26               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio105;

import java.util.Random;
import java.util.Scanner;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // Funciones matemáticas
    public static void inicializarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = 0;
            }
        }
    }

    public static void rellenarMatrizCuadrada(int[][] matriz) {
        Random rand = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rand.nextInt(100); // Números aleatorios menores a 100
            }
        }
    }

    public static void rellenarMatrizNoCuadrada(int[][] matriz) {
        Random rand = new Random();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rand.nextInt(99) + 1; // Números aleatorios entre 1 y 99
            }
        }
    }

    public static int contarPares(int[][] matriz) {
        int pares = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] % 2 == 0) pares++;
            }
        }
        return pares;
    }

    public static int contarImpares(int[][] matriz) {
        int impares = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] % 2 != 0) impares++;
            }
        }
        return impares;
    }

    public static int[] calcularTotalesFilas(int[][] matriz) {
        int[] totalesFilas = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                totalesFilas[i] += matriz[i][j];
            }
        }
        return totalesFilas;
    }

    public static int[] calcularTotalesColumnas(int[][] matriz) {
        int[] totalesColumnas = new int[matriz[0].length];
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                totalesColumnas[j] += matriz[i][j];
            }
        }
        return totalesColumnas;
    }

    // Validaciones
    public static boolean validarDimensiones(int dim) {
        return dim > 2 && dim <= 10;
    }

    // Formato de texto
    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 105 | 2025-10-26                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = Math.max(0, espaciosTotal / 2);
        int espaciosDer = Math.max(0, espaciosTotal - espaciosIzq);
        return " ".repeat(espaciosIzq) + texto + " ".repeat(espaciosDer);
    }

    // Procesamiento de datos
    public static void procesarMatriz(Scanner scanner, String idioma) {
        int filas, columnas;
        do {
            System.out.print(obtenerTexto("INGRESE_FILAS", idioma));
            if (scanner.hasNextInt()) filas = scanner.nextInt();
            else { scanner.nextLine(); continue; }
            System.out.print(obtenerTexto("INGRESE_COLUMNAS", idioma));
            if (scanner.hasNextInt()) columnas = scanner.nextInt();
            else { scanner.nextLine(); continue; }
            scanner.nextLine();
            if (validarDimensiones(filas) && validarDimensiones(columnas)) break;
            mostrarError(obtenerTexto("ERROR_DIMENSIONES", idioma), idioma);
        } while (true);

        int[][] matriz = new int[filas][columnas];
        inicializarMatriz(matriz);

        if (filas == columnas) {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("MATRIZ INICIALIZADA EN CERO", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            for (int i = 0; i < filas; i++) {
                System.out.print("│ ");
                for (int j = 0; j < columnas; j++) {
                    System.out.print("0 ");
                }
                System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (columnas * 2))) + "│");
            }
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

            rellenarMatrizCuadrada(matriz);
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("MATRIZ RELLENA CON ALEATORIOS (<100)", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            for (int i = 0; i < filas; i++) {
                System.out.print("│ ");
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (columnas * 2))) + "│");
            }
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

            imprimirMatrizCompleta(matriz, "MATRIZ COMPLETA");
            imprimirDiagonalPrincipal(matriz, "DIAGONAL PRINCIPAL");
            imprimirDiagonales(matriz, "DIAGONAL PRINCIPAL Y SECUNDARIA");
            imprimirNoDiagonales(matriz, "NO DIAGONALES");
            imprimirArribaDiagonal(matriz, "ARRIBA DE DIAGONAL PRINCIPAL");
            imprimirDebajoDiagonal(matriz, "DEBAJO DE DIAGONAL PRINCIPAL");
        } else {
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("MATRIZ INICIALIZADA EN CERO", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            for (int i = 0; i < filas; i++) {
                System.out.print("│ ");
                for (int j = 0; j < columnas; j++) {
                    System.out.print("0 ");
                }
                System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (columnas * 2))) + "│");
            }
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

            rellenarMatrizNoCuadrada(matriz);
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("MATRIZ RELLENA CON ALEATORIOS (1-99)", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            for (int i = 0; i < filas; i++) {
                System.out.print("│ ");
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (columnas * 2))) + "│");
            }
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

            imprimirMatrizCompleta(matriz, "MATRIZ COMPLETA");
            int[] totalesFilas = calcularTotalesFilas(matriz);
            int[] totalesColumnas = calcularTotalesColumnas(matriz);
            imprimirMatrizConTotales(matriz, totalesFilas, totalesColumnas);

            int pares = contarPares(matriz);
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("CÁLCULO DE NÚMEROS PARES", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (matriz[i][j] % 2 == 0) System.out.println("│ " + matriz[i][j] + " es par en [" + i + "][" + j + "]");
                }
            }
            System.out.println("│ Total pares = " + pares + " ".repeat(ANCHO - 18 - String.valueOf(pares).length()) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");

            int impares = contarImpares(matriz);
            System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("CÁLCULO DE NÚMEROS IMPARES", ANCHO - 2) + "│");
            System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (matriz[i][j] % 2 != 0) System.out.println("│ " + matriz[i][j] + " es impar en [" + i + "][" + j + "]");
                }
            }
            System.out.println("│ Total impares = " + impares + " ".repeat(ANCHO - 19 - String.valueOf(impares).length()) + "│");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
        }
    }

    // Funciones de impresión
    public static void imprimirMatrizCompleta(int[][] matriz, String titulo) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(titulo, ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("│ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (matriz[0].length * 2))) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void imprimirDiagonalPrincipal(int[][] matriz, String titulo) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(titulo, ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("│ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print((i == j ? matriz[i][j] : 0) + " ");
            }
            System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (matriz[0].length * 2))) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void imprimirDiagonales(int[][] matriz, String titulo) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(titulo, ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("│ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print((i == j || i + j == matriz.length - 1 ? matriz[i][j] : 0) + " ");
            }
            System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (matriz[0].length * 2))) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void imprimirNoDiagonales(int[][] matriz, String titulo) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(titulo, ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("│ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print((i == j || i + j == matriz.length - 1 ? 0 : matriz[i][j]) + " ");
            }
            System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (matriz[0].length * 2))) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void imprimirArribaDiagonal(int[][] matriz, String titulo) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(titulo, ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("│ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print((j > i ? matriz[i][j] : 0) + " ");
            }
            System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (matriz[0].length * 2))) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void imprimirDebajoDiagonal(int[][] matriz, String titulo) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(titulo, ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("│ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print((j < i ? matriz[i][j] : 0) + " ");
            }
            System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - (matriz[0].length * 2))) + "│");
        }
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void imprimirMatrizConTotales(int[][] matriz, int[] totalesFilas, int[] totalesColumnas) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("MATRIZ CON TOTALES POR FILA Y COLUMNA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("│ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print(totalesFilas[i] + " ");
            System.out.println(" ".repeat(Math.max(0, ANCHO - 3 - ((matriz[0].length + 1) * 2))) + "│");
        }
        System.out.print("│ ");
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.print(totalesColumnas[j] + " ");
        }
        System.out.print(" ".repeat(Math.max(0, ANCHO - 3 - (matriz[0].length * 2))) + "│");
        System.out.println("\n└" + "─".repeat(ANCHO - 2) + "┘");
    }

    // Funciones de procesamiento
    public static void iniciarPrograma(Scanner scanner) {
        mostrarSello();
        idiomaActual = seleccionarIdioma(scanner);

        do {
            procesarMatriz(scanner, idiomaActual);
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
                case "INGRESE_FILAS": return "Ingrese la cantidad de filas (3-10): ";
                case "INGRESE_COLUMNAS": return "Ingrese la cantidad de columnas (3-10): ";
                case "ERROR_DIMENSIONES": return "Dimensiones deben ser mayores que 2 y menores o iguales a 10.";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "INGRESE_FILAS": return "Enter the number of rows (3-10): ";
                case "INGRESE_COLUMNAS": return "Enter the number of columns (3-10): ";
                case "ERROR_DIMENSIONES": return "Dimensions must be greater than 2 and less than or equal to 10.";
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                default: return "";
            }
        }
    }
}