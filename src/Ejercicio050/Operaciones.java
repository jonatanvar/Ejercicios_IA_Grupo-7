/*
* ---------------------------------------------------------
* SELLO PERSONALIZADO - VERSIÓN CORTA
* ---------------------------------------------------------
* Erinson Alvarez | erinson.alvarez@unah.hn | 050 | 2025-10-27
* ---------------------------------------------------------
*
* PROMPT USADO: Programa que permite elegir entre 5 figuras geométricas (Círculo, Cuadrado, Triángulo, Rectángulo, Rombo), solicita sus dimensiones y calcula su área y perímetro, mostrando la figura y los resultados.
 */

package Ejercicio_050;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Módulo Operaciones: Implementa la lógica central para el Ejercicio 50.
 * Gestiona la solicitud de datos por figura, el cálculo de área/perímetro,
 * y la impresión de la figura con sus resultados.
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
     * Procesa la figura seleccionada (1-5), solicita las dimensiones y realiza los cálculos.
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @param opcionFigura El número de la figura seleccionada (1 a 5).
     */
    public void procesarFigura(Scanner scanner, int opcionFigura) {
        
        String nombreFigura = Utilidades.getTexto(idioma, "FIGURA_" + opcionFigura + "_NOMBRE");
        System.out.println("\n--- " + Utilidades.getTexto(idioma, "TITULO_OPERACIONES") + ": " + nombreFigura + " ---");

        // Variables para almacenar las entradas del usuario (dimensiones)
        double d1 = 0; // Radio / Lado / Base / Diagonal Mayor
        double d2 = 0; // Altura / Diagonal Menor
        double d3 = 0; // Lado 3 del triángulo (para perímetro)
        double ladoTriangulo2 = 0; // Lado 2 del triángulo
        double ladoTriangulo3 = 0; // Lado 3 del triángulo

        // Variables para el resultado
        double area = 0;
        double perimetro = 0;

        // 1. Solicitar entradas según la figura y realizar el cálculo
        switch (opcionFigura) {
            case 1: // Círculo
                d1 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_RADIO"));
                if (d1 <= 0) break;
                area = Math.PI * d1 * d1;
                perimetro = 2 * Math.PI * d1;
                break;
            case 2: // Cuadrado
                d1 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_LADO"));
                if (d1 <= 0) break;
                area = d1 * d1;
                perimetro = 4 * d1;
                break;
            case 3: // Triángulo (Base, Altura, Lados l1, l2, l3)
                d1 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_TRIANGULO_BASE"));
                d2 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_TRIANGULO_ALTURA"));
                
                if (d1 <= 0 || d2 <= 0) break;

                // Para el perímetro, se necesitan los tres lados. Asumiremos que el lado 1 (d1) es la base.
                System.out.println(Utilidades.getTexto(idioma, "MSG_PERIMETRO_LADOS"));
                d1 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_LADO") + " 1: "); // Lado 1 (Base)
                ladoTriangulo2 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_LADO") + " 2: ");
                ladoTriangulo3 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_LADO") + " 3: ");

                if (d1 <= 0 || ladoTriangulo2 <= 0 || ladoTriangulo3 <= 0) break;

                // Recalcular área con la base y altura originales si fueron leídas, sino usar los últimos lados.
                // Usaremos d1 (base) y d2 (altura) para el área.
                area = (d1 * d2) / 2; 
                perimetro = d1 + ladoTriangulo2 + ladoTriangulo3;
                break;
            case 4: // Rectángulo
                d1 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_RECTANGULO_BASE"));
                d2 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_RECTANGULO_ALTURA"));
                if (d1 <= 0 || d2 <= 0) break;
                area = d1 * d2;
                perimetro = 2 * (d1 + d2);
                break;
            case 5: // Rombo
                d1 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_ROMBO_DIAGONAL_MAYOR")); // D
                d2 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_ROMBO_DIAGONAL_MENOR")); // d
                d3 = leerDouble(scanner, Utilidades.getTexto(idioma, "PROMPT_ROMBO_LADO"));             // l
                if (d1 <= 0 || d2 <= 0 || d3 <= 0) break;
                area = (d1 * d2) / 2;
                perimetro = 4 * d3;
                break;
        }

        // 2. Mostrar resultados
        if (area > 0 || perimetro > 0) {
            
            // Imprimir la figura
            System.out.println("\n" + Utilidades.getTexto(idioma, "MSG_FIGURA_SELECCIONADA") + ": " + nombreFigura);
            dibujarFigura(opcionFigura);
            
            // Imprimir Entradas
            System.out.println("\n" + Utilidades.getTexto(idioma, "MSG_ENTRADAS_USUARIO"));
            switch (opcionFigura) {
                case 1: System.out.printf(Utilidades.getTexto(idioma, "RES_RADIO"), d1); break;
                case 2: System.out.printf(Utilidades.getTexto(idioma, "RES_LADO"), d1); break;
                case 3: 
                    System.out.printf(Utilidades.getTexto(idioma, "RES_BASE_ALTURA"), d1, d2);
                    System.out.printf(Utilidades.getTexto(idioma, "RES_LADOS_TRIANGULO"), d1, ladoTriangulo2, ladoTriangulo3); 
                    break;
                case 4: System.out.printf(Utilidades.getTexto(idioma, "RES_BASE_ALTURA"), d1, d2); break;
                case 5: 
                    System.out.printf(Utilidades.getTexto(idioma, "RES_DIAGONALES"), d1, d2); 
                    System.out.printf(Utilidades.getTexto(idioma, "RES_LADO"), d3); 
                    break;
            }

            // Imprimir Resultados
            System.out.println("\n" + Utilidades.getTexto(idioma, "MSG_RESULTADOS_CALCULADOS"));
            System.out.printf(Utilidades.getTexto(idioma, "RES_AREA"), area);
            System.out.printf(Utilidades.getTexto(idioma, "RES_PERIMETRO"), perimetro);
        } else if (d1 != Double.MIN_VALUE && d2 != Double.MIN_VALUE) {
             System.out.println(Utilidades.getTexto(idioma, "ERR_DIMENSION_CERO"));
        }
    }
    
    /**
     * Dibuja una representación simple en ASCII de la figura.
     * @param opcionFigura El número de la figura.
     */
    private void dibujarFigura(int opcionFigura) {
        String dibujo = "";
        switch (opcionFigura) {
            case 1: // Círculo
                dibujo = 
                    "     *** \n" +
                    "   * * \n" +
                    "  * * \n" +
                    "   * * \n" +
                    "     *** \n";
                break;
            case 2: // Cuadrado
                dibujo = 
                    "  ******* \n" +
                    "  * * \n" +
                    "  * * \n" +
                    "  * * \n" +
                    "  ******* \n";
                break;
            case 3: // Triángulo (isósceles/equilátero)
                dibujo = 
                    "      ^      \n" +
                    "     / \\     \n" +
                    "    /   \\    \n" +
                    "   /     \\   \n" +
                    "  /_______\\  \n";
                break;
            case 4: // Rectángulo
                dibujo = 
                    "  *********** \n" +
                    "  * * \n" +
                    "  * * \n" +
                    "  *********** \n";
                break;
            case 5: // Rombo
                dibujo = 
                    "      * \n" +
                    "     / \\     \n" +
                    "    /   \\    \n" +
                    "   \\     /   \n" +
                    "    \\   /    \n" +
                    "     \\ /     \n" +
                    "      * \n";
                break;
        }
        System.out.println(dibujo);
    }
    
    /**
     * Lee y valida un valor de tipo double.
     * @param scanner El objeto Scanner.
     * @param prompt El mensaje a mostrar al usuario.
     * @return El valor double leído, o Double.MIN_VALUE si hubo error.
     */
    private double leerDouble(Scanner scanner, String prompt) {
        double valor = Double.MIN_VALUE;
        boolean entradaValida = false;
        
        while (!entradaValida) {
            System.out.print(prompt);
            try {
                if (scanner.hasNextDouble()) {
                    valor = scanner.nextDouble();
                    scanner.nextLine(); 
                    if (valor >= 0) { // Se asume que las dimensiones no deben ser negativas
                        entradaValida = true;
                    } else {
                        System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_NEGATIVA"));
                    }
                } else {
                    System.out.println(Utilidades.getTexto(idioma, "ERR_ENTRADA_INVALIDA_DOUBLE"));
                    scanner.nextLine(); 
                }
            } catch (InputMismatchException e) {
                // Manejo de error ya cubierto por el else
            }
        }
        return valor;
    }
}
