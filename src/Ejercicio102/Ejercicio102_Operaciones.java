// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #102                                     ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio102 | 2025-11-06

package Ejercicio102;

import java.util.Scanner;

public class Ejercicio102_Operaciones {

    public static void procesarNumeros() {

        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio102_Menus.obtenerIdioma();

        Ejercicio102_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "NÚMEROS SIN DUPLICADOS" : "UNIQUE NUMBERS"
        );

        int[] numerosUnicos = new int[20]; // Se usa el arreglo más pequeño posible
        int cantidadUnicos = 0;

        for (int i = 1; i <= 20; i++) {

            int num;
            boolean valido, duplicado;

            do {
                valido = true;
                duplicado = false;

                System.out.print(idioma.equals("ES") ?
                        "Ingrese un número entre 10 y 100 (" + i + "/20): " :
                        "Enter a number between 10 and 100 (" + i + "/20): ");

                num = sc.nextInt();

                if (num < 10 || num > 100) {
                    valido = false;
                    System.out.println(idioma.equals("ES") ?
                            "❌ Error: Debe estar entre 10 y 100." :
                            "❌ Error: Must be between 10 and 100.");
                } else {
                    for (int j = 0; j < cantidadUnicos; j++) {
                        if (numerosUnicos[j] == num) {
                            duplicado = true;
                            System.out.println(idioma.equals("ES") ?
                                    "⚠️ Número duplicado, no será almacenado." :
                                    "⚠️ Duplicate number, not stored.");
                            break;
                        }
                    }
                }

            } while (!valido);

            if (!duplicado) {
                numerosUnicos[cantidadUnicos] = num;
                cantidadUnicos++;
            }
        }

        System.out.println(idioma.equals("ES") ?
                "\n✅ Números únicos ingresados:" :
                "\n✅ Unique numbers entered:");

        Ejercicio102_Utilidades.imprimirArreglo(numerosUnicos, cantidadUnicos);

        Ejercicio102_Utilidades.mostrarSelloCorto();
        Ejercicio102_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }
}