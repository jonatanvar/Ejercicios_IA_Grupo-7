package Ejercicio094_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 094 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #94: Vector Aleatorio y Ordenado
 * * PROMPT:
 * Haga un programa que inicialice un vector de 100 elementos con números
 * aleatorios y luego los sume, presente los elementos ordenados de menor a
 * mayor y el total.
 */
public class main {

    private static final int TAMANO_VECTOR = 100;

    public static void main(String[] args) {

        // 1. Mostrar cuadro de bienvenida
        MiLibreria.mostrarSaludo("VECTOR ALEATORIO Y ORDENAMIENTO");

        // 2. Inicializar el vector
        int[] vector = new int[TAMANO_VECTOR];

        // 3. Llenar el vector con números aleatorios
        operaciones.inicializarVectorAleatorio(vector);

        // 4. Sumar los elementos
        long totalSuma = operaciones.sumarVector(vector);

        // 5. Ordenar el vector
        operaciones.ordenarVector(vector);

        // --- SALIDA DE RESULTADOS ---

        // 6. Mostrar elementos ordenados
        utilidades.mostrarVectorOrdenado(vector);

        // 7. Mostrar la suma total
        utilidades.mostrarTotal(totalSuma);

        // 8. Mostrar Sello y finalizar
        MiLibreria.mostrarSelloCorto("094");

        System.out.println("\n--- Programa finalizado con éxito ---");
    }
}