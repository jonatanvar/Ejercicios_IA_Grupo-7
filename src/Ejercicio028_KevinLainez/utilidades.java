package Ejercicio028_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 028 | 2025-11-03                  │
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
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #28!"));
        System.out.println(centrarTexto("CRIPTOGRAFÍA DE CUATRO DÍGITOS"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto("El programa cifrará y luego descifrará su número."));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 028 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita al usuario un entero de cuatro dígitos (1000 a 9999).
     * @param sc El objeto Scanner.
     * @return El número entero validado.
     */
    public static int solicitarEnteroCuatroDigitos(Scanner sc) {
        int numero = 0;
        final int MIN = 1000;
        final int MAX = 9999;

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("INGRESO DE DATOS (4 DÍGITOS)"));

        do {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            String prompt = String.format("Ingrese el entero de 4 dígitos (%d-%d):", MIN, MAX);
            System.out.print(BORDE_IZQ + " " + prompt);

            int espaciosRelleno = ANCHO - 3 - prompt.length();
            System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
            System.out.print(BORDE_IZQ + " >> Número: ");

            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                sc.nextLine();

                if (numero < MIN || numero > MAX) {
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("AVISO: El número debe tener exactamente 4 dígitos. Intente de nuevo."));
                    numero = 0;
                }
            } else {
                sc.nextLine();
                System.out.println(dibujarLineaHorizontal('├', '┤'));
                System.out.println(centrarTexto("AVISO: Entrada inválida. Debe ser un número entero."));
                numero = 0;
            }

        } while (numero < MIN || numero > MAX);

        System.out.println(dibujarLineaHorizontal('└', '┘'));
        return numero;
    }

    /**
     * Muestra los resultados del cifrado y descifrado.
     * @param original El número original.
     * @param cifrado El número cifrado.
     * @param descifrado El número descifrado.
     */
    public static void mostrarResultados(int original, int cifrado, int descifrado) {
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- RESULTADOS CRIPTOGRÁFICOS ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        System.out.println(centrarTexto(String.format("1. Número Original: %04d", original)));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("2. Número Cifrado:  %04d", cifrado)));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("3. Número Descifrado: %04d", descifrado)));

        // Verificación de integridad
        String estado = (original == descifrado) ? "DESCIFRADO EXITOSO" : "ERROR DE DESCIFRADO";
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("ESTADO DE LA OPERACIÓN: %s", estado)));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}