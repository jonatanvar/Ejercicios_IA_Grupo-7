// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #110                                                   ║
// ║ Prompt:                                                                     ║
// ║ "Casi phd en dos dimensiones: Pedir al usuario que ingrese un número mayor   ║
// ║ a 2 y menor a 15, con ese número crear una matriz cuadrada y llenarla con    ║
// ║ números positivos (generados con una función). Luego mostrar la matriz       ║
// ║ usando una función y después mostrar su transpuesta con otra función."      ║
// ║ Fecha: 2025-11-06                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio110 | 2025-11-06

package Ejercicio110;

public class Ejercicio110_Main {

    public static void main(String[] args) {

        Ejercicio110_Menus.seleccionarIdioma(); // Selección de idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio110_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio110_Operaciones.matrizCuadradaOperacion();
            } else {
                continuar = false;
            }
        }
    }
}