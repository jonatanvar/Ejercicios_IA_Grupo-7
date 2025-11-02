/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 070 | 2025-10-17               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente el ejercicio #70, es una modificación de un
 *  ejercicio que nosotros no realizamos te mande el
 * enunciado de ese ejercicio para que sepas que bases
 *  tenemos para hacer el nuestro, te mando el enunciado "9.
 * Instrucción asistida por computadora: El uso de las computadoras en
 * la educación se conoce como instrucción asistida por computadora (CAI).
 * Un problema que se desarrolla en los entornos
 * CAI es la fatiga de los estudiantes. Este problema puede
 * eliminarse si se varía el diálogo de la computadora para mantener
 * la atención del estudiante. Modifique el programa del ejercicio
 * “Las computadoras en la educación” de manera que los diversos comentarios
 *  se impriman para cada respuesta correcta e incorrecta, de la siguiente manera:
 * a. Contestaciones a una respuesta correcta:
 * i. Muy bien!
 * ii. Excelente!
 * iii. Buen trabajo!
 * iv. Sigue asi!
 * b. Contestaciones a una respuesta incorrecta:
 * i. No. Por favor intenta de nuevo.
 * ii. Incorrecto. Intenta una vez más.
 * iii. No te rindas!
 * iv. No. Sigue intentando."
 * En nuestro ejercicio debes de aplicar los mismo parámetros que
 * en los ejercicios anteriores, siempre valida y muestra una salida
 *  al usuario elegante el ejercicio nuestro es este: Los sistemas
 * de instrucción asistida por
 * computadora más sofisticados supervisan el rendimiento del estudiante
 *  durante cierto tiempo. La decisión de empezar un nuevo tema se basa
 *  a menudo en el éxito del estudiante con los temas anteriores.
 * Modifique el programa “Instrucción asistida por computadora” para
 * contar el número de respuestas correctas e incorrectas por parte del
 * estudiante Una vez que el estudiante escriba 10
 * respuestas, su programa debe calcular el porcentaje de respuestas correctas.
 *  Si éste es menor del 75%, el programa deberá imprimir un mensaje
 * correspondiente al puntaje
 * Que tu le pongas respuesta correcta o incorrecta, así 10 veces y
 *  depuse que se muestra los cálculos que hiciste para llegar al porcentaje.
 * 1 Respuesta correcta
 * 2 Respuesta incorrecta
 */

package Ejercicio070;

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
            ejecutarEjercicio(scanner, idiomaActual);
            continuar = Menús.preguntarContinuar(scanner, idiomaActual);
        } while (continuar);

        scanner.close();
    }

    private static void ejecutarEjercicio(Scanner scanner, String idioma) {
        int correctas = 0;
        int incorrectas = 0;

        for (int i = 0; i < 10; i++) {
            boolean esCorrecta = Operaciones.leerRespuesta(scanner, idioma, i + 1);
            if (esCorrecta) correctas++;
            else incorrectas++;
            Utilidades.mostrarRespuesta(i + 1, esCorrecta, idioma);
        }

        double porcentaje = (correctas * 100.0) / 10;
        Utilidades.mostrarResultados(correctas, incorrectas, porcentaje, idioma);
        Utilidades.mostrarCalculos(correctas, incorrectas, porcentaje, idioma);
    }
}
