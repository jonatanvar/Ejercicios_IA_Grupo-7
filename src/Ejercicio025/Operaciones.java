/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 025 | 2025-10-23
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que lee tres enteros y determina si pueden ser los lados de un triángulo rectángulo (Teorema de Pitágoras), usando menús de idioma y control.
 */

package Ejercicio_025;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays; // Necesario para ordenar los lados

/**
 * Módulo Operaciones: Implementa la lógica principal del negocio, que es la lectura
 * de los tres lados y la verificación del Teorema de Pitágoras para determinar
 * si forman un triángulo rectángulo.
 */
public class Operaciones {

    private final String idioma; // Almacena el idioma seleccionado

    /**
     * Constructor para inicializar la clase con el idioma actual.
     * @param idioma La clave del idioma ("ES" o "EN").
     */
    public Operaciones(String idioma) {
        this.idioma = idioma;
    }

    /**
     * Coordina la entrada de datos de los lados y la determinación del tipo de triángulo.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     */
    public void determinarTrianguloRectangulo(Scanner scanner) {
        
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + " ---");
        System.out.println(Utilidades.getTexto(idioma, "MSG_INSTRUCCION_LADOS"));
        
        // Array para almacenar los tres lados
        int[] lados = new int[3];

        // Ciclo para solicitar los tres lados
        for (int i = 0; i < 3; i++) {
            System.out.print(Utilidades.getTexto(idioma, "PROMPT_LADO") + (i + 1) + ": ");
            
            // Ciclo interno para asegurar la entrada de un entero positivo y distinto de cero
            int lado = 0;
            boolean entradaValida = false;
            while (!entradaValida) {
                try {
                    lado = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    
                    if (lado > 0) {
                        lados[i] = lado;
                        entradaValida = true;
                    } else {
                        System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_NEGATIVA"));
                        System.out.print(Utilidades.getTexto(idioma, "PROMPT_LADO") + (i + 1) + ": ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA"));
                    scanner.nextLine(); // Limpiar la entrada inválida
                    System.out.print(Utilidades.getTexto(idioma, "PROMPT_LADO") + (i + 1) + ": ");
                }
            }
        }
        
        // Determinar si los lados forman un triángulo rectángulo
        boolean esRectangulo = esTrianguloRectangulo(lados[0], lados[1], lados[2]);

        // Mostrar el resultado
        if (esRectangulo) {
            System.out.printf(Utilidades.getTexto(idioma, "MSG_RESULTADO_RECTO"), lados[0], lados[1], lados[2]);
        } else {
            System.out.printf(Utilidades.getTexto(idioma, "MSG_RESULTADO_NO_RECTO"), lados[0], lados[1], lados[2]);
        }
    }

    /**
     * Aplica el Teorema de Pitágoras para verificar si tres lados forman un triángulo rectángulo.
     * La lógica ordena los lados para identificar fácilmente los catetos (a, b) y la hipotenusa (c).
     * * @param lado1 Longitud del primer lado.
     * @param lado2 Longitud del segundo lado.
     * @param lado3 Longitud del tercer lado.
     * @return true si cumplen con a^2 + b^2 = c^2, false en caso contrario.
     */
    private boolean esTrianguloRectangulo(int lado1, int lado2, int lado3) {
        // 1. Almacenar los lados en un array y ordenarlos
        int[] lados = {lado1, lado2, lado3};
        Arrays.sort(lados); // Ordena de menor a mayor

        // Lados ordenados: a, b (catetos) y c (hipotenusa)
        long a = lados[0]; // Se usa long para prevenir overflow en el cálculo del cuadrado, aunque int debería ser suficiente.
        long b = lados[1];
        long c = lados[2];

        // 2. Aplicar el Teorema de Pitágoras: a^2 + b^2 = c^2
        // Se multiplica directamente (a * a) para mantener la precisión de enteros
        return (a * a + b * b) == (c * c);
    }
}
