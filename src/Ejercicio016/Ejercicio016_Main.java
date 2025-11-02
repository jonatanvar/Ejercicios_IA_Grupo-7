/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 016 | 2025-10-10               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente nuevo ejercicio a realizar el #16, te recuerdo que debe de ir nuestro sello personalizado, la capacidad de reiterar el ejercicio si la entrada es invalida, con mensajes de salida simples para el usuario, junto con nuestra distribución de archivos, el ejercicio es: Split: Escriba un programa que reciba como entrada un número entero (que incluyen los positivos y los negativos los decimales no) de cinco dígitos, que separe ese número en sus dígitos individuales y los imprima, cada uno separado de los demás por tres espacios. [Sugerencia: use los operadores de división entera y módulo.] Por ejemplo, si el usuario escribe el número 42339, el programa debe imprimir: 4   2   3   3   9. Al inicio proporciona un ejemplo de la entrada que debes de ingresar, asegúrate que sean 5 números ingresados mediante una validación.
 */

package Ejercicio016;

import java.util.Scanner;

public class Ejercicio016_Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] digitos = new int[5];
        boolean entradaValida;

        Ejercicio016_Utilidades.mostrarSaludo();

        do {
            entradaValida = Ejercicio016_Utilidades.mostrarIngresoNumero(scanner, digitos);
            if (!entradaValida) {
                Ejercicio016_Utilidades.mostrarErrorEntrada();
            }
        } while (!entradaValida);

        Ejercicio016_Utilidades.mostrarResultado(digitos);
        Ejercicio016_Utilidades.mostrarSelloCorto();

        scanner.close();
        System.out.println("\n" + LINEA.repeat(ANCHO));
        System.out.println(Ejercicio016_Utilidades.centrarTexto("*** Operaciones completadas exitosamente ***", ANCHO));
        System.out.println(LINEA.repeat(ANCHO));
    }
}