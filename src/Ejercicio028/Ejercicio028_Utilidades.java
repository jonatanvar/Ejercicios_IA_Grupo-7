package Ejercicio028;

/*
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 028 | 2025-10-10
 */

import java.util.Scanner;

public class Ejercicio028_Utilidades {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LINEA = "---------------------------------------------------------------------";
    private static final int ANCHO = 70;

    /** Muestra sello personalizado */
    public static void mostrarSelloCorto(String codigo, String fecha) {
        System.out.println(LINEA);
        System.out.println(centrar("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO));
        System.out.println("|" + " ".repeat(ANCHO - 2) + "|");
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | " + codigo + " | " + fecha;
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
        mostrarSelloCorto("028", "2025-10-10");
        System.out.println("=".repeat(50));
        System.out.println("         SELECCIONE EL IDIOMA / SELECT LANGUAGE");
        System.out.println("=".repeat(50));
        System.out.println("1. Español");
        System.out.println("2. English");
        System.out.println("3. Salir / Exit");
        System.out.print("Opción / Option: ");
        return leerEntero(1, 3);
    }

    /** Menú principal */
    public static int mostrarMenuPrincipal(int idioma) {
        String[] txt = textos(idioma);
        System.out.println("\n" + "-".repeat(45));
        System.out.println(txt[0]);
        System.out.println("-".repeat(45));
        System.out.println("1. " + txt[1]);
        System.out.println("2. " + txt[2]);
        System.out.println("3. " + txt[3]);
        System.out.println("4. " + txt[4]);
        System.out.print(txt[5] + " ");
        return leerEntero(1, 4);
    }

    /** Solicita número de 4 dígitos */
    public static int leerNumero4Digitos(int idioma, String accion) {
        String[] txt = textos(idioma);
        System.out.print("\n" + txt[6].replace("{accion}", accion) + " (0000-9999): ");
        while (true) {
            String entrada = scanner.nextLine().trim();
            if (entrada.matches("\\d{4}") && Integer.parseInt(entrada) <= 9999) {
                return Integer.parseInt(entrada);
            }
            System.out.print(txt[7] + " ");
        }
    }

    /** Muestra resultado */
    public static void mostrarResultado(int idioma, String tipo, int original, String resultado) {
        String[] txt = textos(idioma);
        System.out.println("\n" + txt[8].replace("{tipo}", tipo));
        System.out.printf(txt[9], original, resultado);
        System.out.println("\n" + "-".repeat(45) + "\n");
    }

    public static void mostrarDespedida(int idioma) {
        String msg = (idioma == 2) ? "Goodbye! / ¡Adiós!" : "¡Adiós!";
        System.out.println("\n" + msg + "\n");
    }

    /* ------------------- Textos bilingües ------------------- */
    private static String[] textos(int idioma) {
        if (idioma == 2) { // English
            return new String[]{
                    "MAIN MENU",
                    "Encrypt a number",
                    "Decrypt a number",
                    "Back to language menu",
                    "Exit program",
                    "Select an option:",
                    "Enter a 4-digit number to {accion} (0000-9999):",
                    "Error: must be exactly 4 digits. Try again:",
                    "RESULT OF {tipo.toUpperCase()}",
                    "Original: %04d → Encrypted/Decrypted: %s\n"
            };
        }
        // Español
        return new String[]{
                "MENÚ PRINCIPAL",
                "Cifrar un número",
                "Descifrar un número",
                "Volver al menú de idioma",
                "Salir del programa",
                "Seleccione una opción:",
                "Ingrese un número de 4 dígitos para {accion} (0000-9999):",
                "Error: debe tener exactamente 4 dígitos. Intente de nuevo:",
                "RESULTADO DEL {tipo.toUpperCase()}",
                "Original: %04d → Cifrado/Descifrado: %s\n"
        };
    }

    private static int leerEntero(int min, int max) {
        int valor;
        while (true) {
            try {
                valor = scanner.nextInt();
                scanner.nextLine();
                if (valor >= min && valor <= max) return valor;
                System.out.print("Ingrese un número entre " + min + " y " + max + ": ");
            } catch (Exception e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
                scanner.nextLine();
            }
        }
    }
}
