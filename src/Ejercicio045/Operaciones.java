/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 045 | 2025-10-23
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que calcula la potencia B^E (donde E puede ser positivo, negativo o cero) sin usar Math.pow, implementando menús de idioma y control.
 */

package Ejercicio_045;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Módulo Operaciones: Implementa la lógica principal del negocio, que es la
 * lectura de la base y el exponente, y el cálculo de la potencia B^E
 * sin utilizar la librería Math.
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
     * Coordina la entrada de datos de la base y el exponente, y ejecuta el cálculo de potencia.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void ejecutarCalculoPotencia(Scanner scanner) {
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        
        // 1. Leer la Base (double)
        double base = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_BASE"));
        if (base == Double.MIN_VALUE) { // Valor de retorno de error
            return;
        }

        // 2. Leer el Exponente (int)
        int exponente = leerEntero(scanner, Utilidades.getTexto(idioma, "PROMPT_EXPONENTE"));
        if (exponente == Integer.MIN_VALUE) { // Valor de retorno de error
            return;
        }
        
        // Manejar el caso especial: 0 elevado a potencia negativa (Indeterminado o Infinito)
        if (base == 0 && exponente < 0) {
            System.out.println(Utilidades.getTexto(idioma, "ERR_BASE_CERO_NEGATIVO"));
            return;
        }

        // 3. Calcular la potencia
        double resultado = calcularPotencia(base, exponente);

        // 4. Mostrar el resultado
        System.out.printf(Utilidades.getTexto(idioma, "MSG_RESULTADO"), base, exponente, resultado);
        System.out.println();
    }

    /**
     * Calcula la potencia B^E sin usar Math.pow.
     * Maneja casos E=0, E>0 y E<0.
     * @param base El número base (B).
     * @param exponente El exponente (E).
     * @return El resultado de B^E.
     */
    private double calcularPotencia(double base, int exponente) {
        
        // Caso 1: Exponente Cero (E = 0) -> B^0 = 1
        if (exponente == 0) {
            return 1.0;
        }

        double resultadoParcial = 1.0;
        int exponenteAbsoluto = exponente > 0 ? exponente : -exponente; // |E|
        
        // Calcular la potencia positiva (B^|E|) usando un ciclo for
        for (int i = 0; i < exponenteAbsoluto; i++) {
            resultadoParcial *= base;
        }

        // Caso 2: Exponente Negativo (E < 0) -> B^(-|E|) = 1 / B^|E|
        if (exponente < 0) {
            // El resultadoParcial ya contiene B^|E|
            return 1.0 / resultadoParcial;
        }
        
        // Caso 3: Exponente Positivo (E > 0)
        return resultadoParcial;
    }

    /**
     * Lee y valida un valor de tipo double.
     * @param scanner El objeto Scanner.
     * @param prompt El mensaje a mostrar al usuario.
     * @return El valor double leído, o Double.MIN_VALUE si hubo error.
     */
    private double leerDouble(Scanner scanner, String prompt) {
        double valor = Double.MIN_VALUE;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(prompt);
            try {
                if (scanner.hasNextDouble()) {
                    valor = scanner.nextDouble();
                    scanner.nextLine(); 
                    entradaValida = true;
                } else {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_DOUBLE"));
                    scanner.nextLine(); 
                }
            } catch (InputMismatchException e) {
                // Manejo de error ya cubierto por el else
            }
        }
        return valor;
    }
    
    /**
     * Lee y valida un valor de tipo entero.
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
}
