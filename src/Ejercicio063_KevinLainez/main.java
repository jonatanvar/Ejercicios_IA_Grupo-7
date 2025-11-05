package Ejercicio063_KevinLainez;

import java.util.List;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 063 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #63: Números Perfectos (Ejercicio 6.29 Libro 1)
 * * PROMPT:
 * Escriba una función llamada perfecto que determine si el parámetro número es
 * un número perfecto. Use esta función en un programa que determine e imprima
 * todos los números perfectos entre 1 y 1000. Imprima los divisores de cada
 * número perfecto para confirmar que el número sea realmente perfecto.
 */
public class main {

    private static final int LIMITE_BASE = 1000;

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // 3. Solicitar límite de búsqueda (cumple la prueba de poder)
        int limiteBusqueda = utilidades.solicitarLimite(sc, LIMITE_BASE);

        // 4. Mostrar encabezado de resultados
        utilidades.mostrarEncabezadoResultados(limiteBusqueda);

        // 5. Bucle principal para buscar números perfectos
        for (int numero = 1; numero <= limiteBusqueda; numero++) {

            // Llama a la función 'perfecto' para verificar la condición
            if (operaciones.perfecto(numero)) {

                // Si es perfecto, obtenemos y mostramos los divisores
                List<Integer> divisores = operaciones.obtenerDivisores(numero);
                utilidades.mostrarNumeroPerfecto(numero, divisores);
            }
        }

        // 6. Mostrar pie de página
        utilidades.mostrarPieResultados();

        // 7. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");

        // 8. Cerrar Scanner
        sc.close();
    }
}