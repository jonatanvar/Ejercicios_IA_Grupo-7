// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Utilidades gráficas y estética visual                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio057 | 2025-11-06

package Ejercicio057;

public class Ejercicio057_Utilidades {

    public static void mostrarEncabezado(String titulo) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-60s ║\n", titulo);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarPie(String msg) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-60s ║\n", msg);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarSelloCorto() {
        System.out.println("\n[Dany Noguera | Ejercicio057]\n");
    }
}
