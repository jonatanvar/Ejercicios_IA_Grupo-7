/**
 * Sello Personalizado - Versión Completa
 * Autor: Erinson Josue Alvarez Garcia
 * Correo: erinson.alvarez@unah.hn
 * Fecha: 2025-10-09
 * Código de Ejercicio: 002
 * * Análisis: Este programa es una extensión del ejercicio #1. Su propósito es
 * hacer visible en la consola el "sello personalizado" definido para todos
 * los códigos. Utiliza la clase Utilidades para la presentación elegante.
 * * PROMPT USADO:
 * Mostrando el sello: El programa anterior no posee salida visible al usuario es 
 * por ello que ahora vamos a tomar como base el programa “defina un sello 
 * personalizado para el código” y vamos a mostrar al usuario dicho sello.
 */

 package Ejercicio_002_Erinson_Alvarez;

import static Ejercicio_002_Erinson_Alvarez.Utilidades.*;

public class Main {

    /**
     * Muestra el título del ejercicio con un borde decorativo.
     */
    public static void mostrarTitulo() {
        mostrarSeparadorDecorado();
        System.out.println(imprimirLineaCentrada("EJERCICIO 2", BORDE_VERTICAL, BORDE_VERTICAL));
        System.out.println(imprimirLineaCentrada("MOSTRANDO EL SELLO PERSONALIZADO", BORDE_VERTICAL, BORDE_VERTICAL));
        mostrarSeparadorDecorado();
        System.out.println();
    }
    
    /**
     * Método principal que ejecuta la secuencia del programa.
     * * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // 1. Mostrar el título del ejercicio
        mostrarTitulo();
        
        // 2. Mostrar el Sello Personalizado (el objetivo del ejercicio)
        mostrarSelloElegante();
        
        System.out.println("\n");
        mostrarSeparadorDecorado();
        System.out.println(imprimirLineaCentrada("<<< PROGRAMA FINALIZADO CON ÉXITO >>>"));
        mostrarSeparadorDecorado();
    }
}