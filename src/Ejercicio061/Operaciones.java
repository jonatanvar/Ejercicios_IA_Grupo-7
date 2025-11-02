/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 061 | 2025-10-15 19:05 CST    │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio061;

import java.util.Scanner;

public class Operaciones {
    public static int leerYValidarFigura(Scanner scanner, String idioma) {
        int figura = 0;
        boolean valido = false;
        do {
            System.out.println("\n┌" + "─".repeat(Utilidades.ANCHO - 2) + "┐");
            System.out.println("│" + centrarTexto("FIGURAS ASCII", Utilidades.ANCHO - 2) + "│");
            System.out.println("└" + "─".repeat(Utilidades.ANCHO - 2) + "┘");
            System.out.println(Utilidades.obtenerTexto("SELECCIONE_FIGURA", idioma));
            System.out.println("1. Triángulo alineado a la izquierda");
            System.out.println("2. Triángulo alineado a la derecha");
            System.out.println("3. Triángulo estilo pirámide");
            System.out.println("4. Rombo");
            System.out.println("5. Cuadrado vacío");
            System.out.println("6. Cuadrado lleno");
            System.out.println("7. Triángulo invertido alineado a la izquierda");
            System.out.println("8. Triángulo invertido alineado a la derecha");
            System.out.println("9. Triángulo estilo pirámide invertida");
            System.out.print(Utilidades.obtenerTexto("INGRESE_OPCION", idioma));
            if (scanner.hasNextInt()) {
                figura = scanner.nextInt();
                scanner.nextLine();
                if (figura >= 1 && figura <= 9) {
                    valido = true;
                } else {
                    Utilidades.mostrarErrorEntrada(idioma);
                }
            } else {
                scanner.nextLine();
                Utilidades.mostrarErrorEntrada(idioma);
            }
        } while (!valido);
        return figura;
    }

    public static int leerYValidarTamaño(Scanner scanner, String idioma) {
        int tamaño = 0;
        boolean valido = false;
        do {
            System.out.print(Utilidades.obtenerTexto("INGRESE_TAMAÑO", idioma));
            if (scanner.hasNextInt()) {
                tamaño = scanner.nextInt();
                scanner.nextLine();
                if (tamaño >= 1 && tamaño <= 20) {
                    valido = true;
                } else {
                    Utilidades.mostrarErrorLimites(idioma);
                }
            } else {
                scanner.nextLine();
                Utilidades.mostrarErrorEntrada(idioma);
            }
        } while (!valido);
        return tamaño;
    }

    public static String leerYValidarAlineacion(Scanner scanner, String idioma, int figura) {
        if (figura == 4 || figura == 5 || figura == 6) {
            return "centro"; // No requiere alineación
        }
        String alineacion;
        boolean valido = false;
        do {
            System.out.print(Utilidades.obtenerTexto("INGRESE_ALINEACION", idioma));
            alineacion = scanner.nextLine().toLowerCase();
            if (alineacion.equals("izquierda") || alineacion.equals("derecha")) {
                valido = true;
            } else {
                Utilidades.mostrarErrorEntrada(idioma);
            }
        } while (!valido);
        return alineacion;
    }

    private static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }
}