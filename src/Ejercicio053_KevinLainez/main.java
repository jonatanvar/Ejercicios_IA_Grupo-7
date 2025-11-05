package Ejercicio053_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 053 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #53: Convertidor de Temperaturas
 * * PROMPT:
 * Vamos a desarrollar un convertidor de temperaturas para ello se presenta un
 * menú donde indicamos la escala de temperatura inicial, luego se pide la escala
 * de temperatura final y, finalmente se lee la temperatura en la escala inicial.
 * El sistema debe entonces mostrar la temperatura inicial y la temperatura final
 * cada una en su correspondiente escala. Se debe programar una función que reciba
 * temperatura inicial, escala inicial, escala final y regrese el valor de la
 * temperatura en la escala final.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // --- PASO 1: SELECCIÓN DE ESCALA INICIAL ---
        String escalaInicial = utilidades.solicitarEscala(sc, "SELECCIONE LA ESCALA INICIAL", null);

        // --- PASO 2: SELECCIÓN DE ESCALA FINAL ---
        // Se excluye la escala inicial de las opciones.
        String escalaFinal = utilidades.solicitarEscala(sc, "SELECCIONE LA ESCALA FINAL DE CONVERSIÓN", escalaInicial);

        // --- PASO 3: INGRESO DE TEMPERATURA ---
        double tempInicial = utilidades.solicitarTemperatura(sc, escalaInicial);

        // --- PASO 4: CONVERSIÓN ---
        double tempFinal = operaciones.convertirTemperatura(tempInicial, escalaInicial, escalaFinal);

        // --- PASO 5: MOSTRAR RESULTADOS ---
        utilidades.mostrarResultado(tempInicial, escalaInicial, tempFinal, escalaFinal);

        // 6. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");

        // 7. Cerrar Scanner
        sc.close();
    }
}