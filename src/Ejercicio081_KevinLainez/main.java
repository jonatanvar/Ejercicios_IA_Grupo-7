package Ejercicio081_KevinLainez;

// IMPORTACIÓN DE LA LIBRERÍA PROPIA
/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 081 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #81: Implementación de Librería Propia (Estructura Simplificada)
 * * PROMPT:
 * Modifique el programa del ejercicio “Imprimiendo líneas” para implementar
 * una librería propia.
 */
public class main {

    public static void main(String[] args) {

        // 1. Mostrar cuadro de bienvenida (usando la librería MiLibreria)
        MiLibreria.mostrarSaludo("USANDO LIBRERÍA EXTERNA Y ESTRUCTURA SIMPLE");

        // 2. Ejecutar la operación de dibujo (la operación ahora reside directamente en la librería)
        MiLibreria.dibujarPatronDeLineas();

        // 3. Mostrar Sello y finalizar (usando la librería)
        MiLibreria.mostrarSelloCorto("081");

        System.out.println("\n--- Programa finalizado con éxito ---");
    }
}