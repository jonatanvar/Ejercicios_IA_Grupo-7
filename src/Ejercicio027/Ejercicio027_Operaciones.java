// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #27                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio027 | 2025-11-05

package Ejercicio027;

import java.util.Scanner;

public class Ejercicio027_Operaciones {

    public static void sumarSecuencia() {

        Scanner sc = new Scanner(System.in);

        Ejercicio027_Utilidades.mostrarEncabezado(
                Ejercicio027_Menus.obtenerIdioma().equals("ES") ?
                        "SUMA DE SECUENCIA DE ENTEROS" :
                        "SUM OF INTEGER SEQUENCE"
        );

        System.out.print("Ingrese la cantidad de valores a sumar: ");
        int cantidad = sc.nextInt();

        int suma = 0;
        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingrese el valor #" + i + ": ");
            int valor = sc.nextInt();
            suma += valor;
        }

        System.out.println("\n-------------------------------------");
        System.out.println("La suma total es: " + suma);
        System.out.println("-------------------------------------");

        // Sello corto antes del pie final
        Ejercicio027_Utilidades.mostrarSelloCorto();
        Ejercicio027_Utilidades.mostrarPie("Proceso finalizado con éxito.");
    }
}
