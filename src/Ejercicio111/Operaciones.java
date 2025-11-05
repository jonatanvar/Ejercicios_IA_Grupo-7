/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 111 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que realiza diversas operaciones (suma, transpuesta, llenado especial) con matrices cuadradas del mismo orden.
 */

package Ejercicio_111;

import java.util.Random;
import java.util.Arrays;

/**
 * Módulo Operaciones: Implementa la lógica de manipulación de matrices.
 * Contiene funciones para inicializar, llenar, sumar, obtener la transpuesta
 * y realizar llenados específicos (impares/pares).
 */
public class Operaciones {

    private final String idioma;
    private final int ORDEN = Utilidades.ORDEN_MATRIZ;
    private final Random random = new Random();

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    // --- FUNCIONES DE ALTO NIVEL (CORRESPONDEN A LAS OPCIONES DEL MENÚ) ---

    /**
     * Opción a: Llenar ambas matrices con números aleatorios, mostrarlas y mostrar la suma.
     */
    public void opcionLlenadoYSuma() {
        // Inicializar matrices
        int[][] A = inicializarMatriz(ORDEN);
        int[][] B = inicializarMatriz(ORDEN);
        
        // Llenar con números aleatorios (rango 1 a 100)
        llenarAleatorio(A, 1, 100);
        llenarAleatorio(B, 1, 100);

        // Mostrar
        imprimirMatriz(A, Utilidades.getTexto(idioma, "TITULO_MATRIZ_A_ALEATORIO"));
        imprimirMatriz(B, Utilidades.getTexto(idioma, "TITULO_MATRIZ_B_ALEATORIO"));
        
        // Sumar y mostrar resultado
        int[][] C = sumarMatrices(A, B);
        imprimirMatriz(C, Utilidades.getTexto(idioma, "TITULO_MATRIZ_C_SUMA"));
    }

    /**
     * Opción b: Reiniciar, llenar la primera con aleatorios y la segunda con la transpuesta.
     */
    public void opcionTranspuesta() {
        // Reiniciar e Inicializar
        int[][] A = inicializarMatriz(ORDEN);
        int[][] B = inicializarMatriz(ORDEN); // B actuará como la transpuesta
        
        // Llenar A con aleatorios (rango 1 a 99)
        llenarAleatorio(A, 1, 99);
        
        // Calcular Transpuesta y guardarla en B
        obtenerTranspuesta(A, B); // B ahora es A transpuesta
        
        // Mostrar
        imprimirMatriz(A, Utilidades.getTexto(idioma, "TITULO_MATRIZ_A_TRANS_ORIGINAL"));
        imprimirMatriz(B, Utilidades.getTexto(idioma, "TITULO_MATRIZ_B_TRANS_RESULTADO"));
    }

    /**
     * Opción c: Reiniciar, llenar A con impares y B con A[i][j] - 1 (pares).
     */
    public void opcionLlenadoImparPar() {
        // Reiniciar e Inicializar
        int[][] A = inicializarMatriz(ORDEN);
        int[][] B = inicializarMatriz(ORDEN);
        
        // Llenar A con impares y B con el valor - 1 (par)
        llenarImparesPares(A, B);
        
        // Mostrar
        imprimirMatriz(A, Utilidades.getTexto(idioma, "TITULO_MATRIZ_A_IMPAR"));
        imprimirMatriz(B, Utilidades.getTexto(idioma, "TITULO_MATRIZ_B_PAR"));
    }

    // --- FUNCIONES ESPECÍFICAS DE MATRICES ---

    /**
     * Inicializa una matriz cuadrada al orden predefinido con ceros.
     * @param orden El tamaño (NxN).
     * @return La matriz inicializada.
     */
    private int[][] inicializarMatriz(int orden) {
        // Los arreglos en Java se inicializan automáticamente a 0 (cero)
        return new int[orden][orden];
    }
    
    /**
     * Llena una matriz con números aleatorios dentro de un rango especificado.
     * @param matriz La matriz a modificar.
     * @param min El valor mínimo (inclusive).
     * @param max El valor máximo (inclusive).
     */
    private void llenarAleatorio(int[][] matriz, int min, int max) {
        int rango = max - min + 1;
        for (int i = 0; i < ORDEN; i++) {
            for (int j = 0; j < ORDEN; j++) {
                matriz[i][j] = random.nextInt(rango) + min;
            }
        }
    }

    /**
     * Suma dos matrices y retorna el resultado en una nueva matriz.
     * @param A Primera matriz.
     * @param B Segunda matriz.
     * @return La matriz resultado C = A + B.
     */
    private int[][] sumarMatrices(int[][] A, int[][] B) {
        int[][] C = inicializarMatriz(ORDEN);
        for (int i = 0; i < ORDEN; i++) {
            for (int j = 0; j < ORDEN; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    /**
     * Calcula la transpuesta de la matriz A y la almacena en la matriz B.
     * La transpuesta intercambia filas por columnas (A[i][j] -> B[j][i]).
     * @param A Matriz original.
     * @param B Matriz donde se guardará la transpuesta (debe ser del mismo orden).
     */
    private void obtenerTranspuesta(int[][] A, int[][] B) {
        for (int i = 0; i < ORDEN; i++) {
            for (int j = 0; j < ORDEN; j++) {
                B[j][i] = A[i][j]; // Lógica de transposición
            }
        }
    }
    
    /**
     * Llena la matriz A con números impares secuenciales y la matriz B con
     * el valor de A menos 1 (número par).
     * Nota: Para simplicidad, los impares comienzan en 1.
     * @param A Matriz de destino para impares.
     * @param B Matriz de destino para (impar - 1).
     */
    private void llenarImparesPares(int[][] A, int[][] B) {
        int valorImpar = 1;
        for (int i = 0; i < ORDEN; i++) {
            for (int j = 0; j < ORDEN; j++) {
                A[i][j] = valorImpar; // Impar
                B[i][j] = A[i][j] - 1; // Impar - 1 (Par)
                
                // Aseguramos que el siguiente valor a insertar sea impar
                valorImpar += 2; 
            }
        }
    }

    /**
     * Imprime una matriz de forma organizada en la consola.
     * @param matriz La matriz a imprimir.
     * @param titulo El título o descripción a mostrar.
     */
    public void imprimirMatriz(int[][] matriz, String titulo) {
        System.out.println("\n" + titulo);
        System.out.println("-------------------------------------");
        for (int i = 0; i < ORDEN; i++) {
            // Imprimir la fila completa como una cadena para formato
            System.out.print("| ");
            for (int j = 0; j < ORDEN; j++) {
                // Usamos formato para alinear los números
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("-------------------------------------");
    }
}