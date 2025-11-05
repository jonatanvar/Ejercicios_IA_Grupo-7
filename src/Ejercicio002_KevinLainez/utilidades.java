package Ejercicio002_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                    │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 002 | 2025-11-03                    │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de Utilidades para la guía de ejercicios.
 * Contiene métodos estáticos para el formato y la estética de la consola.
 * Es reutilizado del Ejercicio 001.
 */
public class utilidades {

    // Constantes de diseño
    public static final int ANCHO_CONSOLA = 70;
    private static final char LINEA_HORIZONTAL = '═';
    private static final String RELLENO_ESPACIO = " ";

    /**
     * Centra una cadena de texto dado el ANCHO_CONSOLA (70).
     * @param texto La cadena de texto a centrar.
     * @return La cadena de texto centrada o el texto original si es demasiado largo.
     */
    public static String centrarTexto(String texto) {
        int longitudTexto = texto.length();

        // Evita IllegalArgumentException si el texto es demasiado largo.
        if (longitudTexto >= ANCHO_CONSOLA) {
            return texto;
        }

        int espaciosDisponibles = ANCHO_CONSOLA - longitudTexto;
        int espaciosLaterales = espaciosDisponibles / 2;

        String espacioIzquierdo = RELLENO_ESPACIO.repeat(espaciosLaterales);
        String espacioDerecho = RELLENO_ESPACIO.repeat(espaciosDisponibles - espaciosLaterales);

        return espacioIzquierdo + texto + espacioDerecho;
    }

    /**
     * Imprime una línea decorativa completa (═) del ancho de la consola (70).
     */
    public static void mostrarSeparadorDecorado() {
        System.out.println(String.valueOf(LINEA_HORIZONTAL).repeat(ANCHO_CONSOLA));
    }

    /**
     * Imprime la versión corta del sello personalizado.
     * @param desarrollador Nombre del desarrollador.
     * @param correo Correo electrónico.
     * @param ejercicio Número del ejercicio.
     * @param fecha Fecha de creación.
     */
    @SuppressWarnings("unused")
    public static void mostrarSelloCorto(String desarrollador, String correo, String ejercicio, String fecha) {
        int anchoInterior = ANCHO_CONSOLA - 2;
        String lineaHorizontal = String.valueOf(LINEA_HORIZONTAL).repeat(anchoInterior);

        String linea1 = "┌" + lineaHorizontal + "┐";

        // Centramos el encabezado
        String textoEncabezado = "SELLO PERSONALIZADO - VERSIÓN CORTA";
        String linea2Centrada = centrarTexto(textoEncabezado);
        String linea2 = "│" + linea2Centrada.substring(0, anchoInterior) + "│";

        String linea3 = "├" + lineaHorizontal + "┤";

        // Contenido de la línea: | Kevin Lainez | klainezs@unah.hn | 002 | 2025-11-03
        String contenidoBase = "  " + desarrollador + " | " + correo + " | " + ejercicio + " | " + fecha;

        // Calculamos el relleno para el borde final
        int padding = ANCHO_CONSOLA - contenidoBase.length() - 1;
        String contenido = "│" + contenidoBase + RELLENO_ESPACIO.repeat(padding) + "│";

        String linea4 = "└" + lineaHorizontal + "┘";

        System.out.println(linea1);
        System.out.println(linea2);
        System.out.println(linea3);
        System.out.println(contenido);
        System.out.println(linea4);
    }
}