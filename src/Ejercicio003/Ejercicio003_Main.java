/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 003 | 2025-10-09               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio003;

import java.util.Scanner;

/*
 * PROMPT USADO:
 * "agente el #3 hagamos, te recuero nuestro sistema de archivo, en este usa los 3 que son:
 * ├── Ejercicio003_Main.java (Programa principal) ├── Ejercicio003_Utilidades.java
 *  (Funciones de utilidad) └── Ejercicio003_Operaciones.java (Lógica del ejercicio)
 * Incluye también nuestro sello en la versión corta hecha en el #2. el anunciado es el siguiente:
 * Aritmética pre-básica: Escriba un programa que pida al usuario que escriba dos números,
 *  que obtenga los números del usuario e imprima la suma y la diferencia del primero con el segundo número.
 *  que el resultado salga en un cuadro elegante como el sello"
 */

public class Ejercicio003_Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numeros = new double[2];

        Ejercicio003_Utilidades.mostrarSaludo();
        Ejercicio003_Utilidades.mostrarIngresoNumeros(scanner, numeros);

        double suma = Ejercicio003_Operaciones.sumar(numeros[0], numeros[1]);
        double resta = Ejercicio003_Operaciones.restar(numeros[0], numeros[1]);

        Ejercicio003_Utilidades.mostrarResultado(suma, resta);
        Ejercicio003_Utilidades.mostrarSelloCorto();

        scanner.close();
        System.out.println("\n" + LINEA.repeat(ANCHO));
        System.out.println("*** Operaciones completadas exitosamente ***");
        System.out.println(LINEA.repeat(ANCHO));
    }
}