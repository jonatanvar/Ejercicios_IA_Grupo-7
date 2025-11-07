// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #32                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio032 | 2025-11-05

package Ejercicio032;

public class Ejercicio032_Operaciones {

    public static void calcularFactoriales() {

        Ejercicio032_Utilidades.mostrarEncabezado(
                Ejercicio032_Menus.obtenerIdioma().equals("ES") ?
                        "FACTORIALES DEL 1 AL 5" :
                        "FACTORIALS FROM 1 TO 5"
        );

        System.out.println("\nNúmero\tFactorial");
        System.out.println("-----------------");

        for (int i = 1; i <= 5; i++) {
            long factorial = 1;
            for (int j = 1; j <= i; j++) {
                factorial *= j;
            }
            System.out.printf("%d\t%6d\n", i, factorial);
        }

        // Sello corto antes del pie final
        Ejercicio032_Utilidades.mostrarSelloCorto();
        Ejercicio032_Utilidades.mostrarPie("Proceso finalizado con éxito.");
    }
}