// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #89                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio089 | 2025-11-12

package Ejercicio089;

import java.util.Scanner;

public class Ejercicio089_Operaciones {

    public static void teLeoDeVerdad() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio089_Menus.obtenerIdioma();

        Ejercicio089_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "TE LEO, DE VERDAD" : "I READ YOU, REALLY"
        );

        // Leer número inicial entre 11 y 99
        int n = Ejercicio089_Utilidades.leerEntero(
                idioma.equals("ES") ? "Ingrese un número entero mayor que 10 y menor que 100: " :
                        "Enter an integer greater than 10 and less than 100: ", 11, 99
        );

        // Leer n números y almacenarlos
        int[] lista = new int[n];
        for (int i = 0; i < n; i++) {
            lista[i] = Ejercicio089_Utilidades.leerEntero(
                    idioma.equals("ES") ? "Ingrese número " + (i + 1) + ": " :
                            "Enter number " + (i + 1) + ": ", 0, Integer.MAX_VALUE
            );
        }

        // Mostrar lista con formato
        mostrarListaFormateada(lista, idioma);

        // Leer 5 números entre 0 y n-1 para la tabla
        int[] tabla = new int[5];
        for (int i = 0; i < 5; i++) {
            tabla[i] = Ejercicio089_Utilidades.leerEntero(
                    idioma.equals("ES") ? "Ingrese número para tabla " + (i + 1) + " (0-" + (n - 1) + "): " :
                            "Enter number for table " + (i + 1) + " (0-" + (n - 1) + "): ", 0, n - 1
            );
        }

        // Mostrar tabla
        System.out.println("\n───────────── TABLA ─────────────\n");
        System.out.printf("%-10s%-10s\n", idioma.equals("ES") ? "Número" : "Number", idioma.equals("ES") ? "Posición" : "Position");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-10d%-10d\n", tabla[i], lista[tabla[i]]);
        }

        Ejercicio089_Utilidades.mostrarSelloCorto();
        Ejercicio089_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }

    public static void mostrarListaFormateada(int[] lista, String idioma) {
        System.out.print("Lista: ");
        for (int i = 0; i < lista.length; i++) {
            if (i == lista.length - 1) {
                System.out.print("y " + lista[i] + ".");
            } else if (i == lista.length - 2) {
                System.out.print(lista[i] + " ");
            } else {
                System.out.print(lista[i] + ", ");
            }
        }
        System.out.println();
    }
}