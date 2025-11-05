package Ejercicio033_KevinLainez;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 033 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #33: Patrones con Ciclos for (Ejercicio 5.12 Libro 1)
 * * PROMPT:
 * Escriba un programa que utilice ciclos for para generar los siguientes
 * patrones por separado, uno debajo del otro. Use ciclos for para generar
 * los patrones. Todos los asteriscos (*) deben imprimirse mediante una sola
 * instrucción de la forma cout << '*';
 */
public class main {

    public static void main(String[] args) {

        // 1. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // 2. Mostrar el encabezado del área de resultados
        utilidades.mostrarEncabezadoPatrones();

        // 3. Dibujar los cuatro patrones de forma secuencial

        // Es importante notar que los métodos de la clase 'operaciones'
        // imprimen directamente en la consola sin usar utilidades para el formato
        // de cuadros internos, ya que la naturaleza del dibujo del patrón lo impide.

        operaciones.dibujarPatronA();
        operaciones.dibujarPatronB();
        operaciones.dibujarPatronC();
        operaciones.dibujarPatronD();

        // 4. Mostrar el pie de página
        utilidades.mostrarPiePatrones();

        // 5. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
    }
}