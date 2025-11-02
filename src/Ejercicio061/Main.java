/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 061 | 2025-10-15 19:10 CST    │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente tenemos que hacer el Ejercicio#61 que deben de permanecer los parámetros de los
 *  ejercicios anteriores, el ejercicios da como base un ejercicio que no nos toco realizar,
 *  que este este simplemente conta de esto (Figuras v2:Hacer un programa que elija entre
 * cualquiera de las siguientes figuras: Círculo, cuadrado, triángulo, rectángulo y
 * rombo y depende de la figura elegida solicite la información necesaria para hacer el
 *  cálculo de su área y de su perímetro. Debe mostrar la figura seleccionada (nombre y dibujada),
 *  las entradas del usuario y los resultados obtenidos.)
 * Nuestro ejercicio es de  Use técnicas similares a las desarrolladas en los ejercicios “
 * Figuras v2” y “Alinea ésta” (un ejercicio anterior de diseño)
 * para producir un programa que grafique un amplio rango de figuras (triángulo
 * alineado a la izquierda, a la derecha, estilo pirámide, rombo, cuadrado vacío,
 * cuadrado lleno, triángulo invertido alineado a la izquierda, triángulo invertido
 * alineado a la derecha y triángulo estilo pirámide invertida) cada figura es una función distinta.
 * Muestra un menú al usuario de todo lo que el programa puede diseñar, en que lado
 *                                 quiere que se muestre la figura seleccionada, siempre valida lo que el usuario ingresa, siempre nuestro sistema de 4 archivos, y con el diseño elegante en los menús que caracteriza nuestro ejercicios.
 */

package Ejercicio061;

import java.util.Scanner;
import Ejercicio061.Menús;

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
        int figura = Operaciones.leerYValidarFigura(scanner, idioma);
        int tamaño = Operaciones.leerYValidarTamaño(scanner, idioma);
        String alineacion = Operaciones.leerYValidarAlineacion(scanner, idioma, figura);
        Utilidades.mostrarFigura(figura, tamaño, alineacion, idioma);
    }
}