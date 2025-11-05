package Ejercicio113;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 113 | 2025-10-21
 */
public class Ejercicio113_Funciones {

    /**
     * Determina si un trayecto es válido y, en tal caso, calcula su distancia total.
     * @param distancias Matriz de 10x10 con las distancias entre ciudades.
     * @param trayecto Vector de enteros que representa el orden de las ciudades a visitar.
     * @return La distancia total del trayecto. Si no es válido, devuelve -1.
     */
    public static int calcularDistanciaTrayecto(int[][] distancias, int[] trayecto) {
        int distanciaTotal = 0;

        if (trayecto == null || trayecto.length < 2) {
            return -1;
        }
        for (int k = 0; k < trayecto.length - 1; k++) {
            int ciudadActual = trayecto[k];
            int ciudadSiguiente = trayecto[k + 1];

            if (ciudadActual < 0 || ciudadActual >= UtilidadesGrafo.NUM_CIUDADES ||
                    ciudadSiguiente < 0 || ciudadSiguiente >= UtilidadesGrafo.NUM_CIUDADES) {
                return -1;
            }
            int distanciaTramo = distancias[ciudadActual][ciudadSiguiente];

            if (distanciaTramo == 0) {
                return -2;
            }

            distanciaTotal += distanciaTramo;
        }

        return distanciaTotal;
    }
}