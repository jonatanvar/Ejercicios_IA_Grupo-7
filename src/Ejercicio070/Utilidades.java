/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 070 | 2025-10-17               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio070;

public class Utilidades {
    public static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    public static void mostrarSello() {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto("SELLO PERSONALIZADO - VERSIÓN CORTA", ANCHO - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto("Jonatan Varela | jivarelag@unah.hn | 070 | 2025-10-17", ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarRespuesta(int numero, boolean esCorrecta, String idioma) {
        String mensaje = Operaciones.obtenerMensaje(esCorrecta, idioma);
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("RESPUESTA", idioma) + " " + numero, ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.println(BORDE_IZQ + " " + (esCorrecta ? obtenerTexto("CORRECTA", idioma) : obtenerTexto("INCORRECTA", idioma)) + " ".repeat(ANCHO - 2 - mensaje.length() - 12) + BORDE_DER);
        System.out.println(BORDE_IZQ + " " + mensaje + " ".repeat(ANCHO - 2 - mensaje.length() - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarResultados(int correctas, int incorrectas, double porcentaje, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("RESULTADOS", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.printf(BORDE_IZQ + " %-20s %-20s %-20s" + BORDE_DER + "%n", obtenerTexto("CORRECTAS", idioma), obtenerTexto("INCORRECTAS", idioma), obtenerTexto("PORCENTAJE", idioma));
        System.out.printf(BORDE_IZQ + " %-20d %-20d %-20.1f%%" + BORDE_DER + "%n", correctas, incorrectas, porcentaje);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
        if (porcentaje < 75) {
            System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
            System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("MENSAJE_BAJO", idioma), ANCHO - 2) + BORDE_DER);
            System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
        }
    }

    public static void mostrarCalculos(int correctas, int incorrectas, double porcentaje, String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("CALCULOS", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┤");
        System.out.println(BORDE_IZQ + " Total respuestas: 10" + " ".repeat(ANCHO - 2 - 20) + BORDE_DER);
        System.out.println(BORDE_IZQ + " Correctas: " + correctas + " ".repeat(ANCHO - 2 - 12 - String.valueOf(correctas).length()) + BORDE_DER);
        System.out.println(BORDE_IZQ + " Incorrectas: " + incorrectas + " ".repeat(ANCHO - 2 - 13 - String.valueOf(incorrectas).length()) + BORDE_DER);
        System.out.println(BORDE_IZQ + " Porcentaje: (" + correctas + " / 10) * 100 = " + porcentaje + "%" + " ".repeat(ANCHO - 2 - 30 - String.valueOf(porcentaje).length()) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static void mostrarErrorEntrada(String idioma) {
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(obtenerTexto("ERROR_ENTRADA", idioma), ANCHO - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(ANCHO - 2) + "┘");
    }

    public static String obtenerTexto(String clave, String idioma) {
        if (idioma.equals("ES")) {
            switch (clave) {
                case "INGRESE_RESPUESTA": return "Ingrese el tipo de respuesta para la pregunta ";
                case "RESPUESTA": return "Respuesta";
                case "CORRECTA": return "Correcta";
                case "INCORRECTA": return "Incorrecta";
                case "RESULTADOS": return "Resultados Finales";
                case "CORRECTAS": return "Respuestas Correctas";
                case "INCORRECTAS": return "Respuestas Incorrectas";
                case "PORCENTAJE": return "Porcentaje Correcto";
                case "MENSAJE_BAJO": return "Puntaje insuficiente (<75%), estudie más";
                case "CALCULOS": return "Cálculos Realizados";
                case "CONTINUAR": return "¿Desea continuar? (S/N): ";
                case "ERROR_ENTRADA": return "Error: Ingrese un valor válido";
                default: return "";
            }
        } else {
            switch (clave) {
                case "INGRESE_RESPUESTA": return "Enter the type of answer for question ";
                case "RESPUESTA": return "Answer";
                case "CORRECTA": return "Correct";
                case "INCORRECTA": return "Incorrect";
                case "RESULTADOS": return "Final Results";
                case "CORRECTAS": return "Correct Answers";
                case "INCORRECTAS": return "Incorrect Answers";
                case "PORCENTAJE": return "Correct Percentage";
                case "MENSAJE_BAJO": return "Score below 75%, study more";
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