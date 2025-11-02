/*
 * ═══════════════════════════════════════════════════════════════════════════
 *                    SELLO PERSONALIZADO - VERSIÓN COMPLETA
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * Desarrollador    : Jonatan Varela
 * Correo           : jivarelag@unah.hn
 * Fecha            : 2025-10-09
 * Ejercicio        : 002
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */

/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 002 | 2025-10-09               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio002_Jonatan_Varela;

public class Ejercicio002_Utilidades {
    // Constantes para caracteres de diseño
    private static final String LINEA = "═";
    private static final int ANCHO = 70;
    private static final char BORDE_IZQ = '│';
    private static final char BORDE_DER = '│';
    private static final char LINEA_H = '─';

    /**
     * Subrutina que muestra el saludo inicial al usuario
     */
    public static void mostrarSaludo() {
        System.out.println("\n╔" + LINEA.repeat(ANCHO - 2) + "╗");
        System.out.println("║" + centrarTexto("¡Bienvenido al Sistema de Gestión de Código!", ANCHO - 2) + "║");
        System.out.println("║" + centrarTexto("Ejercicio 002: Mostrando el Sello Personalizado", ANCHO - 2) + "║");
        System.out.println("╚" + LINEA.repeat(ANCHO - 2) + "╝");
    }

    /**
     * Subrutina que muestra la información del sello creado
     */
    public static void mostrarInformacionSello() {
        System.out.println("\n" + LINEA.repeat(ANCHO));
        System.out.println(centrarTexto("INFORMACIÓN DEL SELLO PERSONALIZADO MOSTRADO", ANCHO));
        System.out.println(LINEA.repeat(ANCHO));

        System.out.println("\n  📋 Metadatos del Desarrollador:");
        System.out.println("     • Nombre Completo  : Jonatan Varela");
        System.out.println("     • Correo           : jivarelag@unah.hn");
        System.out.println("     • Fecha            : 2025-10-09");

        System.out.println("\n  🔢 Identificación del Código:");
        System.out.println("     • Código Ejercicio : 002");

        System.out.println("\n  📝 Características del Sello:");
        System.out.println("     ✓ Incluye versión completa (comentarios al inicio)");
        System.out.println("     ✓ Incluye versión corta (para trabajo modular)");
        System.out.println("     ✓ Contiene espacio para análisis/resumen");
        System.out.println("     ✓ Formato elegante y estandarizado");

        System.out.println("\n  💡 Uso del Sello:");
        System.out.println("     Este encabezado se utilizará en TODOS los ejercicios");
        System.out.println("     desarrollados, asegurando consistencia y profesionalismo");
        System.out.println("     en la documentación del código.");

        System.out.println("\n  📌 Versión Corta (para módulos):");
        mostrarSelloCortaEnConsola();
    }

    /**
     * Subrutina para mostrar el sello versión corta en consola como un cuadro simétrico
     */
    public static void mostrarSelloCortaEnConsola() {
        String titulo = "SELLO PERSONALIZADO - VERSIÓN CORTA";
        String autor = "Autor: Jonatan Varela | jivarelag@unah.hn";
        String fechaEjercicio = "Fecha: 2025-10-09 | Ejercicio: 002";

        int anchoCuadro = 70; // Ancho simétrico
        System.out.println("\n┌" + String.valueOf(LINEA_H).repeat(anchoCuadro - 2) + "┐");
        System.out.println(BORDE_IZQ + centrarTexto(titulo, anchoCuadro - 2) + BORDE_DER);
        System.out.println("├" + String.valueOf(LINEA_H).repeat(anchoCuadro - 2) + "┤");
        System.out.println(BORDE_IZQ + centrarTexto(autor, anchoCuadro - 2) + BORDE_DER);
        System.out.println(BORDE_IZQ + centrarTexto(fechaEjercicio, anchoCuadro - 2) + BORDE_DER);
        System.out.println("└" + String.valueOf(LINEA_H).repeat(anchoCuadro - 2) + "┘");
    }

    /**
     * Función auxiliar que centra un texto dentro de un ancho dado
     * @param texto El texto a centrar
     * @param ancho El ancho total disponible
     * @return String con el texto centrado y espacios de relleno
     */
    public static String centrarTexto(String texto, int ancho) {
        int espaciosTotal = ancho - texto.length();
        int espaciosIzq = espaciosTotal / 2;
        int espaciosDer = espaciosTotal - espaciosIzq;

        String resultado = "";

        // Espacios izquierdos
        for (int i = 0; i < espaciosIzq; i++) {
            resultado += " ";
        }

        resultado += texto;

        // Espacios derechos
        for (int i = 0; i < espaciosDer; i++) {
            resultado += " ";
        }

        return resultado;
    }
}