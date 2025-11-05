package Ejercicio048_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 048 | 2025-11-03                  │
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
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #48!"));
        System.out.println(centrarTexto("VENTA CON DESCUENTO E IMPUESTO CONDICIONAL"));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 048 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita al usuario un valor double (precio o cantidad) con validación.
     */
    public static double solicitarValor(Scanner sc, String etiqueta) {
        double valor = -1.0;

        do {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            String prompt = etiqueta;
            System.out.print(BORDE_IZQ + " " + prompt);

            int espaciosRelleno = ANCHO - 3 - prompt.length();
            System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
            System.out.print(BORDE_IZQ + " >> Ingrese valor: ");

            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                sc.nextLine();

                if (valor < 0) {
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("AVISO: El valor no puede ser negativo."));
                }
            } else {
                sc.nextLine();
                System.out.println(dibujarLineaHorizontal('├', '┤'));
                System.out.println(centrarTexto("AVISO: Entrada inválida. Debe ser un número."));
                valor = -1.0;
            }

        } while (valor < 0);

        return valor;
    }

    /**
     * Solicita si el cliente es de la tercera edad (S/N).
     * @return True si es de la tercera edad, False en caso contrario.
     */
    public static boolean solicitarTerceraEdad(Scanner sc) {
        String respuesta;
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        String prompt = "¿Es la persona de la tercera edad? (S/N):";
        System.out.print(BORDE_IZQ + " " + prompt);

        int espaciosRelleno = ANCHO - 3 - prompt.length();
        System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
        System.out.print(BORDE_IZQ + " >> Respuesta: ");

        respuesta = sc.nextLine().trim().toUpperCase();

        // Muestra una línea de separación interna para estética
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        return respuesta.equals("S");
    }

    /**
     * Muestra el resumen de la venta.
     */
    public static void mostrarFactura(double subtotal, double porcDescuento, double montoDescuento, double tasaImpuesto, double montoImpuesto, double totalFinal) {
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- DETALLE DE VENTA ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Subtotal
        System.out.println(String.format("%s %-30s %15.2f %s", BORDE_IZQ, "Subtotal:", subtotal, BORDE_DER));

        // Descuento
        String descStr = String.format("Descuento (%.0f%%):", porcDescuento * 100);
        System.out.println(String.format("%s %-30s -%15.2f %s", BORDE_IZQ, descStr, montoDescuento, BORDE_DER));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Subtotal Neto
        double subtotalNeto = subtotal - montoDescuento;
        System.out.println(String.format("%s %-30s %15.2f %s", BORDE_IZQ, "Subtotal Neto (Base Imponible):", subtotalNeto, BORDE_DER));

        // Impuesto
        String impStr = String.format("Impuesto (%.0f%%):", tasaImpuesto * 100);
        System.out.println(String.format("%s %-30s +%15.2f %s", BORDE_IZQ, impStr, montoImpuesto, BORDE_DER));

        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Total Final
        System.out.println(String.format("%s %-30s %15.2f %s", BORDE_IZQ, "** TOTAL A PAGAR **", totalFinal, BORDE_DER));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}