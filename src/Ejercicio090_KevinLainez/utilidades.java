package Ejercicio090_KevinLainez;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Kevin Lainez | klainezs@unah.hn | 090 | 2025-11-03                  │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

/**
 * Clase de utilidades específicas para la entrada y salida del Ejercicio 90.
 */
public class utilidades {

    /**
     * Solicita y valida la entrada de un entero.
     * @param sc El objeto Scanner.
     * @param prompt Mensaje de la solicitud.
     * @return El valor entero ingresado.
     */
    public static int solicitarEntero(Scanner sc, String prompt) {
        int valor = -9999;

        // Bucle do-while para garantizar una entrada numérica válida
        do {
            System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));
            System.out.print(MiLibreria.getBORDE_IZQ() + " " + prompt);

            // Calcula los espacios de relleno
            int espaciosRelleno = MiLibreria.getANCHO() - 3 - prompt.length();
            System.out.print(" ".repeat(espaciosRelleno) + MiLibreria.getBORDE_DER() + "\n");
            System.out.print(MiLibreria.getBORDE_IZQ() + " >> Valor: ");

            try {
                if (sc.hasNextInt()) {
                    valor = sc.nextInt();
                    sc.nextLine(); // Consumir el salto de línea
                } else {
                    sc.nextLine();
                    System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));
                    System.out.println(MiLibreria.centrarTexto("AVISO: Entrada inválida. Debe ser un número entero."));
                    valor = -9999; // Mantener el bucle
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                valor = -9999;
            }
        } while (valor == -9999);

        return valor;
    }

    /**
     * Muestra el contenido final del arreglo.
     * @param arreglo El arreglo de enteros a imprimir.
     */
    public static void mostrarArreglo(int[] arreglo) {
        System.out.println(MiLibreria.dibujarLineaHorizontal('┌', '┐'));
        System.out.println(MiLibreria.centrarTexto("** CONTENIDO FINAL DEL ARREGLO **"));
        System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));

        String contenido = "[ ";
        for (int i = 0; i < arreglo.length; i++) {
            contenido += arreglo[i];
            if (i < arreglo.length - 1) {
                contenido += ", ";
            }
        }
        contenido += " ]";

        System.out.println(MiLibreria.centrarTexto(contenido));
        System.out.println(MiLibreria.dibujarLineaHorizontal('└', '┘'));
    }

    /**
     * Muestra el mensaje de valor repetido.
     */
    public static void mostrarMensajeRepetido(int valor) {
        System.out.println(MiLibreria.dibujarLineaHorizontal('├', '┤'));
        System.out.println(MiLibreria.centrarTexto("¡ADVERTENCIA! El valor " + valor + " ya fue ingresado. Intente de nuevo."));
    }
}