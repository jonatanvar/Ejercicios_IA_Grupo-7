// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #27                                                    ║
// ║ Prompt:                                                                    ║
// ║ "Escriba un programa que utilice una instrucción for para sumar una        ║
// ║ secuencia de enteros. Suponga que el primer entero leído especifica el     ║
// ║ número de valores que quedan por introducir. Su programa debe leer sólo    ║
// ║ un valor por cada instrucción de entrada. Ejemplo de entrada:              ║
// ║ 5 100 200 300 400 500"                                                     ║
// ║ Fecha: 2025-11-05                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio027 | 2025-11-05

package Ejercicio027;

public class Ejercicio027_Main {

    public static void main(String[] args) {

        Ejercicio027_Menus.seleccionarIdioma();
        boolean ejecutar = Ejercicio027_Menus.menuInicioSalir();

        if (ejecutar) {
            Ejercicio027_Operaciones.sumarSecuencia();
        }
    }
}