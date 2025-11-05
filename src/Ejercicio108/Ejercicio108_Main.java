package Ejercicio108;

import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 108 | 2025-10-21
 */
public class Ejercicio108_Main {

    private static final int MSG_FINALIZACION = 14;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ejercicio108_Utilidades.mostrarSelloCorto();
        Ejercicio108_Utilidades.seleccionarIdioma(scanner);

        boolean ejecutar = true;
        while (ejecutar) {
            if (!Ejercicio108_Utilidades.mostrarMenuEjecucion(scanner)) {
                ejecutar = false;
                break;
            }

            Ejercicio108_Utilidades.mostrarEncabezado();

            // 1. Inicializar la matriz 5x5
            int[][] matriz = UtilidadesMatriz.inicializarMatriz();

            // 2. Ciclo principal de llenado (e. Seguir hasta que la matriz esté completa)
            while (!UtilidadesMatriz.estaCompleta(matriz)) {

                // d. Limpiar la pantalla antes de cada ciclo
                UtilidadesMatriz.limpiarPantalla();

                // c. Con la matriz visible en pantalla
                Ejercicio108_Utilidades.imprimirMatriz(matriz);

                int i, j;
                boolean celdaValida = false;

                // Bucle interno para encontrar una celda [i][j] que aún no se haya llenado
                do {
                    // c.ii. Los valores de i y de j se generan aleatoriamente.
                    i = UtilidadesMatriz.generarIndiceAleatorio();
                    j = UtilidadesMatriz.generarIndiceAleatorio();

                    // c.iii. Si la casilla [i][j] tiene un valor diferente a cero entonces no debo pedirlo.
                    if (matriz[i][j] == 0) {
                        celdaValida = true;
                    }
                    // Si no es válida, el ciclo do-while se repite con nuevos índices aleatorios.
                } while (!celdaValida);

                // Pedir el valor para la celda [i][j] generada
                int valor = Ejercicio108_Utilidades.leerValor(scanner, i, j);

                // Guardar el valor en la matriz
                matriz[i][j] = valor;
            }

            // 4. Matriz completa, mostrar el resultado final
            UtilidadesMatriz.limpiarPantalla();
            Ejercicio108_Utilidades.imprimirMatriz(matriz);
            System.out.println("\n" + Ejercicio108_Utilidades.obtenerTexto(13));

            // Consumir el resto del buffer si hay algo.
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }

        scanner.close();
        System.out.println(Ejercicio108_Utilidades.obtenerTexto(MSG_FINALIZACION));
    }
}