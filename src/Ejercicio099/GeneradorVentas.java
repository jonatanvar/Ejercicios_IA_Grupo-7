package Ejercicio099;

import java.util.Random;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 099 | 2025-10-21
 * Librería propia para la generación de ventas y cálculo de salario.
 */
public class GeneradorVentas {

    private static final Random generador = new Random();
    private static final int MIN_VENDEDORES = 20;
    private static final int MAX_VENDEDORES = 50;
    private static final double COMISION_PORCENTAJE = 0.09;
    private static final double SALARIO_BASE = 200.0;
    // Rango de ventas para simulación (0 a 10000)
    private static final int MIN_VENTAS = 0;
    private static final int MAX_VENTAS = 10000;

    /**
     * Genera un número aleatorio de vendedores dentro del rango [20, 50].
     * @return Número de vendedores.
     */
    public static int generarNumeroVendedores() {
        return generador.nextInt(MAX_VENDEDORES - MIN_VENDEDORES + 1) + MIN_VENDEDORES;
    }

    /**
     * Calcula el salario de un vendedor a partir de sus ventas totales.
     * El salario se trunca a un entero.
     * Salario = $200 + 9% * Ventas
     * @param ventas Ventas totales de la semana.
     * @return El salario truncado (entero).
     */
    public static int calcularSalario(double ventas) {
        double salarioBruto = SALARIO_BASE + (COMISION_PORCENTAJE * ventas);
        return (int) salarioBruto;
    }

    /**
     * Genera los salarios truncados para un número dado de vendedores.
     * @param numVendedores Número de vendedores.
     * @return Arreglo de salarios enteros.
     */
    public static int[] generarSalarios(int numVendedores) {
        int[] salarios = new int[numVendedores];

        for (int i = 0; i < numVendedores; i++) {

            double ventas = generador.nextDouble() * (MAX_VENTAS - MIN_VENTAS) + MIN_VENTAS;
            salarios[i] = calcularSalario(ventas);
        }
        return salarios;
    }
}