package Ejercicio058_KevinLainez;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 058 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades para formato, cuadros y el sello personalizado.
 */
public class utilidades {

    // Constantes de estilo
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;
        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    public static void mostrarSaludo() {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #58!"));
        System.out.println(centrarTexto("DETERMINACIÓN DE MÚLTIPLOS"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto("Ingrese 0 como primer número para terminar el programa."));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 058 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita al usuario un entero.
     * @param sc El objeto Scanner.
     * @param etiqueta La descripción del valor a ingresar.
     * @return El valor entero ingresado.
     */
    public static int solicitarEntero(Scanner sc, String etiqueta) {
        int valor = -9999;

        // Bucle do-while para garantizar una entrada numérica válida
        do {
            System.out.print(BORDE_IZQ + " " + etiqueta);

            // Calcula los espacios de relleno
            int espaciosRelleno = ANCHO - 3 - etiqueta.length();
            System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
            System.out.print(BORDE_IZQ + " >> Ingrese valor: ");

            try {
                if (sc.hasNextInt()) {
                    valor = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea
                } else {
                    sc.nextLine();
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("AVISO: Entrada inválida. Debe ser un número entero."));
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    valor = -9999; // Mantener el bucle
                }
            } catch (InputMismatchException e) {
                // Esto no debería ser necesario si se usa hasNextInt() pero es buena práctica
                sc.nextLine();
                valor = -9999;
            }
        } while (valor == -9999);

        return valor;
    }

    /**
     * Muestra el resultado de la función multiple.
     */
    public static void mostrarResultado(int num1, int num2, boolean esMultiple) {
        String resultado = esMultiple ? "SÍ ES MÚLTIPLO" : "NO ES MÚLTIPLO";
        String mensaje = String.format("¿%d es múltiplo de %d? R: %s", num2, num1, resultado);

        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(mensaje));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
    }
}