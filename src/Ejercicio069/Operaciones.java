/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 069 | 2025-10-28
* ---------------------------------------------------------
*
* PROMPT USADO: Programa CAI que enseña multiplicación con retroalimentación variable y aleatoria para mantener la atención del estudiante.
 */

package Ejercicio_069;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Módulo Operaciones: Implementa la lógica principal del programa CAI.
 * Incluye la generación de preguntas de multiplicación (un dígito),
 * la verificación de la respuesta y la retroalimentación variable (aleatoria).
 */
public class Operaciones {

    private final String idioma;
    private final Random random = new Random();

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Inicia la sesión de instrucción asistida por computadora (CAI).
     * Mantiene un ciclo de preguntas hasta que el usuario decida salir (ingresando 0).
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void iniciarSesionCAI(Scanner scanner) {
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        System.out.println(Utilidades.getTexto(idioma, "MSG_INSTRUCCIONES"));

        boolean continuarPreguntando = true;
        
        while (continuarPreguntando) {
            
            // 1. Generar la pregunta y la respuesta correcta
            int num1 = generarEnteroUnDigito();
            int num2 = generarEnteroUnDigito();
            int respuestaCorrecta = num1 * num2;
            boolean respuestaEsCorrecta = false;
            
            System.out.println("\n-------------------------------------------");
            System.out.printf(Utilidades.getTexto(idioma, "MSG_PREGUNTA"), num1, num2);

            // Bucle de verificación: Repite la pregunta hasta que la respuesta sea correcta
            while (!respuestaEsCorrecta) {
                
                // 2. Leer la respuesta del estudiante
                int respuestaEstudiante = leerRespuesta(scanner);

                // Opción para salir del bucle de preguntas
                if (respuestaEstudiante == 0) {
                    continuarPreguntando = false;
                    System.out.println(Utilidades.getTexto(idioma, "MSG_FIN_SESION"));
                    break;
                }
                
                // 3. Verificar y dar retroalimentación
                if (respuestaEstudiante == respuestaCorrecta) {
                    // Respuesta Correcta: Rompe el bucle interno y pide nueva pregunta
                    generarRetroalimentacion(true);
                    respuestaEsCorrecta = true;
                } else {
                    // Respuesta Incorrecta: Permanece en el bucle interno
                    generarRetroalimentacion(false);
                    // Repite la pregunta para asegurar que el usuario sabe qué problema está resolviendo
                    System.out.printf(Utilidades.getTexto(idioma, "MSG_PREGUNTA_REPETIR"), num1, num2);
                }
            }
        }
    }

    /**
     * Genera un entero aleatorio positivo de un solo dígito (rango 1 a 9).
     * @return Un entero entre 1 y 9.
     */
    private int generarEnteroUnDigito() {
        // nextInt(9) genera 0 a 8. Sumando 1 se obtiene 1 a 9.
        return random.nextInt(9) + 1;
    }

    /**
     * Genera una retroalimentación aleatoria para respuestas correctas o incorrectas.
     * Usa un número aleatorio (1-4) y un switch para variar el diálogo.
     * @param esCorrecta true para retroalimentación positiva, false para negativa.
     */
    private void generarRetroalimentacion(boolean esCorrecta) {
        // Genera un número entre 1 y 4
        int selector = random.nextInt(4) + 1; 
        String claveMensaje = "";
        
        if (esCorrecta) {
            claveMensaje = "RESPUESTA_CORRECTA_" + selector;
        } else {
            claveMensaje = "RESPUESTA_INCORRECTA_" + selector;
        }
        
        // Imprime el mensaje aleatorio
        System.out.println(Utilidades.getTexto(idioma, claveMensaje));
    }

    /**
     * Lee y valida la respuesta entera del estudiante.
     * @param scanner El objeto Scanner.
     * @return La respuesta entera ingresada, o 0 si la entrada es inválida/cero.
     */
    private int leerRespuesta(Scanner scanner) {
        int respuesta = 0;
        
        System.out.print(Utilidades.getTexto(idioma, "PROMPT_RESPUESTA"));
        try {
            if (scanner.hasNextInt()) {
                respuesta = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_INT"));
                scanner.nextLine(); 
            }
        } catch (InputMismatchException e) {
            // Ya cubierto por el else
        }
        return respuesta;
    }
}
