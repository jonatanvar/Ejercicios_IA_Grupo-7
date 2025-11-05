package Ejercicio073;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 073 | 2025-10-16
 */
public class Ejercicio073_Main {

    private static final int MSG_FINALIZACION = 18;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio073_Utilidades.mostrarSelloCorto();
        Ejercicio073_Utilidades.seleccionarIdioma(scanner);

        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio073_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            // --- Inicio de la lógica del ejercicio ---
            Ejercicio073_Utilidades.mostrarEncabezado();

            // 1. Pedir el valor inicial
            int valorInicial = Ejercicio073_Utilidades.leerEnteroPositivo(scanner);

            // --- PARTE A: Demostración por Valor (int primitivo) ---
            int cuentaPorValor = valorInicial;
            int resultadoValor;

            System.out.println("\n--- DEMOSTRACIÓN POR VALOR ---");
            Ejercicio073_Utilidades.mostrarValorInicial(cuentaPorValor);

            // Llamada 1: Pasa una copia del valor. La original no cambia.
            resultadoValor = Ejercicio073_Funciones.triplicarPorValor(cuentaPorValor);

            Ejercicio073_Utilidades.mostrarResultadoValor(resultadoValor);
            Ejercicio073_Utilidades.mostrarValorDespuesValor(cuentaPorValor);

            // --- PARTE B: Demostración por Referencia (Simulación con Objeto) ---
            // Creamos un objeto mutable para simular el paso por referencia
            ContenedorEntero cuentaPorReferencia = new ContenedorEntero(valorInicial);

            System.out.println("\n--- DEMOSTRACIÓN POR REFERENCIA (SIMULADA) ---");
            Ejercicio073_Utilidades.mostrarValorAntesReferencia(cuentaPorReferencia.valor);

            // Llamada 2: Pasa la copia de la referencia. Modifica el objeto original.
            Ejercicio073_Funciones.triplicarPorReferencia(cuentaPorReferencia);

            // El valor impreso es el valor modificado DENTRO del objeto original.
            Ejercicio073_Utilidades.mostrarValorDespuesReferencia(cuentaPorReferencia.valor);

            System.out.println();
        }

        scanner.close();
        System.out.println(Ejercicio073_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}