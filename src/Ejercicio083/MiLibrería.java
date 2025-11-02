/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 083 | 2025-10-22               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio088;

import java.util.Scanner;

public class MiLibrería {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    // Funciones matemáticas
    public static double calcularPorcentaje(int correctas, int total) {
        return (correctas * 100.0) / total;
    }

    // Validaciones
    public static boolean validarOpcion(int opcion) {
        return opcion == 1 || opcion == 2;
    }

    // Formato de texto
    public static void mostrarSello() {
        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ Jonatan Varela | jivarelag@unah.hn | 083 | 2025-10-22                │");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }

    // Procesamiento de datos
    public static void procesarRespuestas(Scanner scanner, String idioma) {
        int correctas = 0;
        int incorrectas = 0;

        for (int i = 0; i < 10; i++) {
            int opcion;
            do {
                System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
                System.out.println("│" + centrarTexto(obtenerTexto("PREGUNTA", idioma) + (i + 1), ANCHO - 2) + "│");
                System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");

                String opcion1 = "  1. " + obtenerTexto("CORRECTA", idioma);
                System.out.println("│" + opcion1 + " ".repeat(ANCHO - 2 - opcion1.length()) + "│");

                String opcion2 = "  2. " + obtenerTexto("INCORRECTA", idioma);
                System.out.println("│" + opcion2 + " ".repeat(ANCHO - 2 - opcion2.length()) + "│");

                System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
                System.out.print("Seleccione una opción: ");

                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (validarOpcion(opcion)) {
                        if (opcion == 1) {
                            correctas++;
                            mostrarMensaje(true, i + 1, idioma);
                        } else {
                            incorrectas++;
                            mostrarMensaje(false, i + 1, idioma);
                        }
                        break;
                    }
                } else {
                    scanner.nextLine();
                }
                mostrarError("Opción inválida, intente de nuevo.", idioma);
            } while (true);
        }

        double porcentaje = calcularPorcentaje(correctas, 10);
        mostrarResultados(correctas, incorrectas, porcentaje, idioma);
        if (porcentaje < 75) {
            mostrarMensajeAyuda(idioma);
        }
    }

    // Funciones de procesamiento
    public static void iniciarPrograma(Scanner scanner) {
        mostrarSello();
        idiomaActual = seleccionarIdioma(scanner);

        do {
            procesarRespuestas(scanner, idiomaActual);
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
    public static void mostrarMensaje(boolean esCorrecta, int numero, String idioma) {
        String mensaje = esCorrecta ? obtenerMensajeCorrecto(idioma) : obtenerMensajeIncorrecto(idioma);
        String tipo = esCorrecta ? obtenerTexto("CORRECTA", idioma) : obtenerTexto("INCORRECTA", idioma);

        System.out.println("\n┌" + "─".repeat(ANCHO - 2) + "┐");
        System.out.println("│" + centrarTexto(obtenerTexto("RESPUESTA", idioma) + " " + numero, ANCHO - 2) + "│");
        System.out.println("├" + "─".repeat(ANCHO - 2) + "┤");
        System.out.println("│ " + tipo + " ".repeat(ANCHO - 3 - tipo.length()) + "│");
        System.out.println("│ " + mensaje + " ".repeat(ANCHO - 3 - mensaje.length()) + "│");
        System.out.println("└" + "─".repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarResultados(int correctas, int incorrectas, double porcentaje, String idioma) {
        System.out.println("\n╔" + "═".repeat(ANCHO - 2) + "╗");
        System.out.println("║" + centrarTexto(obtenerTexto("RESULTADOS", idioma), ANCHO - 2) + "║");
        System.out.println("╠" + "═".repeat(ANCHO - 2) + "╣");

        String textoCorrectas = "  " + obtenerTexto("CORRECTAS", idioma) + ": " + correctas;
        System.out.println("║" + textoCorrectas + " ".repeat(ANCHO - 2 - textoCorrectas.length()) + "║");

        String textoIncorrectas = "  " + obtenerTexto("INCORRECTAS", idioma) + ": " + incorrectas;
        System.out.println("║" + textoIncorrectas + " ".repeat(ANCHO - 2 - textoIncorrectas.length()) + "║");

        String textoPorcentaje = "  " + obtenerTexto("PORCENTAJE", idioma) + ": " + String.format("%.1f%%", porcentaje);
        System.out.println("║" + textoPorcentaje + " ".repeat(ANCHO - 2 - textoPorcentaje.length()) + "║");

        System.out.println("╚" + "═".repeat(ANCHO - 2) + "╝");
    }

    public static void mostrarMensajeAyuda(String idioma) {
        System.out.println("\n╔" + "═".repeat(ANCHO - 2) + "╗");
        System.out.println("║" + centrarTexto(obtenerTexto("MENSAJE_AYUDA", idioma), ANCHO - 2) + "║");
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
                return respuesta.equals("S") || respuesta.equals("Y");
            }
            mostrarError("Opción inválida, intente de nuevo.", idioma);
        } while (true);
    }

    // Procesamiento de textos
    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "PREGUNTA": return "Pregunta ";
                case "CORRECTA": return "Correcta";
                case "INCORRECTA": return "Incorrecta";
                case "RESPUESTA": return "Respuesta";
                case "RESULTADOS": return "RESULTADOS FINALES";
                case "CORRECTAS": return "Respuestas Correctas";
                case "INCORRECTAS": return "Respuestas Incorrectas";
                case "PORCENTAJE": return "Porcentaje Correcto";
                case "MENSAJE_AYUDA": return "Por favor pida ayuda adicional a su instructor";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "PREGUNTA": return "Question ";
                case "CORRECTA": return "Correct";
                case "INCORRECTA": return "Incorrect";
                case "RESPUESTA": return "Answer";
                case "RESULTADOS": return "FINAL RESULTS";
                case "CORRECTAS": return "Correct Answers";
                case "INCORRECTAS": return "Incorrect Answers";
                case "PORCENTAJE": return "Correct Percentage";
                case "MENSAJE_AYUDA": return "Please ask your instructor for additional help";
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                default: return "";
            }
        }
    }

    // Funciones de procesamiento de mensajes
    public static String obtenerMensajeCorrecto(String idioma) {
        String[] mensajes = idioma.equals("ES")
                ? new String[]{"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"}
                : new String[]{"Very good!", "Excellent!", "Good job!", "Keep it up!"};
        return mensajes[(int)(Math.random() * mensajes.length)];
    }

    public static String obtenerMensajeIncorrecto(String idioma) {
        String[] mensajes = idioma.equals("ES")
                ? new String[]{"No. Intenta de nuevo.", "Incorrecto. Sigue intentando.", "¡No te rindas!", "Error, sigue adelante."}
                : new String[]{"No. Try again.", "Wrong. Keep trying.", "Don't give up!", "Error, move on."};
        return mensajes[(int)(Math.random() * mensajes.length)];
    }
}