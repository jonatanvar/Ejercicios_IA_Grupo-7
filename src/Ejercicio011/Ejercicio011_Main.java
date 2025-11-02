/*
 * ┌─────────────────────────────────────────────────────────────────────────┐
 * │  SELLO PERSONALIZADO - VERSIÓN CORTA                                   │
 * ├─────────────────────────────────────────────────────────────────────────┤
 * │  Jonatan Varela | jivarelag@unah.hn | 011 | 2025-10-10               │
 * └─────────────────────────────────────────────────────────────────────────┘
 *
 * PROMPT USADO:
 * Agente tenemos que hacer el ejercicio #11 que consta de lo siguiente:
 * Escriba un programa que lea cinco enteros y que determine e imprima los enteros mayor y menor en el grupo.
 * Te recuerdo siempre muestra nuestro sello personalizado, con una salida elegante y formal y la respuesta que salga de forma elegante también junto que si la entrada no es válida el programa permita reiterar la ejecución, junto con nuestra distribución de archivos que es la siguiente para que la tengas de ejemplo permanente:
 * └── Ejercicio###/
 *     ├── Ejercicio###_Main.java     → Control del flujo principal (Acá debe de ir el prompt)
 *     ├── Ejercicio###_Utilidades.java  → Cuadros, sellos y formato estético.
 *     └── Ejercicio###_Operaciones.java → Lógica matemática o funcional.
 * Y también junto que si la entrada no es válida el programa permita reiterar la ejecución.
 * Da un mensaje que solo permita enteros (positivos y negativos), en el caso de que el usuario ingrese decimal o un carácter o letra muestra un mensaje de entrada inválida, y muestra los números ingresados por el usuario.
 * Corrección: el usuario debe ingresar un solo número de 5 dígitos, no cinco números separados, y se valida que sea entero (positivo/negativo). Muestra un ejemplo de un número de 5 dígitos al usuario.
 */

package Ejercicio011;

import java.util.Scanner;

public class Ejercicio011_Main {
    private static final String LINEA = "═";
    private static final int ANCHO = 70;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] digitos = new int[5];
        boolean entradaValida;
        int numero;

        Ejercicio011_Utilidades.mostrarSaludo();

        do {
            entradaValida = Ejercicio011_Utilidades.mostrarIngresoNumero(scanner, digitos);
            if (!entradaValida) {
                Ejercicio011_Utilidades.mostrarErrorEntrada();
            }
        } while (!entradaValida);

        int mayor = Ejercicio011_Operaciones.encontrarMayor(digitos);
        int menor = Ejercicio011_Operaciones.encontrarMenor(digitos);

        Ejercicio011_Utilidades.mostrarResultado(digitos, mayor, menor);
        Ejercicio011_Utilidades.mostrarSelloCorto();

        scanner.close();
        System.out.println("\n" + LINEA.repeat(ANCHO));
        System.out.println(Ejercicio011_Utilidades.centrarTexto("*** Operaciones completadas exitosamente ***", ANCHO));
        System.out.println(LINEA.repeat(ANCHO));
    }
}