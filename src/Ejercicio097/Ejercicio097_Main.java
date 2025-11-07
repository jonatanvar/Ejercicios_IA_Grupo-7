// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #97                                                    ║
// ║ Prompt:                                                                     ║
// ║ "Matriz: Haga un programa que solicite al usuario dos números enteros M y N  ║
// ║ entre 2 y 5, crear una matriz MxN y primero inicializarla en cero,          ║
// ║ mandarla a imprimir, luego sustituir las filas impares por números aleatorios║
// ║ y mandarla a imprimir, finalmente sustituir las columnas pares y mandar a   ║
// ║ imprimir la matriz en este estado final."                                   ║
// ║ Fecha: 2025-11-06                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio097 | 2025-11-06

package Ejercicio097;

public class Ejercicio097_Main {

    public static void main(String[] args) {

        Ejercicio097_Menus.seleccionarIdioma(); // Selección de idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio097_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio097_Operaciones.matrizOperacion();
            } else {
                continuar = false;
            }
        }
    }
}