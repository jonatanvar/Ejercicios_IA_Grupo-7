package Ejercicio064;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 064 | 2025-10-16
 */
public class Ejercicio064_Main {

    private static final int MSG_FINALIZACION = 14;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar Sello Personalizado
        Ejercicio064_Utilidades.mostrarSelloCorto();

        // 2. Selección de Idioma
        Ejercicio064_Utilidades.seleccionarIdioma(scanner);

        // 3. Menú de Ejecución (bucle para repetición)
        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio064_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            // --- Inicio de la lógica del ejercicio ---
            Ejercicio064_Utilidades.mostrarEncabezado();

            // 4. Pedir el número (Validación en Utilidades)
            int numeroOriginal = Ejercicio064_Utilidades.leerEnteroPositivo(scanner);

            // 5. Llamada a la función: invertir los dígitos
            int numeroInvertido = Ejercicio064_Funciones.invertirDigitos(numeroOriginal);

            // 6. Mostrar el resultado
            Ejercicio064_Utilidades.mostrarResultado(numeroInvertido);

            System.out.println(); // Separador antes de volver al menú de ejecución
        }

        // 7. Cierre de recursos y finalización
        scanner.close();
        System.out.println(Ejercicio064_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}