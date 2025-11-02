/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 070 | 2025-10-17               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio070;

import java.util.Scanner;

public class Operaciones {
    private static final String[] MENSAJES_CORRECTOS_ES = {"Muy bien!", "Excelente!", "Buen trabajo!", "Sigue asi!"};
    private static final String[] MENSAJES_INCORRECTOS_ES = {"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.", "No te rindas!", "No. Sigue intentando."};
    private static final String[] MENSAJES_CORRECTOS_EN = {"Very good!", "Excellent!", "Good job!", "Keep it up!"};
    private static final String[] MENSAJES_INCORRECTOS_EN = {"No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying."};

    public static boolean leerRespuesta(Scanner scanner, String idioma, int numero) {
        int opcion;
        do {
            System.out.println("\n┌" + "─".repeat(70 - 2) + "┐");
            System.out.println("│" + centrarTexto(Utilidades.obtenerTexto("INGRESE_RESPUESTA", idioma) + numero, 68) + "│");
            System.out.println("├" + "─".repeat(70 - 2) + "┤");
            System.out.println("│  1. " + (idioma.equals("ES") ? "Correcta" : "Correct") + "          │");
            System.out.println("│  2. " + (idioma.equals("ES") ? "Incorrecta" : "Incorrect") + "       │");
            System.out.println("└" + "─".repeat(70 - 2) + "┘");
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1 || opcion == 2) {
                    return opcion == 1;
                }
            } else {
                scanner.nextLine();
            }
            Utilidades.mostrarErrorEntrada(idioma);
        } while (true);
    }

    public static String obtenerMensaje(boolean esCorrecta, String idioma) {
        String[] correctos = idioma.equals("ES") ? MENSAJES_CORRECTOS_ES : MENSAJES_CORRECTOS_EN;
        String[] incorrectos = idioma.equals("ES") ? MENSAJES_INCORRECTOS_ES : MENSAJES_INCORRECTOS_EN;
        return esCorrecta ? correctos[(int)(Math.random() * correctos.length)] : incorrectos[(int)(Math.random() * incorrectos.length)];
    }

    private static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }
}