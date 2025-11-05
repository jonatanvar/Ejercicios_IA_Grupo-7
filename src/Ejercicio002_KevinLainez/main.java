package Ejercicio002_KevinLainez;

/**
 * ═══════════════════════════════════════════════════════════════════════════
 * SELLO PERSONALIZADO - VERSIÓN COMPLETA
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * Desarrollador    : Kevin Lainez
 * Correo           : klainezs@unah.hn
 * Fecha            : 2025-11-03
 * Ejercicio        : 002
 * Resumen          : Tomando como base el programa anterior, este ejercicio
 * elabora el programa que muestra un saludo al usuario y luego
 * muestra el encabezado del sello personalizado en la consola,
 * asegurando salida visible.
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                    │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 002 | 2025-11-03                    │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase principal que ejecuta el flujo del Ejercicio 002.
 * Muestra un saludo y la información detallada del sello personalizado.
 */
public class main {

    // Constantes específicas del sello
    private static final String DESARROLLADOR = "Kevin Lainez";
    private static final String CORREO = "klainezs@unah.hn";
    private static final String FECHA = "2025-11-03";
    private static final String EJERCICIO = "002";
    private static final String MENSAJE_SALUDO = "¡Iniciando Ejercicio 002: Mostrando el Sello!";

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
        System.out.println(utilidades.centrarTexto("✅ Ejercicio 002 finalizado con éxito."));
        utilidades.mostrarSeparadorDecorado();
    }

    /**
     * Imprime un saludo al usuario usando bordes Unicode, aprovechando
     * las constantes de Utilidades.
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

        // Uso del Sello (Versión Corta)
        System.out.println(utilidades.centrarTexto("»» Versión Corta del Sello ««"));
        utilidades.mostrarSelloCorto(DESARROLLADOR, CORREO, EJERCICIO, FECHA);
    }
}