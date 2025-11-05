package Ejercicio023_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 023 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #23: Cuadrado Hueco (Ejercicio 4.25 Libro 1)
 * * PROMPT:
 * Escriba un programa que pida al usuario que introduzca el tamaño del lado de
 * un cuadrado y que muestre un cuadrado hueco de ese tamaño, compuesto de
 * asteriscos y espacios en blanco. Su programa debe funcionar con cuadrados
 * que tengan lados de todas las longitudes entre 1 y 20.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // 3. Captura y validación del lado
        int lado = utilidades.solicitarLado(sc);

        // 4. Mostrar el encabezado de resultados
        utilidades.mostrarEncabezadoResultado(lado);

        // 5. Dibujar el cuadrado hueco (lógica en MiLibreria.java)
        // La clase operaciones imprime directamente en la consola.
        System.out.print(utilidades.BORDE_IZQ + "  "); // Alineación inicial
        operaciones.dibujarCuadradoHueco(lado);
        System.out.println(utilidades.centrarTexto("")); // Línea de relleno estética

        // 6. Mostrar el pie de página de los resultados
        utilidades.mostrarPieResultado();

        // 7. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");
        sc.close();
    }
}