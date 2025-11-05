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
 * Archivo principal del programa (Main).
 * Se encarga del punto de inicio y de orquestar la llamada a las operaciones
 * de impresión de figuras.
 */
public class Main {

    /**
     * Punto de entrada principal del programa.
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        
        // Instancia de la clase Operaciones, que contiene la lógica de impresión de las figuras
        Operaciones impresorDeFiguras = new Operaciones();

        // Muestra un encabezado (podría estar en Menus.java, pero por simplicidad se incluye aquí)
        System.out.println(impresorDeFiguras.getTitulo());

        // Imprime las figuras en orden
        
        // 1. Cuadro
        impresorDeFiguras.imprimirCuadro();
        
        // Separador visual
        Utilidades.imprimirSeparador();

        // 2. Óvalo
        impresorDeFiguras.imprimirOvalo();

        // Separador visual
        Utilidades.imprimirSeparador();

        // 3. Flecha
        impresorDeFiguras.imprimirFlecha();

        // Separador visual
        Utilidades.imprimirSeparador();

        // 4. Diamante
        impresorDeFiguras.imprimirDiamante();
    }
}
