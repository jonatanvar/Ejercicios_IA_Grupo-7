package Ejercicio095;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 095 | 2025-10-21
 */
public class Ejercicio095_Main {

    private static final int MSG_ORIGINAL = 13;
    private static final int MSG_ORDENADO = 14;
    private static final int MSG_FINALIZACION = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar Sello y Seleccionar Idioma
        Ejercicio095_Utilidades.mostrarSelloCorto();
        Ejercicio095_Utilidades.seleccionarIdioma(scanner);

        // 2. Menú de Ejecución (Ciclo While para repetición)
        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio095_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            // --- Inicio de la lógica del ejercicio ---
            Ejercicio095_Utilidades.mostrarEncabezado();

            // 3. Leer y validar el tamaño del vector
            int tamano = Ejercicio095_Utilidades.leerTamanoVector(scanner);

            // 4. Generación: Llamada a la LIBRERÍA PROPIA (GeneradorArreglos)
            int[] vectorOriginal = GeneradorArreglos.crearVectorAleatorio(tamano);

            // 5. Presentar el vector tal como se creó
            Ejercicio095_Utilidades.mostrarVector(vectorOriginal, MSG_ORIGINAL);

            // 6. Ordenar: Llamada a la LIBRERÍA PROPIA (GeneradorArreglos)
            int[] vectorOrdenado = GeneradorArreglos.ordenarVectorDescendente(vectorOriginal);

            // 7. Presentar el vector ordenado de mayor a menor
            Ejercicio095_Utilidades.mostrarVector(vectorOrdenado, MSG_ORDENADO);

            System.out.println();
        }

        // 8. Cierre de recursos y finalización
        scanner.close();
        System.out.println(Ejercicio095_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}
