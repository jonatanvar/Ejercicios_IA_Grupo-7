/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 079 | 2025-10-22               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Librerias;

import java.util.Scanner;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // Funciones matemáticas
    public static int codificar(int numero) {
        if (!validarNumeroCuatroDigitos(numero)) return -1;
        String numStr = String.valueOf(numero);
        int[] digitos = new int[4];
        for (int i = 0; i < 4; i++) {
            digitos[i] = (Character.getNumericValue(numStr.charAt(i)) + 7) % 10;
        }
        int temp = digitos[0];
        digitos[0] = digitos[2];
        digitos[2] = temp;
        temp = digitos[1];
        digitos[1] = digitos[3];
        digitos[3] = temp;
        return digitos[0] * 1000 + digitos[1] * 100 + digitos[2] * 10 + digitos[3];
    }

    public static int decodificar(int numero) {
        if (!validarNumeroCuatroDigitos(numero)) return -1;
        String numStr = String.valueOf(numero);
        int[] digitos = new int[4];
        for (int i = 0; i < 4; i++) {
            digitos[i] = Character.getNumericValue(numStr.charAt(i));
        }
        int temp = digitos[0];
        digitos[0] = digitos[2];
        digitos[2] = temp;
        temp = digitos[1];
        digitos[1] = digitos[3];
        digitos[3] = temp;
        for (int i = 0; i < 4; i++) {
            digitos[i] = (digitos[i] - 7 + 10) % 10;
        }
        return digitos[0] * 1000 + digitos[1] * 100 + digitos[2] * 10 + digitos[3];
    }

    // Validaciones
    public static boolean validarNumeroCuatroDigitos(int numero) {
        return numero >= 1000 && numero <= 9999;
    }

    // Formato de texto
    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("│" + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 079 | 2025-10-22", ANCHO - 2) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }

    // Procesamiento de datos
    public static void procesarOpcion(int opcion, Scanner scanner, String idioma) {
        int numero;
        do {
            System.out.print(obtenerTexto("INGRESE_NUMERO", idioma));
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                scanner.nextLine();
                if (validarNumeroCuatroDigitos(numero)) {
                    int resultado = (opcion == 1) ? codificar(numero) : decodificar(numero);
                    if (resultado != -1) {
                        mostrarResultado(numero, resultado, opcion, idioma);
                    } else {
                        mostrarError("Error en el procesamiento.", idioma);
                    }
                    return;
                }
            } else {
                scanner.nextLine();
            }
            mostrarError("Ingrese un número válido de 4 dígitos.", idioma);
        } while (true);
    }

    // Funciones de procesamiento
    public static void iniciarPrograma(Scanner scanner) {
        mostrarSello();
        idiomaActual = seleccionarIdioma(scanner);

        do {
            mostrarMenu();
            int opcion;
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1 || opcion == 2) {
                    procesarOpcion(opcion, scanner, idiomaActual);
                } else {
                    mostrarError("Opción inválida, intente de nuevo.", idiomaActual);
                }
            } else {
                scanner.nextLine();
                mostrarError("Opción inválida, intente de nuevo.", idiomaActual);
            }
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
            System.out.println("│  1. Español            │");
            System.out.println("│  2. English            │");
            System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
            System.out.print("Seleccione su idioma / Select language: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1 || opcion == 2) {
                    System.out.println("│" + centrarTexto("Idioma seleccionado / Selected language: " + (opcion == 1 ? "Español" : "English"), ANCHO - 2) + "│");
                    return opcion == 1 ? "ES" : "EN";
                }
            } else {
                scanner.nextLine();
            }
            mostrarError("Opción inválida, intente de nuevo.", "ES");
        } while (true);
    }

    // Formato de salida
    public static void mostrarMenu() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(obtenerTexto("MENU_TITULO", idiomaActual), ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│  1. " + obtenerTexto("OPCION_1", idiomaActual) + " ".repeat(ANCHO - 20) + "│");
        System.out.println("│  2. " + obtenerTexto("OPCION_2", idiomaActual) + " ".repeat(ANCHO - 20) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
        System.out.print("Seleccione una opción: ");
    }

    public static void mostrarResultado(int original, int resultado, int opcion, String idioma) {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(obtenerTexto((opcion == 1) ? "RESULTADO_CODIFICAR" : "RESULTADO_DECODIFICAR", idioma), ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.printf("│ %-20s %-20d │%n", obtenerTexto("ORIGINAL", idioma), original);
        System.out.printf("│ %-20s %-20d │%n", (opcion == 1) ? obtenerTexto("CODIFICADO", idioma) : obtenerTexto("DECODIFICADO", idioma), resultado);
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
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
                System.out.println("│" + centrarTexto(obtenerTexto("CONTINUAR", idioma) + respuesta, ANCHO - 2) + "│");
                return respuesta.equals("S") || respuesta.equals("Y");
            }
            mostrarError("Opción inválida, intente de nuevo.", idioma);
        } while (true);
    }

    // Procesamiento de textos
    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "MENU_TITULO": return "MENÚ DE CRIPTO-FUNCIONES";
                case "OPCION_1": return "Codificar número";
                case "OPCION_2": return "Decodificar número";
                case "INGRESE_NUMERO": return "Ingrese un número de 4 dígitos: ";
                case "RESULTADO_CODIFICAR": return "RESULTADO DE CODIFICACIÓN";
                case "RESULTADO_DECODIFICAR": return "RESULTADO DE DECODIFICACIÓN";
                case "ORIGINAL": return "Número original";
                case "CODIFICADO": return "Número codificado";
                case "DECODIFICADO": return "Número decodificado";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "MENU_TITULO": return "CRYPTO-FUNCTIONS MENU";
                case "OPCION_1": return "Encode number";
                case "OPCION_2": return "Decode number";
                case "INGRESE_NUMERO": return "Enter a 4-digit number: ";
                case "RESULTADO_CODIFICAR": return "ENCODING RESULT";
                case "RESULTADO_DECODIFICAR": return "DECODING RESULT";
                case "ORIGINAL": return "Original number";
                case "CODIFICADO": return "Encoded number";
                case "DECODIFICADO": return "Decoded number";
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                default: return "";
            }
        }
    }
}