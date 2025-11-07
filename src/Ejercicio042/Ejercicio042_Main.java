// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #42                                                    ║
// ║ Prompt:                                                                    ║
// ║ "De las bermudas: Un programa que pida al usuario una altura y luego       ║
// ║ dibuje un triángulo con esa altura."                                       ║
// ║ Fecha: 2025-11-05                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio042 | 2025-11-05

package Ejercicio042;

public class Ejercicio042_Main {

    public static void main(String[] args) {

        // Selección de idioma
        Ejercicio042_Menus.seleccionarIdioma();

        boolean continuar = true;

        // Bucle principal: permite iniciar o finalizar el programa
        while (continuar) {
            boolean ejecutar = Ejercicio042_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio042_Operaciones.dibujarTriangulo();
            } else {
                continuar = false;
            }
        }
    }
}