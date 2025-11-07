// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #62                                                    ║
// ║ Prompt original:                                                           ║
// ║ "Disminuyendo: Escriba un programa que reciba tres números de punto        ║
// ║  flotante de precisión doble, y que los pase a una función que devuelva    ║
// ║  el número más pequeño."                                                   ║
// ║ Fecha: 2025-11-06                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio062 | 2025-11-06

package Ejercicio062;

public class Ejercicio062_Main {

    public static void main(String[] args) {

        Ejercicio062_Menus.seleccionarIdioma(); // Selección de idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio062_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio062_Operaciones.disminuyendo();
            } else {
                continuar = false;
            }
        }
    }
}