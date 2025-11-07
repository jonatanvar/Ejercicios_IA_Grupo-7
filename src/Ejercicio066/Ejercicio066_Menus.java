// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Menús del sistema                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio066 | 2025-11-06

package Ejercicio066;

import java.util.Scanner;

public class Ejercicio066_Menus {

    private static String idioma = "ES";

    public static void seleccionarIdioma() {

        Scanner sc = new Scanner(System.in);
        Ejercicio066_Utilidades.mostrarEncabezado("SELECCIÓN DE IDIOMA / LANGUAGE SELECTION");

        System.out.println("1. Español");
        System.out.println("2. English");
        System.out.print("Seleccione / Select: ");
        int opcion = sc.nextInt();

        idioma = (opcion == 2) ? "EN" : "ES";
    }

    public static boolean menuInicioSalir() {
        Scanner sc = new Scanner(System.in);

        Ejercicio066_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "MENÚ PRINCIPAL" : "MAIN MENU"
        );

        System.out.println(idioma.equals("ES") ?
                "1. Iniciar programa" :
                "1. Start program");
        System.out.println(idioma.equals("ES") ?
                "2. Finalizar" :
                "2. Exit");
        System.out.print(idioma.equals("ES") ?
                "Seleccione una opción: " :
                "Select an option: ");

        int opcion = sc.nextInt();

        return opcion == 1;
    }

    public static String obtenerIdioma() {
        return idioma;
    }
}