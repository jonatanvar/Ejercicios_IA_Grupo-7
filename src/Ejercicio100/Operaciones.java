/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 100 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que ordena un arreglo de 10 enteros ingresados por el usuario mediante el algoritmo de Ordenamiento de Burbuja.
 */

package Ejercicio_100;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays; // Utilizado solo para mostrar el arreglo de forma rápida en la consola

/**
 * Módulo Operaciones: Contiene la lógica de negocio para la lectura del arreglo,
 * la implementación del algoritmo de Ordenamiento de Burbuja, y la impresión
 * de los resultados.
 */
public class Operaciones {

    private final String idioma;

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Función para leer e inicializar un arreglo de enteros con validación.
     * Cumple con el requisito de Validación de Entradas.
     * @param scanner El objeto Scanner para la entrada de datos.
     * @param tamaño El tamaño del arreglo (debe ser 10).
     * @return El arreglo de enteros lleno, o null si la lectura fue interrumpida por un error.
     */
    public int[] leerArreglo(Scanner scanner, int tamaño) {
        int[] arreglo = new int[tamaño];
        System.out.println(Utilidades.getTexto(idioma, "MSG_INSTRUCCIONES_ENTRADA"));
        
        for (int i = 0; i < tamaño; i++) {
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.printf(Utilidades.getTexto(idioma, "PROMPT_ENTRADA_ELEMENTO"), i + 1, tamaño);
                
                try {
                    // Verificar si el siguiente token es un entero
                    if (scanner.hasNextInt()) {
                        arreglo[i] = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        entradaValida = true;
                    } else {
                        // Manejo de error si no se ingresa un entero
                        System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_INT"));
                        scanner.nextLine(); // Descartar la entrada inválida
                    }
                } catch (InputMismatchException e) {
                    // Esto debería ser cubierto por el hasNextInt/else, pero se deja por seguridad
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_INT"));
                    scanner.nextLine();
                }
            }
        }
        return arreglo;
    }

    /**
     * Implementación del algoritmo de Ordenamiento de Burbuja (Bubble Sort).
     * El algoritmo compara pares sucesivos e intercambia si están en orden descendente.
     * Cumple con el requisito de Función Obligatoria. 
     * @param arr El arreglo de enteros a ordenar (se ordena in place).
     */
    public void ordenamientoBurbuja(int[] arr) {
        int n = arr.length;
        int temp;
        
        // Bucle exterior: Controla el número de pasadas (n-1 pasadas)
        for (int i = 0; i < n - 1; i++) {
            // Bucle interior: Realiza las comparaciones e intercambios en cada pasada
            // En cada pasada, el elemento más grande "burbujea" al final (n-1-i)
            for (int j = 0; j < n - 1 - i; j++) {
                
                // Si el elemento actual es mayor que el siguiente, se intercambian
                if (arr[j] > arr[j + 1]) {
                    // Intercambio (swap)
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Función para mostrar el contenido de un arreglo.
     * Cumple con el requisito de uso de Funciones.
     * @param arr El arreglo a imprimir.
     * @param titulo El título o descripción a mostrar antes del arreglo.
     */
    public void mostrarArreglo(int[] arr, String titulo) {
        System.out.println("\n" + titulo);
        // Usamos la utilidad Arrays.toString para una impresión limpia
        System.out.println(Arrays.toString(arr));
    }
}