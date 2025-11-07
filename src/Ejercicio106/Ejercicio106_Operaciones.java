// ╔═══════════════════════════════════════════════════════════════════════════╗
// ║ Lógica principal de ventas por sucursal y día                             ║
// ╚═══════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio106 | 2025-11-06

package Ejercicio106;

import java.util.Scanner;

public class Ejercicio106_Operaciones {

    public static void procesarVentas() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio106_Menus.obtenerIdioma();

        Ejercicio106_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "REGISTRO DE VENTAS" : "SALES RECORDING"
        );

        int sucursales = 5;
        int diasSemana = 6;

        double[][] ventas = new double[sucursales][diasSemana];

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        String[] sucursalIdent = {"S1", "S2", "S3", "S4", "S5"};

        for (int i = 0; i < sucursales; i++) {
            System.out.println("\n" + (idioma.equals("ES") ?
                    "Ingresando ventas para sucursal: " :
                    "Entering sales for store: ") + (i + 1));

            for (int j = 0; j < diasSemana; j++) {
                System.out.print(dias[j] + ": ");
                ventas[i][j] = sc.nextDouble();
            }
        }

        System.out.println("\n" + (idioma.equals("ES") ? "Matriz de ventas:" : "Sales matrix:"));
        Ejercicio106_Utilidades.imprimirMatriz(ventas, sucursalIdent, dias);

        // Matriz extendida (incluye totales semanales y totales por día)
        double[][] matrizExtendida = new double[6][7];

        for (int i = 0; i < sucursales; i++) {
            double totalSucursal = 0;
            for (int j = 0; j < diasSemana; j++) {
                matrizExtendida[i][j] = ventas[i][j];
                totalSucursal += ventas[i][j];
            }
            matrizExtendida[i][6] = totalSucursal;
        }

        for (int j = 0; j < diasSemana; j++) {
            double totalDia = 0;
            for (int i = 0; i < sucursales; i++) {
                totalDia += ventas[i][j];
            }
            matrizExtendida[5][j] = totalDia;
        }

        matrizExtendida[5][6] = 0;

        String[] filasExt = {"S1", "S2", "S3", "S4", "S5", "TOTAL DÍAS"};
        String[] columnasExt = {"Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "TOTAL"};

        System.out.println("\n" + (idioma.equals("ES") ? "Matriz con totales:" : "Matrix with totals:"));
        Ejercicio106_Utilidades.imprimirMatriz(matrizExtendida, filasExt, columnasExt);

        Ejercicio106_Utilidades.mostrarSelloCorto();
        Ejercicio106_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }
}