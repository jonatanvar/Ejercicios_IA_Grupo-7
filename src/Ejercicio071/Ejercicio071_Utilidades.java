// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Utilidades gráficas y estética visual                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio071 | 2025-11-07

package Ejercicio071;

public class Ejercicio071_Utilidades {

    public static void mostrarEncabezado(String titulo) {
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-68s ║\n", titulo);
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarPie(String msg) {
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ %-68s ║\n", msg);
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarSelloCorto() {
        System.out.println("\n[Dany Noguera | Ejercicio071]\n");
    }
}