// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #42                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio042 | 2025-11-05

package Ejercicio042;

import java.util.Scanner;

public class Ejercicio042_Operaciones {

    public static void dibujarTriangulo() {
        Scanner sc = new Scanner(System.in);
        String idioma = Ejercicio042_Menus.obtenerIdioma();

        Ejercicio042_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "TRIÁNGULO SEGÚN ALTURA" : "TRIANGLE BY HEIGHT"
        );

        System.out.print(idioma.equals("ES") ? "Ingrese la altura del triángulo: " :
                "Enter triangle height: ");
        int altura = sc.nextInt();

        System.out.println();

        for (int i = 1; i <= altura; i++) {
            // Espacios a la izquierda
            for (int j = 1; j <= altura - i; j++) System.out.print(" ");
            // Asteriscos del triángulo
            for (int k = 1; k <= (2 * i - 1); k++) System.out.print("*");
            System.out.println();
        }

        // Sello corto antes del pie final
        Ejercicio042_Utilidades.mostrarSelloCorto();
        Ejercicio042_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Triángulo dibujado correctamente." :
                        "Triangle drawn successfully."
        );
    }
}