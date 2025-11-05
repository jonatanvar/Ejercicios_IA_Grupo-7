package Ejercicio103_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 103 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #103: Simulación de Tiro de Dados (Ejercicio 7.17 Libro 1)
 * * PROMPT:
 * Escriba un programa para simular el tiro de dos dados. El programa debe
 * utilizar rand para tirar el primer dado, y de nuevo para tirar el segundo dado.
 * Después debe calcularse la suma de los dos valores. Su programa debe tirar
 * los dados 36,000 veces. Utilice un arreglo unidimensional para registrar el
 * número de veces que aparezca cada una de las posibles sumas. Imprima los
 * resultados en formato tabular. Determine además si los totales son razonables.
 */
public class main {

    public static void main(String[] args) {

        // 1. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo(operaciones.TIROS);

        // 2. Ejecutar la simulación y obtener el arreglo de frecuencias
        int[] frecuencias = operaciones.simularTiroDados();

        // 3. Imprimir los resultados en formato tabular
        utilidades.imprimirTablaResultados(frecuencias, operaciones.TIROS);

        // 4. Determinar si los totales son razonables
        utilidades.validarRazonabilidad(frecuencias);

        // 5. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
    }
}