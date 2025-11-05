/**
 * Ejercicio001_Main.java
 * Rol: Controla el flujo principal del programa, mostrando los sellos personalizados
 * (versión completa y corta) en cuadros elegantes para el ejercicio EJ-002.
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
 * Mostrando el sello: El programa anterior no posee salida visible al usuario es por ello que ahora
 * vamos a tomar como base el programa “defina un sello personalizado para el código” y vamos a
 * mostrar al usuario dicho sello.
 * Corrección: Ahora sería el ejercicio 002.
 * Nueva solicitud: La salida solo debe mostrar el sello (completo y corto) con bordes perfectos.
 */
package Ejercicio_2_Lis;

public class Ejercicio002_Main {
    public static void main(String[] args) {
        // Mostrar sello personalizado corto
        Ejercicio002_Utilidades.mostrarSelloCorto("002", "2025-10-10");

        // Mostrar encabezado completo
        Ejercicio002_Utilidades.mostrarEncabezadoCompleto("002", "2025-10-10");

        // Mostrar sello personalizado corto nuevamente
        Ejercicio002_Utilidades.mostrarSelloCorto("002", "2025-10-10");
    }
}