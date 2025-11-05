package Ejercicio008_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 008 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #8: Operaciones con Cuatro Números
 * * PROMPT:
 * Tomando como base el programa “Jugando con tres números” hagamos un programa
 * que lea cuatro números, los ordene de mayor a menor y los muestre ordenados
 * luego muestre su suma, promedio, producto, menor y mayor.
 */
public class Main {

    private static final int CANTIDAD_NUMEROS = 4;

    public static void main(String[] args) {
        // 1. Inicializar Scanner
        Scanner sc = new Scanner(System.in);

        // 2. Mostrar cuadro de bienvenida
        Utilidades.mostrarSaludo();

        // Array para almacenar los cuatro números
        double[] numeros = new double[CANTIDAD_NUMEROS];

        // 3. Captura de datos dentro de un cuadro
        System.out.println(Utilidades.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(Utilidades.centrarTexto("INGRESO DE CUATRO NÚMEROS"));

        // Solicitamos los 4 números usando la utilidad
        for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
            // El método solicitarNumero ya se encarga del formato de entrada
            numeros[i] = Utilidades.solicitarNumero(sc, i + 1);
        }

        // Cerramos el cuadro de ingreso (la última línea horizontal ya fue dibujada por solicitarNumero)
        System.out.println(Utilidades.dibujarLineaHorizontal('└', '┘'));

        // 4. Cálculos y Ordenamiento

        // Ordenamiento de mayor a menor (retorna Double[])
        Double[] numerosOrdenados = Operaciones.ordenarMayorAMenor(numeros);

        // Operaciones Aritméticas
        double suma = Operaciones.calcularSuma(numeros);
        double promedio = Operaciones.calcularPromedio(numeros);
        double producto = Operaciones.calcularProducto(numeros);
        double mayor = Operaciones.encontrarMayor(numeros);
        double menor = Operaciones.encontrarMenor(numeros);

        // 5. Mostrar Resultados
        Utilidades.mostrarResultado(numerosOrdenados, suma, promedio, producto, mayor, menor);

        // 6. Mostrar Sello y mensaje de finalización
        Utilidades.mostrarSelloCorto();

        System.out.println("\n--- Programa finalizado con éxito ---");

        // 7. Cerrar Scanner
        sc.close();
    }
}