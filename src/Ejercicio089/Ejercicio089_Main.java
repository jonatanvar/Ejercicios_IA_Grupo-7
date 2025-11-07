// ╔══════════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                               ║
// ║ Proyecto: Ejercicio #89                                                          ║
// ║ Prompt original:                                                                 ║
// ║ "Te leo, de verdad: Hacer un programa que pida al usuario un número entero       ║
// ║ mayor que diez y menor que cien, luego leer tantos números como el número        ║
// ║ inicial, mostrando la lista de números con formato especial, y luego leer        ║
// ║ cinco números en un arreglo y mostrar una tabla con su posición correspondiente."║
// ║ Fecha: 2025-11-12                                                                ║
// ╚══════════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio089 | 2025-11-12

package Ejercicio089;

public class Ejercicio089_Main {

    public static void main(String[] args) {

        Ejercicio089_Menus.seleccionarIdioma();

        boolean continuar = true;

        while (continuar) {
            boolean ejecutar = Ejercicio089_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio089_Operaciones.teLeoDeVerdad();
            } else {
                continuar = false;
            }
        }
    }
}