// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Metadatos: Dany Noguera | dany.noguera@unah.hn | 017 | 2025-11-04         ║
// ║ Resumen: Menús de idioma y acción.                                        ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | dany.noguera@unah.hn | 017 | 2025-11-04

package Ejercicio017;
import java.util.Scanner;

public class Ejercicio017_Menus {

    /** Selección de idioma */
    public static int menuIdioma(Scanner sc) {
        System.out.println("Seleccione idioma / Select language:");
        System.out.println("1. Español");
        System.out.println("2. English");
        System.out.print("> ");
        return sc.nextInt();
    }

    /** Menú de ejecutar/salir */
    public static boolean menuAccion(Scanner sc, int idioma) {
        System.out.println((idioma == 1) ? "\nSeleccione una opción:" : "\nSelect an option:");
        System.out.println((idioma == 1) ? "1. Ejecutar programa" : "1. Run program");
        System.out.println((idioma == 1) ? "2. Salir" : "2. Exit");
        System.out.print("> ");
        int opcion = sc.nextInt();
        return opcion == 1;
    }
}
