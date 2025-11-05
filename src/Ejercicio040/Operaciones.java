/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 040 | 2025-10-23
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que lee una serie de enteros no negativos (deteniéndose en el primero negativo) y luego imprime una tabla con N, N², N³, 2N-1 y sus totales, utilizando un ciclo para la lectura y menús de idioma y control.
 */

package Ejercicio_040;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Módulo Operaciones: Implementa la lógica principal del negocio.
 * Gestiona la lectura de una serie de enteros no negativos (detenida por un negativo),
 * calcula N, N², N³, 2N-1 y sus totales, y luego imprime la tabla.
 */
public class Operaciones {

    private final String idioma; // Almacena el idioma seleccionado

    // Variables acumuladoras (usamos long para evitar desbordamiento en N^3)
    private long totalN = 0;
    private long totalN2 = 0;
    private long totalN3 = 0;
    private long total2N1 = 0;
    
    // Lista para almacenar los números positivos ingresados
    private final List<Integer> numerosPositivos = new ArrayList<>();
    
    // Variable para almacenar el valor centinela (el número negativo que detuvo la entrada)
    private int centinela = 0;

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Coordina la entrada de datos (ciclo de lectura) y la impresión de la tabla.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void procesarYMostrarTabla(Scanner scanner) {
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        System.out.println(Utilidades.getTexto(idioma, "MSG_INSTRUCCION_LECTURA"));
        
        // 1. Ejecutar el ciclo de lectura y cálculo de totales
        leerNumerosYAcumularTotales(scanner);
        
        // 2. Imprimir la tabla completa con los resultados
        imprimirTabla();
    }

    /**
     * Utiliza un ciclo while para leer números hasta que se ingresa un negativo.
     * Almacena los números positivos y acumula los totales de las columnas.
     * @param scanner El objeto Scanner.
     */
    private void leerNumerosYAcumularTotales(Scanner scanner) {
        int numero;
        boolean continuar = true;

        while (continuar) {
            System.out.print(Utilidades.getTexto(idioma, "PROMPT_ENTERO"));
            
            try {
                if (scanner.hasNextInt()) {
                    numero = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    
                    if (numero >= 0) {
                        // Es un número positivo o cero: se almacena y se calculan los totales
                        numerosPositivos.add(numero);
                        
                        long n = numero;
                        long n2 = n * n;
                        long n3 = n * n * n;
                        long dosN1 = 2 * n - 1;
                        
                        // Acumular totales
                        totalN += n;
                        totalN2 += n2;
                        totalN3 += n3;
                        total2N1 += dosN1;
                        
                    } else {
                        // Es el centinela (número negativo): se almacena y se detiene el ciclo
                        centinela = numero;
                        continuar = false;
                    }
                } else {
                    // Manejo de entrada no numérica
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA"));
                    scanner.nextLine(); // Limpiar la entrada inválida
                }
            } catch (InputMismatchException e) {
                // Ya manejado por el if/else
            }
        }
    }

    /**
     * Imprime la tabla con los datos individuales y la fila de totales.
     */
    private void imprimirTabla() {
        
        if (numerosPositivos.isEmpty()) {
            System.out.println(Utilidades.getTexto(idioma, "MSG_SIN_DATOS"));
            return;
        }
        
        // Formato para asegurar la alineación de las columnas
        String formatoFilaDatos = "| %-2d | %-5d | %-7d | %-10d | %-7d |%n";
        String formatoFilaCentinela = "| %-2d | %-5d | %-7s | %-10s | %-7s |%n";
        String formatoFilaTotales = "| %-8s | %-7d | %-10d | %-7d |%n";
        String formatoFilaSeparacion = "+----+-------+---------+------------+---------+%n";

        // Imprimir Encabezado
        System.out.println("\n" + Utilidades.getTexto(idioma, "MSG_TITULO_TABLA"));
        System.out.printf(formatoFilaSeparacion);
        System.out.printf("| %-2s | %-5s | %-7s | %-10s | %-7s |%n", 
            Utilidades.getTexto(idioma, "COL_INDICE"), 
            Utilidades.getTexto(idioma, "COL_N"),
            Utilidades.getTexto(idioma, "COL_N2"),
            Utilidades.getTexto(idioma, "COL_N3"),
            Utilidades.getTexto(idioma, "COL_2N1"));
        System.out.printf(formatoFilaSeparacion);

        // Imprimir Filas de Datos
        int indice = 1;
        for (int n : numerosPositivos) {
            long n2 = (long)n * n;
            long n3 = (long)n * n * n;
            long dosN1 = 2L * n - 1;
            
            System.out.printf(formatoFilaDatos, indice++, n, n2, n3, dosN1);
        }
        
        // Imprimir Fila del Centinela (si no es 0)
        if (centinela != 0) {
            System.out.printf(formatoFilaSeparacion);
            System.out.printf(formatoFilaCentinela, indice, centinela, "", "", "");
        }
        
        // Imprimir Fila de Totales
        System.out.printf(formatoFilaSeparacion);
        
        // La fila de totales no tiene índice (#) ni el primer valor (N) es sumado en la columna N
        // Por eso el formato de la fila de totales es diferente, unificando las dos primeras columnas en una etiqueta.
        System.out.printf("| %-8s | %-7d | %-10d | %-7d |%n",
            Utilidades.getTexto(idioma, "COL_TOTALES"),
            totalN2, 
            totalN3, 
            total2N1);
            
        System.out.printf(formatoFilaSeparacion);
    }
}
