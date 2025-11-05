/**
 * Sello Personalizado - Versión Completa
 * Autor: Erinson Josue Alvarez Garcia (Erinson Alvarez)
 * Correo: erinson.alvarez@unah.hn
 * Fecha: 2025-10-09
 * Código de Ejercicio: 001
 * * Análisis: Este programa muestra un saludo elegante al usuario y a continuación
 * presenta el encabezado o "sello personalizado" definido para todos los códigos
 * del desarrollador. Utiliza funciones de la clase Utilidades para la estética.
 * * PROMPT USADO:
 * Defina un sello personalizado para el código: Aprovechando la implementación de 
 * comentarios en los lenguajes de programación cree un encabezado elegante con 
 * el que han de comenzar todos los códigos que usted desarrolle, el mismo debe 
 * poseer una versión corta para cuando trabaje modularmente con otras personas. 
 * No olvide incluir en el encabezado su nombre, apodo (si gusta), correo 
 * electrónico fecha y, en el caso particular de la clase un código correlativo 
 * para el ejercicio contenido en ésta guía; además recuerde que el código debe 
 * ir documentado por lo que el espacio para análisis/resumen puede incluirse en 
 * el encabezado y personalizarse; una vez lo tenga listo usted debe elaborar un 
 * programa que muestre un saludo al usuario y luego muestre el encabezado del 
 * inciso anterior.
 */

 package Ejercicio_001_Erinson_Alvarez;

import static Ejercicio_001_Erinson_Alvarez.Utilidades.*;

public class Main {
    
    // --- Metadatos del Desarrollador (Para el Sello) ---
    private static final String AUTOR = "Erinson Josue Alvarez Garcia (Erinson Alvarez)";
    private static final String CORREO = "erinson.alvarez@unah.hn";
    private static final String FECHA = "2025-10-09";
    private static final String CODIGO_EJERCICIO = "1";
    
    // --- Sello Personalizado - Versión Corta (Para Archivos Modulares) ---
    private static final String SELLO_CORTO = "Erinson Alvarez | erinson.alvarez@unah.hn | 001 | 2025-10-09";

    /**
     * Muestra el saludo inicial al usuario con un borde decorativo.
     */
    public static void mostrarSaludo() {
        System.out.println("\n");
        // Borde superior
        System.out.println("╔" + centrarTexto("").substring(1, ANCHO_CONSOLA - 1).replace(' ', '═') + "╗");
        
        // Contenido
        System.out.println("║" + centrarTexto("¡BIENVENIDO AL PROGRAMA!") + "║");
        System.out.println("║" + centrarTexto("Ejercicio 1: Definición de Sello") + "║");
        
        // Borde inferior
        System.out.println("╚" + centrarTexto("").substring(1, ANCHO_CONSOLA - 1).replace(' ', '═') + "╝");
        System.out.println("\n");
    }

    /**
     * Muestra toda la información detallada del sello personalizado.
     */
    public static void mostrarSello() {
        mostrarSeparadorDecorado();
        System.out.println(centrarTexto("** ENCABEZADO PERSONALIZADO - VERSIÓN COMPLETA **"));
        mostrarSeparadorDecorado();
        
        System.out.println(centrarTexto("Autor: " + AUTOR));
        System.out.println(centrarTexto("Correo: " + CORREO));
        System.out.println(centrarTexto("Fecha: " + FECHA));
        System.out.println(centrarTexto("Código de Ejercicio: " + CODIGO_EJERCICIO));
        
        mostrarSeparadorDecorado();
        System.out.println(centrarTexto("** Sello Personalizado - Versión Corta **"));
        mostrarSeparadorDecorado();
        
        System.out.println(centrarTexto(SELLO_CORTO));
        
        mostrarSeparadorDecorado();
        System.out.println(centrarTexto("Fin de la Demostración del Sello."));
        mostrarSeparadorDecorado();
    }

    /**
     * Método principal que ejecuta la secuencia del programa.
     * * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // 1. Mostrar Saludo al Usuario
        mostrarSaludo();
        
        // 2. Mostrar el Sello Personalizado
        mostrarSello();
        
        System.out.println("\n" + centrarTexto("--- PROGRAMA FINALIZADO ---"));
    }
}