package Ejercicio039;

/*
 * Cristina Cruz | Lis❤  | cristinacruz@unah.hn | 039 | 2025-10-10
 */

import java.util.Scanner;

public class Ejercicio039_Utilidades {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LINEA = "---------------------------------------------------------------------";
    private static final int ANCHO = 70;

    /** Muestra sello personalizado centrado */
    public static void mostrarSelloCorto(String codigo, String fecha) {
        System.out.println(LINEA);
        System.out.println(centrar("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO));
        System.out.println("|" + " ".repeat(ANCHO - 2) + "|");
        String sello = "Cristina Cruz | Lis❤  | cristinacruz@unah.hn | " + codigo + " | " + fecha;
        System.out.println(centrar(sello, ANCHO));
        System.out.println(LINEA);
        System.out.println();
    }

    private static String centrar(String texto, int ancho) {
        int espacios = ancho - texto.length();
        int izq = espacios / 2;
        return "|" + " ".repeat(izq) + texto + " ".repeat(espacios - izq) + "|";
    }

    /** Menú de idioma */
    public static int seleccionarIdioma() {
        mostrarSelloCorto("039", "2025-10-10");
        System.out.println("=".repeat(50));
        System.out.println("         SELECCIONE EL IDIOMA / SELECT LANGUAGE");
        System.out.println("=".repeat(50));
        System.out.println("1. Español");
        System.out.println("2. English");
        System.out.println("3. Salir / Exit");
        System.out.print("Opción / Option: ");
        return leerEntero(1, 3);
    }

    /** Menú de ejecución */
    public static int mostrarMenuEjecucion(int idioma) {
        String[] txt = textos(idioma);
        System.out.println("\n" + "-".repeat(40));
        System.out.println(txt[0]);
        System.out.println("-".repeat(40));
        System.out.println("1. " + txt[1]);
        System.out.println("2. " + txt[2]);
        System.out.println("3. " + txt[3]);
        System.out.print(txt[4] + " ");
        return leerEntero(1, 3);
    }

    /** Solicita número impar entre min y max */
    public static int leerNumeroImpar(int idioma, int min, int max) {
        String[] txt = textos(idioma);
        int valor;
        System.out.print("\n" + txt[5] + " (" + min + "-" + max + "): ");
        while (true) {
            valor = leerEntero(min, max);
            if (valor % 2 == 1) {
                return valor;
            }
            System.out.print(txt[6] + " ");
        }
    }

    public static void mostrarDespedida(int idioma) {
        String msg = (idioma == 2) ? "Goodbye! / ¡Adiós!" : "¡Adiós!";
        System.out.println("\n" + msg + "\n");
    }

    public static void imprimirEspacios(int cantidad) {
        for (int i = 0; i < cantidad; i++) System.out.print(" ");
    }

    /* ------------------- Textos bilingües ------------------- */
    private static String[] textos(int idioma) {
        if (idioma == 2) { // English
            return new String[]{
                    "EXECUTION MENU",
                    "Run diamond",
                    "Back to language menu",
                    "Exit program",
                    "Select an option:",
                    "Enter an odd number",
                    "Error: must be odd. Try again:"
            };
        }
        // Español
        return new String[]{
                "MENÚ DE EJECUCIÓN",
                "Ejecutar el rombo",
                "Volver al menú de idioma",
                "Salir del programa",
                "Seleccione una opción:",
                "Ingrese un número impar",
                "Error: debe ser impar. Intente de nuevo:"
        };
    }

    private static int leerEntero(int min, int max) {
        int valor;
        while (true) {
            try {
                valor = scanner.nextInt();
                if (valor >= min && valor <= max) {
                    scanner.nextLine();
                    return valor;
                }
                System.out.print("Ingrese un número entre " + min + " y " + max + ": ");
            } catch (Exception e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
                scanner.nextLine();
            }
        }
    }
}