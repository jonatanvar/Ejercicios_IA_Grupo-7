package Ejercicio059;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 059 | 2025-10-16
 */
public class Ejercicio059_Main {

    private static final int MSG_FINALIZACION = 13;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar Sello Personalizado
        Ejercicio059_Utilidades.mostrarSelloCorto();

        // 2. Selección de Idioma
        Ejercicio059_Utilidades.seleccionarIdioma(scanner);

        // 3. Menú de Ejecución (bucle para repetición)
        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio059_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            // --- Inicio de la lógica del ejercicio ---
            Ejercicio059_Utilidades.mostrarEncabezado();

            // 4. Pedir el lado X (Validación en Utilidades)
            int lado = Ejercicio059_Utilidades.leerLadoCuadrado(scanner);

            System.out.println("\n--- Cuadrado Relleno (Lado: " + lado + ") ---");

            // 5. Llamada a la función: dibujar el cuadrado
            Ejercicio059_Funciones.dibujarCuadradoRelleno(lado);

            System.out.println(); // Separador antes de volver al menú de ejecución
        }

        // 6. Cierre de recursos y finalización
        scanner.close();
        System.out.println(Ejercicio059_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}