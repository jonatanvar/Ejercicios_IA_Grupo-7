package Ejercicio090_KevinLainez;

import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 090 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Ejercicio #90: Lectura de Arreglo sin Repetidos
 * * PROMPT:
 * Modifique el programa “Te leo, de verdad”para que, usando una función,
 * no permita ingresar valores repetidos.
 */
public class main {

    private static final int TAMANO_ARREGLO = 5;

    public static void main(String[] args) {
        // 1. Inicializar
        Scanner sc = new Scanner(System.in);
        int[] arreglo = new int[TAMANO_ARREGLO];
        int nuevoValor;

        // 2. Mostrar cuadro de bienvenida
        MiLibreria.mostrarSaludo("LECTURA DE ARREGLO SIN VALORES REPETIDOS");

        System.out.println(MiLibreria.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(MiLibreria.centrarTexto("INICIO DE INGRESO DE " + TAMANO_ARREGLO + " VALORES ÚNICOS"));

        // 3. Bucle para llenar el arreglo
        for (int i = 0; i < TAMANO_ARREGLO; i++) {

            boolean esRepetido;

            // Bucle do-while para garantizar que el valor sea único
            do {
                // Solicitar el valor
                String prompt = String.format("Ingrese el entero #%d:", i + 1);
                nuevoValor = utilidades.solicitarEntero(sc, prompt);

                // --- LLAMADA A LA FUNCIÓN DE VALIDACIÓN CLAVE ---
                // Verifica si el valor existe entre los elementos ya ingresados (índices 0 hasta i-1)
                esRepetido = operaciones.contieneRepetido(arreglo, nuevoValor, i);

                if (esRepetido) {
                    utilidades.mostrarMensajeRepetido(nuevoValor);
                }

            } while (esRepetido);

            // 4. Si el valor es único, se almacena en el arreglo
            arreglo[i] = nuevoValor;
            System.out.println(MiLibreria.dibujarLineaHorizontal('└', '┘'));

            if (i < TAMANO_ARREGLO - 1) {
                System.out.println(MiLibreria.centrarTexto("Valor aceptado. Siguiente..."));
                System.out.println(MiLibreria.dibujarLineaHorizontal('┌', '┐'));
            }
        }

        // 5. Mostrar Resultados
        utilidades.mostrarArreglo(arreglo);

        // 6. Mostrar Sello y finalizar
        MiLibreria.mostrarSelloCorto("090");

        System.out.println("\n--- Programa finalizado con éxito ---");

        // 7. Cerrar Scanner
        sc.close();
    }
}