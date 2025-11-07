// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #52                                                    ║
// ║ Prompt original:                                                           ║
// ║ "Traza tu destino: Un programa que pida al usuario un entero entre uno     ║
// ║ (1) y cincuenta (50) y luego comience a pedir que ingrese tantos números   ║
// ║ como número entero indicó. Cuando se hayan leído todos debe mostrar:       ║
// ║   a) Cantidad de números pares leídos.                                     ║
// ║   b) Cantidad de números impares leídos.                                   ║
// ║   c) Cantidad de números de una cifra, de dos, de tres y más de tres.      ║
// ║ Se debe usar funciones para determinar par, impar y cantidad de cifras."   ║
// ║ Fecha: 2025-11-05                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio052 | 2025-11-05

package Ejercicio052;

public class Ejercicio052_Main {

    public static void main(String[] args) {

        Ejercicio052_Menus.seleccionarIdioma();  // Selección de idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio052_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio052_Operaciones.trazaTuDestino();
            } else {
                continuar = false;
            }
        }
    }
}