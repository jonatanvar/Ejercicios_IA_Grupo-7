package Ejercicio104;

import java.util.Scanner;

public class Ejercicio104_Main {

    private static final int MSG_FINALIZACION = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio104_Utilidades.mostrarSelloCorto();
        Ejercicio104_Utilidades.seleccionarIdioma(scanner);

        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio104_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            Ejercicio104_Utilidades.mostrarEncabezado();

            double[][] transacciones = GeneradorVentas.generarTransaccionesSimuladas();
            Ejercicio104_Utilidades.mostrarTotalTransacciones(transacciones.length);

            double[][] ventasAcumuladas = Ejercicio104_Funciones.procesarVentas(transacciones);

            double[][] matrizReporte = Ejercicio104_Funciones.calcularTotalesCruzados(ventasAcumuladas);

            Ejercicio104_Utilidades.mostrarTabla(matrizReporte);

            System.out.println();
        }

        scanner.close();
        System.out.println(Ejercicio104_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}