package Ejercicio001_KevinLainez;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * SELLO PERSONALIZADO - VERSIÓN COMPLETA
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * Desarrollador    : Kevin Lainez
 * Correo           : klainezs@unah.hn
 * Fecha            : 2025-11-03
 * Ejercicio        : 001
 * Resumen          : Programa: Mostrar un saludo al usuario y la información
 * del sello personalizado en la consola, siguiendo el formato
 * del ejemplo proporcionado. Establece las Utilidades estéticas.
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                    │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 001 | 2025-11-03                    │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase principal que ejecuta el flujo del Ejercicio 001.
 * Muestra un saludo y la información detallada del sello personalizado.
 */
public class main {

    // Constantes específicas del sello
    private static final String DESARROLLADOR = "Kevin Lainez";
    private static final String CORREO = "klainezs@unah.hn";
    private static final String FECHA = "2025-11-03";
    private static final String EJERCICIO = "001";
    private static final String MENSAJE_SALUDO = "¡Bienvenido al Módulo de Programación Estructurada!";

    /**
     * Método principal que se ejecuta al iniciar el programa.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // 1. Mostrar Saludo al usuario con estética Unicode
        mostrarSaludo();
        utilidades.mostrarSeparadorDecorado();

        // 2. Mostrar la información completa del Sello Personalizado
        mostrarInformacionSello();

        utilidades.mostrarSeparadorDecorado();
        System.out.println(utilidades.centrarTexto("✅ Programa finalizado. ¡Utilidades estéticas listas!"));
        utilidades.mostrarSeparadorDecorado();
    }

    /**
     * Imprime un saludo al usuario usando bordes Unicode.
     */
    private static void mostrarSaludo() {
        int anchoInterior = utilidades.ANCHO_CONSOLA - 2;

        // 1. Calcular espacios para centrar el mensaje
        int longitudMensaje = MENSAJE_SALUDO.length();
        int espaciosTotales = anchoInterior - longitudMensaje;
        int espaciosIzq = espaciosTotales / 2;
        int espaciosDer = espaciosTotales - espaciosIzq;

        // 2. Imprimir los bordes y el mensaje
        System.out.println("╔" + "═".repeat(anchoInterior) + "╗");
        String lineaTexto = "║" + " ".repeat(espaciosIzq) + MENSAJE_SALUDO + " ".repeat(espaciosDer) + "║";
        System.out.println(lineaTexto);
        System.out.println("╚" + "═".repeat(anchoInterior) + "╝");
    }

    /**
     * Imprime en la consola la información del sello personalizado de forma estructurada.
     */
    private static void mostrarInformacionSello() {
        System.out.println(utilidades.centrarTexto("💎 INFORMACIÓN DETALLADA DEL SELLO PERSONALIZADO 💎"));
        utilidades.mostrarSeparadorDecorado();

        // Metadatos del Desarrollador
        System.out.println(utilidades.centrarTexto("»» Metadatos del Desarrollador ««"));
        System.out.println(utilidades.centrarTexto("Desarrollador: " + DESARROLLADOR));
        System.out.println(utilidades.centrarTexto("Correo: " + CORREO));

        utilidades.mostrarSeparadorDecorado();

        // Identificación del Código
        System.out.println(utilidades.centrarTexto("»» Identificación del Código ««"));
        System.out.println(utilidades.centrarTexto("Ejercicio No.: " + EJERCICIO));
        System.out.println(utilidades.centrarTexto("Fecha de Creación: " + FECHA));

        utilidades.mostrarSeparadorDecorado();

        // Características del Sello
        System.out.println(utilidades.centrarTexto("»» Características del Sello ««"));
        System.out.println(utilidades.centrarTexto("Versión Larga: Incluida en cada inicio de archivo (.java)"));
        System.out.println(utilidades.centrarTexto("Versión Corta: Incluida en la parte superior de los archivos utilitarios"));

        utilidades.mostrarSeparadorDecorado();

        // Uso del Sello (Versión Corta)
        System.out.println(utilidades.centrarTexto("»» Versión Corta del Sello ««"));
        utilidades.mostrarSelloCorto(DESARROLLADOR, CORREO, EJERCICIO, FECHA);
    }
}