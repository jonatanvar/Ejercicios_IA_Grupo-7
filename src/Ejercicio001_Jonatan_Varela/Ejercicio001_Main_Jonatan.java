/*
 * ═══════════════════════════════════════════════════════════════════════════
 *                    SELLO PERSONALIZADO - VERSIÓN COMPLETA
 * ═══════════════════════════════════════════════════════════════════════════
 *
 * Desarrollador    : Jonatan Varela
 * Correo           : jivarelag@unah.hn
 * Fecha            : 2025-10-09
 * Ejercicio        : 001
 *
 * PROMPT USADO:
 * "agente empecemos con el ejercicio #1 ya te cargue mis datos así que
 *  ya los tienes, genera una salida muy atractiva, como los ejemplos dados
 * anteriormente. el enunciado es el siguiente: Defina un sello personalizado
 *  para el código: Aprovechando la implementación de comentarios en los
 * lenguajes de programación cree un encabezado elegante con el que han de
 *  comenzar todos los códigos que usted desarrolle, el mismo debe poseer
 * una versión corta para cuando trabaje modularmente con otras personas.
 *  No olvide incluir en el encabezado su nombre, apodo (si gusta),
 * correo electrónico fecha y, en el caso particular de la clase un
 * código correlativo para el ejercicio contenido en ésta guía; además recuerde
 * que el código debe ir documentado por lo que el espacio para análisis/resumen
 *  puede incluirse en el encabezado y personalizarse; una vez lo tenga listo
 *  usted debe elaborar un programa that muestre un saludo al usuario and
 * luego muestre the encabezado del inciso anterior."
 *
 * ═══════════════════════════════════════════════════════════════════════════
 */
/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 001 | 2025-10-09               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio001_Jonatan_Varela;

public class Ejercicio001_Main_Jonatan {
    // Constantes para caracteres de diseño
    private static final String LINEA = "═";
    private static final int ANCHO = 70;

    /**
     * Método principal que ejecuta el flujo secuencial del programa
     */
    public static void main(String[] args) {
        // 1. Mostrar saludo elegante al usuario
        Ejercicio001_Utilidades.mostrarSaludo();

        // 2. Mostrar información sobre el sello creado
        Ejercicio001_Utilidades.mostrarInformacionSello();

        // 3. Mensaje de finalización
        System.out.println("\n" + LINEA.repeat(ANCHO));
        System.out.println("*** El sello personalizado ha sido definido exitosamente ***");
        System.out.println(LINEA.repeat(ANCHO));
    }
}