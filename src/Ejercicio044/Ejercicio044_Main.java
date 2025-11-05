package Ejercicio044;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 044 | 2025-10-16
 */
public class Ejercicio044_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio044_Utilidades.mostrarSelloCorto();

        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio044_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            System.out.println("\n*** INICIO DEL SISTEMA ***");

            // Requisito C: La función debe mostrar, validar y devolver la opción.
            int opcionFinal = Ejercicio044_Funciones.mostrarMenuPrincipal(scanner);

            if (opcionFinal == Ejercicio044_Funciones.OPCION_FINALIZAR) {
                System.out.println("Saliendo del Menú Principal. Gracias por usar el sistema.");
                ejecutar = false; // Detiene el bucle exterior si se seleccionó la opción Finalizar.
            }
        }

        scanner.close();
        System.out.println("\nPrograma Finalizado.");
    }
}