/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 083 | 2025-10-22               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente tenemos un nuevo ejercicio similar al anterior, solo que esta vez nosotros
 *  si hicimos el ejercicio base (70), nosotros debemos de implementar nuestra librería
 * donde van los ciclos, funciones y nuestras librerías propias, el ejercicio que debemos
 *  de hacer es el #83 que consta de lo siguiente:
 * Modifique el programa del ejercicio “Instrucción asistida por computadora” para
 * implementar una librería propia.
 * Y el ejercicio Instrucción asistida por computadora es este:
 * Instrucción asistida por computadora mejorado: Los sistemas de instrucción asistida
 * por computadora más sofisticados supervisan el rendimiento del estudiante durante cierto
 *  tiempo. La decisión de empezar un nuevo tema se basa a menudo en el éxito del estudiante
 *  con los temas anteriores. Modifique el programa “Instrucción asistida por computadora”
 * para contar el número
 * de respuestas correctas e incorrectas por parte del estudiante. Una vez que el estudiante
 * escriba 10 respuestas, su programa debe calcular el porcentaje de respuestas
 *  correctas. Si éste es menor del 75%, el programa deberá imprimir Por favor
 *  pida ayuda adicional a su instructor y terminar.
 * En tu ventana de contextos estará el ejercicio 70, modifícalo y elimina las
 * carpetas que no necesitamos, y agrega la carpeta de MiLibreria en este nuevo ejercicio
 */

package Ejercicio083;

import java.util.Scanner;
import Librerías.MiLibrería;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}