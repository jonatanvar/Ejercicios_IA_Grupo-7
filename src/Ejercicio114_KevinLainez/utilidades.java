package Ejercicio114_KevinLainez;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 114 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades para formato, entrada de datos y presentación de resultados.
 */
public class utilidades {

    // Constantes de estilo y límites
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';
    private static final int MIN_DIMENSION = 3;
    private static final int MAX_DIMENSION = 10;
    private static final int ANCHO_CELDA_MATRIZ = 5; // Suficiente para números < 1000

    public static String centrarTexto(String texto) {
        int espaciosTotales = ANCHO - 2 - texto.length();
        int espaciosIzquierda = espaciosTotales / 2;
        int espaciosDerecha = espaciosTotales - espaciosIzquierda;

        if (espaciosTotales < 0) {
            return String.valueOf(BORDE_IZQ) + " " + texto.substring(0, ANCHO - 4) + " " + String.valueOf(BORDE_DER);
        }
        return String.valueOf(BORDE_IZQ) + " ".repeat(espaciosIzquierda) + texto + " ".repeat(espaciosDerecha) + String.valueOf(BORDE_DER);
    }

    public static String dibujarLineaHorizontal(char inicio, char fin) {
        return String.valueOf(inicio) + String.valueOf(LINEA_H).repeat(ANCHO - 2) + String.valueOf(fin);
    }

    public static void mostrarSaludo() {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #114!"));
        System.out.println(centrarTexto("IDENTIFICACIÓN DE VALLES EN MATRICES"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(String.format("La dimensión debe ser entre %d y %d.", MIN_DIMENSION, MAX_DIMENSION)));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 114 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita al usuario la dimensión (filas o columnas) de la matriz con validación de rango.
     * @param sc El objeto Scanner.
     * @param dimension Nombre de la dimensión ("Filas" o "Columnas").
     * @return El valor de la dimensión.
     */
    public static int solicitarDimension(Scanner sc, String dimension) {
        int valor = -1;

        do {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            String prompt = String.format("Ingrese el número de %s [%d-%d]:", dimension, MIN_DIMENSION, MAX_DIMENSION);
            System.out.print(BORDE_IZQ + " " + prompt);

            int espaciosRelleno = ANCHO - 3 - prompt.length();
            System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
            System.out.print(BORDE_IZQ + " >> Cantidad: ");

            try {
                if (sc.hasNextInt()) {
                    valor = sc.nextInt();
                    sc.nextLine();

                    if (valor < MIN_DIMENSION || valor > MAX_DIMENSION) {
                        System.out.println(dibujarLineaHorizontal('├', '┤'));
                        System.out.println(centrarTexto("AVISO: La dimensión debe estar entre " + MIN_DIMENSION + " y " + MAX_DIMENSION + "."));
                        valor = -1;
                    }
                } else {
                    sc.nextLine();
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("AVISO: Entrada inválida. Debe ser un número entero."));
                    valor = -1;
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                valor = -1;
            }
        } while (valor == -1);

        return valor;
    }

    /**
     * Muestra la matriz generada.
     */
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- MATRIZ GENERADA ---"));

        for (int i = 0; i < matriz.length; i++) {
            StringBuilder sbFila = new StringBuilder();
            for (int j = 0; j < matriz[i].length; j++) {
                sbFila.append(String.format("%" + ANCHO_CELDA_MATRIZ + "d", matriz[i][j]));
            }
            System.out.println(centrarTexto(sbFila.toString()));
        }
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra los resultados de la búsqueda de valles.
     */
    public static void mostrarResultados(List<Valle> valles) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- RESULTADOS DE BÚSQUEDA DE VALLES ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        if (valles.isEmpty()) {
            System.out.println(centrarTexto("CONCLUSIÓN: No se encontraron valles en la matriz."));
        } else {
            System.out.println(centrarTexto(String.format("CONCLUSIÓN: Se encontraron %d valle(s) [excluyendo bordes].", valles.size())));

            // Requerimiento: mostrar coordenadas, valor y vecinos
            for (Valle valle : valles) {
                System.out.println(dibujarLineaHorizontal('├', '┤'));

                // Coordenadas base 1 (R, C)
                String coords = String.format("Valle en Coordenadas (%d, %d). Valor del valle: %d",
                        valle.fila, valle.columna, valle.valor);
                System.out.println(centrarTexto(coords));

                // Vecinos
                String vecinosStr = valle.vecinos.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));
                String salidaVecinos = String.format("Vecinos (%s): %s", "R,RD,D,LI,LD,I,ID,II", vecinosStr);

                // Simular el formato de salida esperado: En 955,945,876 el valle es 4 y, ...
                System.out.println(centrarTexto("Valores Vecinos: " + vecinosStr));
            }
        }
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}