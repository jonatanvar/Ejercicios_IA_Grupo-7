/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 026 | 2025-10-12               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente un nuevo ejercicio el #26, recuerda los parámetros antes desarrollados en ejercicios anteriores,
 *  el ejercicio conta de los siguiente:
 * Copiar y pegar: Escriba una aplicación en JAVA que utilice una instrucción while y la secuencia de escape de tabulación \t para imprimir la siguiente tabla de valores:
 * N    10*N   100*N  1000*N
 * 1	 10	    100    1000
 * 2	 20     200	   2000
 * 3      30	300    3000
 * 4	  40   	400    4000
 * 5	  50	500	   5000
 * implementa el diseño de 4 archivos, con un cuadro elegante con la salida,
 *  junto al menú que corresponde a los ejercicios que hemos desarrollado.
 *
 */

package Ejercicio026;

import java.util.Scanner;

public class Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilidades.mostrarSello();
        idiomaActual = Menús.seleccionarIdioma(scanner);

        do {
            int opcion = Menús.mostrarMenuPrincipal(scanner, idiomaActual);
            if (opcion == 1) {
                ejecutarEjercicio(idiomaActual);
                continuar = Menús.preguntarRepetir(scanner, idiomaActual);
            } else {
                Menús.mostrarDespedida(idiomaActual);
                continuar = false;
            }
        } while (continuar);

        scanner.close();
    }

    private static void ejecutarEjercicio(String idioma) {
        Utilidades.mostrarTablaValores(idioma);
    }
}