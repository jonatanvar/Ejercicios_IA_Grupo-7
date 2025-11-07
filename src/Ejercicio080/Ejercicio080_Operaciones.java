// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Operaciones lógicas del ejercicio #80                                      ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio080 | 2025-11-10

package Ejercicio080;

public class Ejercicio080_Operaciones {

    public static void generarTabla() {
        String idioma = Ejercicio080_Menus.obtenerIdioma();

        Ejercicio080_Utilidades.mostrarEncabezado(
                idioma.equals("ES") ? "TABLA DE MULTIPLICAR" : "MULTIPLICATION TABLE"
        );

        System.out.println(idioma.equals("ES") ?
                "Bienvenido al programa de tablas de multiplicar." :
                "Welcome to the multiplication table program."
        );

        int limite = Ejercicio080_Utilidades.leerEntero(
                idioma.equals("ES") ? "Ingrese un número entre 1 y 15: " : "Enter a number between 1 and 15: ",
                1, 15
        );

        // Ciclos para generar tabla
        for (int i = 1; i <= limite; i++) {
            for (int j = 1; j <= limite; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        Ejercicio080_Utilidades.mostrarSelloCorto();
        Ejercicio080_Utilidades.mostrarPie(
                idioma.equals("ES") ? "Proceso finalizado con éxito." : "Process completed successfully."
        );
    }
}