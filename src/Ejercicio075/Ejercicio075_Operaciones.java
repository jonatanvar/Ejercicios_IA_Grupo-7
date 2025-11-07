// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #75                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio075 | 2025-11-08

package Ejercicio075;

public class Ejercicio075_Operaciones {

    public static void mostrarTablaTrigonometria() {
        String idioma = Ejercicio075_Menus.obtenerIdioma();
        Ejercicio075_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "TABLA TRIGONOMÉTRICA" : "TRIGONOMETRIC TABLE"
        );

        int contador = 0;
        System.out.printf("%-15s%-15s%-15s%-15s\n", "Grados", "Seno", "Coseno", "Tangente");
        System.out.println("--------------------------------------------------------------");

        for (int grados = 0; grados <= 360; grados++) {
            System.out.printf("%-15d%-15.3f%-15.3f", grados, calcularSeno(grados), calcularCoseno(grados));

            // Control de tangente para 90 y 270
            if (grados % 180 == 90) {
                System.out.printf("%-15s\n", "Indef");
            } else {
                System.out.printf("%-15.3f\n", calcularTangente(grados));
            }

            contador++;
            if (contador % 50 == 0) {
                Ejercicio075_Utilidades.pausarTabla();
                // Reimprimir encabezado
                System.out.printf("\n%-15s%-15s%-15s%-15s\n", "Grados", "Seno", "Coseno", "Tangente");
                System.out.println("--------------------------------------------------------------");
            }
        }

        Ejercicio075_Utilidades.mostrarSelloCorto();
        Ejercicio075_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }

    public static double calcularSeno(double grados) {
        return Math.sin(Math.toRadians(grados));
    }

    public static double calcularCoseno(double grados) {
        return Math.cos(Math.toRadians(grados));
    }

    public static double calcularTangente(double grados) {
        return Math.tan(Math.toRadians(grados));
    }
}