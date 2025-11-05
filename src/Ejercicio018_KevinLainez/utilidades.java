package Ejercicio018_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 018 | 2025-11-03                  │
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
        int espaciosTotales = ANCHO - 2 - texto.length();
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
     * Muestra el saludo de bienvenida e instrucciones en un cuadro.
     */
    public static void mostrarSaludo() {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #18!"));
        System.out.println(centrarTexto("REGISTRO DE KILOMETRAJE POR GASOLINA"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto("Instrucción: Ingrese -1 en kilómetros para finalizar el programa."));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    /**
     * Muestra el sello personalizado (versión corta) en un cuadro.
     */
    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 018 | 2025-11-03";

        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita y captura la entrada de un valor entero (kilómetros o litros).
     * @param sc El objeto Scanner.
     * @param etiqueta La descripción del valor a ingresar (ej: "Kilómetros recorridos").
     * @return El valor entero ingresado por el usuario.
     */
    public static int solicitarValor(Scanner sc, String etiqueta) {
        // Imprime el prompt alineado a la izquierda
        System.out.print(BORDE_IZQ + " " + etiqueta);

        // Calcula los espacios necesarios para mantener el formato
        int espaciosRelleno = ANCHO - 3 - etiqueta.length();
        System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
        System.out.print(BORDE_IZQ + " >> Ingrese valor: ");

        int valor = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        return valor;
    }

    /**
     * Muestra el KPL de un reabastecimiento y el KPL total acumulado.
     * @param contador El número de reabastecimiento.
     * @param kplActual El KPL calculado para el reabastecimiento actual.
     * @param kplTotal El KPL total acumulado hasta ahora.
     */
    public static void mostrarResultadosParciales(int contador, double kplActual, double kplTotal) {
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("Reabastecimiento #%d:", contador)));
        System.out.println(centrarTexto(String.format("KPL Actual: %.2f km/l", kplActual)));
        System.out.println(centrarTexto(String.format("KPL Total Acumulado: %.2f km/l", kplTotal)));
    }

    /**
     * Muestra el resumen final de la sesión.
     * @param kplTotal El KPL total final.
     * @param totalKm Los kilómetros totales.
     * @param totalLts Los litros totales.
     */
    public static void mostrarResumenFinal(double kplTotal, double totalKm, double totalLts) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- RESUMEN FINAL ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("Total Kilómetros Recorridos: %.2f km", totalKm)));
        System.out.println(centrarTexto(String.format("Total Litros Consumidos: %.2f l", totalLts)));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("** KPL PROMEDIO FINAL: %.2f km/l **", kplTotal)));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}