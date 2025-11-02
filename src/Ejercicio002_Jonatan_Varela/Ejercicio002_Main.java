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
 * PROMPT USADO:
 * "agente ahora el #2 con el siguiente enunciado: Mostrando el sello: El programa anterior no posee salida visible al usuario es por ello que ahora vamos a tomar como base el programa “defina un sello personalizado para el código” y vamos a mostrar al usuario dicho sello. muestra un sello elegante como habíamos hecho en el #1, te cuerdo que tu ya tienes mis datos para ponerlo en el sello, y a ahora muestra el prompt solo en el archivo .Main"
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

public class Ejercicio002_Main {
    // Constantes para caracteres de diseño
    private static final String LINEA = "═";
    private static final int ANCHO = 70;

    /**
     * Método principal que ejecuta el flujo secuencial del programa
     */
    public static void main(String[] args) {
        // 1. Mostrar saludo elegante al usuario
        Ejercicio002_Utilidades.mostrarSaludo();

        // 2. Mostrar información sobre el sello creado
        Ejercicio002_Utilidades.mostrarInformacionSello();

        // 3. Mensaje de finalización
        System.out.println("\n" + LINEA.repeat(ANCHO));
        System.out.println("*** El sello personalizado ha sido mostrado exitosamente ***");
        System.out.println(LINEA.repeat(ANCHO));
    }
}