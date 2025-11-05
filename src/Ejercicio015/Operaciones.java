/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 015 | 2025-10-22
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que imprime un cuadro, un óvalo, una flecha y un diamante utilizando caracteres en la consola.
 */

package Ejercicio_015;

/**
 * Módulo Operaciones: Contiene la lógica principal del programa, que en este caso
 * es la función de "dibujar" o imprimir cada una de las figuras requeridas.
 */
public class Operaciones {

    /**
     * Devuelve el título o encabezado del programa.
     * @return Título del programa.
     */
    public String getTitulo() {
        return "=== EJERCICIO 15: IMPRESIÓN DE FIGURAS EN ASCII ===\n";
    }

    /**
     * Imprime un cuadro (rectángulo) simple en la consola.
     */
    public void imprimirCuadro() {
        System.out.println("--- CUADRO ---");
        System.out.println("************");
        System.out.println("* *");
        System.out.println("* *");
        System.out.println("************");
    }

    /**
     * Imprime una forma que se asemeja a un óvalo en la consola.
     */
    public void imprimirOvalo() {
        System.out.println("--- ÓVALO ---");
        System.out.println("    *** ");
        System.out.println("  * * ");
        System.out.println(" * * ");
        System.out.println("  * * ");
        System.out.println("    *** ");
    }

    /**
     * Imprime una figura que se asemeja a una flecha (apuntando hacia arriba).
     */
    public void imprimirFlecha() {
        System.out.println("--- FLECHA ---");
        System.out.println("      * ");
        System.out.println("     *** ");
        System.out.println("    ***** ");
        System.out.println("      * ");
        System.out.println("      * ");
        System.out.println("      * ");
    }

    /**
     * Imprime una figura que se asemeja a un diamante (rombo).
     */
    public void imprimirDiamante() {
        System.out.println("--- DIAMANTE ---");
        System.out.println("      * ");
        System.out.println("     * * ");
        System.out.println("    * * ");
        System.out.println("     * * ");
        System.out.println("      * ");
    }
}
