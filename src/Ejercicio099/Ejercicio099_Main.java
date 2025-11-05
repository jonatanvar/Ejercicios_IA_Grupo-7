package Ejercicio099;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 099 | 2025-10-21
 */
public class Ejercicio099_Main {

    private static final int MSG_FINALIZACION = 11;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio099_Utilidades.mostrarSelloCorto();
        Ejercicio099_Utilidades.seleccionarIdioma(scanner);

        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio099_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            Ejercicio099_Utilidades.mostrarEncabezado();

            int numVendedores = GeneradorVentas.generarNumeroVendedores();
            System.out.println("Procesando pagos para " + numVendedores + " vendedores...");

            int[] salarios = GeneradorVentas.generarSalarios(numVendedores);

            int[] contadores = Ejercicio099_Funciones.contarSalariosPorRango(salarios);

            Ejercicio099_Utilidades.mostrarReporte(contadores);

            System.out.println();
        }

        scanner.close();
        System.out.println(Ejercicio099_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}