package Ejercicio077;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 077 | 2025-10-16
 */
public class Ejercicio077_Main {

    private static final int MSG_FINALIZACION = 17;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Mostrar Sello y Seleccionar Idioma
        Ejercicio077_Utilidades.mostrarSelloCorto();
        Ejercicio077_Utilidades.seleccionarIdioma(scanner);

        // 2. Menú de Ejecución
        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio077_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            // --- Inicio de la lógica del ejercicio ---
            Ejercicio077_Utilidades.mostrarEncabezado();

            // 3. Lectura de Números Base (con validación e intercambio)
            double[] bases = Ejercicio077_Utilidades.leerYOrdenarBases(scanner);
            double num1 = bases[0];
            double num2 = bases[1];

            // 4. Lectura de Exponentes P1, P2, P3 (con validación de rango)
            int p1 = Ejercicio077_Utilidades.leerExponente(scanner, 1);
            int p2 = Ejercicio077_Utilidades.leerExponente(scanner, 2);
            int p3 = Ejercicio077_Utilidades.leerExponente(scanner, 3);

            // 5. Generación y Muestra de la Tabla Comparativa
            Ejercicio077_Utilidades.mostrarTabla(num1, num2, p1, p2, p3);

            System.out.println();
        }

        // 6. Cierre de recursos y finalización
        scanner.close();
        System.out.println(Ejercicio077_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}