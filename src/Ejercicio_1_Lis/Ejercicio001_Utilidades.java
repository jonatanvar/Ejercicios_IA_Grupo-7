/**
 * Ejercicio001_Utilidades.java
 * Rol: Proporciona funciones de utilidad para formatear la salida con bordes
 * Unicode, centrar texto y mostrar los encabezados personalizado (completo y corto).
 *
 * Sello personalizado - Versión corta
 * ┌────────────────────────────────────────────────────────────────────┐
 * │   Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 001 | 2025-10-10  │
 * └────────────────────────────────────────────────────────────────────┘
 */
package Ejercicio_1_Lis;

public class Ejercicio001_Utilidades {
    // Constantes para el formato de salida
    private static final int ANCHO = 70;
    private static final String BORDE_IZQ = "│ ";
    private static final String BORDE_DER = " │";
    private static final String LINEA_H = "─";
    private static final String LINEA_SUP = "┌" + LINEA_H.repeat(ANCHO - 2) + "┐";
    private static final String LINEA_INF = "└" + LINEA_H.repeat(ANCHO - 2) + "┘";
    private static final String LINEA_SEP = "├" + LINEA_H.repeat(ANCHO - 2) + "┤";

    // Muestra el cuadro de bienvenida
    public static void mostrarSaludo() {
        System.out.println(LINEA_SUP);
        System.out.println(centrarTexto("¡BIENVENIDO (A) AL SISTEMA DE GESTIÓN DE CÓDIGO!", ANCHO));
        System.out.println(centrarTexto("EJERCICIO 001: MOSTRAR SALUDO Y ENCABEZADOS", ANCHO));
        System.out.println(LINEA_INF);
        System.out.println();
    }

    // Muestra el encabezado personalizado completo
    public static void mostrarEncabezadoCompleto(String codigoEjercicio, String fecha) {
        System.out.println(LINEA_SUP);
        System.out.println(centrarTexto("ENCABEZADO PERSONALIZADO - VERSIÓN COMPLETA", ANCHO));
        System.out.println(LINEA_SEP);
        System.out.println(BORDE_IZQ + "Autor: Cristina Cruz (Lis <3)" + " ".repeat(ANCHO - 29 - 4) + BORDE_DER);
        System.out.println(BORDE_IZQ + "Correo: cristinacruz@unah.hn" + " ".repeat(ANCHO - 28 - 4) + BORDE_DER);
        System.out.println(BORDE_IZQ + "Fecha: " + fecha + " ".repeat(ANCHO - 8 - fecha.length() - 4) + BORDE_DER);
        System.out.println(BORDE_IZQ + "Código de ejercicio: " + codigoEjercicio + " ".repeat(ANCHO - 20 - codigoEjercicio.length() - 4) + BORDE_DER);
        System.out.println(LINEA_SEP);
        System.out.println(BORDE_IZQ + "Análisis: Este programa muestra un saludo y los encabezados" + " ".repeat(ANCHO - 57 - 4) + BORDE_DER);
        System.out.println(BORDE_IZQ + "personalizados (completo y corto) en cuadros elegantes." + " ".repeat(ANCHO - 54 - 4) + BORDE_DER);
        System.out.println(LINEA_INF);
        System.out.println();
    }

    // Muestra el sello personalizado corto
    public static void mostrarSelloCorto(String codigoEjercicio, String fecha) {
        System.out.println(LINEA_SUP);
        System.out.println(centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO));
        System.out.println(LINEA_SEP);
        String sello = "Cristina Cruz | Lis❤ | cristinacruz@unah.hn | " + codigoEjercicio + " | " + fecha;
        System.out.println(centrarTexto(sello, ANCHO));
        System.out.println(LINEA_INF);
        System.out.println();
    }

    // Centra el texto dentro del ancho especificado
    private static String centrarTexto(String texto, int ancho) {
        int longitudTexto = texto.length();
        if (longitudTexto >= ancho - 4) {
            return BORDE_IZQ + texto.substring(0, ancho - 4) + BORDE_DER;
        }
        int espaciosIzq = (ancho - 4 - longitudTexto) / 2;
        int espaciosDer = ancho - 4 - longitudTexto - espaciosIzq;
        return BORDE_IZQ + " ".repeat(espaciosIzq) + texto + " ".repeat(espaciosDer) + BORDE_DER;
    }
}