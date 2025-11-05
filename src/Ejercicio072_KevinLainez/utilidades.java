package Ejercicio072_KevinLainez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 072 | 2025-11-03                  │
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
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #72!"));
        System.out.println(centrarTexto("CÁLCULO DEL ÁREA DE UN CÍRCULO"));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 072 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita al usuario el radio de un círculo con validación.
     * @param sc El objeto Scanner.
     * @return El valor del radio (double y positivo).
     */
    public static double solicitarRadio(Scanner sc) {
        double radio = -1.0;

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("INGRESO DEL RADIO"));

        do {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            String prompt = "Ingrese el radio del círculo (debe ser > 0):";
            System.out.print(BORDE_IZQ + " " + prompt);

            int espaciosRelleno = ANCHO - 3 - prompt.length();
            System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
            System.out.print(BORDE_IZQ + " >> Ingrese valor: ");

            try {
                if (sc.hasNextDouble()) {
                    radio = sc.nextDouble();
                    sc.nextLine();

                    if (radio <= 0) {
                        System.out.println(dibujarLineaHorizontal('├', '┤'));
                        System.out.println(centrarTexto("AVISO: El radio debe ser positivo. Intente de nuevo."));
                    }
                } else {
                    sc.nextLine();
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("AVISO: Entrada inválida. Debe ser un número."));
                    radio = -1.0;
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                radio = -1.0;
            }
        } while (radio <= 0);

        System.out.println(dibujarLineaHorizontal('└', '┘'));
        return radio;
    }

    /**
     * Muestra el resultado del cálculo del área.
     */
    public static void mostrarResultado(double radio, double area) {
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- RESULTADO DEL CÁLCULO ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        String radioStr = String.format("Radio ingresado: %.2f", radio);
        String areaStr = String.format("Área del Círculo (π*r²): %.4f", area);

        System.out.println(centrarTexto(radioStr));
        System.out.println(centrarTexto(areaStr));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}