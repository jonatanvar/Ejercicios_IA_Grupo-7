// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ UTILIDADES GRÁFICAS (bordes, centrado y sello)                             ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio037 | 2025-11-05

        package Ejercicio037;

public class Ejercicio037_Utilidades {

    public static void mostrarEncabezado(String titulo) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.printf ("║ %-60s ║\n", titulo);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarPie(String mensaje) {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.printf ("║ %-60s ║\n", mensaje);
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }

    public static void mostrarSelloCorto() {
        System.out.println("\n[Dany Noguera | Ejercicio037]\n");
    }
}