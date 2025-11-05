package Ejercicio076_KevinLainez;

import Ejercicio076_KevinLainez.utilidades.AngulosValidados;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 076 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #76: Validación y Tabla de Ángulos
 * * PROMPT:
 * Usando la librería math.h haga un programa que solicite al usuario dos ángulos
 * con las siguientes restricciones: Ambos ángulos deben estar entre 0 y 360.
 * El segundo ángulo debe ser mayor que el primero con opción a intercambio o relectura.
 * Imprimir una tabla de funciones trigonométricas.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // 3. Gestión y Validación de Ángulos (cumpliendo las restricciones)
        AngulosValidados angulos = utilidades.gestionarAngulos(sc);

        double angulo1 = angulos.angulo1;
        double angulo2 = angulos.angulo2;

        // 4. Imprimir la Tabla Trigonométrica
        operaciones.imprimirTablaTrigonometrica(angulo1, angulo2);

        // 5. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");

        // 6. Cerrar Scanner
        sc.close();
    }
}