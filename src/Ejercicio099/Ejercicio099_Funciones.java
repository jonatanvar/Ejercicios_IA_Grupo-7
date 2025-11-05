package Ejercicio099;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 099 | 2025-10-21
 */
public class Ejercicio099_Funciones {

    private static final int NUM_RANGOS = 9;

    /**
     * Procesa un arreglo de salarios y cuenta cuántos caen en cada uno de los 9 rangos.
     * @param salarios Arreglo de salarios truncados (enteros).
     * @return Arreglo de enteros con los conteos por rango.
     */
    public static int[] contarSalariosPorRango(int[] salarios) {
        int[] contadores = new int[NUM_RANGOS];

        for (int salario : salarios) {

            int indice;

            if (salario >= 1000) {
                indice = 8;
            } else if (salario >= 200) {

                indice = salario / 100 - 2;

                if (indice > 7) {
                    indice = 7;
                }
            } else {
                continue;
            }

            contadores[indice]++;
        }

        return contadores;
    }
}