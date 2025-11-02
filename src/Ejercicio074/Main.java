/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 074 | 2025-10-18               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente nuevo ejercicio el #74 siempre implementa los requerimientos
 * de los ejercicios anteriores con una salida elegante en cada una de
 * las salidas al usuario, el ejercicio consta de lo siguiente:
 * Hay que hacer un programa que involucre dos funciones para elevar al cuadrado y
 * para elevar al cubo sin embargo estas funciones tienen que llevar el
 * mismo nombre la única diferencia en cada par es que una hace uso de
 * paso de parámetros por valor y la otra lo hace por referencia. El programa
 * tendrá dos funciones llamadas elevarCd (para elevar al cuadrado) y
 * elevarCb (para elevar al cubo) entonces, al arrancar y luego de dar
 *  la bienvenida al usuario presentará una tabla con cinco columnas en la
 *  primera aparecerán los números del cero (0) al diez (10), en la segunda
 * el cuadrado de estos números obtenidos por valor, en la tercera el cuadrado
 * obtenido por referencia, en la cuarta el cubo obtenidos por valor y en la
 *  última el cubo obtenidos por referencia. (si se puede tener funciones con
 *  el mismo nombre en el mismo archivo cpp solo hay que saber cómo hacerlo)
 * Todo el código dividido en nuestro sistemas de 4 archivos, valida entradas, que
 *  las salida al usuario sean fáciles de interpretar
 */

package Ejercicio074;

import java.util.Scanner;

public class Main {
    private static final int ANCHO = 70;
    private static String idiomaActual = "ES";
    private static boolean continuar = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utilidades.mostrarSello();
        idiomaActual = Menús.seleccionarIdioma(scanner);

        do {
            ejecutarEjercicio(idiomaActual);
            continuar = Menús.preguntarContinuar(scanner, idiomaActual);
        } while (continuar);

        scanner.close();
    }

    private static void ejecutarEjercicio(String idioma) {
        Utilidades.mostrarBienvenida(idioma);
        Utilidades.mostrarTabla(idioma);
    }
}