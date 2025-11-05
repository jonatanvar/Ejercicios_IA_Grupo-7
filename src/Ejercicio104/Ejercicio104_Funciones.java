package Ejercicio104;

public class Ejercicio104_Funciones {

    private static final int VENDEDORES = GeneradorVentas.NUM_VENDEDORES;
    private static final int PRODUCTOS = GeneradorVentas.NUM_PRODUCTOS;

    public static double[][] procesarVentas(double[][] transacciones) {
        double[][] ventas = new double[PRODUCTOS + 1][VENDEDORES + 1];

        for (double[] transaccion : transacciones) {
            int numVendedor = (int) transaccion[0];
            int numProducto = (int) transaccion[1];
            double valorVenta = transaccion[2];

            ventas[numProducto][numVendedor] += valorVenta;
        }

        return ventas;
    }

    public static double[][] calcularTotalesCruzados(double[][] ventas) {
        final int FILAS_FINAL = PRODUCTOS + 2;
        final int COLS_FINAL = VENDEDORES + 2;

        double[][] resultado = new double[FILAS_FINAL][COLS_FINAL];

        for (int i = 1; i <= PRODUCTOS; i++) {
            double totalFila = 0;
            for (int j = 1; j <= VENDEDORES; j++) {
                resultado[i][j] = ventas[i][j];
                totalFila += ventas[i][j];
            }
            resultado[i][VENDEDORES + 1] = totalFila;
        }

        for (int j = 1; j <= VENDEDORES + 1; j++) {
            double totalColumna = 0;
            for (int i = 1; i <= PRODUCTOS; i++) {
                totalColumna += resultado[i][j];
            }
            resultado[PRODUCTOS + 1][j] = totalColumna;
        }

        return resultado;
    }
}