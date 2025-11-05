package Ejercicio054;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 054 | 2025-10-15
 */
public class Ejercicio054_Main {

    private static final int MSG_FINALIZACION = 14;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar Sello Personalizado
        Ejercicio054_Utilidades.mostrarSelloCorto();

        // 2. Selección de Idioma
        Ejercicio054_Utilidades.seleccionarIdioma(scanner);

        // 3. Menú de Ejecución (bucle para repetición)
        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio054_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            // --- Inicio de la lógica del ejercicio ---
            Ejercicio054_Utilidades.mostrarEncabezado();

            // 4. Pedir X y Y (Validación en Utilidades)
            int numX = Ejercicio054_Utilidades.leerEnteroRango(scanner);
            char caracterY = Ejercicio054_Utilidades.leerCaracter(scanner);

            // 5. PRIMER BLOQUE: Imprimir X líneas con cantidad aleatoria de Y
            // Se usa una función que recibe X y Y, y devuelve el conteo total.
            int totalCaracteresContados = Ejercicio054_Funciones.imprimirPrimerBloque(numX, caracterY);

            // 6. SEGUNDO BLOQUE: Imprimir X líneas con cantidad basada en el total
            // Se usa una función que recibe X, Y, y el total contado.
            Ejercicio054_Funciones.imprimirSegundoBloque(numX, caracterY, totalCaracteresContados);

            System.out.println(); // Separador antes de volver al menú de ejecución
        }

        // 7. Cierre de recursos y finalización
        scanner.close();
        System.out.println(Ejercicio054_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}