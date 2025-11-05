/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 030 | 2025-10-23
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que utiliza un ciclo for para encontrar el menor de varios enteros, donde el primer valor leído especifica el número de valores restantes. Incluye menús de idioma y control.
 */

package Ejercicio_030;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Módulo Operaciones: Implementa la lógica principal del negocio.
 * Gestiona la entrada del número de valores (N) y utiliza un ciclo 'for'
 * para encontrar el menor de los N enteros subsecuentes.
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
     * Coordina la entrada de datos (cantidad y valores) y ejecuta la búsqueda del mínimo.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void encontrarMenorDeEnteros(Scanner scanner) {
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        
        // 1. Leer el número de valores a procesar (N)
        int n = leerCantidadDeValores(scanner);
        
        if (n <= 0) {
            System.out.println(Utilidades.getTexto(idioma, "MSG_CANTIDAD_INSUFICIENTE"));
            return;
        }
        
        // 2. Ejecutar la lógica de búsqueda del mínimo
        buscarYMostrarMenor(scanner, n);
    }

    /**
     * Solicita al usuario la cantidad de números (N) a ingresar y valida que sea positivo.
     * @param scanner El objeto Scanner.
     * @return El número de valores (N), o -1 si la entrada es inválida.
     */
    private int leerCantidadDeValores(Scanner scanner) {
        int n = -1;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(Utilidades.getTexto(idioma, "PROMPT_CANTIDAD_VALORES"));
            try {
                if (scanner.hasNextInt()) {
                    n = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    if (n > 0) {
                        entradaValida = true;
                    } else if (n == 0) {
                        return 0; // Permite salir si N=0
                    } else {
                        System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_NEGATIVA"));
                    }
                } else {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA"));
                    scanner.nextLine(); // Limpiar entrada
                }
            } catch (InputMismatchException e) {
                // Ya manejado por el if/else si la entrada no es un entero
            }
        }
        return n;
    }

    /**
     * Utiliza un ciclo for para leer N valores y encontrar el menor.
     * @param scanner El objeto Scanner.
     * @param n La cantidad de valores a leer.
     */
    private void buscarYMostrarMenor(Scanner scanner, int n) {
        int menorValor = 0;
        int valorActual;
        boolean primerValorLeido = false;
        
        System.out.println(Utilidades.getTexto(idioma, "MSG_INSTRUCCION_VALORES") + n + Utilidades.getTexto(idioma, "MSG_PUNTOS"));
        
        // El ciclo 'for' se ejecuta N veces para leer los valores restantes
        for (int i = 1; i <= n; i++) {
            System.out.print(Utilidades.getTexto(idioma, "PROMPT_VALOR") + i + ": ");
            
            try {
                if (scanner.hasNextInt()) {
                    valorActual = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    
                    if (!primerValorLeido) {
                        // Inicializar el menorValor con el primer número de la secuencia
                        menorValor = valorActual;
                        primerValorLeido = true;
                    } else if (valorActual < menorValor) {
                        // Si el valor actual es menor que el mínimo encontrado hasta ahora
                        menorValor = valorActual;
                    }
                } else {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA"));
                    scanner.nextLine(); // Limpiar la entrada inválida y reintentar la iteración (i no se incrementa si se hace correctamente)
                    i--; // Decrementar 'i' para repetir la lectura del mismo valor
                }
            } catch (InputMismatchException e) {
                // Manejo de error ya cubierto por el 'else' dentro del ciclo
            }
        }
        
        // Muestra el resultado final
        if (primerValorLeido) {
            System.out.printf(Utilidades.getTexto(idioma, "MSG_RESULTADO_MENOR"), menorValor);
        }
    }
}
