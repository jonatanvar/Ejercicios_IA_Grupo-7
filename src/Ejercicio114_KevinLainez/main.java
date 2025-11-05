package Ejercicio114_KevinLainez;

import java.util.List;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 114 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #114: Identificación de Valles en una Matriz
 * * PROMPT:
 * Una matriz tiene un valle si el valor de una de sus celdas es menor que el
 * de cualquiera de sus 8 celdas vecinas. Haga un programa que lea una matriz
 * (el usuario te indicará cuántas filas y columnas) y nos diga si la matriz
 * tiene un valle o no. Las casillas que no tienen 8 vecinos no se consideran
 * candidatas a ser valle.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // --- ENTRADA DE DIMENSIONES ---
        System.out.println(utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("DEFINICIÓN DE LA MATRIZ"));

        // 3. Solicitar y validar filas y columnas
        int filas = utilidades.solicitarDimension(sc, "Filas");
        int columnas = utilidades.solicitarDimension(sc, "Columnas");

        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));

        // 4. Inicializar y llenar la matriz
        int[][] matriz = new int[filas][columnas];
        operaciones.inicializarMatrizAleatoria(matriz);

        // 5. Mostrar Matriz generada
        utilidades.mostrarMatriz(matriz);

        // 6. Encontrar Valles (lógica en operaciones.java)
        List<Valle> vallesEncontrados = operaciones.encontrarValles(matriz);

        // 7. Mostrar Resultados
        utilidades.mostrarResultados(vallesEncontrados);

        // 8. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");

        // 9. Cerrar Scanner
        sc.close();
    }
}