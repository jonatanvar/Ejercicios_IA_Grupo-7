package Ejercicio068;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Cristina Cruz | Lis❤ | cristinacruz@unah.hn | 068 | 2025-10-16
 */
public class Ejercicio068_Funciones {

    private static Random generadorAleatorio = new Random();

    /**
     * Genera un entero positivo de un dígito (1-9).
     * Simula la función rand() para generar números para la multiplicación.
     * @return Un número entero entre 1 y 9.
     */
    public static int generarDigitoAleatorio() {
        // nextInt(9) genera [0, 8], al sumar 1, el rango es [1, 9]
        return generadorAleatorio.nextInt(9) + 1;
    }

    /**
     * Plantea una pregunta de multiplicación y obliga al estudiante a responder
     * correctamente usando un ciclo while.
     * @param scanner Objeto Scanner para la entrada del usuario.
     * @param mensajePregunta Mensaje de la pregunta ("¿Cuánto es...").
     * @param mensajeCorrecto Mensaje de respuesta correcta.
     * @param mensajeIncorrecto Mensaje de respuesta incorrecta.
     */
    public static void hacerPregunta(Scanner scanner, String mensajePregunta,
                                     String mensajeCorrecto, String mensajeIncorrecto) {

        int num1 = generarDigitoAleatorio();
        int num2 = generarDigitoAleatorio();
        int respuestaCorrecta = num1 * num2;

        boolean respuestaValida = false;

        while (!respuestaValida) {
            // 1. Mostrar la pregunta
            System.out.printf("\n%s %d por %d? ", mensajePregunta, num1, num2);

            // 2. Leer la respuesta del estudiante con manejo de error
            int respuestaEstudiante = 0;
            try {
                if (scanner.hasNextInt()) {
                    respuestaEstudiante = scanner.nextInt();

                    // 3. Verificar la respuesta
                    if (respuestaEstudiante == respuestaCorrecta) {
                        System.out.println(mensajeCorrecto);
                        respuestaValida = true; // Sale del ciclo
                    } else {
                        System.out.println(mensajeIncorrecto);
                        // No cambia respuestaValida, el ciclo continúa
                    }
                } else {
                    System.out.println(mensajeIncorrecto); // Trata la entrada no entera como error
                    scanner.next(); // Limpiar el buffer
                }
            } catch (InputMismatchException e) {
                System.out.println(mensajeIncorrecto);
                scanner.next(); // Limpiar el buffer
            }
        }
    }
}