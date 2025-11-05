package Ejercicio013_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 013 | 2025-11-03                  │
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

    /**
     * Centra un texto dentro del ancho especificado.
     * @param texto El texto a centrar.
     * @return El texto centrado con espacios de relleno.
     */
    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length(); // 2 por los bordes
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;

        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    /**
     * Dibuja una línea horizontal para los bordes del cuadro.
     * @param inicio El carácter de esquina/conexión izquierda.
     * @param fin El carácter de esquina/conexión derecha.
     * @return La línea horizontal formateada.
     */
    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    /**
     * Muestra el saludo de bienvenida en un cuadro.
     */
    public static void mostrarSaludo() {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #13!"));
        System.out.println(centrarTexto("DETERMINACIÓN DE PAR O IMPAR"));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    /**
     * Muestra el sello personalizado (versión corta) en un cuadro.
     */
    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 013 | 2025-11-03";

        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra el resultado de la determinación de par o impar.
     * @param numero El número entero ingresado.
     * @param resultado El texto que indica si es "PAR" o "IMPAR".
     */
    public static void mostrarResultado(int numero, String resultado) {
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("** RESULTADO DEL ANÁLISIS **"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        String mensaje = String.format("El número %d es: %s", numero, resultado);
        System.out.println(centrarTexto(mensaje));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita y captura la entrada de un número entero.
     * @param sc El objeto Scanner.
     * @return El número entero ingresado por el usuario.
     */
    public static int solicitarEntero(Scanner sc) {
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        String prompt = "Ingrese un número entero para determinar si es Par o Impar:";

        // Imprime el prompt alineado a la izquierda
        System.out.print(BORDE_IZQ + " " + prompt);

        // Calcula los espacios necesarios para mantener el formato
        int espaciosRelleno = ANCHO - 3 - prompt.length();
        System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
        System.out.print(BORDE_IZQ + " >> Ingrese valor: ");

        int numero = sc.nextInt();

        // Muestra una línea de separación interna para estética tras la entrada
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        return numero;
    }
}