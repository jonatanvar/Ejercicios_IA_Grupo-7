package Ejercicio104;

import java.util.Random;

public class GeneradorVentas {

    private static final Random random = new Random();
    public static final int NUM_VENDEDORES = 4;
    public static final int NUM_PRODUCTOS = 5;
    private static final int MAX_TRANSACCIONES = 100;

    public static double[][] generarTransaccionesSimuladas() {
        int numTransacciones = random.nextInt(MAX_TRANSACCIONES) + 1;
        double[][] transacciones = new double[numTransacciones][3];

        for (int i = 0; i < numTransacciones; i++) {
            transacciones[i][0] = random.nextInt(NUM_VENDEDORES) + 1;
            transacciones[i][1] = random.nextInt(NUM_PRODUCTOS) + 1;
            transacciones[i][2] = 10.0 + (500.0 - 10.0) * random.nextDouble();
        }

        return transacciones;
    }
}