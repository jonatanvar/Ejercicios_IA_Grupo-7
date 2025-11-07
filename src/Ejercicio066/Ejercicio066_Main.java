// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #66                                                    ║
// ║ Prompt original:                                                           ║
// ║ "¿Qué tan bueno de 1 a 4?: Escriba una función llamada puntosCalidad que   ║
// ║ reciba como entrada el promedio de un estudiante y devuelva:               ║
// ║  4 si el promedio está entre 90 y 100                                      ║
// ║  3 si está entre 80 y 89                                                   ║
// ║  2 si está entre 70 y 79                                                   ║
// ║  1 si está entre 60 y 69                                                   ║
// ║  0 si el promedio es menor que 60"                                         ║
// ║ Fecha: 2025-11-06                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio066 | 2025-11-06

package Ejercicio066;

public class Ejercicio066_Main {

    public static void main(String[] args) {

        Ejercicio066_Menus.seleccionarIdioma(); // Idioma

        boolean continuar = true;

        while (continuar) {

            boolean ejecutar = Ejercicio066_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio066_Operaciones.evaluarPromedioEstudiante();
            } else {
                continuar = false;
            }
        }
    }
}