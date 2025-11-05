package Ejercicio114_KevinLainez;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 114 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Representa un valle encontrado con sus detalles.
 */
class Valle {
    int fila;
    int columna;
    int valor;
    List<Integer> vecinos;

    public Valle(int fila, int columna, int valor, List<Integer> vecinos) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
        this.vecinos = vecinos;
    }
}

/**
 * Clase que contiene la lógica para inicializar la matriz y detectar valles.
 */
public class operaciones {

    private static final Random generador = new Random();

    /**
     * Inicializa una matriz con números aleatorios (0 a 999).
     * @param matriz La matriz a inicializar.
     */
    public static void inicializarMatrizAleatoria(int[][] matriz) {
        // Usamos nextInt(1000) para generar números en el rango [0, 999]
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = generador.nextInt(1000);
            }
        }
    }

    /**
     * Obtiene los valores de los 8 vecinos de una celda dada.
     * Asume que la celda tiene 8 vecinos (no es borde/esquina).
     * @param matriz La matriz.
     * @param r Índice de fila (desde 0).
     * @param c Índice de columna (desde 0).
     * @return Lista de los 8 valores vecinos.
     */
    private static List<Integer> obtenerValoresVecinos(int[][] matriz, int r, int c) {
        List<Integer> vecinos = new ArrayList<>();

        // Coordenadas relativas de los 8 vecinos
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1}; // Cambio en filas
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1}; // Cambio en columnas

        for (int i = 0; i < 8; i++) {
            vecinos.add(matriz[r + dr[i]][c + dc[i]]);
        }
        return vecinos;
    }

    /**
     * Detección de Valles: Comprueba si un valor es menor que todos sus vecinos.
     * @param valor Celda candidata.
     * @param vecinos Lista de 8 valores vecinos.
     * @return true si el valor es menor que todos sus vecinos.
     */
    private static boolean esValle(int valor, List<Integer> vecinos) {
        for (int vecino : vecinos) {
            if (valor >= vecino) {
                return false; // El valor debe ser ESTRICTAMENTE menor
            }
        }
        return true;
    }

    /**
     * Encuentra todos los valles en la matriz, excluyendo los bordes.
     * @param matriz La matriz a analizar.
     * @return Lista de objetos Valle con los detalles.
     */
    public static List<Valle> encontrarValles(int[][] matriz) {
        List<Valle> vallesEncontrados = new ArrayList<>();
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Solo se consideran celdas internas (no bordes) para asegurar 8 vecinos.
        // Bucle de i va desde 1 hasta filas-2 (excluye fila 0 y la última fila)
        // Bucle de j va desde 1 hasta columnas-2 (excluye columna 0 y la última columna)
        for (int i = 1; i < filas - 1; i++) {
            for (int j = 1; j < columnas - 1; j++) {

                int valorCelda = matriz[i][j];
                List<Integer> vecinos = obtenerValoresVecinos(matriz, i, j);

                if (esValle(valorCelda, vecinos)) {
                    // Se crea el objeto Valle con coordenadas base 1 (i+1, j+1)
                    vallesEncontrados.add(new Valle(i + 1, j + 1, valorCelda, vecinos));
                }
            }
        }
        return vallesEncontrados;
    }
}