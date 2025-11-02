/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                    │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 065                               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio065;

public class Utilidades {
    public static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 065 | 2025-10-17 20:34 CST", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarResultados(double[] horas, double[] cargos, double total, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(Utilidades.obtenerTexto("RESULTADOS", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.printf(BORDE_IZQ + " %-15s %-15s %-15s" + BORDE_DER + "%n", Utilidades.obtenerTexto("CLIENTE", idioma), Utilidades.obtenerTexto("HORAS", idioma), Utilidades.obtenerTexto("CARGO", idioma));
        for (int i = 0; i < 3; i++) {
            System.out.printf(BORDE_IZQ + " %-15s %-15.1f $%-15.2f" + BORDE_DER + "%n", "Cliente " + (i + 1), horas[i], cargos[i]);
        }
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.printf(BORDE_IZQ + " %-30s $%-15.2f" + BORDE_DER + "%n", Utilidades.obtenerTexto("TOTAL", idioma), total);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarCalculos(double[] horas, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(Utilidades.obtenerTexto("CALCULOS", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        for (int i = 0; i < 3; i++) {
            double cargo = Operaciones.calcularCargos(horas[i]);
            String calculo = "";
            if (horas[i] <= 3) {
                calculo = "Cargo mínimo de $2.00 (hasta 3 horas)";
            } else if (horas[i] > 24) {
                calculo = "Cargo máximo de $10.00 (más de 24 horas)";
            } else {
                double horasExtra = horas[i] - 3;
                double cargoExtra = Math.ceil(horasExtra) * 0.50;
                calculo = String.format("2.00 + %d x 0.50 = %.2f (máx. $10.00)", (int)Math.ceil(horasExtra), Math.min(2.00 + cargoExtra, 10.00));
            }
            System.out.println(BORDE_IZQ + " Cliente " + (i + 1) + ": " + calculo + " ".repeat(ANCHO - 2 - calculo.length() - 10) + BORDE_DER);
        }
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarErrorEntrada(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(Utilidades.obtenerTexto("ERROR_ENTRADA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "RESULTADOS": return "Resultados de Estacionamiento";
                case "CLIENTE": return "Cliente";
                case "HORAS": return "Horas";
                case "CARGO": return "Cargo ($)";
                case "TOTAL": return "Total de Recibos";
                case "CALCULOS": return "Cálculos Realizados";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                case "ERROR_ENTRADA": return "Error: Ingrese un valor válido";
                default: return "";
            }
        } else {
            switch (clave) {
                case "RESULTADOS": return "Parking Results";
                case "CLIENTE": return "Client";
                case "HORAS": return "Hours";
                case "CARGO": return "Charge ($)";
                case "TOTAL": return "Total Receipts";
                case "CALCULOS": return "Calculations Performed";
                case "CONTINUAR": return "Do you want to continue? (Y/N): ";
                case "ERROR_ENTRADA": return "Error: Enter a valid value";
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
}