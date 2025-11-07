// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #22                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio022 | 2025-11-04

package Ejercicio022;

import java.util.Scanner;

public class Ejercicio022_Operaciones {

    public static void encontrarMayor() {

        Scanner sc = new Scanner(System.in);
        int contador = 1;
        int numero;
        int mayor = Integer.MIN_VALUE;

        Ejercicio022_Utilidades.mostrarEncabezado(
                Ejercicio022_Menus.obtenerIdioma().equals("ES") ?
                        "MÁXIMO DE 10 NÚMEROS" :
                        "MAXIMUM OF 10 NUMBERS"
        );

        while (contador <= 10) {
            System.out.printf("Ingrese el número #%d: ", contador);
            numero = sc.nextInt();

            if (numero > mayor) {
                mayor = numero;
            }
            contador++;
        }

        System.out.println("\n-------------------------------------");
        System.out.println("El número mayor es: " + mayor);
        System.out.println("-------------------------------------");

        // ✅ Sello corto antes del mensaje final (tu requisito)
        Ejercicio022_Utilidades.mostrarSelloCorto();
        Ejercicio022_Utilidades.mostrarPie("Proceso finalizado con éxito.");
    }
}