// ╔════════════════════════════════════════════════════════════════════════════╗
// ║ Desarrollador: Dany Noguera (dany.noguera@unah.hn)                         ║
// ║ Proyecto: Ejercicio #47                                                    ║
// ║ Prompt:                                                                    ║
// ║ "Se debe leer un número cualquiera (de no más de cinco dígitos) y mostrar  ║
// ║ el número descompuesto por sus dígitos y la suma de estos. Ejemplo: 431    ║
// ║  → 431 = 4, 3 y 1 su suma es 4+3+1 = 8.                                    ║
// ║ Respetar el formato de salida exacto."                                     ║
// ║ Fecha: 2025-11-05                                                          ║
// ╚════════════════════════════════════════════════════════════════════════════╝
// Versión corta: Dany Noguera | Ejercicio047 | 2025-11-05

package Ejercicio047;

public class Ejercicio047_Main {

    public static void main(String[] args) {

        // Selección de idioma
        Ejercicio047_Menus.seleccionarIdioma();

        boolean continuar = true;

        // Bucle principal: permite iniciar o finalizar el programa
        while (continuar) {
            boolean ejecutar = Ejercicio047_Menus.menuInicioSalir();

            if (ejecutar) {
                Ejercicio047_Operaciones.descomponerNumero();
            } else {
                continuar = false;
            }
        }
    }
}