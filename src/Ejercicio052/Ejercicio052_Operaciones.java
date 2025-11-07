// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #52                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio052 | 2025-11-05

package Ejercicio052;

import java.util.Scanner;

public class Ejercicio052_Operaciones {

    public static void trazaTuDestino() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio052_Menus.obtenerIdioma();

        Ejercicio052_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "TRAZA TU DESTINO" : "TRACE YOUR DESTINY"
        );

        int cantidadNumeros = 0;

        do {
            System.out.print(idioma.equals("ES") ?
                    "Ingrese un número entre 1 y 50: " :
                    "Enter a number between 1 and 50: ");

            cantidadNumeros = sc.nextInt();

        } while (cantidadNumeros < 1 || cantidadNumeros > 50);

        // Contadores
        int pares = 0, impares = 0;
        int unaCifra = 0, dosCifras = 0, tresCifras = 0, masTresCifras = 0;

        for (int i = 1; i <= cantidadNumeros; i++) {

            int numero;
            do {
                System.out.print(idioma.equals("ES") ?
                        "Ingrese un número (" + i + "/" + cantidadNumeros + "): " :
                        "Enter number (" + i + "/" + cantidadNumeros + "): ");
                numero = sc.nextInt();
            } while (numero < 0); // No permitir negativos

            if (esPar(numero)) pares++;
            else impares++;

            int cifras = contarCifras(numero);

            if (cifras == 1) unaCifra++;
            else if (cifras == 2) dosCifras++;
            else if (cifras == 3) tresCifras++;
            else masTresCifras++;
        }

        System.out.println("\n───────────── RESULTADOS ─────────────\n");
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
        System.out.println("De 1 cifra : " + unaCifra);
        System.out.println("De 2 cifras: " + dosCifras);
        System.out.println("De 3 cifras: " + tresCifras);
        System.out.println("Más de 3 cifras: " + masTresCifras);

        Ejercicio052_Utilidades.mostrarSelloCorto();
        Ejercicio052_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }

    // ===== FUNCIONES OBLIGATORIAS =====
    public static boolean esPar(int n) {
        return n % 2 == 0;
    }

    public static boolean esImpar(int n) {
        return n % 2 != 0;
    }

    public static int contarCifras(int n) {
        return Integer.toString(n).length();
    }
}