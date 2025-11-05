package Ejercicio023_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 023 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades para formato, cuadros y el sello personalizado.
 */
public class utilidades {

    // Constantes de estilo
    private static final int ANCHO = 70;
    public static final char BORDE_IZQ = '│';
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
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #23!"));
        System.out.println(centrarTexto("DIBUJO DE CUADRADO HUECO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto("Ingrese el tamaño del lado (entre 1 y 20)."));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    /**
     * Muestra el sello personalizado (versión corta) en un cuadro.
     */
    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 023 | 2025-11-03";

        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita al usuario un entero dentro del rango [1, 20].
     * Vuelve a preguntar si el valor está fuera del rango.
     * @param sc El objeto Scanner.
     * @return El tamaño del lado validado.
     */
    public static int solicitarLado(Scanner sc) {
        int lado = 0;

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("INGRESO DE TAMAÑO DEL LADO"));

        do {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            String prompt = "Tamaño del lado (1-20):";
            System.out.print(BORDE_IZQ + " " + prompt);

            // Calcula los espacios necesarios para mantener el formato
            int espaciosRelleno = ANCHO - 3 - prompt.length();
            System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
            System.out.print(BORDE_IZQ + " >> Ingrese valor: ");

            if (sc.hasNextInt()) {
                lado = sc.nextInt();
                sc.nextLine(); // Consumir el salto de línea

                if (lado < 1 || lado > 20) {
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("AVISO: El tamaño debe estar entre 1 y 20. Intente de nuevo."));
                    lado = 0; // Fuerza la repetición del bucle
                }
            } else {
                sc.nextLine(); // Limpiar la entrada no válida
                System.out.println(dibujarLineaHorizontal('├', '┤'));
                System.out.println(centrarTexto("AVISO: Entrada inválida. Debe ser un número entero."));
                lado = 0; // Fuerza la repetición del bucle
            }

        } while (lado < 1 || lado > 20);

        System.out.println(dibujarLineaHorizontal('└', '┘'));
        return lado;
    }

    /**
     * Muestra el cuadro de resultados antes de imprimir el cuadrado.
     */
    public static void mostrarEncabezadoResultado(int lado) {
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("** CUADRADO HUECO DE LADO: " + lado + " **"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
    }

    /**
     * Muestra el pie de página de los resultados.
     */
    public static void mostrarPieResultado() {
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}