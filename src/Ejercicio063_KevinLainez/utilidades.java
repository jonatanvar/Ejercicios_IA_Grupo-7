package Ejercicio063_KevinLainez;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 063 | 2025-11-03                  │
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
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #63!"));
        System.out.println(centrarTexto("BÚSQUEDA DE NÚMEROS PERFECTOS"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto("Se buscarán números perfectos entre 1 y 1000."));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 063 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra el encabezado de la sección de resultados.
     */
    public static void mostrarEncabezadoResultados(int limite) {
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto(String.format("** NÚMEROS PERFECTOS EN EL RANGO [1, %d] **", limite)));
    }

    /**
     * Muestra la información de un número perfecto encontrado.
     * @param numero El número perfecto.
     * @param divisores La lista de divisores para confirmación.
     */
    public static void mostrarNumeroPerfecto(int numero, List<Integer> divisores) {
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // 1. Mostrar el número
        System.out.println(centrarTexto(String.format("¡NÚMERO PERFECTO ENCONTRADO!: %d", numero)));

        // 2. Formatear y mostrar los divisores
        String divisoresStr = divisores.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" + "));
        int suma = divisores.stream().mapToInt(Integer::intValue).sum();

        String confirmacion = String.format("Confirmación: %d = %s", suma, divisoresStr);

        // Dividir si es muy largo para centrar
        if (confirmacion.length() > ANCHO - 4) {
            System.out.println(centrarTexto("Confirmación (Divisores):"));
            // Imprime la cadena larga sin centrar, ajustando solo con bordes
            System.out.print(BORDE_IZQ + " ");
            System.out.print(divisoresStr);
            System.out.println(" ".repeat(ANCHO - 3 - divisoresStr.length()) + BORDE_DER);
        } else {
            System.out.println(centrarTexto(confirmacion));
        }
    }

    /**
     * Muestra el pie de página de la sección de resultados.
     */
    public static void mostrarPieResultados() {
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto("--- FIN DEL ANÁLISIS ---"));
        System.out.println(centrarTexto("NOTA: Puede modificar el código para evaluar números mayores a 1000."));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita al usuario el límite superior para la búsqueda (opcional).
     */
    public static int solicitarLimite(Scanner sc, int limiteBase) {
        int limite = limiteBase;

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("CONFIGURACIÓN DE BÚSQUEDA"));

        do {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            String prompt = String.format("Ingrese el límite superior (defecto: %d):", limiteBase);
            System.out.print(BORDE_IZQ + " " + prompt);

            int espaciosRelleno = ANCHO - 3 - prompt.length();
            System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
            System.out.print(BORDE_IZQ + " >> Ingrese valor (o 0 para usar el defecto): ");

            try {
                if (sc.hasNextInt()) {
                    int entrada = sc.nextInt();
                    sc.nextLine();

                    if (entrada == 0) {
                        limite = limiteBase;
                        break;
                    } else if (entrada > 1) {
                        limite = entrada;
                        break;
                    } else {
                        System.out.println(dibujarLineaHorizontal('├', '┤'));
                        System.out.println(centrarTexto("AVISO: El límite debe ser mayor a 1."));
                    }
                } else {
                    sc.nextLine();
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("AVISO: Entrada inválida. Ingrese un número entero."));
                }
            } catch (Exception e) {
                sc.nextLine();
                limite = 0; // Forzar repetición
            }
        } while (limite <= 1);

        System.out.println(dibujarLineaHorizontal('└', '┘'));
        return limite;
    }
}