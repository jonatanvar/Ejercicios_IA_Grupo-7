package Ejercicio058_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 058 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #58: Determinación de Múltiples (Ejercicio 6.20 Libro 1)
 * * PROMPT:
 * Escriba una función llamada multiple que determine, para un par de enteros,
 * si el segundo entero es múltiplo del primero. La función debe tomar dos
 * argumentos enteros y devolver true si el segundo es múltiplo del primero,
 * y false en caso contrario. Use esta función en un programa que reciba como
 * entrada una serie de pares de enteros.
 */
public class main {

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        utilidades.mostrarSaludo();

        // Variables para los pares
        int num1, num2;

        // --- INICIO DEL BUCLE DE PROCESAMIENTO ---
        System.out.println(utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(utilidades.centrarTexto("INGRESO DE PARES DE ENTEROS"));

        // 3. Primer par (para la condición del bucle)
        num1 = utilidades.solicitarEntero(sc, "Ingrese el PRIMER entero (Divisor, 0 para terminar):");

        // Bucle centinela: se detiene cuando el primer número (divisor) es 0
        while (num1 != 0) {

            // 4. Segundo número
            num2 = utilidades.solicitarEntero(sc, "Ingrese el SEGUNDO entero (Múltiplo):");

            // 5. Determinar y mostrar el resultado
            boolean esMultiple = operaciones.multiple(num1, num2);
            utilidades.mostrarResultado(num1, num2, esMultiple);

            // 6. Solicitar el siguiente par (reiniciar el bucle)
            System.out.println(utilidades.dibujarLineaHorizontal('├', '┤'));
            System.out.println(utilidades.centrarTexto("Siguiente Par..."));
            num1 = utilidades.solicitarEntero(sc, "Ingrese el PRIMER entero (Divisor, 0 para terminar):");
        }

        // --- FIN DEL BUCLE ---
        System.out.println(utilidades.dibujarLineaHorizontal('└', '┘'));
        System.out.println(utilidades.centrarTexto("Fin de la serie de entradas."));

        // 7. Mostrar Sello y finalizar
        utilidades.mostrarSelloCorto();
        System.out.println("\n--- Programa finalizado con éxito ---");

        // 8. Cerrar Scanner
        sc.close();
    }
}