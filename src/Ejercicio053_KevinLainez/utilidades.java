package Ejercicio053_KevinLainez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 053 | 2025-11-03                  │
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

    // Opciones del menú
    private static final String[] ESCALAS = {
            "1. Celsius (C)",
            "2. Fahrenheit (F)",
            "3. Kelvin (K)"
    };

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
        System.out.println(centrarTexto("¡BIENVENIDO AL EJERCICIO #53!"));
        System.out.println(centrarTexto("CONVERSOR DE TEMPERATURAS"));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
        System.out.println();
    }

    public static void mostrarSelloCorto() {
        String sello = "Kevin Lainez | klainezs@unah.hn | 053 | 2025-11-03";
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("SELLO PERSONALIZADO"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));
        System.out.println(centrarTexto(sello));
        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra las opciones de escala (todas o filtrando una) y solicita la elección.
     * @param sc El objeto Scanner.
     * @param mensaje El título del menú.
     * @param escalaExcluida La escala que no debe mostrarse (o null si ninguna).
     * @return El código de la escala elegida (C, F, o K).
     */
    public static String solicitarEscala(Scanner sc, String mensaje, String escalaExcluida) {
        int opcionElegida = -1;
        String escalaElegida = null;
        boolean entradaValida = false;

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto(mensaje));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        // Mostrar Opciones
        for (int i = 0; i < ESCALAS.length; i++) {
            // ESCALAS[i] es "1. Celsius (C)". Su código es operaciones.CELSIUS, etc.
            String codigoEscala = obtenerCodigoEscala(i + 1);
            if (!codigoEscala.equals(escalaExcluida)) {
                System.out.println(centrarTexto(ESCALAS[i]));
            }
        }
        System.out.println(dibujarLineaHorizontal('└', '┘'));

        // Solicitar y Validar
        do {
            try {
                System.out.print(">> Ingrese su opción (1-3): ");
                opcionElegida = sc.nextInt();
                sc.nextLine();

                escalaElegida = obtenerCodigoEscala(opcionElegida);

                if (opcionElegida >= 1 && opcionElegida <= 3) {
                    // Validación clave: La escala final no puede ser la inicial
                    if (escalaExcluida != null && escalaElegida.equals(escalaExcluida)) {
                        System.out.println("ERROR: No puede elegir la misma escala. Seleccione otra.");
                        opcionElegida = -1; // Forzar repetición
                    } else {
                        entradaValida = true;
                    }
                } else {
                    System.out.println("ERROR: Opción fuera de rango. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Entrada inválida. Ingrese un NÚMERO.");
                sc.nextLine();
                opcionElegida = -1;
            }
        } while (!entradaValida);

        return escalaElegida;
    }

    /**
     * Auxiliar para obtener el código de escala a partir del número de opción.
     */
    private static String obtenerCodigoEscala(int opcion) {
        return switch (opcion) {
            case 1 -> operaciones.CELSIUS;
            case 2 -> operaciones.FAHRENHEIT;
            case 3 -> operaciones.KELVIN;
            default -> null;
        };
    }

    /**
     * Solicita la temperatura inicial.
     */
    public static double solicitarTemperatura(Scanner sc, String escala) {
        double temp = Double.NaN;

        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("INGRESO DE TEMPERATURA INICIAL"));

        do {
            System.out.println(dibujarLineaHorizontal('├', '┤'));
            String prompt = String.format("Ingrese la temperatura en escala %s:", escala);
            System.out.print(BORDE_IZQ + " " + prompt);

            int espaciosRelleno = ANCHO - 3 - prompt.length();
            System.out.print(" ".repeat(espaciosRelleno) + BORDE_DER + "\n");
            System.out.print(BORDE_IZQ + " >> Temperatura: ");

            if (sc.hasNextDouble()) {
                temp = sc.nextDouble();
                sc.nextLine();
            } else {
                sc.nextLine();
                System.out.println(dibujarLineaHorizontal('├', '┤'));
                System.out.println(centrarTexto("AVISO: Entrada inválida. Debe ser un número."));
                temp = Double.NaN;
            }

        } while (Double.isNaN(temp));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
        return temp;
    }

    /**
     * Muestra el resultado de la conversión.
     */
    public static void mostrarResultado(double tempInicial, String escalaInicial, double tempFinal, String escalaFinal) {
        System.out.println();
        System.out.println(dibujarLineaHorizontal('┌', '┐'));
        System.out.println(centrarTexto("--- RESULTADO DE CONVERSIÓN ---"));
        System.out.println(dibujarLineaHorizontal('├', '┤'));

        String inicialStr = String.format("Temperatura Inicial: %.2f %s", tempInicial, escalaInicial);
        String finalStr = String.format("Temperatura Final: %.2f %s", tempFinal, escalaFinal);

        System.out.println(centrarTexto(inicialStr));
        System.out.println(centrarTexto(finalStr));

        System.out.println(dibujarLineaHorizontal('└', '┘'));
    }
}