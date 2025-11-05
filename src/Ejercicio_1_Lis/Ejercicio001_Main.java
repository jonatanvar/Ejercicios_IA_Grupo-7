/**
 * Ejercicio001_Main.java
 * Rol: Controla el flujo principal del programa, mostrando un saludo al usuario
 * y los encabezados personalizado (versión completa y corta) en cuadros elegantes.
 *
 * Prompt utilizado:
 * Defina un sello personalizado para el código: Aprovechando la implementación de comentarios
 * en los lenguajes de programación cree un encabezado elegante con el que han de comenzar
 * todos los códigos que usted desarrolle, el mismo debe poseer una versión corta para cuando
 * trabaje modularmente con otras personas. No olvide incluir en el encabezado su nombre, apodo
 * (si gusta), correo electrónico, fecha y, en el caso particular de la clase un código correlativo
 * para el ejercicio contenido en esta guía; además recuerde que el código debe ir documentado por
 * lo que el espacio para análisis/resumen puede incluirse en el encabezado y personalizarse; una vez
 * lo tenga listo usted debe elaborar un programa que muestre un saludo al usuario y luego muestre el
 * encabezado del inciso anterior. El programa debe dividirse solo en Main y Utilidades.
 */
package Ejercicio_1_Lis;

public class Ejercicio001_Main {
    // Constantes para el formato de salida
    private static final int ANCHO = 70;
    private static final String BORDE_IZQ = "│ ";
    private static final String BORDE_DER = " │";
    private static final String LINEA_H = "─";

    public static void main(String[] args) {
        // Mostrar sello personalizado corto (como encabezado)
        Ejercicio001_Utilidades.mostrarSelloCorto("009", "2025-10-15");

        // Mostrar cuadro de bienvenida
        Ejercicio001_Utilidades.mostrarSaludo();

        // Mostrar encabezado completo
        Ejercicio001_Utilidades.mostrarEncabezadoCompleto("009", "2025-10-15");

        // Mostrar encabezado corto
        Ejercicio001_Utilidades.mostrarSelloCorto("009", "2025-10-15");

        // Mensaje de cierre
        System.out.println("═".repeat(70));
        System.out.println(centrarTexto("*** Operaciones completadas exitosamente ***", 70));
        System.out.println("═".repeat(70));
    }

    // Método para centrar texto (reubicado aquí para el mensaje de cierre)
    private static String centrarTexto(String texto, int ancho) {
        int longitudTexto = texto.length();
        if (longitudTexto >= ancho - 4) {
            return BORDE_IZQ + texto.substring(0, ancho - 4) + BORDE_DER;
        }
        int espacios = (ancho - 4 - longitudTexto) / 2;
        return BORDE_IZQ + " ".repeat(espacios) + texto + " ".repeat(ancho - 4 - longitudTexto - espacios) + BORDE_DER;
    }
}