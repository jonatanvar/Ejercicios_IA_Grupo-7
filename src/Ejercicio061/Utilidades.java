/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 061 | 2025-10-15 19:05 CST    │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio061;

public class Utilidades {
    public static final int ANCHO = 70; // Movido a público para acceso en otras clases
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 061 | 2025-10-15 19:05 CST", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarFigura(int figura, int tamaño, String alineacion, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("FIGURA", idioma) + obtenerTexto("FIGURA_NOMBRE" + figura, idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");

        switch (figura) {
            case 1:
                generarTrianguloIzquierda(tamaño);
                break;
            case 2:
                generarTrianguloDerecha(tamaño);
                break;
            case 3:
                generarPiramide(tamaño);
                break;
            case 4:
                generarRombo(tamaño);
                break;
            case 5:
                generarCuadradoVacio(tamaño);
                break;
            case 6:
                generarCuadradoLleno(tamaño);
                break;
            case 7:
                generarTrianguloInvertidoIzquierda(tamaño);
                break;
            case 8:
                generarTrianguloInvertidoDerecha(tamaño);
                break;
            case 9:
                generarPiramideInvertida(tamaño);
                break;
        }

        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    private static void generarTrianguloIzquierda(int tamaño) {
        for (int i = 1; i <= tamaño; i++) {
            System.out.println(BORDE_IZQ + "* ".repeat(i) + " ".repeat(ANCHO - 2 - 2*i) + BORDE_DER);
        }
    }

    private static void generarTrianguloDerecha(int tamaño) {
        for (int i = 1; i <= tamaño; i++) {
            System.out.println(BORDE_IZQ + " ".repeat(ANCHO - 2 - 2*i) + "* ".repeat(i) + BORDE_DER);
        }
    }

    private static void generarPiramide(int tamaño) {
        for (int i = 1; i <= tamaño; i++) {
            System.out.println(BORDE_IZQ + " ".repeat((ANCHO - 2 - 2*i)/2) + "* ".repeat(i) + " ".repeat((ANCHO - 2 - 2*i)/2) + BORDE_DER);
        }
    }

    private static void generarRombo(int tamaño) {
        for (int i = 1; i <= tamaño; i++) {
            System.out.println(BORDE_IZQ + " ".repeat((ANCHO - 2 - 2*i)/2) + "* ".repeat(i) + " ".repeat((ANCHO - 2 - 2*i)/2) + BORDE_DER);
        }
        for (int i = tamaño - 1; i >= 1; i--) {
            System.out.println(BORDE_IZQ + " ".repeat((ANCHO - 2 - 2*i)/2) + "* ".repeat(i) + " ".repeat((ANCHO - 2 - 2*i)/2) + BORDE_DER);
        }
    }

    private static void generarCuadradoVacio(int tamaño) {
        System.out.println(BORDE_IZQ + "* ".repeat(tamaño) + " ".repeat(ANCHO - 2 - 2*tamaño) + BORDE_DER);
        for (int i = 2; i < tamaño; i++) {
            System.out.println(BORDE_IZQ + "* " + " ".repeat(2*(tamaño - 2)) + "* " + " ".repeat(ANCHO - 2 - 2*tamaño) + BORDE_DER);
        }
        System.out.println(BORDE_IZQ + "* ".repeat(tamaño) + " ".repeat(ANCHO - 2 - 2*tamaño) + BORDE_DER);
    }

    private static void generarCuadradoLleno(int tamaño) {
        for (int i = 0; i < tamaño; i++) {
            System.out.println(BORDE_IZQ + "* ".repeat(tamaño) + " ".repeat(ANCHO - 2 - 2*tamaño) + BORDE_DER);
        }
    }

    private static void generarTrianguloInvertidoIzquierda(int tamaño) {
        for (int i = tamaño; i >= 1; i--) {
            System.out.println(BORDE_IZQ + "* ".repeat(i) + " ".repeat(ANCHO - 2 - 2*i) + BORDE_DER);
        }
    }

    private static void generarTrianguloInvertidoDerecha(int tamaño) {
        for (int i = tamaño; i >= 1; i--) {
            System.out.println(BORDE_IZQ + " ".repeat(ANCHO - 2 - 2*i) + "* ".repeat(i) + BORDE_DER);
        }
    }

    private static void generarPiramideInvertida(int tamaño) {
        for (int i = tamaño; i >= 1; i--) {
            System.out.println(BORDE_IZQ + " ".repeat((ANCHO - 2 - 2*i)/2) + "* ".repeat(i) + " ".repeat((ANCHO - 2 - 2*i)/2) + BORDE_DER);
        }
    }

    public static void mostrarErrorEntrada(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_ENTRADA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarErrorLimites(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_LIMITES", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "SELECCIONE_FIGURA": return "Seleccione una figura:";
                case "INGRESE_OPCION": return "Ingrese su opción: ";
                case "INGRESE_TAMAÑO": return "Ingrese el tamaño (1-20): ";
                case "INGRESE_ALINEACION": return "Ingrese la alineación (izquierda/derecha): ";
                case "FIGURA": return "Figura: ";
                case "FIGURA_NOMBRE1": return "Triángulo alineado a la izquierda";
                case "FIGURA_NOMBRE2": return "Triángulo alineado a la derecha";
                case "FIGURA_NOMBRE3": return "Triángulo estilo pirámide";
                case "FIGURA_NOMBRE4": return "Rombo";
                case "FIGURA_NOMBRE5": return "Cuadrado vacío";
                case "FIGURA_NOMBRE6": return "Cuadrado lleno";
                case "FIGURA_NOMBRE7": return "Triángulo invertido alineado a la izquierda";
                case "FIGURA_NOMBRE8": return "Triángulo invertido alineado a la derecha";
                case "FIGURA_NOMBRE9": return "Triángulo estilo pirámide invertida";
                case "ERROR_ENTRADA": return "Error: Ingrese un valor válido";
                case "ERROR_LIMITES": return "Error: El tamaño debe estar entre 1 y 20";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                default: return "";
            }
        } else {
            switch (clave) {
                case "SELECCIONE_FIGURA": return "Select a figure:";
                case "INGRESE_OPCION": return "Enter your option: ";
                case "INGRESE_TAMAÑO": return "Enter the size (1-20): ";
                case "INGRESE_ALINEACION": return "Enter the alignment (left/right): ";
                case "FIGURA": return "Figure: ";
                case "FIGURA_NOMBRE1": return "Triangle aligned left";
                case "FIGURA_NOMBRE2": return "Triangle aligned right";
                case "FIGURA_NOMBRE3": return "Triangle pyramid style";
                case "FIGURA_NOMBRE4": return "Diamond";
                case "FIGURA_NOMBRE5": return "Empty square";
                case "FIGURA_NOMBRE6": return "Full square";
                case "FIGURA_NOMBRE7": return "Inverted triangle aligned left";
                case "FIGURA_NOMBRE8": return "Inverted triangle aligned right";
                case "FIGURA_NOMBRE9": return "Inverted pyramid style triangle";
                case "ERROR_ENTRADA": return "Error: Enter a valid value";
                case "ERROR_LIMITES": return "Error: Size must be between 1 and 20";
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                default: return "";
            }
        }
    }

    private static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }
}