/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 060 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Modificación del ejercicio "Alineado". Programa que dibuja un cuadrado relleno, cuyo lado y carácter de relleno son especificados por el usuario, utilizando una función obligatoria.
 */

package Ejercicio_060;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Módulo Operaciones: Implementa la lógica principal del negocio, que es
 * la lectura del lado y el carácter de relleno, y la función obligatoria
 * para dibujar el cuadrado.
 */
public class Operaciones {

    private final String idioma; // Almacena el idioma seleccionado

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Coordina la entrada de datos (lado y carácter) y llama a la función de dibujo.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void ejecutarDibujoCuadrado(Scanner scanner) {
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        
        // 1. Leer el Lado (entero)
        int lado = leerEntero(scanner, Utilidades.getTexto(idioma, "PROMPT_LADO"));
        
        // Si el lado es inválido o <= 0, terminamos.
        if (lado <= 0) {
            if (lado != Integer.MIN_VALUE) {
                 System.out.println(Utilidades.getTexto(idioma, "ERR_LADO_CERO"));
            }
            return;
        }

        // 2. Leer el Carácter de Relleno (char)
        char caracterRelleno = leerCaracter(scanner, Utilidades.getTexto(idioma, "PROMPT_CARACTER"));
        
        // 3. Dibujar el cuadrado (Función obligatoria)
        System.out.println("\n" + Utilidades.getTexto(idioma, "MSG_RESULTADO"));
        System.out.printf(Utilidades.getTexto(idioma, "MSG_PARAMETROS"), lado, caracterRelleno);
        
        dibujarCuadrado(lado, caracterRelleno);
    }
    
    /**
     * Función obligatoria: Muestra un cuadrado relleno de un carácter,
     * cuyo lado se especifica en el parámetro entero.
     * @param lado El número de filas y columnas del cuadrado.
     * @param caracterRelleno El carácter con el que se rellenará el cuadrado.
     */
    private void dibujarCuadrado(int lado, char caracterRelleno) {
        
        // El ciclo exterior controla las FILAS
        for (int i = 0; i < lado; i++) {
            
            // El ciclo interior controla las COLUMNAS
            for (int j = 0; j < lado; j++) {
                // Imprimir el carácter sin salto de línea (print en lugar de println)
                System.out.print(caracterRelleno); 
            }
            
            // Al finalizar el ciclo interior (al final de la fila), 
            // imprimir un salto de línea para pasar a la siguiente fila.
            System.out.println();
        }
    }

    // --- FUNCIONES AUXILIARES DE LECTURA ---
    
    /**
     * Lee y valida un valor de tipo entero (para el lado).
     * @param scanner El objeto Scanner.
     * @param prompt El mensaje a mostrar al usuario.
     * @return El valor entero leído, o Integer.MIN_VALUE si hubo error.
     */
    private int leerEntero(Scanner scanner, String prompt) {
        int valor = Integer.MIN_VALUE;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(prompt);
            try {
                if (scanner.hasNextInt()) {
                    valor = scanner.nextInt();
                    scanner.nextLine(); 
                    entradaValida = true;
                } else {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_INT"));
                    scanner.nextLine(); 
                }
            } catch (InputMismatchException e) {
                // Manejo de error ya cubierto por el else
            }
        }
        return valor;
    }
    
    /**
     * Lee un carácter del usuario. Si la entrada es una cadena, toma el primer carácter.
     * @param scanner El objeto Scanner.
     * @param prompt El mensaje a mostrar al usuario.
     * @return El primer carácter de la entrada, o '#' por defecto si hay un error serio.
     */
    private char leerCaracter(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String entrada = scanner.nextLine().trim(); // Lee toda la línea y quita espacios
        
        if (entrada.length() > 0) {
            return entrada.charAt(0);
        } else {
            // Si el usuario solo presiona Enter, pedimos una entrada válida
            System.out.println(Utilidades.getTexto(idioma, "ERR_CARACTER_VACIO"));
            // Intentar leer de nuevo
            return leerCaracter(scanner, prompt); 
        }
    }
}
