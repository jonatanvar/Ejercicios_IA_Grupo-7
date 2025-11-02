/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 006 | 2025-10-09               │
 * └─────────────────────────────────────────────────────────────────────────┘
 */

package Ejercicio006;

import java.util.Scanner;

/*
 * PROMPT USADO:
 * "Agente necesito que realicemos el ejercicio #6,
 * te recuerdo que en todo deben de ir el sello anteriormente hecho, y nuestra distribución de 3 archivos:
 *   └── Ejercicio###/
 *    ├── Ejercicio###_Main.java → Control del flujo principal (Acá debe de ir el prompt)
 *    ├── Ejercicio###_Utilidades.java → Cuadros, sellos y formato estético.
 * └── Ejercicio###_Operaciones.java → Lógica matemática o funcional.
 *  Necesito que mejoremos este ejercicio: Aritmética pre-básica:
 *  Escriba un programa que pida al usuario que escriba dos números,
 * que obtenga los números del usuario e imprima la suma y la diferencia del primero con el segundo número.
 *  debemos de implementar estas mejoras:
 * Aritmética truqueada: permitir que de manera que siempre se le reste al mayor el menor
 * y que nunca permita la división por cero, para esto si será posible dividir los números
 * lo hará sin problemas si no se le mostrará un mensaje al usuario que no se mostrará la división luego,
 * mostrará los números ordenados de mayor a menor y procederá a realizar y mostrar las operaciones
 * aritméticas posibles. También brinda un mensaje que no se puede dividir entre 0, pero que el programa
 * siga corriendo, al hacer la resta siempre se le reste al mayor el menor, junto con todo lo demás que te
 *   corresponde hacer. Muestra el resultado de la suma, resta y división"
 *
 */

public class Ejercicio006_Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numeros = new double[2];

        Ejercicio006_Utilidades.mostrarSaludo();
        Ejercicio006_Utilidades.mostrarIngresoNumeros(scanner, numeros);

        double mayor = Math.max(numeros[0], numeros[1]);
        double menor = Math.min(numeros[0], numeros[1]);

        double suma = Ejercicio006_Operaciones.sumar(mayor, menor);
        double resta = Ejercicio006_Operaciones.restar(mayor, menor);
        double division = 0.0;
        boolean divisionPosible = menor != 0;
        if (divisionPosible) {
            division = Ejercicio006_Operaciones.dividir(mayor, menor);
        }

        Ejercicio006_Utilidades.mostrarResultado(mayor, menor, suma, resta, division, divisionPosible);
        Ejercicio006_Utilidades.mostrarSelloCorto();

        scanner.close();
        System.out.println("\n" + LINEA.repeat(ANCHO));
        System.out.println("*** Operaciones completadas exitosamente ***");
        System.out.println(LINEA.repeat(ANCHO));
    }
}