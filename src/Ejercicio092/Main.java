/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 092 | 2025-10-23               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Ejercicio #92 agente que es como los anteriores, ya que ese
 * depende de otro, pero siempre te daré el contexto necesario, este es el enunciado:
 * Al programa "Es otro ejercicio acá abajo te lo dejo" (“Te leo, te pongo atención y te supero” )
 * Modifique el programa “Te leo y te pongo atención” (que es otro ejercicio que ya te mando)
 *  : Modifique el programa “Te leo, de verdad ”para que, usando una
 * función, no permita ingresar valores repetidos. Y ese ejercicios depende de este ultimo que dice:
 * Hacer un programa que pida al usuario un número entero mayor que diez y
 * menor que cien, luego leer tantos números como el que haya ingresado el usuario
 * entonces muestre en una lista todos los números separados por coma
 * (el último lleva punto después de él y la letra “y” en lugar de coma antes que él.
 *  Y pida al usuario cinco números (almacenados en un solo arreglo) esos números deben
 * estar entre 0 y el primer número que se le pidió ingresar al usuario y, finalmente mostrar
 *  una tabla donde aparezcan estos cinco números en la primera columna y en la segunda el número
 *  de la lista de números en la posición de la primera columna. Así:
 * Notar 25, 65 y 8.
 *
 * Ya con todo ese contexto nuestro ejercicio  termina diciendo lo siguiente:
 * Al programa “Te leo, te pongo atención y te supero” agregar lo
 * siguiente:
 * a. Función espar(float) que, retornando un booleano, determina si el valor recibido es par.
 * b. Usando la función espar() contar los números pares e impares de la salida final (los cinco
 * mostrados en la tabla)
 * c. Después de la tabla aparezcan total de pares, total de impares y total de haber sumado los
 * valores, los cuadrados y los cubos.
 * d. Total de valores, total de cuadrados, total de cubos, total de pares e impares no son variables
 * diferentes, todas son partes del vector TOTALES.
 *
 *Ya con todo eso genera el código que necesitamos que es el #92.
 * con los parámetros nuevos y los que hemos asado siempre.
 */

package Ejercicio092;

import java.util.Scanner;
import Ejercicio092.MiLibrería;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MiLibrería.iniciarPrograma(scanner);
        scanner.close();
    }
}