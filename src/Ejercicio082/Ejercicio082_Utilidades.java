package Ejercicio082;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 082 | 2025-11-04
 */

import java.util.Scanner;

public class Ejercicio082_Utilidades {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LINEA = "---------------------------------------------------------------------";
    private static final int ANCHO = 70;

    public static void mostrarSelloCorto() {
        System.out.println(LINEA);
        System.out.println(centrar("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO));
        System.out.println("|" + " ".repeat(ANCHO - 2) + "|");
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 082 | 2025-11-04";
        System.out.println(centrar(sello, ANCHO));
        System.out.println(LINEA);
        System.out.println();
    }

    private static String centrar(String texto, int ancho) {
        int espacios = ancho - texto.length();
        int izq = espacios / 2;
        return "|" + " ".repeat(izq) + texto + " ".repeat(espacios - izq) + "|";
    }

    public static int seleccionarIdioma() {
        mostrarSelloCorto();
        System.out.println("=".repeat(50));
        System.out.println("         SELECCIONE EL IDIOMA / SELECT LANGUAGE");
        System.out.println("=".repeat(50));
        System.out.println("1. Español");
        System.out.println("2. English");
        System.out.println("3. Salir / Exit");
        System.out.print("Opción / Option: ");
        return leerEntero(1, 3);
    }

    public static int mostrarMenuPrincipal(int idioma) {
        String[] txt = textos(idioma);
        System.out.println("\n" + "-".repeat(45));
        System.out.println(txt[0]);
        System.out.println("-".repeat(45));
        System.out.println("1. " + txt[1]);
        System.out.println("2. " + txt[2]);
        System.out.println("3. " + txt[3]);
        System.out.print(txt[4] + " ");
        return leerEntero(1, 3);
    }

    public static int leerLado(int idioma) {
        String[] txt = textos(idioma);
        System.out.print("\n" + txt[5] + " (1-20): ");
        return leerEntero(1, 20);
    }

    public static char leerCaracter(int idioma) {
        String[] txt = textos(idioma);
        System.out.print(txt[6] + " ");
        while (true) {
            String entrada = scanner.nextLine().trim();
            if (entrada.length() == 1) {
                return entrada.charAt(0);
            }
            System.out.print(txt[7] + " ");
        }
    }

    public static boolean preguntarContinuar(int idioma) {
        String[] txt = textos(idioma);
        System.out.print("\n" + txt[8] + " (s/n): ");
        while (true) {
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s") || respuesta.equals("y")) return true;
            if (respuesta.equals("n")) return false;
            System.out.print(txt[9] + " ");
        }
    }

    public static void mostrarDespedida(int idioma) {
        String msg = (idioma == 2) ? "Goodbye! / ¡Adiós!" : "¡Adiós!";
        System.out.println("\n" + msg + "\n");
    }

    private static String[] textos(int idioma) {
        if (idioma == 2) {
            return new String[]{
                    "MAIN MENU",
                    "Draw square",
                    "Back to language menu",
                    "Exit program",
                    "Select an option:",
                    "Enter side length",
                    "Enter fill character (1 char):",
                    "Error: enter exactly one character.",
                    "Do you want to continue?",
                    "Please answer with s (yes) or n (no):"
            };
        }
        return new String[]{
                "MENÚ PRINCIPAL",
                "Dibujar cuadrado",
                "Volver al menú de idioma",
                "Salir del programa",
                "Seleccione una opción:",
                "Ingrese el tamaño del lado",
                "Ingrese el carácter de relleno (1 solo):",
                "Error: debe ingresar exactamente un carácter.",
                "¿Desea continuar?",
                "Por favor responda con s (sí) o n (no):"
        };
    }

    private static int leerEntero(int min, int max) {
        int valor;
        while (true) {
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor >= min && valor <= max) return valor;
                System.out.print("Ingrese un número entre " + min + " y " + max + ": ");
            } catch (Exception e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
            }
        }
    }
}