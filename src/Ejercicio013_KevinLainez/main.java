package Ejercicio013_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 013 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #13: Par o Impar (Ejercicio 2.24 Libro 1)
 * * PROMPT:
 * Escriba un programa que lea un entero y que determine e imprima si es impar o par.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // 3. Captura del entero dentro de un cuadro
        System.out.println(utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("INGRESO DEL NÚMERO"));

        int numero = utilidades.solicitarEntero(sc);

        // Cerramos el cuadro de ingreso (la última línea horizontal ya fue dibujada por solicitarEntero)
        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));

        // 4. Lógica de Par o Impar
        String resultado;

        // Usamos el operador módulo (%), si el residuo de la división entre 2 es 0, es PAR.
        if (numero % 2 == 0) {
            resultado = "PAR";
        } else {
            resultado = "IMPAR";
        }

        // 5. Mostrar Resultados
        utilidades.mostrarResultado(numero, resultado);

        // 6. Mostrar Sello y mensaje de finalización
        utilidades.mostrarSelloCorto();

        System.out.println("\n--- Programa finalizado con éxito ---");

        // 7. Cerrar Scanner
        sc.close();
    }
}