/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 021 | 2025-10-11               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio021;

import java.util.Scanner;

public class Ejercicio021_Utilidades {
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';
    private static final double HORAS_NORMALES = 40.0;

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 021 | 2025-10-11", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static int mostrarIngresoNumEmpleados(Scanner scanner, String idioma) {
        int numEmpleados;
        do {
            System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
            System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("INGRESO_NUM_EMPLEADOS", idioma), ANCHO - 2) + BORDE_DER);
            System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
            System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("RANGO_EMPLEADOS", idioma), ANCHO - 2) + BORDE_DER);
            System.out.print(obtenerTexto("INGRESE_NUM_EMPLEADOS", idioma) + ": ");

            if (scanner.hasNextInt()) {
                numEmpleados = scanner.nextInt();
                if (numEmpleados >= 3 && numEmpleados <= 5) {
                    imprimirLineaConDato(obtenerTexto("INGRESE_NUM_EMPLEADOS", idioma) + ": " + numEmpleados);
                    System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
                    return numEmpleados;
                }
            } else {
                scanner.next();
            }
            mostrarErrorEntrada(idioma);
        } while (true);
    }

    public static void mostrarIngresoDatosEmpleado(Scanner scanner, String idioma, int numEmpleado, String[] nombres, double[] horas, double[] tarifas, int indice) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("INGRESO_DATOS_EMPLEADO", idioma) + " " + numEmpleado, ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");

        scanner.nextLine(); // Limpiar buffer
        System.out.print(obtenerTexto("INGRESE_NOMBRE", idioma) + ": ");
        nombres[indice] = scanner.nextLine();
        imprimirLineaConDato(obtenerTexto("INGRESE_NOMBRE", idioma) + ": " + nombres[indice]);

        boolean entradaValida = false;
        do {
            System.out.print(obtenerTexto("INGRESE_HORAS", idioma) + ": ");
            if (scanner.hasNextDouble()) {
                horas[indice] = scanner.nextDouble();
                if (horas[indice] >= 0) {
                    imprimirLineaConDato(obtenerTexto("INGRESE_HORAS", idioma) + ": " + horas[indice]);
                    entradaValida = true;
                } else {
                    mostrarErrorEntrada(idioma);
                    scanner.nextLine();
                }
            } else {
                mostrarErrorEntrada(idioma);
                scanner.next();
            }
        } while (!entradaValida);

        entradaValida = false;
        do {
            System.out.print(obtenerTexto("INGRESE_TARIFA", idioma) + ": ");
            if (scanner.hasNextDouble()) {
                tarifas[indice] = scanner.nextDouble();
                if (horas[indice] <= HORAS_NORMALES && tarifas[indice] < 80) {
                    imprimirLineaConDato(obtenerTexto("INGRESE_TARIFA", idioma) + ": " + tarifas[indice]);
                    entradaValida = true;
                } else if (horas[indice] > HORAS_NORMALES && tarifas[indice] > 100) {
                    imprimirLineaConDato(obtenerTexto("INGRESE_TARIFA", idioma) + ": " + tarifas[indice]);
                    entradaValida = true;
                } else {
                    mostrarMensajeTarifaInvalida(horas[indice], idioma);
                    scanner.nextLine();
                }
            } else {
                mostrarErrorEntrada(idioma);
                scanner.next();
            }
        } while (!entradaValida);

        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarTablaResultados(String[] nombres, double[] horas, double[] tarifas, double[] sueldos, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("TABLA_RESULTADOS", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ENCABEZADO_TABLA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");

        for (int i = 0; i < nombres.length; i++) {
            String linea = String.format("%-15s | %-6.1f | %-8.2f | %-10.2f", nombres[i], horas[i], tarifas[i], sueldos[i]);
            System.out.println(BORDE_IZQ + centrarTexto(linea, ANCHO - 2) + BORDE_DER);
        }

        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    private static void mostrarErrorEntrada(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_ENTRADA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    private static void mostrarMensajeTarifaInvalida(double horas, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        if (horas <= HORAS_NORMALES) {
            System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_TARIFA_MENOR_40", idioma), ANCHO - 2) + BORDE_DER);
        } else {
            System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_TARIFA_MAYOR_40", idioma), ANCHO - 2) + BORDE_DER);
        }
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    private static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "INGRESO_NUM_EMPLEADOS": return "Ingrese la cantidad de empleados";
                case "RANGO_EMPLEADOS": return "(Mínimo 3, máximo 5)";
                case "INGRESE_NUM_EMPLEADOS": return "Cantidad de empleados";
                case "INGRESO_DATOS_EMPLEADO": return "DATOS DEL EMPLEADO";
                case "INGRESE_NOMBRE": return "Nombre";
                case "INGRESE_HORAS": return "Horas trabajadas";
                case "INGRESE_TARIFA": return "Tarifa por hora";
                case "CUOTA_BASE": return "Cuota base";
                case "TABLA_RESULTADOS": return "TABLA DE SUELDOS";
                case "ENCABEZADO_TABLA": return "Nombre          | Horas | Tarifa  | Sueldo";
                case "ERROR_ENTRADA": return "ERROR: Ingrese un valor válido";
                case "ERROR_TARIFA_MENOR_40": return "ERROR: Tarifa debe ser < 80 para ≤ 40 horas";
                case "ERROR_TARIFA_MAYOR_40": return "ERROR: Tarifa debe ser > 100 para > 40 horas";
                default: return "";
            }
        } else {
            switch (clave) {
                case "INGRESO_NUM_EMPLEADOS": return "Enter the number of employees";
                case "RANGO_EMPLEADOS": return "(Minimum 3, maximum 5)";
                case "INGRESE_NUM_EMPLEADOS": return "Number of employees";
                case "INGRESO_DATOS_EMPLEADO": return "EMPLOYEE DATA";
                case "INGRESE_NOMBRE": return "Name";
                case "INGRESE_HORAS": return "Hours worked";
                case "INGRESE_TARIFA": return "Hourly rate";
                case "CUOTA_BASE": return "Base quota";
                case "TABLA_RESULTADOS": return "PAYROLL TABLE";
                case "ENCABEZADO_TABLA": return "Name            | Hours | Rate    | Salary";
                case "ERROR_ENTRADA": return "ERROR: Enter a valid value";
                case "ERROR_TARIFA_MENOR_40": return "ERROR: Tariff must be < 80 for ≤ 40 hours";
                case "ERROR_TARIFA_MAYOR_40": return "ERROR: Tariff must be > 100 for > 40 hours";
                default: return "";
            }
        }
    }

    private static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;
        return " ".repeat(Math.max(0, espaciosIzq)) + texto + " ".repeat(Math.max(0, espaciosDer));
    }

    private static void imprimirLineaConDato(String texto) {
        int espaciosRestantes = ANCHO - texto.length() - 2;
        if (espaciosRestantes < 0) espaciosRestantes = 0;
        System.out.println(BORDE_IZQ + texto + " ".repeat(espaciosRestantes) + BORDE_DER);
    }
}