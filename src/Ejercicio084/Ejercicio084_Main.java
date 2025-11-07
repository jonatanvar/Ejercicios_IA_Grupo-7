// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #84                                                    ║
// ║ Prompt original:                                                           ║
// ║ "Nos gustan los ángulos rectos: Cree una librería que imprima diversos      ║
// ║ tipos de cuadrados y triángulos. El programa debe permitir al usuario       ║
// ║ elegir la figura, el carácter y las dimensiones, validando entradas y       ║
// ║ asegurando que los rectángulos cumplan que el lado largo sea doble del corto."║
// ║ Fecha: 2025-11-11                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio084 | 2025-11-11

package Ejercicio084;

public class Ejercicio084_Main {

    public static void main(String[] args) {

        Ejercicio084_Menus.seleccionarIdioma();  // Selección de idioma

        boolean continuar = true;

        while (continuar) {
            boolean ejecutar = Ejercicio084_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio084_Operaciones.seleccionarFigura();
            } else {
                continuar = false;
            }
        }
    }
}