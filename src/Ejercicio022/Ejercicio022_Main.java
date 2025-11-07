// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #22                                                    ║
// ║ Prompt:                                                                    ║
// ║ "El proceso de encontrar el número más grande (es decir, el máximo de un   ║
// ║ grupo de números) se utiliza frecuentemente en aplicaciones de computadora.║
// ║ Escriba un programa que utilice una instrucción WHILE para determinar e    ║
// ║ imprimir el mayor número de una serie de 10 números introducidos por el    ║
// ║ usuario."                                                                  ║
// ║ Fecha: 2025-11-04                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio022 | 2025-11-04

package Ejercicio022;

public class Ejercicio022_Main {

    public static void main(String[] args) {

        Ejercicio022_Menus.seleccionarIdioma();
        boolean ejecutar = Ejercicio022_Menus.menuInicioSalir();

        if (ejecutar) {
            Ejercicio022_Operaciones.encontrarMayor();
        }
    }
}
