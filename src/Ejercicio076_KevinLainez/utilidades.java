package Ejercicio076_KevinLainez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 076 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades para formato, cuadros y la lógica de validación de ángulos.
 */
public class utilidades {

    // Constantes de estilo
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';
    private static final int MIN_ANGULO = 0;
    private static final int MAX_ANGULO = 360;

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
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #76!"));
        System.out.println(centrarTexto("VALIDACIÓN DE ÁNGULOS Y TRIGONOMETRÍA"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto("Restricción: 0° ≤ Ángulo 1 < Ángulo 2 ≤ 360°"));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 076 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Solicita al usuario un ángulo con validación de rango.
     * @param sc El objeto Scanner.
     * @param etiqueta El nombre del ángulo (ej: "Primer Ángulo").
     * @return El valor del ángulo en grados.
     */
    private static double solicitarAngulo(Scanner sc, String etiqueta) {
        double angulo = -1.0;

        do {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            String prompt = String.format("Ingrese %s [%d-%d]:", etiqueta, MIN_ANGULO, MAX_ANGULO);
            System.out.print(BORDE_IZQ + " " + prompt);

            int espaciosRelleno = ANCHO - 3 - prompt.length();
            System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
            System.out.print(BORDE_IZQ + " >> Ángulo: ");

            try {
                if (sc.hasNextDouble()) {
                    angulo = sc.nextDouble();
                    sc.nextLine();

                    if (angulo < MIN_ANGULO || angulo > MAX_ANGULO) {
                        System.out.println(dibujarLineaHorizontal('├', '┤'));
                        System.out.println(centrarTexto("AVISO: El ángulo debe estar entre 0° y 360°."));
                        angulo = -1.0;
                    }
                } else {
                    sc.nextLine();
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("AVISO: Entrada inválida. Debe ser un número."));
                    angulo = -1.0;
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                angulo = -1.0;
            }
        } while (angulo < MIN_ANGULO || angulo > MAX_ANGULO);

        return angulo;
    }

    /**
     * Clase interna para devolver los dos ángulos validados y potencialmente intercambiados.
     */
    public static class AngulosValidados {
        public double angulo1;
        public double angulo2;

        public AngulosValidados(double a1, double a2) {
            this.angulo1 = a1;
            this.angulo2 = a2;
        }
    }

    /**
     * Gestiona la entrada de ambos ángulos y aplica la lógica de ordenamiento/intercambio.
     * @param sc El objeto Scanner.
     * @return Un objeto AngulosValidados con los ángulos finales.
     */
    public static AngulosValidados gestionarAngulos(Scanner sc) {

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("INGRESO Y VALIDACIÓN DE ÁNGULOS"));

        double angulo1, angulo2;
        boolean ordenValido = false;

        do {
            angulo1 = solicitarAngulo(sc, "Primer Ángulo");
            angulo2 = solicitarAngulo(sc, "Segundo Ángulo");

            if (angulo1 < angulo2) {
                ordenValido = true;
                break; // Orden correcto
            }

            // Si angulo1 >= angulo2
            int opcion = 0;
            do {
                System.out.println(dibujarLineaHorizontal('├', '┤'));
                String pregunta = String.format("A1=%.1f, A2=%.1f. ¿Desea que A1=%.1f y A2=%.1f?",
                        angulo1, angulo2, angulo2, angulo1);

                System.out.println(centrarTexto(pregunta));
                System.out.println(centrarTexto("1 = SÍ (Intercambiar)"));
                System.out.println(centrarTexto("2 = NO (Volver a leer ambos ángulos)"));
                System.out.print(BORDE_IZQ + " >> Opción: ");

                try {
                    if (sc.hasNextInt()) {
                        opcion = sc.nextInt();
                        sc.nextLine();
                    } else {
                        sc.nextLine();
                        opcion = 0;
                    }
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    opcion = 0;
                }

                if (opcion == 1) {
                    double temp = angulo1;
                    angulo1 = angulo2;
                    angulo2 = temp;
                    ordenValido = true;
                } else if (opcion == 2) {
                    ordenValido = false; // Volver al inicio del bucle principal
                } else {
                    System.out.println(dibujarLineaHorizontal('├', '┤'));
                    System.out.println(centrarTexto("ERROR: Opción no válida."));
                }
            } while (opcion != 1 && opcion != 2);

        } while (!ordenValido);

        System.out.println(dibujarLineaHorizontal('└', '┘'));
        return new AngulosValidados(angulo1, angulo2);
    }
}