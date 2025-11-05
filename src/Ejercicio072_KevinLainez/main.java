package Ejercicio072_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 072 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #72: Área de Círculo (Ejercicio 6.55 Libro 1)
 * * PROMPT:
 * Escriba un programa en JAVA que pida al usuario el radio de un círculo y
 * después llame a la función inline areaCirculo para calcular el área de ese círculo.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // 3. Captura y validación del radio
        double radio = utilidades.solicitarRadio(sc);

        // 4. Llamada a la función areaCirculo (simulando la llamada "inline")
        double area = operaciones.areaCirculo(radio);

        // 5. Mostrar Resultados
        utilidades.mostrarResultado(radio, area);

        // 6. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");

        // 7. Cerrar Scanner
        sc.close();
    }
}