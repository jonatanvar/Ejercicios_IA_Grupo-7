package Ejercicio008_KevinLainez;

import java.util.Scanner;
import java.util.Arrays;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 008 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de Utilidades para formato, cuadros y el sello personalizado.
 */
public class Utilidades {

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
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #8!"));
        System.out.println(centrarTexto("OPERACIONES CON CUATRO NÚMEROS"));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    /**
     * Muestra el sello personalizado (versión corta) en un cuadro.
     */
    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 008 | 2025-11-03";

        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra los resultados de las Operaciones en un cuadro elegante.
     * @param numerosOrdenados Los números ordenados de mayor a menor.
     * @param suma El resultado de la suma.
     * @param promedio El resultado del promedio.
     * @param producto El resultado del producto.
     * @param mayor El número mayor.
     * @param menor El número menor.
     */
    public static void mostrarResultado(Double[] numerosOrdenados, double suma, double promedio, double producto, double mayor, double menor) {
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("** RESULTADOS DE OPERACIONES **"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Formato de números ordenados
        String strOrdenados = Arrays.toString(numerosOrdenados);
        // Quita los corchetes para un mejor formato
        strOrdenados = strOrdenados.substring(1, strOrdenados.length() - 1);

        System.out.println(centrarTexto("Números Ordenados (Mayor a Menor):"));
        System.out.println(centrarTexto(strOrdenados));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Resultados
        System.out.println(centrarTexto(String.format("Suma Total: %.2f", suma)));
        System.out.println(centrarTexto(String.format("Promedio:   %.2f", promedio)));
        System.out.println(centrarTexto(String.format("Producto:   %.2f", producto)));
        System.out.println(centrarTexto(String.format("Número Mayor: %.2f", mayor)));
        System.out.println(centrarTexto(String.format("Número Menor: %.2f", menor)));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita y captura la entrada de un número, mostrando un prompt.
     * @param sc El objeto Scanner.
     * @param indice El índice del número (ej: 1, 2, 3, 4).
     * @return El número de tipo double ingresado por el usuario.
     */
    public static double solicitarNumero(Scanner sc, int indice) {
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        String prompt = String.format("Ingrese el número #%d (double):", indice);

        // Imprime el prompt alineado a la izquierda
        System.out.print(BORDE_IZQ + " " + prompt);

        // Calcula los espacios necesarios para mantener el formato
        int espaciosRelleno = ANCHO - 3 - prompt.length();
        System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
        System.out.print(BORDE_IZQ + " >> Ingrese valor: ");

        double numero = sc.nextDouble();

        // Muestra una línea de separación interna para estética tras la entrada
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        return numero;
    }
}